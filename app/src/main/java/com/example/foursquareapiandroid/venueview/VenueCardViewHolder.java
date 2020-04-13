package com.example.foursquareapiandroid.venueview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.foursquareapiandroid.R;

public class VenueCardViewHolder  extends RecyclerView.ViewHolder {

    private View view;
 //   public NetworkImageView productImage;
    public TextView venue_name;
    public TextView venue_city;
    public TextView venue_country;
    public TextView venue_address;
    public TextView venue_category;


    public VenueCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view=itemView;
        venue_name = itemView.findViewById(R.id.venue_name);
        venue_city = itemView.findViewById(R.id.venue_city);
        venue_country = itemView.findViewById(R.id.venue_country);
        venue_address = itemView.findViewById(R.id.venue_address);
        venue_category = itemView.findViewById(R.id.venue_category);


    }

    public View getView() {
        return view;
    }


}
