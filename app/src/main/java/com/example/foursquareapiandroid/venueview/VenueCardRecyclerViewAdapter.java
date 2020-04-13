package com.example.foursquareapiandroid.venueview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foursquareapiandroid.R;
import com.example.foursquareapiandroid.dto.CategoryDTO;
import com.example.foursquareapiandroid.dto.search.Venue;

import java.util.Date;
import java.util.List;

public class VenueCardRecyclerViewAdapter extends RecyclerView.Adapter<VenueCardViewHolder>{

    private List<Venue> venueList;

    private Context context;


    public VenueCardRecyclerViewAdapter(List<Venue> venueList, Context context) {
        this.venueList = venueList;
        this.context=context;
    }

    @NonNull
    @Override
    public VenueCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.venue_card, parent, false);
        return new VenueCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueCardViewHolder holder, final int position) {
        if (venueList != null && position < venueList.size()) {
            Venue venue = venueList.get(position);
            
            holder.venue_name.setText(venue.getName());
            holder.venue_city.setText(venue.getLocation().getCity());
            holder.venue_address.setText(venue.getLocation().getAddress());
            holder.venue_country.setText(venue.getLocation().getCountry());
            if(venue.getCategories().size()>0){
                for(CategoryDTO categoryDTO : venue.getCategories()){
                    holder.venue_category.setText(holder.venue_category.getText()+":"+categoryDTO.getName());
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }
}
