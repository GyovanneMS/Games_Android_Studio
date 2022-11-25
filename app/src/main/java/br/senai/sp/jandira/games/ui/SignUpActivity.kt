package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.databinding.ActivitySignUpBinding
import br.senai.sp.jandira.games.model.Client
import br.senai.sp.jandira.games.model.Level
import br.senai.sp.jandira.games.repository.ClienteRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding;

    lateinit var contactRepository: ClienteRepository

    private var id = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater);
        setContentView(R.layout.activity_sign_up)

        id = intent.getIntExtra("id", 0);

        binding.teste.setOnClickListener {
            save();
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater;
        inflater.inflate(R.menu.menu_new_users, menu);

        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        save();
        val voltar = Intent(this, MainActivity::class.java);
        startActivity(voltar)
        return true;
    }

    private fun save() {

        val client = Client();
        client.cidade = binding.aInputCity.text.toString();
        client.email = binding.aInputEmail.text.toString();
        client.senha = binding.aInputPassword.text.toString();
        client.nome = binding.aInputName.text.toString();


        var genero = binding.radioGenre.id//.checkedRadioButtonId;
        //client.genero =
        var generoFirstLetter = this.findViewById<RadioButton>(genero).text.first();
        client.genero = generoFirstLetter;
        var sliderItems = binding.aSliderConsole;

        if (sliderItems.value.toInt() == 1 || sliderItems.value.toInt() == 2){
            client.nivel = Level.Land;
        }
        else if(sliderItems.value.toInt() == 3 || sliderItems.value.toInt() == 4){
            client.nivel = Level.Wood;
        }
        else if(sliderItems.value.toInt() == 5 || sliderItems.value.toInt() == 6){
            client.nivel = Level.Stone;
        }
        else if(sliderItems.value.toInt() == 7 || sliderItems.value.toInt() == 8){
            client.nivel = Level.Iron;
        }
        else if(sliderItems.value.toInt() == 9 || sliderItems.value.toInt() == 10){
            client.nivel = Level.Gold;
        }
        else if(sliderItems.value.toInt() == 11 || sliderItems.value.toInt() == 12){
            client.nivel = Level.Diamond;
        }
        else if(sliderItems.value.toInt() == 13 || sliderItems.value.toInt() == 14){
            client.nivel = Level.Emerald;
        }
        else if(sliderItems.value.toInt() == 15 || sliderItems.value.toInt() == 16){
            client.nivel = Level.Miner;
        }
        else if(sliderItems.value.toInt() == 17 || sliderItems.value.toInt() == 18){
            client.nivel = Level.Ore_maker;
        }

        val repository = ClienteRepository(this);
        var whatNumber = repository.save(client)


        Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "${whatNumber}", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "${client}", Toast.LENGTH_SHORT).show()
        //finish()
    }


//    private fun saveUser() {
//
//        val user = User();
//        user.id = 1;
//        user.name = editName.text.toString();
//        user.email = editEmail.text.toString();
//        user.password = editPassword.text.toString();
//        user.weight = editWeight.text.toString().toInt();
//        user.height = editHeight.text.toString().toDouble();
//
//        //Gravar usuário no shared preferences
//        //Step 1 - Obter uma instância do sharedPreferences
//        val dados = getSharedPreferences("dados", MODE_PRIVATE)
//
//        //Step 2 - Criar um editor para o arquivo
//
//        val editor = dados.edit()
//
//        //step 3 - Inserir dados no arquivo sharedPrefereces
//        editor.putInt("id", user.id)
//        editor.putString("name", user.name)
//        editor.putString("email", user.email)
//        editor.putString("password", user.password)
//        editor.putInt("weight", user.weight)
//        editor.putFloat("height", user.height.toFloat())
//
//        if(editor.commit()){
//            Toast.makeText(this, "Usuário gravado com sucesso!", Toast.LENGTH_SHORT).show();
//            finish(); //Fecha a Activity
//        } else{
//            Toast.makeText(this, "Ocorreu um erro na gravação!", Toast.LENGTH_SHORT).show();



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