package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.games.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_save){
            Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show()
            return true
        } else if(item.itemId == R.id.menu_settings){
            Toast.makeText(this, "Configurar o que?", Toast.LENGTH_SHORT).show()
            return true
        }else if(item.itemId == R.id.menu_exit){
            Toast.makeText(this, "Saindo-o", Toast.LENGTH_SHORT).show()
            return true
        } else {
            return true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_users, menu)

        return true
    }
}