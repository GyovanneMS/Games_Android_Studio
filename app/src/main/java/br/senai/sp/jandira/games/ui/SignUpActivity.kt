package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignUpBinding
import br.senai.sp.jandira.games.model.Client
import br.senai.sp.jandira.games.repository.ClienteRepository


class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding;

    lateinit var contactRepository: ClienteRepository;

    lateinit var cliente: Client;

    private var id = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater);
        setContentView(R.layout.activity_sign_up)

        id = intent.getIntExtra("id", 0);

        binding.buttonSave.setOnClickListener {
            save();
        }
    }

    private fun save() {
        val client = Client();
        client.cidade = binding.aInputCity.toString();
        client.foto = getDrawable(R.drawable.ic_baseline_person_24).toS
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_save){
//            Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
//            return true
//        } else if(item.itemId == R.id.menu_settings){
//            Toast.makeText(this, "Configurar o que?", Toast.LENGTH_SHORT).show()
//            return true
//        }else if(item.itemId == R.id.menu_exit){
//            Toast.makeText(this, "Saindo-o", Toast.LENGTH_SHORT).show()
//            return true
//        } else {
//            return true
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_new_users, menu)
//
//        return true
//    }
}