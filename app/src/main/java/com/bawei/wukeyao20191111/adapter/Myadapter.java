package com.bawei.wukeyao20191111.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wukeyao20191111.R;
import com.bawei.wukeyao20191111.bean.Bean;
import com.bawei.wukeyao20191111.glide.GlideHolder;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 功能：Myadapter类
 * 作者：武柯耀
 * 当前日期：2019/11/11
 * 当前时间：10:00
 */
public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private Context mContext;
   private List<Bean.DataBean.GridDataBean> mList;
  private  final  int ONT_TYPE =1;
    private  final  int TWO_TYPE =2;
    private  final  int THREE_TYPE =3;
    public Myadapter(Context mContext, List<Bean.DataBean.GridDataBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        View view =null;
        switch (i){
            case ONT_TYPE:
                view = LayoutInflater.from(mContext).inflate(R.layout.item,null);
                viewHolder = new OneHolder(view);
                break;
            case TWO_TYPE:
                view = LayoutInflater.from(mContext).inflate(R.layout.item2,null);

                viewHolder = new TwoHolder(view);
                break;
            case THREE_TYPE:
                view = LayoutInflater.from(mContext).inflate(R.layout.item3,null);

                viewHolder = new ThreeHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
      if (viewHolder instanceof OneHolder){
          GlideHolder.imageHolder(mList.get(i).getImageurl(),((OneHolder) viewHolder).mOneImage);
          GlideHolder.imageHolder(mList.get(i).getImageurl(),((OneHolder) viewHolder).mOneImage2);
          GlideHolder.imageHolder(mList.get(i).getImageurl(),((OneHolder) viewHolder).mOneImage3);
      }else {
          ((TwoHolder) viewHolder).mTwoName.setText(mList.get(i).getTitle());
          ((TwoHolder) viewHolder).mTwoPrice.setText(mList.get(i).getPrice());
          GlideHolder.imageHolder(mList.get(i).getImageurl(),((TwoHolder) viewHolder).mTwoImage);
      }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }



    class OneHolder extends RecyclerView.ViewHolder {
        ImageView mOneImage;
        ImageView mOneImage2;
        ImageView mOneImage3;
        public OneHolder(@NonNull View itemView) {
            super(itemView);
            mOneImage = itemView.findViewById(R.id.image);
            mOneImage2 = itemView.findViewById(R.id.image2);
            mOneImage3 = itemView.findViewById(R.id.image3);
        }
    }
    class TwoHolder extends RecyclerView.ViewHolder {
        ImageView mTwoImage;
        TextView mTwoName;
        TextView mTwoPrice;
        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            mTwoImage = itemView.findViewById(R.id.image);
            mTwoName = itemView.findViewById(R.id.name);
            mTwoPrice = itemView.findViewById(R.id.price);
        }
    }
    class ThreeHolder extends RecyclerView.ViewHolder {
        ImageView mThreeImage;
        TextView mThreeName;
        TextView mThreePrice;
        public ThreeHolder(@NonNull View itemView) {
            super(itemView);
            mThreeImage = itemView.findViewById(R.id.image);
            mThreeName = itemView.findViewById(R.id.name);
            mThreePrice = itemView.findViewById(R.id.price);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONT_TYPE;
        } else if (position == 1) {
            return TWO_TYPE;
        }else if (position ==2){

        }
       return  TWO_TYPE;

    }

    //点击事件
    public interface onItemClickListener{
        void onClick(int position);
    }
    public onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }
}
