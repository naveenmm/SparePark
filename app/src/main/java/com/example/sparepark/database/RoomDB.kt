package com.example.sparepark.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sparepark.SpareParkApplication

@Database(
    entities = [SpaceRaw::class, SpaceFinderRaw::class, SpaceOwnerRaw::class],
    version = 1
)
abstract class RoomDB : RoomDatabase() {

    abstract fun spaceDao(): SpaceDao
    abstract fun spaceOwnerDao(): SpaceOwnerDao
    abstract fun spaceFinderDao(): SpaceFinderDao

    companion object {
        private var INSTANCE: RoomDB? = null
        fun getDatabase(context: Context = SpareParkApplication.instance): RoomDB? {
            if (INSTANCE == null) {
                synchronized(RoomDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDB::class.java, "room_db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}