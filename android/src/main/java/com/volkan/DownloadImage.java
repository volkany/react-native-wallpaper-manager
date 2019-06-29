package com.volkan;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;
import android.graphics.Bitmap;

import java.io.*;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
  
	@Override
	protected Bitmap doInBackground(String... URL) {
  
		String imageURL = URL[0];
  
		Bitmap bitmap = null;
		try {
			// Resim indiriyoruz
			InputStream input = new java.net.URL(imageURL).openStream();
			// Decode Bitmap
			bitmap = BitmapFactory.decodeStream(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}
  
	@Override
	protected void onPostExecute(Bitmap result) {
		//İndirdiğimiz resmi imgView'e atıyoruz
		
	}
  }