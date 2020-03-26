package com.example.sale_bird;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class appliances extends RecyclerView.Adapter<appliances.appliancesView> {
    List<Integer> imageList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> price = new ArrayList<>();
    List<String> off = new ArrayList<>();
    private onClickListener monClickListener;
    public appliances(List<Integer> imageList, List<String> titleList, List<String> priceList, List<String> offList, onClickListener OnClickListener)
    {
        this.imageList = imageList;
        this.titleList = titleList;
        this.price = priceList;
        this.off = offList;
        this.monClickListener = OnClickListener;
    }
    @NonNull
    @Override

    public appliancesView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_appliance, viewGroup, false);
        return new appliancesView(view,monClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull appliancesView holder, int position) {
        holder.imagePhone.setImageResource(imageList.get(position));
        holder.textTitle.setText(titleList.get(position));
        holder.price.setText(price.get(position));
        holder.off.setText(off.get(position));

    }

    @Override
    public int getItemCount() {
       return imageList.size();
    }


    public class appliancesView extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagePhone;
        TextView textTitle, price, off;
        onClickListener OnClickListener;
        public appliancesView(@NonNull View itemView,  onClickListener mmOnClickListener) {
            super(itemView);
            imagePhone = itemView.findViewById(R.id.image_phone);
            textTitle = itemView.findViewById(R.id.title_phone);
            price = itemView.findViewById(R.id.price);

            off = itemView.findViewById(R.id.off);
            this.OnClickListener = mmOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnClickListener.onClick(getAdapterPosition());
        }
    }

    public interface onClickListener {
        void onClick(int position);
    }
}
