package br.com.isaiasiotti.myrepos.network

import br.com.isaiasiotti.myrepos.domain.RepositoryEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.github.com/"

private val moshi = Moshi.Builder()
  .add(KotlinJsonAdapterFactory())
  .build()

private val retrofit = Retrofit.Builder()
  .baseUrl(BASE_URL)
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .build()

interface GithubApiService {
  @GET("repos/{user_param}/{repository_param}")
  suspend fun getRepository(
    @Path("user_param") user_param: String,
    @Path("repository_param") repository_param: String
  ): RepositoryEntity
}

object GithubApi {
  val retrofitService: GithubApiService by lazy {
    retrofit.create(GithubApiService::class.java)
  }
}