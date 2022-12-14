package app.aoyama.huit.laproduct

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memoDao(): MemoDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "database",
                    ).allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}