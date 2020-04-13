package com.example.foursquareapiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.foursquareapiandroid.api.FourSquaresApiService;
import com.example.foursquareapiandroid.categoryview.CategoryRecyclerViewAdapter;
import com.example.foursquareapiandroid.dto.CategoryDTO;
import com.example.foursquareapiandroid.dto.CategoryResponse;
import com.example.foursquareapiandroid.dto.Icon;
import com.example.foursquareapiandroid.dto.search.Location;
import com.example.foursquareapiandroid.dto.search.SearchResponse;
import com.example.foursquareapiandroid.dto.search.Venue;
import com.example.foursquareapiandroid.dto.search.VenuesResponse;
import com.example.foursquareapiandroid.venueview.VenueCardRecyclerViewAdapter;
import com.example.foursquareapiandroid.venueview.VenueGridItemDecoration;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String categoryId;
    private Spinner spinner_category;
    private List<CategoryDTO> list = new ArrayList<CategoryDTO>();
    //    private TextInputLayout queryTextInput;
    private TextInputEditText queryEditText;
    //   private TextInputLayout locationTextInput;
    private TextInputEditText locationEditText;
    private Button btnSearch;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;

    //venues
    private RecyclerView recyclerView;
    private List<Venue> venues = new ArrayList<>();
    private VenueCardRecyclerViewAdapter venueCardRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        venues = new ArrayList<>();
        addItemsOnSpinnerCategory();
        locationEditText = findViewById(R.id.edit_location_editor);
        queryEditText = findViewById(R.id.edit_query_editor);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recycler_view);
        setBtnSearchClickListener();
        setRecyclerView();


    }


    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2,
                GridLayoutManager.VERTICAL, false));

        //  venues.add(new Venue("1", "chelentano",new Location(), null));
        venueCardRecyclerViewAdapter = new VenueCardRecyclerViewAdapter(venues, getApplicationContext());

        recyclerView.setAdapter(venueCardRecyclerViewAdapter);

        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new VenueGridItemDecoration(largePadding, smallPadding));
    }

    public void setBtnSearchClickListener() {


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venues.clear();
                String location = locationEditText.getText().toString();
                String query = queryEditText.getText().toString();

                final Map<String, String> data = new HashMap<>();
                data.put("near", location);
                data.put("query", query);
                data.put("categoryId", categoryId);
                FourSquaresApiService.getInstance()
                        .getJSONApi()
                        .getPlaces(data)
                        .enqueue(new Callback<VenuesResponse>() {
                            @Override
                            public void onResponse(@NonNull Call<VenuesResponse> call, @NonNull Response<VenuesResponse> response) {
                                venues.addAll(response.body().getResponse().getVenues());
                                //venues =response.body().getVenues();
//                                for (Venue venue : venues) {
//                                    Log.e("item", venue.toString());
//                                }
                                // categoryRecyclerViewAdapter.notifyDataSetChanged();
                                venueCardRecyclerViewAdapter.notifyDataSetChanged();

                            }

                            @Override
                            public void onFailure(@NonNull Call<VenuesResponse> call, @NonNull Throwable t) {
                                Log.e("ERROR", "*************ERORR request***********");
                                t.printStackTrace();
                            }
                        });
            }
        });
    }

    public void addItemsOnSpinnerCategory() {

        spinner_category = (Spinner) findViewById(R.id.spinner_category);

        FourSquaresApiService.getInstance()
                .getJSONApi()
                .getAllCategories()
                .enqueue(new Callback<CategoryResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CategoryResponse> call, @NonNull Response<CategoryResponse> response) {
                        list.addAll(response.body().getResponse().getCategories());
//                        for (CategoryDTO category : list) {
//                            Log.e("item", category.toString());
//                        }
                        categoryRecyclerViewAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
                        Log.e("ERROR", "*************ERORR request***********");
                        t.printStackTrace();
                    }
                });

        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(MainActivity.this, R.layout.spinner_item, R.id.spinner_category, list);//MainActivity.this, R.id.spinner_category,list);
        categoryRecyclerViewAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_category.setAdapter(categoryRecyclerViewAdapter);
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                CategoryDTO categoryDTO = categoryRecyclerViewAdapter.getItem(position);
                // Here you can do the action you want to...
            //    Toast.makeText(MainActivity.this, "ID: " + categoryDTO.getId(), Toast.LENGTH_SHORT).show();
                categoryId = categoryDTO.getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });
    }
}
