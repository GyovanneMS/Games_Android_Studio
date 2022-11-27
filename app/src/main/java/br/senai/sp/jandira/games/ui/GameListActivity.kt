package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGameListBinding
import br.senai.sp.jandira.games.repository.ClienteRepository
//import br.senai.sp.jandira.games.repository.GamesRepositor

class GameListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityGameListBinding

    lateinit var clienteRepositorio: ClienteRepository
    lateinit var adapter: GamesAdapter
    lateinit var rvGames: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clienteRepositorio = ClienteRepository(this)

        val id = intent.getIntExtra("id", 0)
        val user = clienteRepositorio.getClienteById(id) //Ver o nome certo
        
        carragarRecyperView()
        
        
    }

    override fun onResume() {
        super.onResume()

        //carragarRecyperView()
    }

    private fun carragarRecyperView() {
        rvGames = findViewById(R.id.Rv_Games);
        //        //Como visualizar isso?
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        repositorio = GamesRepositor(this)
        //        //Pegando a view e colocando "todos" os contatos nela
        rvGames.adapter = adapter;
        //        //Chamando o método do adapter para criar um json com cada item pedo dos contatos
        //adapter = GamesAdapter(games, this)
        
        binding.editName.text = Client.name
        binding.editEmail.text = Client.email
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_gamelist, menu)

        return true

    }
}



