package com.example.aipham.vietlai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NDFeedbackAdapter extends BaseAdapter {

    Context context;
    int myLayout;
    List<NDFeedback> arrayList;

    public NDFeedbackAdapter(Context context, int myLayout, List<NDFeedback> arrayList) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {

        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup paent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);
        TextView txtName = (TextView)convertView.findViewById(R.id.txtName);
        ImageView imageHinh = (ImageView)convertView.findViewById(R.id.imageHinh);

        txtName.setText(arrayList.get(position).noiDung);
        imageHinh.setImageResource(arrayList.get(position).Hinh);

        return convertView;
    }


}
