package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import br.senai.sp.jandira.games.model.Console
import java.time.LocalDate
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_cliente")
class Client {

    @PrimaryKey(autoGenerate = true)
    var id = 0;

    var nome = "";
    var email = "";
    var senha = "";
    var foto: Bitmap? = null;
    var cidade = "";


    @ColumnInfo(name = "data_lancamento")
    var dataNascimento: LocalDate? = null;
    var nivel = Level.Land;
    var console: Console? = null;
    var genero = 'I';
}

