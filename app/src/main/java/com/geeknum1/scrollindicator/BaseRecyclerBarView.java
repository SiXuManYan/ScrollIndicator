package com.geeknum1.scrollindicator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;



/**
 * Created by mustang on 2019/07/03.
 */

public abstract class BaseRecyclerBarView extends LinearLayout {

    public View blurring_view;
    public SeekBar seekBar;
    public RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public BaseRecyclerBarView(Context context) {
        super(context);
        initView();

    }

    public BaseRecyclerBarView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public BaseRecyclerBarView(Context context,
                                AttributeSet attrs,
                               int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }


    public void initView() {
        inflate(getContext(), R.layout.recycler_bar_layout, this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        seekBar = findViewById(R.id.slide_indicator_point);
        seekBar.setPadding(0, 0, 0, 0);
        seekBar.setThumbOffset(0);

        blurring_view = findViewById(R.id.blurring_view);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled( RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //显示区域的高度。
                int extent = recyclerView.computeHorizontalScrollExtent();
                //整体的高度，注意是整体，包括在显示区域之外的。
                int range = recyclerView.computeHorizontalScrollRange();
                //已经向下滚动的距离，为0时表示已处于顶部。
                int offset = recyclerView.computeHorizontalScrollOffset();
                if(extent>=range){
                    blurring_view.setVisibility(View.INVISIBLE);
                    seekBar.setVisibility(GONE);
                    return;
                }
                if(extent>=(range-offset)){
                    blurring_view.setVisibility(View.INVISIBLE);
                }else {
                    blurring_view.setVisibility(View.VISIBLE);
                }

                Log.i("dx------", range + "****" + extent + "****" + offset);
                //此处获取seekbar的getThumb，就是可以滑动的小的滚动游标
                GradientDrawable gradientDrawable = (GradientDrawable) seekBar.getThumb();
                //根据列表的个数，动态设置游标的大小，设置游标的时候，progress进度的颜色设置为和seekbar的颜色设置的一样的，所以就不显示进度了。
                gradientDrawable.setSize(40, 5);
                //设置可滚动区域
                seekBar.setMax((int) (range - extent));
                if (dx == 0) {
                    seekBar.setProgress(0);
                } else if (dx > 0) {
                    Log.i("dx------", "右滑");
                    seekBar.setProgress(offset);
                } else if (dx < 0) {
                    Log.i("dx------", "左滑");
                    seekBar.setProgress(offset);
                }
            }

            @Override
            public void onScrollStateChanged( RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

        });




    }




}
