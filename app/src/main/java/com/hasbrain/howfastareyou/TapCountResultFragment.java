package com.hasbrain.howfastareyou;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jupiter (vu.cao.duy@gmail.com) on 10/14/15.
 */
public class TapCountResultFragment extends Fragment {
    int s;
Context context;

  // long[] timeArray;
    List<String> timeArray = new ArrayList<>();
    List<Integer> buttonclickArray = new ArrayList<>();
    //Data[] Mdata;
  //ArrayList<Long> mylist = new ArrayList<>();

    private static final String TAG = "MyApp";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View rootview = inflater.inflate(R.layout.fragment_layout, container, false);
        return rootview;


}

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putIntegerArrayList("integer", (ArrayList<Integer>) buttonclickArray);
        bundle.putStringArrayList("teem", (ArrayList<String>) timeArray);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            //Restore the fragment's state
            timeArray = (List<String>) savedInstanceState.getStringArrayList("teem");
            buttonclickArray = (List<Integer>) savedInstanceState.getIntegerArrayList(("integerx"));
    }
    }
    @Override
    public void onViewCreated(final View v, Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
       s = bundle.getInt(TapCountActivity.EXTRA_DD);
        buttonclickArray.add(s);
        timeArray = bundle.getStringArrayList("time");
        setRetainInstance(true);


        RecyclerView rvContacts = (RecyclerView) v.findViewById(R.id.view);


        // Create adapter passing in the sample user data
       HighScoreAdapter adapter = new HighScoreAdapter(getActivity(),timeArray, buttonclickArray);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);

        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(( getContext())));
        // That's all!
    }



    public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.ViewHolder> {
        private ArrayList<String> time1;
        private Context mContext;


        private Context getContext() {
            return mContext;
        }


        public HighScoreAdapter(FragmentActivity activity, List<String> data, List<Integer> buttonclickArray) {
            activity = (FragmentActivity) mContext;
            data = time1;


        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // inflate view to xml file

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_time, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView btnclick;
            public TextView time;


            public ViewHolder(View itemView) {
                super(itemView);
               btnclick= (TextView) itemView.findViewById(R.id.tv);
                time = (TextView) itemView.findViewById(R.id.tvTime);

            }
        }






        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {



            //Long data = timeArray.get(position);

            // Set item views based on your views and data model
            TextView textView = holder.btnclick;
            textView.setText(String.valueOf(s));

            TextView textView1 = holder.time;
            textView1.setText("" + String.valueOf(timeArray.get(position))); //set array data here

            //You need a fucking data class to display the recyclerview
            //Reason being, data can be captured but u need the data class to be filled and populate with values for display
        }

        @Override
        public int getItemCount() {
            return timeArray.size();
        }





        // each data item is just a string in this case


    }





}
