package com.junction.seoul.hunterandroid.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.junction.seoul.hunterandroid.data.BusNumber
import com.junction.seoul.hunterandroid.databinding.ItemAddRemoveTextBinding

class AddAndDeleteAdapter(private val viewModel: AddAndDeleteViewModel) :
  RecyclerView.Adapter<AddAndDeleteAdapter.ViewHolder>() {

  private val data = mutableListOf<BusNumber>()

  fun setItem(items: List<BusNumber>) {
    data.run {
      clear()
      addAll(items)
    }
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ViewHolder.from(parent)

  override fun getItemCount() = data.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(data[position], viewModel)
  }

  class ViewHolder(private val binding: ItemAddRemoveTextBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BusNumber, viewModel: AddAndDeleteViewModel) {
      binding.busNumber = item
      binding.vm = viewModel
      binding.executePendingBindings()
    }

    companion object {
      fun from(parent: ViewGroup): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAddRemoveTextBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
      }
    }
  }
}


