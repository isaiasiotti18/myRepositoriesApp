package br.com.isaiasiotti.myrepos.database

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.isaiasiotti.myrepos.domain.RepositoryEntity

@Dao
interface RepositoryDAO {
  @Insert
  suspend fun insert(repository: RepositoryEntity)
  
  @Query("SELECT * FROM repositories")
  fun repositoriesList(): LiveData<List<RepositoryEntity>>
  
  @Query("DELETE FROM repositories WHERE repository_name = :repositoryName")
  suspend fun deleteRepository(repositoryName: String)
  
}