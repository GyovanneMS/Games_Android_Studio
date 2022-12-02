package br.senai.sp.jandira.games.DAO

import androidx.room.*
import br.senai.sp.jandira.games.model.Client

@Dao
interface ClienteDao {

    @Insert
    fun save(cliente: Client): Long //

    @Delete
    fun delete(cliente: Client): Int //Quantidade de registros apagados

    @Update
    fun update(cliente: Client): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_cliente ORDER by nome ASC")
    fun getAll(): List<Client>

    @Query("SELECT * FROM tbl_cliente where id = :id")
    fun getClientById(id: Int): Client

}
