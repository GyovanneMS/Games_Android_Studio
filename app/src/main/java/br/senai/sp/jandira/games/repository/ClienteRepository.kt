package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.DAO.DB
import br.senai.sp.jandira.games.model.Client

class ClienteRepository(context: Context) {

    private val db = DB.getDataBase(context).clienteDao();

    fun save(contact: Client): Long{
        return db.save(contact);
    }

    fun update(contact: Client): Int{
        return db.update(contact);
    }

    fun delete(contact: Client): Int{
        return db.delete(contact);
    }

    fun getAll(): List<Client> {
        return db.getAll();
    }

    fun getClientById(id: Int): Client{
        return db.getClientById(id);
    }
}
