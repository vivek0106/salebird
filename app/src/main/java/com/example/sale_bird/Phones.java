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

public class Phones extends RecyclerView.Adapter<Phones.PhonesView> {
    List<Integer> imageList=new ArrayList<>();
    List<String> titleList=new ArrayList<>();
    List<String> price=new ArrayList<>();
    List<String> emi=new ArrayList<>();
    List<String> off=new ArrayList<>();
    private onClickListener monClickListener;

    public Phones(List<Integer> imageList, List<String> titleList, List<String> priceList,List<String> emiList,List<String> offList, onClickListener OnClickListener) {
        this.imageList=imageList;
        this.titleList=titleList;
        this.price=priceList;
        this.emi=emiList;
        this.off=offList;
        this.monClickListener=OnClickListener;
    }



    @NonNull
    @Override
    public PhonesView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_phone,viewGroup,false);
        return new PhonesView(view,monClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhonesView phonesView, int position) {
        phonesView.imagePhone.setImageResource(imageList.get(position));
        phonesView.textTitle.setText(titleList.get(position));
        phonesView.price.setText(price.get(position));
        phonesView.emi.setText(emi.get(position));
        phonesView.off.setText(off.get(position));

    }
    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class PhonesView extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imagePhone;
        TextView textTitle,price,emi,off;
        onClickListener OnClickListener;
        public PhonesView(@NonNull View itemView,onClickListener mmOnClickListener) {
            super(itemView);
            imagePhone=itemView.findViewById(R.id.image_phone);
            textTitle=itemView.findViewById(R.id.title_phone);
            price=itemView.findViewById(R.id.price);
            emi=itemView.findViewById(R.id.emi);
            off=itemView.findViewById(R.id.off);
            this.OnClickListener=mmOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnClickListener.onClick(getAdapterPosition());

        }
    }
    public interface onClickListener{
        void onClick(int position);
    }
}
