package com.example.mad_assignment3_kalsoomasghar;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends AppCompatActivity {
    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private List<ModelClass> modelClassList;

    public RecyclerViewAdapter(Context mContext, List<ModelClass> modelClassList) {
        this.mContext = mContext;
        this.modelClassList = modelClassList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout parentLayout;
        CircleImageView image;
        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "recyclerviewAdapter viewholderclass");

            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
            image = (CircleImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById((R.id.name));

        }
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "recyclerviewAdapter oncreateviewholder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_view_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    public int getItemCount() {
        return modelClassList.size();
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(modelClassList.get(position).getImage())
                .into(holder.image);

        holder.name.setText(modelClassList.get(position).getName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View v) {
                                                       Intent i = new Intent(mContext, Screen2.class);

                                                       i.putExtra("images", modelClassList.get(position).getImage());
                                                       i.putExtra("names", modelClassList.get(position).getName());
                                                       i.putExtra("numbers", modelClassList.get(position).getNumber());
                                                       i.putExtra("emails", modelClassList.get(position).getEmail());

                                                       mContext.startActivity(i);
                                                   }
                                               }

                //..............................................................................................

        );
    }
}


