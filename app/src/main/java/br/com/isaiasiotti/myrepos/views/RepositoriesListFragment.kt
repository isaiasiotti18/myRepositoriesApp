package br.com.isaiasiotti.myrepos.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.isaiasiotti.myrepos.R
import br.com.isaiasiotti.myrepos.database.RepositoryDatabase
import br.com.isaiasiotti.myrepos.databinding.RepositoriesListFragmentBinding
import br.com.isaiasiotti.myrepos.viewmodels.RepositoryViewModel
import br.com.isaiasiotti.myrepos.viewmodels.RepositoryViewModelFactory

class RepositoriesListFragment : Fragment() {
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    
    val binding: RepositoriesListFragmentBinding = DataBindingUtil.inflate(
      inflater, R.layout.repositories_list_fragment, container, false
    )
  
    val application = requireNotNull(this.activity).application
    
    val dataSource = RepositoryDatabase.getInstance(application).repositoryDao
    val viewModelFactory = RepositoryViewModelFactory(dataSource, application)
    
    val repositoryViewModel = ViewModelProvider(
      this,
      viewModelFactory
    )[RepositoryViewModel::class.java]
    
    binding.viewModel = repositoryViewModel
    
    binding.lifecycleOwner = this
    
    val adapter = RepositoryAdapter()
    
    binding.rvList.adapter = adapter
    
    repositoryViewModel.repositories.observe(viewLifecycleOwner, Observer {
      it?.let {
        adapter.submitList(it)
      }
    })
    
    binding.btnSearch.setOnClickListener {
      repositoryViewModel.getGithubRepository(binding.searchRepo.text.toString())
    }
    
    return binding.root
  }
}