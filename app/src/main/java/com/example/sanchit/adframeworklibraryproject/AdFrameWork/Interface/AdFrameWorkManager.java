package com.example.sanchit.adframeworklibraryproject.AdFrameWork.Interface;

import java.util.Map;

//import android.R;
import android.app.Activity;
import com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Controller.Executor;
public class AdFrameWorkManager
{
	public static AdFrameWorkManager instance;
	Executor exec;
	public static AdFrameWorkManager Init(Activity act)
	{

		if(instance == null)
		{
			instance = new AdFrameWorkManager();
			instance.exec = Executor.Init(act);
		}
		return instance;
	}
	
	public static void ShowAd(Map<String,String> metaData)
	{
		Executor.ShowAd(metaData);
	}
	
}
