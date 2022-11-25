package br.senai.sp.jandira.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.adapter.GamesAdapter
import br.senai.sp.jandira.games.databinding.ActivityGameListBinding
import br.senai.sp.jandira.games.repository.GamesRepositor

class GameListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityGameListBinding

    lateinit var repositorio: GamesRepositor
    lateinit var adapter: GamesAdapter
    lateinit var rvGames: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        carragarRecyperView()
    }

    private fun carragarRecyperView() {
        repositorio = GamesRepositor(this)
        //Pegando o metodo (Tipo o controler) getall() da "model" ContactRepository
        val games = repositorio.getAll();
        //Chamando o método do adapter para criar um json com cada item pedo dos contatos
        adapter = GamesAdapter(games, this)
        rvGames = findViewById(R.id.Rv_Games)
        //Pegando a view e colocando "todos" os contatos nela
        rvGames.adapter = adapter;
        //Como visualizar isso?
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_gamelist, menu)

        return true

    }
}



