package com.test.app.b;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	protected CCGLSurfaceView _glSurfaceView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("yyyy", "onCreate start");
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		_glSurfaceView = new CCGLSurfaceView(this);
		setContentView(_glSurfaceView);
		Log.d("yyyy", "onCreate end");
	}
	
	@Override
	protected void onStart()
	{			
		Log.d("yyyy", "onStart start");
		super.onStart();		
		CCDirector.sharedDirector().attachInView(_glSurfaceView);			
		CCDirector.sharedDirector().setDeviceOrientation(CCDirector.kCCDeviceOrientationLandscapeLeft);			
		CCDirector.sharedDirector().setDisplayFPS(true);			
		CCDirector.sharedDirector().setAnimationInterval(1.0f / 60.0f);
		
		CCScene scene = GameLogo.scene();
		CCDirector.sharedDirector().runWithScene(scene);
		Log.d("yyyy", "onStart end");
	}
	
	@Override
	protected void onPause()
	{
		Log.d("yyyy", "onPause start");
		super.onPause();			
		CCDirector.sharedDirector().pause();
		Log.d("yyyy", "onPause end");
	}

	@Override
	protected void onResume()
	{
		Log.d("yyyy", "onResume start");
		super.onResume();			
		CCDirector.sharedDirector().resume();
		Log.d("yyyy", "onResume end");
	}

	@Override
	protected void onStop()
	{
		Log.d("yyyy", "onStop start");
		super.onStop();			
		CCDirector.sharedDirector().end();
		Log.d("yyyy", "onStop end");

	}

	@Override
	protected void onDestroy()
	{
		Log.d("yyyy", "onDestroy start");
		super.onDestroy();			
		CCDirector.sharedDirector().end();
		Log.d("yyyy", "onDestroy end");
	}
}
