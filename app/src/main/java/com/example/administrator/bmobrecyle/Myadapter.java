package com.example.administrator.bmobrecyle;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class Myadapter extends  RecyclerView.Adapter<Myadapter.ViewHolder>{
    List<Person> perlist;
    OnDeiListener listener;
    public Myadapter(List<Person> perlist,OnDeiListener listener){
        this.perlist=perlist;
        this.listener=listener;
    }
    public void changData(List<Person> perlist) {
        this.perlist = perlist;
        notifyDataSetChanged();
    }

    static public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1;
        private TextView tv2;
        private Button del;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1= (TextView) itemView.findViewById(R.id.tv1);
            tv2= (TextView) itemView.findViewById(R.id.tv2);
            del= (Button) itemView.findViewById(R.id.btn_del);
        }

    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        ViewHolder holder=new ViewHolder(view);




        return holder;
    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
            Person person=perlist.get(position);
            holder.tv1.setText(person.getName());

             holder.tv2.setText(person.getAddress());

        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.del();
            }
        });

    }





    public int getItemCount() {
        return perlist.size();
    }
}
