package com.example.myactivity;

import java.security.PublicKey;

import javax.security.auth.PrivateCredentialPermission;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
	//
    public final static String Message="com.example.myactivity.Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView（）设定当前的Activity对应的布局
        setContentView(R.layout.activity_main);
      
    }
    
    //我们已经在button的XML文件里面定义了android：onclick=“SendMessage”属性用于响应点击事件
    //现在我们在对应的Activity里面实现这个响应点击事件的函数public void SendMessage（View view）
    public void SendMessage(View view){
    	//Intent 类定义的对象intent的构造函数有两个参数（Context，Class）
    	//这里我们设置的Context为this，Class为我们要启动的Activity（SecondActivity.class）
    	Intent intent=new Intent(this,SecondActivity.class);
    	EditText editText=(EditText)findViewById(R.id.editMessage);
    	String message =editText.getText().toString();
    	/*这里我们给intent添加我们希望传递给要启动的Activity的数据
    	 *要用到putExtra（String name，String value）方法，其中第一个参数为键名，第二个参数为数据的值
    	 *注意键名的写法：public final static Message=“com.example.MainActivity....”,这是为了启动下
    	 *一个Activity以后还可以访问这个键值
    	 */
    	intent.putExtra(Message, message);
    	//利用startActivity来启动下一个Activity
    	startActivity(intent);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
