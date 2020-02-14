package com.example.opencode20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class list_Adapter extends BaseAdapter {

    private String[] Rank;
    private String[] Name;
    private String[] ID;
    private int[] DP;
    private String[] TPoints;
    private String[] PRs;

    private LayoutInflater inflater;

    //RankArray, NameArray, IDArray, drawableArray, TPointsArray, PRsArray
    public list_Adapter(Context context,String[] Rank,String[] Name, String[] ID, int[] DP, String[] TPoints, String[] PRs) {
        inflater = LayoutInflater.from(context);
        this.Rank = Rank;
        this.Name = Name;
        this.DP = DP;
        this.ID = ID;
        this.TPoints = TPoints;
        this.PRs = PRs;
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
            convertView = inflater.inflate(R.layout.lboard_layout,parent,false);
            TextView rank = convertView.findViewById(R.id.Rank);
            rank.setText(Rank[position]);
            TextView name = convertView.findViewById(R.id.Name);
            name.setText(Name[position]);
            TextView id = convertView.findViewById(R.id.ID);
            id.setText(ID[position]);

            ImageView dp = convertView.findViewById(R.id.user_DP);
            dp.setImageResource(DP[position]);

            TextView TotalPoints = convertView.findViewById(R.id.TPoint);
            TotalPoints.setText(TPoints[position]);

            TextView prs = convertView.findViewById(R.id.PRs);
            prs.setText(PRs[position]);
        }
        return convertView;
    }
}
