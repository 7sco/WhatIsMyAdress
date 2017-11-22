package com.example.franciscoandrade.whatismyaddress;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by franciscoandrade on 11/21/17.
 */

public class EmailViewHolder extends RecyclerView.Adapter<EmailViewHolder.ViewHolderEmail>  {
    ArrayList<Email> listEmail;


    public EmailViewHolder(ArrayList<Email> listEmail) {
        this.listEmail = listEmail;
    }

    @Override
    public EmailViewHolder.ViewHolderEmail onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent, false);
        return new ViewHolderEmail(view);

    }

    @Override
    public void onBindViewHolder(final EmailViewHolder.ViewHolderEmail holder, final int position) {
        holder.onBind(listEmail.get(position).getEmail());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {

                Toast.makeText(view.getContext(), "Clicked",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listEmail.size();
    }



    public class ViewHolderEmail extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView email;


        ItemClickListener itemClickListener;


        public ViewHolderEmail(View itemView) {
            super(itemView);

            email=itemView.findViewById(R.id.idtextRecycler);
        }

        public void onBind(String movie) {

            email.setText(movie);

        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener=ic;
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(view, getLayoutPosition());

        }
    }
}
