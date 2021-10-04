package br.com.isaiasiotti.myrepos.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import br.com.isaiasiotti.myrepos.R
import br.com.isaiasiotti.myrepos.databinding.RepositoryDetailsFragmentBinding

class RepositoryDetailsFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding: RepositoryDetailsFragmentBinding = DataBindingUtil.inflate(
      inflater,
      R.layout.repository_details_fragment,
      container,
      false
    )
    
    return binding.root
  }
}