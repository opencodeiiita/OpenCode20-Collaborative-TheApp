package com.example.opencode20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MentorsFragment extends Fragment {

    private GridView gridView;
    private static String[] userName = {"Ritik Harchani","Prateek Mishra","Ekansh Bansal","Jigar","Manthan","Ayush", "Nitin","Shivansh"};
    private static int[] userDP = {R.drawable.dummy_mentor,R.drawable.dummy_mentor,R.drawable.dummy_mentor,R.drawable.dummy_mentor,
            R.drawable.dummy_mentor,R.drawable.dummy_mentor,R.drawable.dummy_mentor,R.drawable.dummy_mentor};
    private static String[] userID = {"@harchani-ritik", "@mikinshu", "@Ace-Bansal", "@Jigar3", "@thesmallstar","@ayush","@Nitin" ,"@Shiv07tiwari"};
    private grid_Adapter grid_adapter;

    public static MentorsFragment newInstance()
    {
        return new MentorsFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mentors,null);
        gridView = rootView.findViewById(R.id.gridView);
        grid_adapter = new grid_Adapter(getContext(),userName,userDP,userID );
        gridView.setAdapter(grid_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), userName[position], Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
