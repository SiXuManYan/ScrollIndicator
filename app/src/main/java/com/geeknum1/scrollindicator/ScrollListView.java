package com.geeknum1.scrollindicator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


/**
 * Created by mustang on 2019/07/03.
 */

public class ScrollListView extends BaseScrollListView {




    public ScrollListView(Context context) {
        super(context);


    }

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public ScrollListView(Context context,
                          AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }


    @Override
    public void initView() {
        super.initView();
        ArrayList<BottomPopBean> list1 = new ArrayList<>();

        horizontalScrollBar(list1);


    }



    private void horizontalScrollBar(ArrayList<BottomPopBean> list1) {
        BottomPopBean bean21 = new BottomPopBean(R.mipmap.ic_launcher, "XXXXXX", "YYYYYY");
        BottomPopBean bean22 = new BottomPopBean(R.mipmap.ic_launcher, "XXXXXX", "YYYYYY");
        BottomPopBean bean23 = new BottomPopBean(R.mipmap.ic_launcher, "XXXXXX", "YYYYYY");
        BottomPopBean bean24 = new BottomPopBean(R.mipmap.ic_launcher, "XXXXXX", "YYYYYY");
        BottomPopBean bean25 = new BottomPopBean(R.mipmap.ic_launcher, "XXXXXX", "YYYYYY");
        list1.add(bean21);
        list1.add(bean22);
        list1.add(bean23);
        list1.add(bean24);
        list1.add(bean25);
        list1.add(bean24);
        list1.add(bean25);
        list1.add(bean24);
        list1.add(bean25);
        list1.add(bean24);
        list1.add(bean25);
        list1.add(bean24);
        list1.add(bean25);
        linearLayout.removeAllViews();
        for (int i = 0; i < list1.size(); i++) {
            final BottomPopBean bean = list1.get(i);
            View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    null);
            ImageView imageView = view.findViewById(R.id.iv);
            TextView tvTitle = view.findViewById(R.id.title);
            TextView tvSubtitle = view.findViewById(R.id.sub_title);
            View relativeLayout = view.findViewById(R.id.iv_bg);
            if (i == 0) {
                tvTitle.setTextColor(Color.parseColor("#484f65"));
                tvSubtitle.setTextColor(Color.parseColor("#7e8695"));
                setRadiusGradient(relativeLayout, "#f4f7fe", "#e3eaf2");
            } else if (i == 1) {
                tvTitle.setTextColor(Color.parseColor("#97866c"));
                tvSubtitle.setTextColor(Color.parseColor("#afa38d"));
                setRadiusGradient(relativeLayout, "#f5eddf", "#e5decb");
            }else {
                tvTitle.setTextColor(Color.parseColor("#695e5a"));
                tvSubtitle.setTextColor(Color.parseColor("#b9a39b"));
                setRadiusGradient(relativeLayout, "#f5eeed", "#ece3e0");
            }
            imageView.setImageResource(bean.getImage());
            tvTitle.setText(bean.getTitle());
            tvSubtitle.setText(bean.getSubTitle());
            linearLayout.addView(view);

        }

    }

    private void setRadiusGradient(View view, String startColor, String endColor) {
        int[] array = new int[2];
        array[0] = Color.parseColor(startColor);
        array[1] = Color.parseColor(endColor);
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TL_BR, array);
        gd.setCornerRadius(12);
        //创建drawable
        view.setBackgroundDrawable(gd);
    }

}
