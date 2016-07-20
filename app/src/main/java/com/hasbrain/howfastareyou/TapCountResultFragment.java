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

/**
 * Created by Jupiter (vu.cao.duy@gmail.com) on 10/14/15.
 */
public class TapCountResultFragment extends Fragment {
    int s;
    long btnTime;
    Data[] data;
    private static final String TAG = "MyApp";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);


}

    @Override
    public void onViewCreated(final View v, Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
       s = bundle.getInt(TapCountActivity.EXTRA_DD);
       btnTime = bundle.getLong(TapCountActivity.EXTRA_PP);


        RecyclerView rvContacts = (RecyclerView) v.findViewById(R.id.view);

        // Initialize contacts

        // Create adapter passing in the sample user data
       HighScoreAdapter adapter = new HighScoreAdapter(getActivity(), data);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);

        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));
        // That's all!
    }



    public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.ViewHolder> {
        private Data[] mData;
        private Context mContext;

        public HighScoreAdapter(FragmentActivity activity, Data[] data) {
           activity= (FragmentActivity) mContext;
            data =mData;

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


        // Pass in the newRedditPost     array into the constructor
        public HighScoreAdapter(Context context, Data[] data) {
            mData = data;
            mContext = context;
        }

        private Context getContext() {
            return mContext;
        }



        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Data data = mData[position];

            // Set item views based on your views and data model
            TextView textView = holder.btnclick;
            textView.setText(s);
            TextView textView1 = holder.time;
            textView1.setText((int) btnTime);

        }

        @Override
        public int getItemCount() {
            return mData.length;
        }





        // each data item is just a string in this case


    }





}
