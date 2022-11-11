package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_game")
class Games {

    @PrimaryKey(autoGenerate = true)
    var id = 0;

    @ColumnInfo(name = "nome_game")
    var nomeGame = "";
    var studio = "";
    var descricao = "";
    var imageGame: Bitmap? = null;

    @ColumnInfo(name = "ano_finalizado")
    var AnoFinalizado = 0;

    var finalizado = Boolean;

}