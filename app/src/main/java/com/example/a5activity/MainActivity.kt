package com.example.a5activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            // 点击事件
            dial()
        }
    }
    /**
     * 页面跳转：明确的指定从当前页面，跳转到SecondActivity页面
     */
    fun exactlyIntent(){
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

    /**
     * 隐式跳转：拨打电话
     */
    fun dial(){
        // 通过配置文件的意图过滤器来查找我们需要的Activity
        Intent().apply {
            // activity动作行为
            //action = "android.intent.action.DIAL"
            action = Intent.ACTION_DIAL

            // data 传递数据
            data = Uri.parse("tel:18289816889")
        }.also {
            startActivity(it)
        }
    }

    /**
     * 隐式跳转：发送短信消息
     */
    fun sms(){
        // 通过配置文件的意图过滤器来查找我们需要的Activity
        Intent().apply {
            // activity动作行为
            //action = "android.intent.action.DIAL"
            action = Intent.ACTION_VIEW

            // data 传递数据
            data = Uri.parse("sms:这是我的消息")
        }.also {
            startActivity(it)
        }
    }

    /**
     * 隐式跳转：打开相机
     */
    fun media(){
        // 通过配置文件的意图过滤器来查找我们需要的Activity
        Intent().apply {
            // activity动作行为
            action = "android.media.action.IMAGE_CAPTURE"

        }.also {
            startActivity(it)
        }
    }

    /**
     * 接收界面返回的数据，也就是回调
     */
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