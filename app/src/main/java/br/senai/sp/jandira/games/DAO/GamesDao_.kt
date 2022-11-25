package br.senai.sp.jandira.games.DAO

import androidx.room.*
import br.senai.sp.jandira.games.model.Games

@Dao
interface GamesDao_ {

    @Insert
    fun save(game: Games): Long //

    @Delete
    fun delete(game: Games): Int //Quantidade de registros apagados

    @Update
    fun update(game: Games): Int  //Quantidade de atualizações feitas com sucesso

    @Query("SELECT * FROM tbl_game ORDER by nome_game ASC")
    fun getAll(): List<Games>

    @Query("SELECT * FROM tbl_game where id = :id")
    fun getGamesById(id: Int): Games

}