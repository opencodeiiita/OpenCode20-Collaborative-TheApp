package com.example.opencode20;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class
ParticipantsFragment extends Fragment {

    private GridView gridView;
    private static String[] userName = {"John Wick","Thor","Tom","Jerry","IronMan"};
    private static int[] userDP = {R.drawable.dummy_dp,R.drawable.dummy_dp,R.drawable.dummy_dp,R.drawable.dummy_dp,R.drawable.dummy_dp};
    private static String[] userID = {"@nobelgas", "@dummy", "@error404", "@codiotic", "@geeeky"};
    private grid_Adapter grid_adapter;

    public static ParticipantsFragment newInstance()
    {
        return new ParticipantsFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_participants,null);
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
