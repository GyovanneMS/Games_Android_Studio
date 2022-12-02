package br.senai.sp.jandira.games.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.repository.ClienteRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    lateinit var clienteRepository: ClienteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar!!.hide()
        setContentView(binding.root)
        clienteRepository = ClienteRepository(this)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        if (dados.getInt("id", 0) != 0) {
            val abrirGamesActivity = Intent(this, GameListsActivity::class.java)
            abrirGamesActivity.putExtra("id", dados.getInt("id", 0))
            startActivity(abrirGamesActivity)
        }


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
            var email = binding.editEmail.text.toString();
            var pass = binding.editTextPassword.text.toString();
            var id = 0;
            val dados = getSharedPreferences("dados", MODE_PRIVATE);
            val salvar = dados.edit();
            var existe = false;

            for (client in clienteRepository.getAll()){
                if(email == client.email && pass == client.senha){
                    id = client.id;
                    existe = true;
                    break;
                    //Fazer um Toast
                }
            }

            if(existe){
                if(binding.checkBoxRemindMe.isChecked){
                    salvar.putInt("id", id);
                    salvar.commit();
                }
                val openGames = Intent(this, GameListsActivity::class.java)
                openGames.putExtra("id", id)
                startActivity(openGames);
            } else {
                Toast.makeText(this, "Erro ao dar login", Toast.LENGTH_LONG).show()
            }
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
