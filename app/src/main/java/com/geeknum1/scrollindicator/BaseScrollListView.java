package com.geeknum1.scrollindicator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SeekBar;



/**
 * Created by mustang on 2019/07/03.
 */

public abstract class BaseScrollListView extends LinearLayout {

    public HorizontalScrollView scrollView;
    public View blurring_view;
    public LinearLayout linearLayout;
    public SeekBar seekBar;


    public BaseScrollListView(Context context) {
        super(context);
        initView();

    }

    public BaseScrollListView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public BaseScrollListView(Context context,
                               AttributeSet attrs,
                              int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }




    public void initView() {
        inflate(getContext(), R.layout.srcoll_list_layout, this);
        scrollView = (HorizontalScrollView) findViewById(R.id.hsv);
        blurring_view = findViewById(R.id.blurring_view);
        linearLayout = findViewById(R.id.lin);
        seekBar = findViewById(R.id.slide_indicator_point);
        seekBar.setPadding(0, 0, 0, 0);
        seekBar.setThumbOffset(0);
        scrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int x, int i1, int i2, int i3) {
                //显示区域的高度。
                int extent = computeHorizontalScrollExtent();
                //整体的高度，注意是整体，包括在显示区域之外的。
                int range =scrollView.getChildAt(0).getMeasuredWidth();
                if(extent>=range){
                    blurring_view.setVisibility(View.INVISIBLE);
                    seekBar.setVisibility(GONE);
                    return;
                }
                if(extent>=(range-x)){
                    blurring_view.setVisibility(View.INVISIBLE);
                }else {
                    blurring_view.setVisibility(View.VISIBLE);
                }

                //已经向下滚动的距离，为0时表示已处于顶部。
                int offset = x;
                Log.i("dx------", range + "****" + extent + "****" + offset+ "xxx=" + x);
                //此处获取seekbar的getThumb，就是可以滑动的小的滚动游标
                GradientDrawable gradientDrawable = (GradientDrawable) seekBar.getThumb();
                //根据列表的个数，动态设置游标的大小，设置游标的时候，progress进度的颜色设置为和seekbar的颜色设置的一样的，所以就不显示进度了。
                gradientDrawable.setSize( 60, 5);
                //设置可滚动区域
                seekBar.setMax((int) (range - extent));
                if (x == 0) {
                    seekBar.setProgress(0);
                } else if (x > 0) {
                    Log.i("dx------", "右滑");
                    seekBar.setProgress(offset);
                } else if (x < 0) {
                    Log.i("dx------", "左滑");
                    seekBar.setProgress(offset);
                }

            }
        });

        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                //显示区域的高度。
                int extent = computeHorizontalScrollExtent();
                //整体的高度，注意是整体，包括在显示区域之外的。
                int range =scrollView.getChildAt(0).getMeasuredWidth();
                if(extent>=range){
                    blurring_view.setVisibility(View.INVISIBLE);
                    seekBar.setVisibility(GONE);
                }
                scrollView.scrollTo(1,0);
            }
        },100);


    }



}
