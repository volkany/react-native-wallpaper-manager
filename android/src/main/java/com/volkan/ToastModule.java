package com.volkan;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.Callback;


import java.util.Map;
import java.util.HashMap;
import android.graphics.Bitmap;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.WallpaperManager;

// import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.graphics.drawable.Drawable;


public class ToastModule extends ReactContextBaseJavaModule {

	private static final String DURATION_SHORT_KEY = "SHORT";
	private static final String DURATION_LONG_KEY = "LONG";
	public WallpaperManager wallpaperManager;
	public Callback callback;

	public ToastModule(ReactApplicationContext reactContext) {
		super(reactContext);
		wallpaperManager = WallpaperManager.getInstance(getReactApplicationContext());
	}

	@Override
	public String getName() {
		return "ToastExample";
	}

	@Override
	public Map<String, Object> getConstants() {
		final Map<String, Object> constants = new HashMap<>();
		constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
		constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
		constants.put("LOCK_SCREEN", WallpaperManager.FLAG_LOCK);
		constants.put("SYSTEM", WallpaperManager.FLAG_SYSTEM);
		constants.put("ALL", WallpaperManager.FLAG_LOCK | WallpaperManager.FLAG_SYSTEM);
		return constants;
	}

	@ReactMethod
	public void show(String message, int duration) {
		Toast.makeText(getReactApplicationContext(), message, duration).show();
	}



	public Bitmap getBitmapFromURL(String src) {
		try {
				java.net.URL url = new java.net.URL(src);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoInput(true);
				connection.connect();
				InputStream input = connection.getInputStream();
				Bitmap myBitmap = BitmapFactory.decodeStream(input);
				//wallpaperManager.setBitmap(myBitmap);
				return myBitmap;
		} catch (IOException e) {
				e.printStackTrace();
				return null;
		}
	}

	@ReactMethod
	public void setWallpaper(String url, final int which, Callback clb) {
		Toast.makeText(getReactApplicationContext(), "root: "+url, Toast.LENGTH_SHORT).show();
		callback = clb;
		Glide.with(getReactApplicationContext())
			.asBitmap()
			.load(url)
			.listener(new RequestListener<Bitmap>() {
				@Override
				public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
					callback.invoke("loadFailed", -1);
					return false;
				}

				@Override
				public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
					try {
						int resultCode = wallpaperManager.setBitmap(resource, null, true, which);
						Toast.makeText(getReactApplicationContext(), "GLIDE: Sonuç: "+String.valueOf(resultCode)+" which: "+which, Toast.LENGTH_LONG).show();
						callback.invoke(null, resultCode);
					} catch (IOException e) {
						e.printStackTrace();
						callback.invoke(e.getMessage(), -1);
						return false;
					}
					return true;
				}
			})
			.into(new CustomTarget<Bitmap>() {
				@Override
				public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
					
				}

				@Override
				public void onLoadCleared(@Nullable Drawable placeholder) {
				}
			});
	}
}