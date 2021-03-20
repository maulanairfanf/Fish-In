package com.simalakama.fishin.ui.profil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.simalakama.fishin.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> title;
    private HashMap<String, List<String>> detail;

    public FaqAdapter(Context context, List<String> title, HashMap<String, List<String>> detail) {
        this.context = context;
        this.title = title;
        this.detail = detail;
    }

    @Override
    public int getGroupCount() {
        return title.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return detail.get(title.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return title.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return detail.get(title.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String stringTitle = (String)getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_title_faq, null);
        }
        TextView title = convertView.findViewById(R.id.txt_title);
        title.setText(stringTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String stringDetail = (String)getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_detail_faq, null);
        }
        TextView detail = convertView.findViewById(R.id.txt_detail);
        detail.setText(stringDetail);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
