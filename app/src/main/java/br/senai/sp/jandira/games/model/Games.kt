package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import java.time.LocalDate

class Games {

    var codigo = 0;
    var nomeGame = "";
    var studio = "";
    var descricao = "";
    var imageGame: Bitmap? = null;
    var AnoFinalizado:LocalDate? = null;
    var finalizado = Boolean;

}