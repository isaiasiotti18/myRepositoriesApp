package br.com.isaiasiotti.myrepos.domain

import androidx.room.*

@Entity(tableName = "repositories")
data class RepositoryEntity(
  @PrimaryKey
  val id: Int,
  
  @ColumnInfo(name = "full_name")
  val full_name: String,
  
  @ColumnInfo(name = "repository_name")
  val name: String,
  
  @ColumnInfo(name = "stargazers_count")
  val stargazers_count: Int,
  
  @ColumnInfo(name = "forks_count")
  val forks_count: Int,
  
  @Embedded
  val owner: OwnerProperty
)

