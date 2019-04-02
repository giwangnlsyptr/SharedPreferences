package com.example.giwangnuelsyaputri.tugas5;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment implements MainView{
    RecyclerView rv;
    ArtistAdapter adapter;
    ArtistPresenter data;
    List<ArtistModel> artistModels = new ArrayList<>();


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new ArtistAdapter(getContext(), artistModels);
        rv.setAdapter(adapter);
        data = new ArtistPresenter(getContext(),this);
        data.setData();
    }

    @Override
    public void onSuccess(List<ArtistModel> artistModels) {
        this.artistModels.clear();
        this.artistModels.addAll(artistModels);
        this.adapter.notifyDataSetChanged();
    }

}
