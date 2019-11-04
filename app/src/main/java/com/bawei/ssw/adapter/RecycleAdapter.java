package com.bawei.ssw.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.ssw.Main2Activity;
import com.bawei.ssw.R;
import com.bawei.ssw.bean.Beans;
import com.bawei.ssw.view.MainActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 *  * <p>文件描述：<p>
 *  * <p>作者：Zhang Zhi Bo<p>
 *  * <p>创建时间：2019/10/24 08 55 28<p>
 *  * <p>版本号：1<p>
 */
public class  RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Holder> {
    private Context context;
    private List<Beans.ResultBean> list;
    private MainActivity mainActivity;

    public RecycleAdapter(Context context, List<Beans.ResultBean> list) {
        this.context = context;
        this.list = list;
        this.mainActivity = (MainActivity) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
      holder.textView.setText(list.get(i).commodityName);
      Glide.with(context)
              .load(list.get(i).masterPic)
              .placeholder(R.drawable.ic_launcher_background)
              .error(R.drawable.ic_launcher_background)
              .into(holder.imageView);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(mainActivity, Main2Activity.class);
              intent.putExtra("name",list.get(i).commodityName);
              mainActivity.startActivity(intent);

          }
      });
	  
	  

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
             imageView = itemView.findViewById(R.id.image);
             textView = itemView.findViewById(R.id.text);
        }
    }
}
