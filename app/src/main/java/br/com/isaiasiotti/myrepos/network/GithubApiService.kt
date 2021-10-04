package br.com.isaiasiotti.myrepos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.github.com/"

private val moshi = Moshi.Builder()
  .add(KotlinJsonAdapterFactory())
  .build()

private val retrofit = Retrofit.Builder()
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .baseUrl(BASE_URL)
  .build()

interface GithubApiService {
  @GET("repos/{user}/{repository}")
  suspend fun getRepository(
    @Path("user") user: String,
    @Path("repository") repository: String
  ): Call<RepositoryProperty>
}

object GithubApi {
  val retorfitService: GithubApiService by lazy {
    retrofit.create(GithubApiService::class.java)
  }
}