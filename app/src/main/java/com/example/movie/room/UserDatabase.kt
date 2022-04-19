package com.example.movie.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notebelanja.room.User
import com.example.notebelanja.room.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase():RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object{
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context: Context): UserDatabase? {
            if (INSTANCE == null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,"Noted.db"
                    ).build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}