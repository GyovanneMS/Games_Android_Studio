package br.senai.sp.jandira.games.DAO

import androidx.room.*
import br.senai.sp.jandira.games.model.Client

@Dao
interface ClienteDao {

    @Insert
    fun save(contact: Client): Long //

    @Delete
    fun delete(contact: Client): Int //Quantidade de registros apagados

    @Update
    fun update(contact: Client): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_cliente ORDER by nome ASC")
    fun getAll(): List<Client>

    @Query("SELECT * FROM tbl_cliente where id = :id")
    fun getContactById(id: Int): Client

}