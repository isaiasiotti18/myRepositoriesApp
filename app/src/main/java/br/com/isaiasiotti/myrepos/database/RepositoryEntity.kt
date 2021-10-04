package br.com.isaiasiotti.myrepos.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "repositories")
data class RepositoryEntity(
  @ColumnInfo(name = "user_name")
  val userName: String,
  
  @ColumnInfo(name = "repository_name")
  val repositoryName: String,
  
  @ColumnInfo(name = "stars")
  val stars: Int,
  
  @ColumnInfo(name = "forks")
  val forks: Int
)

