package com.example.a5activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 获取传递过来的数据
        /*
        val name = intent.getStringExtra("name")
        val password = intent.getStringExtra("pwd")
         */
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val age = bundle?.getInt("age")

        Log.v("ljr", "$name:$age")
        // 返回方法1：
        mBackBtn.setOnClickListener {
            // 回调数据:回调结果不带数据
            //setResult(1)

            // 回调数据:回调结果带数据
            Intent().apply {
                putExtra("uid","001")
            }.also {
                setResult(0,it)
            }

            // 结束当前页面
            finish()
        }

        // 返回方法2：
        // 再manifests里面：<activity android:name=".SecondActivity"
        //            android:parentActivityName=".MainActivity"></activity>
    }
}