package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.DAO.DB
import br.senai.sp.jandira.games.model.Client

class ClienteRepository(context: Context) {

    private val db = DB.getDataBase(context).clienteDao();

    fun save(cliente: Client): Long{
        return db.save(cliente);
    }

    fun update(cliente: Client): Int{
        return db.update(cliente);
    }

    fun delete(cliente: Client): Int{
        return db.delete(cliente);
    }

    fun getAll(): List<Client> {
        return db.getAll();
    }

    fun getClienteById(id: Int): Client{
        return db.getClientById(id);
    }
}