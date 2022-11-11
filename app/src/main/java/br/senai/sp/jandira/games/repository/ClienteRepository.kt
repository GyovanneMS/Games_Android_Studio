package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.DAO.DB
import br.senai.sp.jandira.games.model.Cliente

class ClienteRepository(context: Context) {

    private val db = DB.getDataBase(context).clienteDao();

    fun save(contact: Cliente): Long{
        return db.save(contact);
    }

    fun update(contact: Cliente): Int{
        return db.update(contact);
    }

    fun delete(contact: Cliente): Int{
        return db.delete(contact);
    }

    fun getAll(): List<Cliente> {
        return db.getAll();
    }

    fun getClienteById(id: Int): Cliente{
        return db.getContactById(id);
    }
}