package com.geeknum1.scrollindicator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;


/**
 * Created by mustang on 2019/07/03.
 */
public class RecyclerListView extends BaseRecyclerBarView {




    public RecyclerListView(Context context) {
        super(context);


    }

    public RecyclerListView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public RecyclerListView(Context context,
                            AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }


    @Override
    public void initView() {
        super.initView();
        ArrayList<BottomPopBean> list1 = new ArrayList<>();
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

        horizontalScrollBar(list1);


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

    private void horizontalScrollBar(ArrayList<BottomPopBean> list1) {
        RecyclerviewAdapter itemAdapter = new RecyclerviewAdapter(getContext(), list1);
        recyclerView.setAdapter(itemAdapter);

    }


    public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

        private Context context;
        private ArrayList<BottomPopBean> data;

        public RecyclerviewAdapter(Context context, ArrayList<BottomPopBean> data) {
            this.context = context;
            this.data = data;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            BottomPopBean bean = data.get(position);
            if (position % 2 == 0) {
                holder.tvTitle.setTextColor(Color.parseColor("#464f65"));
                holder.tvSubtitle.setTextColor(Color.parseColor("#7e8695"));
                setRadiusGradient(holder.relativeLayout, "#f4f7fe", "#e3eaf2");
            } else {
                holder.tvTitle.setTextColor(Color.parseColor("#80715d"));
                holder.tvSubtitle.setTextColor(Color.parseColor("#b3a592"));
                setRadiusGradient(holder.relativeLayout, "#f9f3e9", "#e8e2d4");
            }

            holder.imageView.setImageResource(bean.getImage());
            holder.tvTitle.setText(bean.getTitle());
            holder.tvSubtitle.setText(bean.getSubTitle());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageView;
            private TextView tvTitle;
            private TextView tvSubtitle;
            private View relativeLayout;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.iv);
                tvTitle = itemView.findViewById(R.id.title);
                tvSubtitle = itemView.findViewById(R.id.sub_title);
                relativeLayout = itemView.findViewById(R.id.iv_bg);

            }


        }

    }
}
