package com.suek.ex91kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //대량의 데이터 property[멤버변수]
    var items= ArrayList<ItemVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //원래는 서버에서 데이터를 읽어와야 하지만
        //시간상 그냥 대량의 데이터 날 코딩 추가
        items.add( ItemVO("Sam", "Hello Kotlin", R.drawable.gametitle_01) )
        items.add( ItemVO("Robin", "Good Kotlin", R.drawable.gametitle_02) )
        items.add( ItemVO("Kim", "Nice Kotlin", R.drawable.gametitle_03) )
        items.add( ItemVO("Park", "How are you Kotlin", R.drawable.gametitle_04) )
        items.add( ItemVO("Hong", "Nice to meet you Kotlin", R.drawable.gametitle_05) )
        items.add( ItemVO("Sam", "Hello Kotlin", R.drawable.gametitle_01) )
        items.add( ItemVO("Robin", "Good Kotlin", R.drawable.gametitle_02) )
        items.add( ItemVO("Kim", "Nice Kotlin", R.drawable.gametitle_03) )
        items.add( ItemVO("Park", "How are you Kotlin", R.drawable.gametitle_04) )
        items.add( ItemVO("Hong", "Nice to meet you Kotlin", R.drawable.gametitle_05) )


        //코틀린의 Recycler 는 setAdapter 를 사용하지 않고
        //RecyclerView 의 프로퍼티(멤버변수) 로서 adapter 를 가지고 있음.
        //그래서 아답터를 굳이 멤버변수로 만들 필요 없음!!
        recycler.adapter= MyAdapter(this, items)

        //리사이클러뷰에 레이아웃매니저 설정
        recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)   //reverseLayout- 데이터 역순으로 뒤집을때 쓰는것
    }

    override fun onResume() {   //데이터 불러올때?
        super.onResume()

        //리사이클러뷰 갱신하기
        //리사이클러뷰안에 있는 adapter 가 null 인지를 체크한 후에 명령요청
        //멤버변수가 null 아닌지 체크를 해주고 실행하는 키워드 => !! (not not)
        //!! (not not) 키워드의 특징 : 혹시 null 이면 메소드를 실행하지 않음.. 즉 null 에러가 나지 않음- 자동 try , catch
        recycler.adapter!!.notifyDataSetChanged()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_aa -> Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show()
            R.id.menu_bb -> Toast.makeText(this, "bb", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

}
