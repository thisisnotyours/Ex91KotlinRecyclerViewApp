package com.suek.ex91kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*

class MyAdapter constructor(val context:Context, val items:ArrayList<ItemVO>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater= LayoutInflater.from(context)
        val itemView= layoutInflater.inflate(R.layout.recycler_item, parent, false)
        val vh= VH(itemView)
        return vh
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {   //상속받을때 ()써주기
        val vh= holder as VH    //코틀린의 형변환 연산자 as

        //현재번째 아이템
        val item= items.get(position)
        vh.itemView.tv_title.setText(item.title)
        //vh.itemView.tv_msg.setText(item.msg)
        //코틀린에서는 setXXX() 메소드를 싫어함. 대신 set 해서 설정할 값을
        //멤버변수(property:속성)로 설정하는 것을 권장
        vh.itemView.tv_msg.text= item.msg
        //Glide 와 같은 역할을 하는 Picasso 라이브러리 사용
        Picasso.get().load(item.img).into(vh.itemView.iv)    //picasso.get 하면 객체가 옴



        //코틀린에서는 이 위치에서 itemView 의 클릭이벤트 처리를 함- position 의 정보가 필요해서
       /* vh.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //아이템의 상세정보 화면으로 이동


            }
        })*/



    }



    //inner class ViewHolder 클래스 : itemView 안의 뷰들을 관리하는 객체클래스
    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView){    //constructor 생략가능
        /*val tvTitle= itemView.tv_title
        val tvMsg= itemView.tv_msg
        val iv= itemView.iv*/


        //이벤트처리 방법 1) VH에서 하기
        init {
            //자바에서는 이 생성자에서 getLayoutPosition() 메소드로 클릭한 아이템을 구별했었음..
            //코틀린에서는 getLayoutPosition() 메소드 대신에
            //이 아답터에 멤버변수로 이미 layoutPosition 이 존재함
            itemView.setOnClickListener(object : View.OnClickListener{
                override fun onClick(v: View?) {
                    Toast.makeText(context, ""+layoutPosition, Toast.LENGTH_SHORT).show()

                    val intent= Intent(context, ItemActivity::class.java)
                    intent.putExtra("title", items.get(layoutPosition).title)
                    intent.putExtra("msg", items.get(layoutPosition).msg)
                    intent.putExtra("img", items.get(layoutPosition).img)

                    context.startActivity(intent)
                }
            })

            //이벤트처리 방법 2) bindViewHolder()에서 하기
            //아이템의 위치정보가 존재하는 "bindViewHolder()"에서 '클릭이벤트 처리'를 할 수도 있음
        }
    }
}