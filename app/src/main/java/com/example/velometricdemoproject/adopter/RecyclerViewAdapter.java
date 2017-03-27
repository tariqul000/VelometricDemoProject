package com.example.velometricdemoproject.adopter;



import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.velometricdemoproject.R;
import com.example.velometricdemoproject.holder.AllHomeViewHolder;
import com.example.velometricdemoproject.model.HomeViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chris.black on 6/11/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<HomeViewModel> homeViewModelSong;

    public RecyclerViewAdapter(List<HomeViewModel> homeViewModelSong) {
        this.homeViewModelSong = homeViewModelSong;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder viewHolder, int i) {

        Log.d("homeViewModelSong ",homeViewModelSong.get(i).getTitle());
        viewHolder.text1.setText(homeViewModelSong.get(i).getTitle());
        viewHolder.text2.setText(homeViewModelSong.get(i).getArtist());

    }

    @Override
    public int getItemCount() {
        return homeViewModelSong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView text1,text2;
        public ViewHolder(View view) {
            super(view);

            text1 = (TextView)view.findViewById(R.id.text1);
            text2 = (TextView)view.findViewById(R.id.text2);


        }
    }

}