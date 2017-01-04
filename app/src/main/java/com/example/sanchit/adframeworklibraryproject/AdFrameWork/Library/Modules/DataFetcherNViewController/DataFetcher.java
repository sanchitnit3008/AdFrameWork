package com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Modules.DataFetcherNViewController;

import java.io.InputStream;
import java.util.Map;


//import android.R;
//import android.net.Uri;
//import android.os.Bundle;
//import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
//import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
//import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.sanchit.adframeworklibraryproject.AdFrameWork.Library.Controller.Executor;



 public class DataFetcher implements AnimationListener
 {
	 
	 Animation animSlideUp,animSlideDown;
	 Button save,redeem;
	 String baseUrl = "http://t3.gstatic.com/images?q=tbn:ANd9GcSAoWMO4COdaKsMDPoIHTO-DVugDx8_b_8Hx1kTibAaSBOILdm2";
	 public void FetchData(Map<String, String> verifiedData)
	 {

		 if(verifiedData.containsKey("User_Data"))
		 {
			 verifiedData.put("userInfo", "0");
			 // Get Ads according to user's Demographic Data
			 postData(verifiedData);
		 }
		 else
		 {
			 verifiedData.put("userInfo", "-1");
			 // Get Misscellaneous Ad
			 postData(verifiedData);
		 }
		 
	 }
	 
	 Context getCurrentContext()
	 {
		 return Executor.getContext();
	 }
	 
	 LinearLayout getLayout()
	 {
		 return null;
	 }
	 
	 Activity getActivity()
	 {
		return Executor.getActivity();
		 //return null;
	 }
	 
	  
	  public void postData(Map<String,String> verifiedData) 
	  {
		  
		  
		  ViewGroup rootView = (ViewGroup)getActivity().findViewById
	                (android.R.id.content);
		  View topMostView = getLeafView(rootView);
        
        // let's add a sibling to the leaf view
        final ViewGroup leafParent = (ViewGroup)topMostView.getParent();
		  final View viewlocal = Executor.GetInflatedView(leafParent);
		  WebView web = Executor.getWebView(viewlocal);
		  Executor.passReferences(viewlocal);
		  web.loadUrl(baseUrl);
		  web.getSettings().setJavaScriptEnabled(true);

		  web.setWebViewClient(new WebViewClient() {

			   public void onPageFinished(WebView view, String url) {
			        // do your stuff here
				   System.out.println("url = "+url);
				  
				   ViewGroup vg = (ViewGroup)view.getParent();
				  leafParent.addView(viewlocal);
				   Handler h = new Handler();
				   h.postDelayed(new Runnable() {
					   @Override
					   public void run() {
						   Executor.ResizeWeb(viewlocal);
					   }
				   }, 5000);
				  System.out.println("chala kya at the end");
			    }
			});
		 // adView.bringToFront();
		  //adView.loadUrl(baseUrl, verifiedData);
		  	
		  //MainAdUI adUI = new MainAdUI();
		  //LayoutInflater.inflate(null, adView, false);
		  //FragmentManager fragmentManager = getActivity().getFragmentManager();
		  //android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		 // adView.loadUrl(baseUrl);
		 
		  
//		  
//		    // Create a new HttpClient and Post Header
//		    HttpClient httpclient = new DefaultHttpClient();
//		    HttpPost httppost = new HttpPost(baseUrl);
//		    @SuppressWarnings("unchecked")
//			List<String> keys = (List<String>) verifiedData.keySet();
//		    @SuppressWarnings("unchecked")
//			List<String> values = (List<String>) verifiedData.values();
//		    try {
//		    	List<NameValuePair> hd = new ArrayList<NameValuePair>();
//		       for(int i = 0; i < verifiedData.size(); i++)
//		       {
//		    	   hd.add(new BasicNameValuePair(keys.get(i),values.get(i)));   
//		       }
//		       hd.add(new BasicNameValuePair("userInfo",miscCode));
//		       httppost.setEntity(new UrlEncodedFormEntity(hd));
//
//		        // Execute HTTP Post Request
//		        HttpResponse response = httpclient.execute(httppost);
//		        
//		        // ServerData Validator takes over
//		        
//		    } catch (ClientProtocolException e) 
//		    {
//		    	// Executor throws ClientProtocolException exception
//		        // TODO Auto-generated catch block
//		    } catch (IOException e) 
//		    {
//		    	// Executor throws IOException exception
//		        // TODO Auto-generated catch block
//		    }
		}
	  
	  private View getLeafView(View view) {
	        if (view instanceof ViewGroup) {
	            ViewGroup vg = (ViewGroup)view;
	            for (int i = 0; i < vg.getChildCount(); ++i) {
	                View chview = vg.getChildAt(i);
	                View result = getLeafView(chview);
	                if (result != null) 
	                    return result;
	            }
	            return null;
	        }
	        else {
	            return view;
	        }
	    }
	  
	  private void Adjust (View viewlocal,int height)
	  {
		  Executor.AdjustView(viewlocal, height);
	  }

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		//animation.start();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
 }
 
 class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
	  ImageView bmImage;

	  public ImageDownloader(ImageView bmImage) {
	      this.bmImage = bmImage;
	  }

	  protected Bitmap doInBackground(String... urls) {
	      String url = urls[0];
	      Bitmap mIcon = null;
	      try {
	        InputStream in = new java.net.URL(url).openStream();
	        mIcon = BitmapFactory.decodeStream(in);
	      } catch (Exception e) {
	          Log.e("Error", e.getMessage());
	      }
	      return mIcon;
	  }

	  protected void onPostExecute(Bitmap result) {
	      bmImage.setImageBitmap(result);
	  }
	}
