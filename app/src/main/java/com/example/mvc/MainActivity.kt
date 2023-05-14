package com.example.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvc.databinding.ActivityMainBinding

//Controller
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    var model = Model()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this
    }

    fun clickNumber(i: Int){
        Toast.makeText(this, "$i 번을 클릭했습니다.", Toast.LENGTH_SHORT).show()
        model.inputPassword(i)

        if (model.password.size == 4 && model.checkPassword()){
            //4자리 이상 비밀번호가 1234
            binding.messageSuccess.visibility = View.VISIBLE
        }
    }
}

//1. View를 통해 사용자가 이벤트를 발생시킨다.
//2. Controller가 Model에 접근하여 데이터를 요청한다.
//3. Model이 Controller에게 데이터를 넘겨준다.
//4. Controller가 View에게 처리된 데이터를 보여준다.