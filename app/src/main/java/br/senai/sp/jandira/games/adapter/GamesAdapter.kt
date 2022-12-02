package br.senai.sp.jandira.games.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesAdapter(val context: Context): RecyclerView.Adapter<GamesAdapter.HolderPt>() {

    private var gamesList = listOf<Games>();

    fun updateGamesList(games: List<Games>){
        this.gamesList = games;
        notifyDataSetChanged()
    }

    class HolderPt(view: View): RecyclerView.ViewHolder(view) {
        val textTituloPt = view.findViewById<TextView>(R.id.text_view_title);
        val textDescricao = view.findViewById<TextView>(R.id.text_view_description);
        val textStudio = view.findViewById<TextView>(R.id.text_view_developer);
        val imageHolder = view.findViewById<ImageView>(R.id.image_holder);

        fun bind(games: Games) {
            textTituloPt.text = games.nomeGame;
            textDescricao.text = games.descricao;
            textStudio.text = games.studio;
            //imageHolder.setImageDrawable(games.imageGame);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPt {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false);
        return HolderPt(view);
    }

    override fun onBindViewHolder(holder: HolderPt, position: Int) {
        holder.bind(gamesList[position]);
    }

    override fun getItemCount(): Int {
        return gamesList.size;
    }


}