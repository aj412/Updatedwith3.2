package com.hasbrain.howfastareyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by ajatc on 15/7/2016.
 */
public class ListAdapter extends ArrayAdapter<Data> {
    public ListAdapter(Context context, int resource) {
        super(context, resource);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
String message;
        if(convertView == null){
            // make changes for gridview in this file
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.content_time, parent,false);
            // convertView.setLayoutParams(new GridView.LayoutParams(size, size));

        }

       // Data data = getItem(position);
        TextView title = (TextView) convertView.findViewById(R.id.tv);
     //String var =
        //title.setText();
       // message = getIntent().getExtras().getString(TestActivity.EXTRA_DD);




        return convertView;
    }


}
