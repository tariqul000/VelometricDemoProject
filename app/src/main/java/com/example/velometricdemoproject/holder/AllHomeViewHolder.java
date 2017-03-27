package com.example.velometricdemoproject.holder;

import com.example.velometricdemoproject.model.HomeViewModel;

import java.util.ArrayList;



/**
 * Created by user on 3/21/2017.
 */

public class AllHomeViewHolder extends HomeViewModel {


    private ArrayList<HomeViewModel> homeViewModels = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<HomeViewModel> getHomeViewModel() {
        return homeViewModels;
    }

    /**
     * @param homeViewModel The contacts
     */
    public void setHomeViewModel(ArrayList<HomeViewModel> homeViewModel) {
        this.homeViewModels = homeViewModel;
    }
}
