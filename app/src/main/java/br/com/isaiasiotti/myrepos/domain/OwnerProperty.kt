package br.com.isaiasiotti.myrepos.domain

import com.squareup.moshi.Json

data class OwnerProperty(
  @Json(name = "login")
  val user_name: String,
  
  val avatar_url: String
)