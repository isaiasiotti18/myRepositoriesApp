package br.com.isaiasiotti.myrepos.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.isaiasiotti.myrepos.databinding.RepositoryItemBinding
import br.com.isaiasiotti.myrepos.domain.RepositoryEntity

class RepositoryAdapter: ListAdapter<RepositoryEntity, RepositoryAdapter.ViewHolder>(DiffCallback) {
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryAdapter.ViewHolder {
    return ViewHolder(
      RepositoryItemBinding.inflate(
        LayoutInflater.from(parent.context)
      )
    )
  }
  
  override fun onBindViewHolder(holder: RepositoryAdapter.ViewHolder, position: Int) {
    val repositoryProperty = getItem(position)
    holder.bind(repositoryProperty)
  }
  
  // View Holder
  class ViewHolder(private var binding: RepositoryItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(repositoryProperty: RepositoryEntity) {
      binding.repository = repositoryProperty
      binding.executePendingBindings()
    }
    
  }
  
  // DiffUtil
  companion object DiffCallback: DiffUtil.ItemCallback<RepositoryEntity>() {
    override fun areItemsTheSame(
      oldItem: RepositoryEntity,
      newItem: RepositoryEntity
    ): Boolean {
      return oldItem === newItem
    }
  
    override fun areContentsTheSame(
      oldItem: RepositoryEntity,
      newItem: RepositoryEntity
    ): Boolean {
      return oldItem.id == newItem.id
    }
  
  }
  
}