package com.example.exercise1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class ListViewAdapter  extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;


    public ListViewAdapter(Context context){
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(list_kontak.classNamaArrayList);
    }

    public void SearchNama(String query){
        list_kontak.classNamaArrayList.clear();
        if (query.isEmpty()){
            list_kontak.classNamaArrayList.addAll(arrayList);
        }
        else {
            query = query.toLowerCase();
            for (ClassNama SeacrhData : arrayList){
                if (SeacrhData.getName().toLowerCase().contains(query)){
                    list_kontak.classNamaArrayList.add(SeacrhData);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return list_kontak.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return list_kontak.classNamaArrayList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = this.inflater.inflate(R.layout.item_listview, (ViewGroup) null);
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(list_kontak.classNamaArrayList.get(i).getName());
        return view;
    }

}