package com.example.ernest.myflippertest;

import android.app.Application;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
//import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements OnGestureListener
{
    class ImageStructure
    {
        private int imageId;
        private String imageName;
        private String date;
        ImageStructure(int id, String name, String d)
        {
            imageId     = id;
            imageName   = name;
            date        = d;
        }
    };
    ImageStructure imageStruArray[] = new ImageStructure[]
       {
           new ImageStructure(R.drawable.shuiping,    "水瓶座",   "01.20-02.18"),
           new ImageStructure(R.drawable.shuangyu,    "双鱼座",   "02.19-03.20"),
           new ImageStructure(R.drawable.baiyang,     "白羊座",   "03.21-04.19"),
           new ImageStructure(R.drawable.jinniu,      "金牛座",   "04.20-05.20"),
           new ImageStructure(R.drawable.shuangzi,    "双子座",   "05.21-06.21"),
           new ImageStructure(R.drawable.juxie,       "巨蟹座",   "06.22-07.22"),
           new ImageStructure(R.drawable.shizi,       "狮子座",   "07.23-08.22"),
           new ImageStructure(R.drawable.chunv,       "处女座",   "08.23-09.22"),
           new ImageStructure(R.drawable.tiancheng,   "天秤座",   "09.23-10.23"),
           new ImageStructure(R.drawable.tianxie,     "天蝎座",   "10.24-11.22"),
           new ImageStructure(R.drawable.sheshou,     "射手座",   "11.23-12.21"),
           new ImageStructure(R.drawable.mojie,       "摩羯座",   "12.22-01.19"),
       };

    private AdapterViewFlipper flipper;
    private GestureDetector gestureDetector;
    private int curImageId = 0;
    final int FLIP_DISTANCE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(this, this);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageStruArray.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imageStruArray[i].imageId);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(baseAdapter);
        this.setTitle(""+//getString(R.string.app_name) + "--" +
                (curImageId + 1) + "  " +
                imageStruArray[curImageId].imageName + "(" +
                imageStruArray[curImageId].date+ ")");

    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if(motionEvent1.getX() - motionEvent.getX() > FLIP_DISTANCE)
        {
            //flipper.setInAnimation();
            flipper.showPrevious();
            if (curImageId == 0)
            {
                curImageId = imageStruArray.length - 1;
            }
            else
            {
                curImageId--;
            }
            this.setTitle(""+//getString(R.string.app_name) + "--" +
                    (curImageId + 1) + "  " +
                    imageStruArray[curImageId].imageName + "(" +
                    imageStruArray[curImageId].date+ ")");
            return true;
        }
        else if(motionEvent.getX() - motionEvent1.getX() > FLIP_DISTANCE)
        {
            flipper.showNext();
            if (curImageId >= imageStruArray.length - 1)
            {
                curImageId = 0;
            }
            else
            {
                curImageId++;
            }
            this.setTitle(""+//getString(R.string.app_name) + "--" +
                    (curImageId + 1) + "  " +
                    imageStruArray[curImageId].imageName + "(" +
                    imageStruArray[curImageId].date+ ")");
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return gestureDetector.onTouchEvent(event);
    }


    @Override
    public void onLongPress(MotionEvent event)
    {
    }

    @Override
    public boolean onDown(MotionEvent arg0)
    {
        return false;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

}
