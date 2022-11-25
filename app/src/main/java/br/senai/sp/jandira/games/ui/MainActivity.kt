package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.repository.ClienteRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide();

        binding.textViewSignUp.setOnClickListener {
            signUpp()
        }

        binding.buttonLogin.setOnClickListener {
            login()
        }

    }

    private fun login() {
        if(validar()){
            val email = binding.editEmail.text.toString();
            val pass = binding.editTextPassword.text.toString();

            //Abrir o SHarePreferences
            val dados = ClienteRepository(this).getAll()

            //Verificar se os dados de autenticação estão corretos
           // if(email == a && pass == passSp){
                val openGames = Intent(this, GameListActivity::class.java)
                startActivity(openGames);
           // } else {
                //Toast.makeText( this, "Authentication failed!!", Toast.LENGTH_SHORT).show()
            //}
        }
    }

    private fun validar(): Boolean {
        if(binding.editEmail.text.isEmpty()){
            binding.editEmail.error = "E-mail is required!!"
            return false;
        }
        if(binding.editTextPassword.text.isEmpty()){
            binding.editTextPassword.error = "Password is required!!"
            return false;
        }
        return true
    }

    private fun signUpp() {
        val openSignUpActivity = Intent(this, SignUpActivity::class.java)
        startActivity(openSignUpActivity);
    }
}