package br.senai.sp.jandira.games.DAO

import androidx.room.*
import br.senai.sp.jandira.games.model.Console

@Dao
interface ConsoleDao {

    @Insert
    fun save(contact: Console): Long //

    @Delete
    fun delete(contact: Console): Int //Quantidade de registros apagados

    @Update
    fun update(contact: Console): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_console ORDER by nome ASC")
    fun getAll(): List<Console>

    @Query("SELECT * FROM tbl_game where id = :id")
    fun getConsoleById(id: Int): Console

}