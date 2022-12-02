package br.senai.sp.jandira.games.DAO

import android.content.Context
import androidx.room.*
import br.senai.sp.jandira.games.model.Games

class GamesDao_(context: Context) {
    companion object {
        fun getGames(context: Context): List<Games> {
            val pt1 = Games();

            pt1.id = 1;
            pt1.nomeGame = "Cuphead";
            pt1.studio = "MDHR"
            pt1.descricao =
                "Cuphead é um jogo eletrônico de run and gun e plataforma criado pelos irmãos canadenses Chad e Jared Moldenhauer através da Studio MDHR. O jogo foi inspirado no estilo de animação Rubber hose usado em desenhos animados da Era de Ouro da animação americana, como o trabalho dos estúdios Fleischer Studios, Warner Bros."
            pt1.AnoFinalizado = 2022

            val pontosTuristicos = listOf<Games>(pt1);

            return pontosTuristicos
        }
    }
}