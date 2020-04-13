package com.example.foursquareapiandroid.categoryview;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.toolbox.NetworkImageView;

import com.example.foursquareapiandroid.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder  {
    private View view;
    public NetworkImageView category_image;
  //  public Spinner spinner_category;
    public TextView category_name;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view=itemView;
      //  spinner_category=itemView.findViewById(R.id.spinner_category);
        category_name=itemView.findViewById(R.id.category_name);
        category_image=itemView.findViewById(R.id.category_icon);
    }

    public View getView() {
        return view;
    }

}
