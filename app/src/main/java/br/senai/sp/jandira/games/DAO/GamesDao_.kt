package br.senai.sp.jandira.games.DAO

import androidx.room.*
import br.senai.sp.jandira.games.model.Cliente

@Dao
interface GamesDao_ {

     @Insert
    fun save(contact: Cliente): Long //

    @Delete
    fun delete(contact: Cliente): Int //Quantidade de registros apagados

    @Update
    fun update(contact: Cliente): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_game ORDER by nome_game ASC")
    fun getAll(): List<Cliente>

    @Query("SELECT * FROM tbl_game where id = :id")
    fun getContactById(id: Int): Cliente

}