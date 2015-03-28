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
        //setContentView�����趨��ǰ��Activity��Ӧ�Ĳ���
        setContentView(R.layout.activity_main);
      
    }
    
    //�����Ѿ���button��XML�ļ����涨����android��onclick=��SendMessage������������Ӧ����¼�
    //���������ڶ�Ӧ��Activity����ʵ�������Ӧ����¼��ĺ���public void SendMessage��View view��
    public void SendMessage(View view){
    	//Intent �ඨ��Ķ���intent�Ĺ��캯��������������Context��Class��
    	//�����������õ�ContextΪthis��ClassΪ����Ҫ������Activity��SecondActivity.class��
    	Intent intent=new Intent(this,SecondActivity.class);
    	EditText editText=(EditText)findViewById(R.id.editMessage);
    	String message =editText.getText().toString();
    	/*�������Ǹ�intent�������ϣ�����ݸ�Ҫ������Activity������
    	 *Ҫ�õ�putExtra��String name��String value�����������е�һ������Ϊ�������ڶ�������Ϊ���ݵ�ֵ
    	 *ע�������д����public final static Message=��com.example.MainActivity....��,����Ϊ��������
    	 *һ��Activity�Ժ󻹿��Է��������ֵ
    	 */
    	intent.putExtra(Message, message);
    	//����startActivity��������һ��Activity
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
