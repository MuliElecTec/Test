package com.example.ernest.myflippertest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imageIds = new int[]
            {
                    R.drawable.baiyang,     //白羊座
                    R.drawable.chunv,       //处女座
                    R.drawable.jinniu,      //金牛座
                    R.drawable.juxie,       //巨蟹座
                    R.drawable.mojie,       //摩羯座
                    R.drawable.sheshou,     //射手座
                    R.drawable.shizi,       //狮子座
                    R.drawable.shuangyu,    //双鱼座
                    R.drawable.shuangzi,    //双子座
                    R.drawable.shuiping,    //水瓶座
                    R.drawable.tiancheng,   //天秤座
                    R.drawable.tianxie      //天蝎座
            };
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
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
                imageView.setImageResource(imageIds[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };

        flipper.setAdapter(baseAdapter);






    }
}
