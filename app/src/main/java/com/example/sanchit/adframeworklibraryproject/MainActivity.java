package com.example.sanchit.adframeworklibraryproject;

import java.util.HashMap;
import java.util.Map;

//import com.AdFrameWork.Interface.AdFrameWorkManager;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sanchit.adframeworklibraryproject.AdFrameWork.Interface.AdFrameWorkManager;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    
    public void initiate(View v)
    {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("UUID", "123");
    	System.out.println("chala kya");
    	AdFrameWorkManager.Init(this);
    	AdFrameWorkManager.ShowAd(map);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
