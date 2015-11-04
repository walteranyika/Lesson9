package com.walter.lesson9;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//Ctrl+Shift+O
////Ctrl+Shift+F

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Item> data;

	// Constructor
	public CustomAdapter(Context context, ArrayList<Item> data) {
		this.mContext = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,
					false);
			viewHolder = new ViewHolder();
			viewHolder.titleTextView = (TextView) convertView
					.findViewById(R.id.textViewItem);
			viewHolder.posTextView = (TextView) convertView
					.findViewById(R.id.textViewPos);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Item mchongo = data.get(position);
		viewHolder.titleTextView.setText(mchongo.getTitle());
		viewHolder.posTextView.setText(mchongo.getPosition());

		return convertView;
	}

	static class ViewHolder {
		TextView titleTextView;
		TextView posTextView;
	}

}
