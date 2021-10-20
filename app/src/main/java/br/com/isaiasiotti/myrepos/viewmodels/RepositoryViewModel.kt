package br.com.isaiasiotti.myrepos.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.isaiasiotti.myrepos.database.RepositoryDAO
import br.com.isaiasiotti.myrepos.domain.RepositoryEntity
import br.com.isaiasiotti.myrepos.network.GithubApi
import kotlinx.coroutines.launch

class RepositoryViewModel(dataSource: RepositoryDAO, application: Application): ViewModel() {
  
  val database = dataSource
  
  val repositories = database.repositoriesList()
  
  fun getGithubRepository(full_name: String) {
    
    val splitFullName = full_name.split("/")
    val username = splitFullName[0]
    val repository = splitFullName[1]
    
    viewModelScope.launch {
      try {
        
        val repositoryResult = GithubApi.retrofitService.getRepository(
          user_param = username,
          repository_param = repository
        )
        
        insert(repositoryResult)
        
        Log.i("Response Repository", "$repositoryResult")
        
      } catch (e: Exception) {
        Log.e("Error", "$e")
      }
    }
  }
  
  private suspend fun insert(repository: RepositoryEntity) {
    database.insert(repository)
  }
  
}