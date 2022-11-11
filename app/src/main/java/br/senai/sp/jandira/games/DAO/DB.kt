package br.senai.sp.jandira.games.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Cliente

@Database(entities = [Cliente::class], version = 1)
abstract class DB: RoomDatabase() {

    abstract fun clienteDao(): ClienteDao

    companion object {
        private lateinit var instance: DB //uma das ultimas coisas a acontecer

        fun getDataBase(context: Context): DB {
            if (/*:: Permite ver os métodos para ver se já existem*/!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, DB::class.java, "tbl_cliente")
                    .allowMainThreadQueries().build();
            }
            return instance
        }
    }
}