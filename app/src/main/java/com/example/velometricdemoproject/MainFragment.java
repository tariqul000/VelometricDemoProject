package com.example.velometricdemoproject;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.velometricdemoproject.adopter.RecyclerViewAdapter;
import com.example.velometricdemoproject.holder.AllHomeViewHolder;
import com.example.velometricdemoproject.model.HomeViewModel;
import com.example.velometricdemoproject.rest.ApiService;
import com.example.velometricdemoproject.rest.RetroClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    RecyclerView recyclerView;
    public List<HomeViewModel> allSong;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        getAllDataView("datafeed.json.php?section=top10");
        return rootView;
    }




    public void getAllDataView(final String url) {

        allSong= new ArrayList<>();

        final ProgressDialog dialog;

        /**
         * Progress Dialog for User Interaction
         */
        dialog = ProgressDialog.show(getActivity(), null, null, true, false);
        dialog.setContentView(R.layout.progress_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        ApiService api = RetroClient.getApiService();

        Call<List<HomeViewModel>> cell = api.getMyJSON(url);

        Log.d("Home Api", " " + cell.request().url().toString());
        cell.enqueue(new Callback<List<HomeViewModel>>() {
            @Override
            public void onResponse(Call<List<HomeViewModel>> call, Response<List<HomeViewModel>> response) {
                //Dismiss Dialog
                if (response.isSuccessful()) {

                        allSong = response.body();

                    Log.d("get value", allSong.get(1).getTitle());

                    setAdopter(allSong);

                }
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<HomeViewModel>> call, Throwable t) {
                Toast.makeText(getActivity(), "NO internet connection", Toast.LENGTH_LONG).show();
                Log.d("Home Api error", " " + t.getLocalizedMessage());

               dialog.dismiss();
            }
        });
    }

    public void setAdopter(List<HomeViewModel> allSong){


        RecyclerViewAdapter recyclerViewAdapter= new RecyclerViewAdapter(allSong);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter.notifyDataSetChanged();

    }
}
