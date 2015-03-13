package com.teemaker.tmake;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ImageView image;
	TextView text;
	Bitmap bMap;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page);
		Bundle extras=getIntent().getExtras();
		int e=extras.getInt("RES_ID");
		image=(ImageView)findViewById(R.id.image1);
		
		switch(e){
		case R.id.template1:
			bMap= BitmapFactory.decodeResource(getResources(), R.drawable.template_basic_front);
			image.setImageBitmap(bMap);
			break;
		case R.id.template2:
			bMap= BitmapFactory.decodeResource(getResources(), R.drawable.template_polo_front);
			image.setImageBitmap(bMap);
			break;
		case R.id.template3:
			bMap= BitmapFactory.decodeResource(getResources(), R.drawable.template_tanktop_front);
			image.setImageBitmap(bMap);
			break;
		case R.id.template4:
			bMap= BitmapFactory.decodeResource(getResources(), R.drawable.template_basic_front);
			image.setImageBitmap(bMap);
			break;
		case R.id.template5:
			bMap= BitmapFactory.decodeResource(getResources(), R.drawable.template_polo_front);
			image.setImageBitmap(bMap);
			break;
		case R.id.template6:
			bMap= BitmapFactory.decodeResource(getResources(), R.drawable.template_tanktop_front);
			image.setImageBitmap(bMap);
			break;
	
		}
		
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);

        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View arg0) {
                 
//                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(i, RESULT_LOAD_IMAGE);
            	TextView txt=(TextView)findViewById(R.id.text);
            	txt.setText("Tap where you want to place image");            
            }
        });

        image.setOnTouchListener(new View.OnTouchListener(){
        	public boolean onTouch(View v, MotionEvent event) {
                
        		float x=(float) event.getX();
        		float y=(float) event.getY();
        		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tp);
            	bitmap = getBitmapOverlay(bMap, bitmap, x, y);
                image.setImageBitmap(bitmap);
        		return true;
        }        	
        });
	
	}
	
	
	
	public static Bitmap getBitmapOverlay(Bitmap bmp1, Bitmap bmp2, float left, float top) {
	    Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(),  bmp1.getConfig());
	    Canvas canvas = new Canvas(bmOverlay);    
	    canvas.drawBitmap(bmp1, 0, 0, null);
	    canvas.drawBitmap(bmp2, left-(bmp2.getWidth()/2), top-(bmp2.getHeight()/2), null);
	    return bmOverlay;
	}
	
}	
		
	/*}
	
	@Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	     super.onActivityResult(requestCode, resultCode, data);
	      
	     if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
	         Uri selectedImage = data.getData();
	         String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	         Cursor cursor = getContentResolver().query(selectedImage,
	                 filePathColumn, null, null, null);
	         cursor.moveToFirst();
	 
	         int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	         String picturePath = cursor.getString(columnIndex);
	         
	         ImageView imageView = (ImageView) findViewById(R.id.imgView);
	         imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	         cursor.close();
	                      
	         // String picturePath contains the path of selected Image
	     }
	}
	
}
		
		
		//final Bitmap bMap1 = bMap.copy(bMap.getConfig(), true);
	    for(int x = 0;x < bMap.getWidth();x++){
			int flag=0;
			int to=Color.RED;
	        for(int y = 0;y < bMap.getHeight();y++){
	        	if(bMap.getPixel(x,y)==Color.BLACK&&flag==0) {flag=1;continue;}
	        	else if(bMap.getPixel(x,y)==Color.BLACK&&flag==1) {to=Color.WHITE;continue;} 
	            bMap1.setPixel(x, y, to);
	        }
	        }*/
/*		
		final View touchView = findViewById(R.id.image1);
		
	    touchView.setOnTouchListener(new View.OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            int x=(int) event.getX();
	            int y=(int) event.getY();
	            Point p=new Point(x,y);

	    		image.setImageBitmap(FloodFill(bMap1,p,Color.RED,Color.WHITE));
	    	    return true;
	        }
	    });
	    }

	private Bitmap FloodFill(Bitmap bmp, Point pt, int targetColor, int replacementColor){
		Queue<Point> q = new LinkedList<Point>();
		q.add(pt);
		while (q.size() > 0) {
		    Point n = q.poll();
		    if (bmp.getPixel(n.x, n.y) != targetColor)
		        continue;

		    Point w = n, e = new Point(n.x + 1, n.y);
		    while ((w.x > 0) && (bmp.getPixel(w.x, w.y) == targetColor)) {
		        bmp.setPixel(w.x, w.y, replacementColor);
		        if ((w.y > 0) && (bmp.getPixel(w.x, w.y - 1) == targetColor))
		            q.add(new Point(w.x, w.y - 1));
		        if ((w.y < bmp.getHeight() - 1)
		                && (bmp.getPixel(w.x, w.y + 1) == targetColor))
		            q.add(new Point(w.x, w.y + 1));
		        w.x--;
		    }
		    while ((e.x < bmp.getWidth() - 1)
		            && (bmp.getPixel(e.x, e.y) == targetColor)) {
		        bmp.setPixel(e.x, e.y, replacementColor);
		        text.setText("here");
		        if ((e.y > 0) && (bmp.getPixel(e.x, e.y - 1) == targetColor))
		            q.add(new Point(e.x, e.y - 1));
		        if ((e.y < bmp.getHeight() - 1)
		                && (bmp.getPixel(e.x, e.y + 1) == targetColor))
		            q.add(new Point(e.x, e.y + 1));
		        e.x++;
		        
		    }
		}	
	return bmp;
	}
	*/