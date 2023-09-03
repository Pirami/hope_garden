package com.example.pi_test

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pi_test.databinding.TagItemBinding
import com.example.pi_test.models.Search

class TagRecyclerAdapter(private val itemList: List<Search>): RecyclerView.Adapter<TagRecyclerAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding: TagItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.tag = item

            // item의 정보를 뽑아내기
            val name = item.name
            val churchName = item.churchName
//            val sex = item.sex
//            val id = item.id
            val death = item.death
//            val reborn = item.reborn
//            val birth = item.birth

            Log.d("확인: ", "${name}(${churchName})")
//            val toast = Toast.makeText(requireContext(), "확인: ${name}(${churchName})", Toast.LENGTH_SHORT)
//            toast.show()
//            Log.d("바인딩 확인: ", item.toString())
            itemView.setOnClickListener {
//                data 넘어온 것 확인 완료 (클릭시 -> activity_Page 3 으로 넘겨주기)
                Log.d("확인2: ", "${name}(${churchName})")
                val intent = Intent(itemView.context, MemberSearchView::class.java)
                intent.putExtra("name", name)
                intent.putExtra("churchName", churchName)
//                intent.putExtra("sex", sex)
//                intent.putExtra("id", id)
                intent.putExtra("death", death)
//                intent.putExtra("reborn", reborn)
//                intent.putExtra("birth", birth)
                itemView.context.startActivity(intent)
//                intent.run { context.startActivity(this) }
//                val intent = Intent(itemView?.context, MemberSearchView::class.java)
//                intent.putExtra("name", "${name}(${churchName})")
//                startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = TagItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
        // item의 정보를 뽑아내기
//        val name = itemList[position].name
//        val churchName = itemList[position].churchName
//        Log.d("확인: ", "${itemList[position]}(${position})")

//       2023.09.03 추가
//        holder.itemView.setOnClickListener {
//            itemClickListener.onClick(it, position)
//        }
//        holder.apply {
//            bind(item)
//        }
//        return item
//        여기까지
    }
    //ClickListener
//    interface OnItemClickListener {
//        fun onClick(v: View, position: Int)
//    }
//    private lateinit var itemClickListener : OnItemClickListener
//
//    fun setItemClickListener(itemClickListener: OnItemClickListener) {
//        this.itemClickListener = itemClickListener
//    }

    override fun getItemCount(): Int {
        Log.d("dataSize 확인: ", itemList.size.toString())
        return itemList.size
    }
}