package br.com.isaiasiotti.myrepos.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.isaiasiotti.myrepos.database.RepositoryDAO

class RepositoryViewModelFactory(
  private val dataSource: RepositoryDAO,
  private val application: Application
): ViewModelProvider.Factory {
  @Suppress("unchecked_cast")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(RepositoryViewModel::class.java)) {
      return RepositoryViewModel(dataSource, application) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}