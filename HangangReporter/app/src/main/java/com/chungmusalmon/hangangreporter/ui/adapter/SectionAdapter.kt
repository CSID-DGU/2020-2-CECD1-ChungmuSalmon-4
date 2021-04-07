package com.chungmusalmon.hangangreporter.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chungmusalmon.hangangreporter.viewmodel.model.Section
import com.chungmusalmon.hangangreporter.base.BaseAdapter
import com.chungmusalmon.hangangreporter.databinding.ItemMainSectionBinding
import com.chungmusalmon.hangangreporter.ui.source.CongestionClass
import java.lang.Exception

class SectionAdapter : BaseAdapter<Section>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SectionViewHolder(ItemMainSectionBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is SectionViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    class SectionViewHolder(private val binding: ItemMainSectionBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Section){
            binding.tvName.text = item.name
            binding.tvCongestion.text = map(item.congestion).classification
            binding.tvCongestion.setTextColor(Color.parseColor(map(item.congestion).color))
        }

        companion object{
            fun map(congestion : Int) : CongestionClass{
                return when(congestion){
                    0 -> CongestionClass("여유", "#2F9D27")
                    1 -> CongestionClass("보통", "#FFBB00")
                    2 -> CongestionClass("혼잡", "#980000")
                    else -> throw Exception()
                }
            }
        }
    }


}