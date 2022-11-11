package br.senai.sp.jandira.games.DAO

import androidx.room.*
import br.senai.sp.jandira.games.model.Cliente

@Dao
interface ClienteDao {

    @Insert
    fun save(contact: Cliente): Long //

    @Delete
    fun delete(contact: Cliente): Int //Quantidade de registros apagados

    @Update
    fun update(contact: Cliente): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_cliente ORDER by nome ASC")
    fun getAll(): List<Cliente>

    @Query("SELECT * FROM tbl_cliente where id = :id")
    fun getContactById(id: Int): Cliente

}