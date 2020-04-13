package com.example.foursquareapiandroid.categoryview;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.android.volley.toolbox.NetworkImageView;
import com.example.foursquareapiandroid.R;
import com.example.foursquareapiandroid.dto.CategoryDTO;
import com.example.foursquareapiandroid.network.ImageRequester;

import java.util.List;


public class CategoryRecyclerViewAdapter extends ArrayAdapter<CategoryDTO> {//RecyclerView.Adapter<CategoryViewHolder> {

    private List<CategoryDTO> categoryList;
    private ImageRequester imageRequester;
   // private Context context;

//    public CategoryRecyclerViewAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Object[] objects) {
//        super(context, resource, textViewResourceId, objects);
//    }
    public CategoryRecyclerViewAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
        this.categoryList=objects;
        imageRequester = ImageRequester.getInstance();
    }



    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public CategoryDTO getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
       return getCustomView(position,convertView,parent);
    }

    public View getCustomView(int position, View convertView,
                              ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, parent, false);
        CategoryDTO categoryDTO = (CategoryDTO) getItem(position);
        TextView category_name = (TextView) row.findViewById(R.id.category_name);
        category_name.setText(categoryDTO.getName());

        imageRequester.setImageFromUrl((NetworkImageView) row.findViewById(R.id.category_icon), categoryDTO.getIcon().getPrefix() + "64" + categoryDTO.getIcon().getSuffix());
        return row;
    }

}
