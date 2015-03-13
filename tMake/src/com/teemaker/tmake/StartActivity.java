package com.teemaker.tmake;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends Activity {

	TextView quotes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_page);

		quotes = (TextView) findViewById(R.id.quotes);

		Message q = new Message();
		q.obj=quotes;
		q.what=0;
		quotesHandler.sendEmptyMessage(0);
	}

	public void design(View view) {
		Intent intent=new Intent(this,TemplateActivity.class);
		startActivity(intent);
	}

	private Handler quotesHandler = new Handler(){

		int i=0;
		String quote[] = {"I am neither a god, an angel, or a saint. I am awake. \n~ Siddhartha Gautama",
				"Sometimes I think the surest sign that intelligent life exists elsewhere in the universe is that none of it has tried to contact us. \n~Bill Watterson",
				"“Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.” \n - Albert Einstein",
				"Get your facts first, then you can distort them as you please. \n - Mark Twain",
				"“Be yourself; everyone else is already taken.”  \n - Oscar Wilde",
				"“In three words I can sum up everything I've learned about life: it goes on.”  \n - Robert Frost"
		};

		public void handleMessage(Message msg){
			quotes.setText(quote[i]);
			i = (i+1)% quote.length;
			quotesHandler.sendEmptyMessageDelayed(0,10000);
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_page, menu);
		return true;
	}

}

