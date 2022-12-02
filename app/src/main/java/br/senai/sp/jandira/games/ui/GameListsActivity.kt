package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.DAO.GamesDao_
import br.senai.sp.jandira.games.DAO.GamesDao_.Companion.getGames
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGameListsBinding
import br.senai.sp.jandira.games.model.Client
import br.senai.sp.jandira.games.model.Games
import br.senai.sp.jandira.games.repository.ClienteRepository
//import br.senai.sp.jandira.games.repository.GamesRepositor

//import br.senai.sp.jandira.games.repository.GamesRepositor

class GameListsActivity: AppCompatActivity() {

    lateinit var adapter: GamesAdapter
    lateinit var binding: ActivityGameListsBinding
    lateinit var clienteRepositorio: ClienteRepository
    lateinit var rvGames: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameListsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvGames = findViewById(R.id.Rv_Games)

        adapter = GamesAdapter(this)
        adapter.updateGamesList(GamesDao_.getGames(this))

        rvGames.adapter = adapter
        clienteRepositorio = ClienteRepository(this)

        val id = intent.getIntExtra("id", 0)
        val client = clienteRepositorio.getClientById(id) //Ver o nome certo

        carragarRecyperView()


    }

    override fun onResume() {
        super.onResume()

        //carragarRecyperView()
    }

    private fun carragarRecyperView() {
        var client = Client()
//        rvGames = findViewById(R.id.Rv_Games);
        //        //Como visualizar isso?
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        var repositorio = GamesRepositor(this)
        //        //Pegando a view e colocando "todos" os contatos nela
//        rvGames.adapter = adapter;
        //        //Chamando o método do adapter para criar um json com cada item pedo dos contatos
        //adapter = GamesAdapter(games, this)

        binding.textViewUserName.text = client.nome
        binding.textViewUserEmail.text = client.email
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_gamelist, menu)
 //fsdfsdsf
        return true

    }
}



