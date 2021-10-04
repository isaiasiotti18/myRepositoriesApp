package br.com.isaiasiotti.myrepos.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.isaiasiotti.myrepos.R
import br.com.isaiasiotti.myrepos.databinding.RepositoriesListFragmentBinding
import br.com.isaiasiotti.myrepos.viewmodels.RepositoryViewModel

class RepositoriesListFragment : Fragment() {
  
  private lateinit var viewModel: RepositoryViewModel
  
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    
    val binding: RepositoriesListFragmentBinding = DataBindingUtil.inflate(
      inflater,
      R.layout.repositories_list_fragment,
      container,
      false)
    
    viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)
    
    return binding.root
  }
}