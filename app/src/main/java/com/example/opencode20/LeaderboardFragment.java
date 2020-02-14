package com.example.opencode20;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {

    private ListView listView;
    private static String[] NameArray = {"John Wick","Thor","Tom","Jerry","IronMan", "Batman", "Ultron"};
    private static String[] RankArray = {"1", "2", "3", "4", "5", "6", "7"};
    private static String[] PRsArray = {"59", "54", "50", "45", "43", "40", "39"};
    private static String[] TPointsArray = {"1400", "1350", "1200", "1110", "1070", "900", "880"};
    private static String[] IDArray = {"@nobelgas", "@dummy", "@error404", "@codiotic", "@geeeky", "@CodeBite", "@coding_Nibba"};

    private static int[] drawableArray = {R.drawable.dummy_dp, R.drawable.dummy_dp, R.drawable.dummy_dp, R.drawable.dummy_dp, R.drawable.dummy_dp,
            R.drawable.dummy_dp, R.drawable.dummy_dp, R.drawable.dummy_dp, R.drawable.dummy_dp, R.drawable.dummy_dp};

    private static list_Adapter list_adapter;

    public static LeaderboardFragment newInstance() {
        return new LeaderboardFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaderboard, null);
        listView = rootView.findViewById(R.id.listView);
        list_adapter = new list_Adapter(getContext(), RankArray, NameArray, IDArray, drawableArray, TPointsArray, PRsArray);
        listView.setAdapter(list_adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), NameArray[position] + " is Ranked " + (position+1), Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
}
/************
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * recyclerView = rootView.findViewById(R.id.recyclerView);
 *         data = new ArrayList<>();
 *         layoutManager = new LinearLayoutManager(getContext());
 *         for (int i = 0; i < MyData.NameArray.length; i++) {
 *             data.add(new DataModel(
 *                     MyData.NameArray[i],
 *                     MyData.RankArray[i],
 *                     MyData.IDArray[i],
 *                     MyData.PRsArray[i],
 *                     MyData.id_[i],
 *                     MyData.drawableArray[i],
 *                     MyData.TPointsArray[i]
 *             ));
 *         }
 *         data.add(0,
 *                 new DataModel(
 *                 MyData.NameArray[0],
 *                 MyData.RankArray[0],
 *                 MyData.IDArray[0],
 *                 MyData.PRsArray[0],
 *                 MyData.id_[0],
 *                 MyData.drawableArray[0],
 *                 MyData.TPointsArray[0]
 *         ));
 *         adapter = new recycler_Adapter(data);
 *         recyclerView.setAdapter(adapter);
 *         return rootView;
 *     }

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.NameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }



        removedItems = new ArrayList<Integer>();

        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }


private static class MyOnClickListener implements View.OnClickListener {

    private final Context context;

    private MyOnClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        removeItem(v);
    }

    private void removeItem(View v) {
        int selectedItemPosition = recyclerView.getChildPosition(v);
        RecyclerView.ViewHolder viewHolder
                = recyclerView.findViewHolderForPosition(selectedItemPosition);
        TextView textViewName
                = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
        String selectedName = (String) textViewName.getText();
        int selectedItemId = -1;
        for (int i = 0; i < MyData.nameArray.length; i++) {
            if (selectedName.equals(MyData.nameArray[i])) {
                selectedItemId = MyData.id_[i];
            }
        }
        removedItems.add(selectedItemId);
        data.remove(selectedItemPosition);
        adapter.notifyItemRemoved(selectedItemPosition);
    }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_item) {
            //check if any items to add
            if (removedItems.size() != 0) {
                addRemovedItemToList();
            } else {
                Toast.makeText(this, "Nothing to add", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    private void addRemovedItemToList() {
        int addItemAtListPosition = 3;
        data.add(addItemAtListPosition, new DataModel(
                MyData.nameArray[removedItems.get(0)],
                MyData.versionArray[removedItems.get(0)],
                MyData.id_[removedItems.get(0)],
                MyData.drawableArray[removedItems.get(0)]
        ));
        adapter.notifyItemInserted(addItemAtListPosition);
        removedItems.remove(0);

}
 ****************/