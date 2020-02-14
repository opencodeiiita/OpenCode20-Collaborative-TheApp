package com.example.opencode20;

import android.content.Context;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class grid_Adapter extends BaseAdapter {

    private String[] Name;
    private int[] DP;
    private String[] ID;

    private LayoutInflater inflater;

    public grid_Adapter(Context context, String[] Name, int[]DP, String[] ID) {
        inflater = LayoutInflater.from(context);
        this.Name = Name;
        this.DP = DP;
        this.ID = ID;
    }

    @Override
    public int getCount() {
        return Name.length;
    }

    @Override
    public Object getItem(int position) {
        return Name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = inflater.inflate(R.layout.gridadapter,parent,false);
            TextView name = convertView.findViewById(R.id.userName);
            name.setText(Name[position]);

            TextView id = convertView.findViewById(R.id.userID);
            id.setText(ID[position]);

            ImageView dp = convertView.findViewById(R.id.userDP);
            dp.setImageResource(DP[position]);
        }
        return convertView;
    }
}
