package br.com.isaiasiotti.myrepos.network

data class RepositoryProperty(
  val id: Int,
  
  val name: String,
  
  val stargazers_count: Int,
  
  val forks_count: Int
)