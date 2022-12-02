package br.senai.sp.jandira.games.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
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

    private lateinit var binding: ActivitySignUpBinding;
    private lateinit var level: String
    private lateinit var clienteRepositor: ClienteRepository
    private lateinit var client: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater);
        setContentView(binding.root)
        client = Client()


        val levels = Level.values().map(Enum<*>::name);
        level = levels[0];

        binding.edttLevel.text = level;

        binding.sliderItems.addOnChangeListener { _, value, _ ->
            level = levels[value.toInt() - 1];
            binding.edttLevel.text = level;
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater;
        inflater.inflate(R.menu.menu_new_users, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menu_save -> {
                Log.i("xpto", "clicou!!!")
                save();
                true;
            }
            else -> {
                val voltar = Intent(this, MainActivity::class.java);
                startActivity(voltar);
                true;
            }
        }
    }

    private fun validar(): Boolean {
        if(binding.aInputEmail.text.isEmpty()){
            binding.aInputEmail.error = "Este é um campo obrigatório";
            Log.i("xpto", "Email!")
            return false;
        }
        else if(binding.aInputPassword.text.isEmpty()){
            binding.aInputPassword.error = "Este é um campo obrigatório";
            Log.i("xpto", "Senha!")
            return false;
        }
        else if(binding.aInputName.text.isEmpty()){
            binding.aInputName.error = "Este é um campo obrigatório";
            Log.i("xpto", "nome!")
            return false;
        }
        else if(binding.aInputCity.text.isEmpty()){
            binding.aInputCity.error = "Este é um campo obrigatório";
            Log.i("xpto", "Cidade!")
            return false;
        }
        else {
            return true
        }
    }

    private fun save() {
        if(validar()){
            Log.i("xpto", "Validou!")
            client.cidade = binding.aInputCity.text.toString();
            client.email = binding.aInputEmail.text.toString();
            client.senha = binding.aInputPassword.text.toString();
            client.nome = binding.aInputName.text.toString();


            var genero = binding.radioGenre.id//.checkedRadioButtonId;
            //client.genero =
           // var generoFirstLetter = this.findViewById<RadioButton>(genero).text.first();
            //client.genero = generoFirstLetter;
            var sliderItems = binding.sliderItems;
            client.nivel = Level.Land;
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

            clienteRepositor = ClienteRepository(this);
            var teste = clienteRepositor.save(client)
            if(teste > 0){
                Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show()
                finish()
            } else{
                Log.i("xpto", "Não Salvou!!!")
                Toast.makeText(this, "Não salvou", Toast.LENGTH_LONG).show()
            }



        }
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
