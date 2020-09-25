package com.suek.ex91kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_intro.*   //xml 에 있는 모든 속성의 id 들은 참조가 자동으로 되어있음.

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //id 가 btn 인 버튼에 클릭리스너 추가하기
        btn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                //MainActivity 실행
                var intent= Intent(this@IntroActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

    fun clickExit(view: View) {    //view 변수명 : View 자료형
        finish()
    }
}
