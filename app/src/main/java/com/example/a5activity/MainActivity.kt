package com.example.a5activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            // 页面跳转
            val intent = Intent(this,SecondActivity::class.java)
            // 传递数据
            /*
            intent.putExtra("name","jack")
            intent.putExtra("pwd","1234")
            */

            // 通过bundle来管理数据
            val bundle = Bundle()
            bundle.putString("name","jack")
            bundle.putInt("age",20)
            intent.putExtras(bundle)

            // 启动跳转
            //startActivity(intent)

            // 需要返回值的跳转
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 判断是不是我请求的数据
        if (requestCode == 1){
            // 判断处理结果
            if (resultCode == 0){
                // 成功,取出数据
                Log.v("ljr","处理成功:${data?.getStringExtra("uid")}")
            }else{
                // 失败
                Log.v("ljr","处理失败")
            }
        }
    }
}