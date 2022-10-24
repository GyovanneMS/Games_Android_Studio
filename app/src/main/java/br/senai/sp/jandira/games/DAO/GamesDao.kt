package br.senai.sp.jandira.games.DAO

import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Games

class GamesDao {

    //Itens estáticos
    companion object{
        fun getGames(context: Context): List<Games>{

            val pt1 = Games();
            val pt2 = Games();
            val pt3 = Games();
            val pt4 = Games();
            val pt5 = Games();
            val pt6 = Games();
            val pt7 = Games();
            val pt8 = Games();

            pt1.codigo = 1;
            pt1.nomeGame = "Cuphead";
            pt1.descricao = "Cuphead é um jogo eletrônico de run and gun e plataforma criado pelos irmãos canadenses Chad e Jared Moldenhauer através da Studio MDHR. O jogo foi inspirado no estilo de animação Rubber hose usado em desenhos animados da Era de Ouro da animação americana, como o trabalho dos estúdios Fleischer Studios, Warner Bros. ";
            pt1.studio = "Studio MDHR";
            pt1.imageGame = context.getDrawable(R.drawable.cuphead);

            pt2.codigo = 2;
            pt2.nomeGame = "Cuphead DLC";
            pt2.descricao = "Xicrinho em 'Cuphead - The Delicious Last Course' é um DLC que contém uma nova aventura e uma nova ilha para Xicrinho e Caneco explorarem, agora com a ajuda da Srta. Xicra! Use novas armas, novas relíquias e as habilidades inéditas da Srta. Xicra para enfrentar um novo elenco de chefões enormes e complexos e ajudar o Chef Pitadinha na última missão desafiadora de Xicrinho."
            pt2.studio = "Studio MDHR";
            pt2.imageGame = context.getDrawable(R.drawable.dlc);

            pt3.codigo = 3;
            pt3.nomeGame = "Hollow Knight";
            pt3.descricao = "Desça no mundo de Hollow Knight O premiado jogo de ação e aventura de insetos e heróis. Explore cavernas serpenteantes, cidades antigas e ermos mortais.";
            pt3.studio = "Team Cherry";
            pt3.imageGame = context.getDrawable(R.drawable.hollowknight);

            pt4.codigo = 4;
            pt4.nomeGame = "Planet Zoo";
            pt4.descricao = "Planet Zoo é um jogo de simulação de construção e gerenciamento desenvolvido e publicado pela Frontier Developments para Microsoft Windows. O jogo é considerado um sucessor espiritual dos jogos Zoo Tycoon e Zoo Tycoon 2, com uma jogabilidade semelhante à variante de parque temático do estúdio, Planet Coaster.";
            pt4.studio = "Frontier Developments";
            pt4.imageGame = context.getDrawable(R.drawable.planetzoo);

            pt5.codigo = 5;
            pt5.nomeGame = "Plants vs zombies 2";
            pt5.descricao = "Plants vs. Zombies 2: It's About Time é um jogo do gênero Tower Defense criado pela PopCap Games. É a continuação de Plants vs. Zombies. O jogo apresenta o mesmo estilo de jogabilidade do primeiro, mas os gráficos e a trama são diferentes.";
            pt5.studio = "PopCap Games";
            pt5.imageGame = context.getDrawable(R.drawable.pvz2);

            pt6.codigo = 6;
            pt6.nomeGame = "Pvz Heroes";
            pt6.descricao = "Plants vs. Zombies Heroes é um jogo de cartas digital colecionável da série Plants vs. Zombies, desenvolvido pela PopCap Games e publicado pela Electronic Arts. Em 10 de março de 2016, passou por um lançamento suave em alguns países no iOS, antes de ser lançado internacionalmente em 18 de outubro de 2016.";
            pt6.studio = "Studio MDHR";
            pt6.imageGame = context.getDrawable(R.drawable.pvzheroes);

            pt7.codigo = 7;
            pt7.nomeGame = "Termo";
            pt7.descricao = "Termo é legal";
            pt7.studio = "Fernando Serboncini";
            pt7.imageGame = context.getDrawable(R.drawable.termo);

            pt8.codigo = 8;
            pt8.nomeGame = "War";
            pt8.descricao = "War, clássico dos jogos de tabuleiro, chegou ao Android, iOS e para PC. A editora Grow lançou uma versão digital que possui todas as regras originais, além de interface amigável, multiplayer online e a opção de jogar contra amigos que estão em outro dispositivo, como, por exemplo, computador contra celular ou tablet.";
            pt8.studio = "Grow.";
            pt8.imageGame = context.getDrawable(R.drawable.war);

            val games = listOf<Games>(pt1, pt2, pt3, pt4, pt5, pt6, pt7, pt8);

            return games;
        }
    }
}