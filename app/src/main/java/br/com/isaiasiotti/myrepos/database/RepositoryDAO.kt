package br.com.isaiasiotti.myrepos.database

import androidx.room.*

@Dao
interface RepositoryDAO {
  
  @Insert
  suspend fun insert(repository: RepositoryEntity): RepositoryEntity
  
  @Query("SELECT * FROM repositories")
  suspend fun listRepositories()
  
  @Query("DELETE FROM repositories WHERE repository_name = :repositoryName")
  suspend fun deleteRepository(repositoryName: String)
  
}