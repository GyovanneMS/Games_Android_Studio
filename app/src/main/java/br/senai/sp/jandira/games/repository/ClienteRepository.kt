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

<<<<<<< HEAD
    fun getClienteById(id: Int): Client{
=======
    fun getClientById(id: Int): Client{
>>>>>>> 7cd7b1dad7cc4d89d607f9ad7ca3ce3487410362
        return db.getClientById(id);
    }
}
