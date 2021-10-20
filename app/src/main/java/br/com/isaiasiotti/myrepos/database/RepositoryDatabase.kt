package br.com.isaiasiotti.myrepos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.isaiasiotti.myrepos.domain.RepositoryEntity

@Database(entities = [RepositoryEntity::class], version = 1, exportSchema = false)
abstract class RepositoryDatabase: RoomDatabase() {
  abstract val repositoryDao: RepositoryDAO
  
  companion object {
    
    @Volatile
    private var INSTANCE: RepositoryDatabase? = null
    
    fun getInstance(context: Context): RepositoryDatabase {
      synchronized(this) {
        var instance = INSTANCE
        
        if (instance == null) {
          instance = Room.databaseBuilder(
            context.applicationContext,
            RepositoryDatabase::class.java,
            "repository_database"
          )
            .fallbackToDestructiveMigration()
            .build()
        }
        return instance
      }
    }
  }
}