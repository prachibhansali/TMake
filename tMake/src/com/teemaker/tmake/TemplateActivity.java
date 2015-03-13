package com.teemaker.tmake;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class TemplateActivity extends Activity {

	public void imageDisplay(View view) {
		Intent intent=new Intent(this,MainActivity.class);
		intent.putExtra("RES_ID",view.getId());
		startActivity(intent);
	}

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.template_select);
		
	}


}
