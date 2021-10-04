package br.com.isaiasiotti.myrepos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.isaiasiotti.myrepos.network.GithubApi
import br.com.isaiasiotti.myrepos.network.RepositoryProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel: ViewModel() {
  
  private val _userName: String
  
  private val repositoryName: String
  
  private val _response = MutableLiveData<RepositoryProperty>()
  val response: LiveData<RepositoryProperty>
    get() = _response
  
  private fun getGithubRepository() {
    response.value = GithubApi.retorfitService.getRepository()
  }
}