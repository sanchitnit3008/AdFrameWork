package com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Controller;
import java.util.Map;
//import android.animation.AnimatorSet;
//import android.animation.ObjectAnimator;
//import android.app.ActionBar.LayoutParams;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
//import android.util.AttributeSet;
//import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
//import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
//import android.view.animation.ScaleAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
//import android.widget.FrameLayout;
import android.widget.ImageView;

//import com.AdFrameWork.Interface.AdFrameWorkManager;
import com.example.sanchit.adframeworklibraryproject.R;
//import com.example.adframeworksdk.R;
import com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Modules.DataFetcherNViewController.DataFetcher;
import com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Modules.MetaDataValidator.MetaDataValidator;
//import com.AdFrameWork.Library.Modules.MetaDataValidator.MetaDataValidator;
public class Executor 
{
	static Executor instance;
	DataFetcher fetcher;
	MetaDataValidator validator;
	Activity activity;
	 View localRef;
	public static Executor Init(Activity act)
	{
		if(instance == null)
		{
			instance = new Executor();
			instance.fetcher = new DataFetcher();
			instance.validator = new MetaDataValidator();
			instance.activity = act;
		}
		return instance;
	}
	
	public static void ShowAd(Map<String,String> metaData)
	{
		instance.Validate(metaData);
	}
	
	void Validate(Map<String,String> metaData)
	{
		validator.validate(metaData);
	}
	
	public static void AssignView(WebView view,View from)
	{
		WebView fromWeb = (WebView)from.findViewById(R.id.webview);
		fromWeb = view;
		 System.out.println("chala assigning view");
	}
	
	public static void ResizeWeb(View from)
	{
		WebView webv = (WebView)from.findViewById(R.id.webview);
		webv.setDrawingCacheEnabled(true);
		Bitmap bm = webv.getDrawingCache();
		int height = bm.getHeight();
		AdjustView(from,height);
	}
	
	public static void passReferences(final View viewfrom){
		
		final WebView webV = (WebView)viewfrom.findViewById(R.id.webview);
		final Button save = (Button)viewfrom.findViewById(R.id.savebtn);
		final WebView fromWeb = (WebView)viewfrom.findViewById(R.id.webview);
		final ImageView im = (ImageView)viewfrom.findViewById(R.id.imView);
		im.setVisibility(View.GONE);
		final Button redeem = (Button)viewfrom.findViewById(R.id.redeem);
		final Button cross = (Button)viewfrom.findViewById(R.id.cross);
		final Button save2 = (Button)viewfrom.findViewById(R.id.savebtn2);
		save2.setVisibility(View.GONE);
		
		final Button redraw = (Button)viewfrom.findViewById(R.id.reset);
		save.setOnClickListener(new View.OnClickListener() {
			
							@Override
							public void onClick(View v) {
								v.setClickable(false);
								redeem.setClickable(false);
								save2.setVisibility(View.VISIBLE);
								im.setVisibility(View.VISIBLE);
								save2.setClickable(true);
							}
						});
		
		save2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				v.setClickable(false);
				save.setClickable(true);
			}
		});
		
		
		
cross.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewfrom.setVisibility(View.INVISIBLE);
			}
		});
	}
	
	public static WebView getWebView(View viewlocal)
	{
		WebView web = (WebView)viewlocal.findViewById(R.id.webview);
		return web;
	}
	
	public static void ShowAdAfterVerification(Map<String,String> verifiedData)
	{
		instance.fetcher.FetchData(verifiedData);
	}
	
	public static Activity getActivity()
	{
		return instance.activity;
	}
	
	public static Context getContext()
	{
		return instance.activity.getApplicationContext();
	}
	
	public static View GetInflatedView(ViewGroup container)
	{
		LayoutInflater inflater = (LayoutInflater)instance.activity.getApplicationContext().getSystemService
			      (Context.LAYOUT_INFLATER_SERVICE);
		return inflater.inflate(R.layout.coupon_layout, container,false);
	}
	
	void StartAnimLocal(View v,Animation anim,int pivotX,int pivotY)
	{
		v.setPivotX(pivotX);
		v.setPivotY(pivotY);
		v.startAnimation(anim);
	}
	
	
	public static void AdjustView(View viewlocal,int height)
	{
		FrameLayout vg = (FrameLayout)viewlocal.findViewById(R.id.frame);
		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,height);
		if(lp!=null)
		lp.height = (int)(height*1.8);
		vg.setLayoutParams(lp);
	}

}
