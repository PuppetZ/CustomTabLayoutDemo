package com.example.z_z.customtablayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Z_z on 2017/12/18.
 */

public class DummyFragment extends ListFragment {
    private TextView mTextView;
    private List<Map<String,String>> mMapList = new ArrayList<>();
    private int tabIndex = 0;
    private String text = "";


    /**
     * 单例模式创建Fragment
     * @param tabIndex  fragment索引
     * @return  fragment
     */
    public static DummyFragment newInstance(int tabIndex){
        DummyFragment fragment = new DummyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex",tabIndex);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabIndex = getArguments().getInt("tabIndex");
        switch (tabIndex){
            case 0:
                text = "这是第一个tab";
            case 1:
                text = "这是第二个tab";
            case 2:
                text = "这是第三个tab";
            case 3:
                text = "这是第四个tab";
            case 4:
                text = "这是第五个tab";
            case 5:
                text = "这是第六个tab";
        }
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            Map<String,String>map = new HashMap<>();
            map.put("text","text"+ i);
            mMapList.add(map);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dummy,container,false);
        mTextView =  view.findViewById(R.id.textView_fragment_info);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView.setText(text);
        SimpleAdapter adapter = new SimpleAdapter(getContext(),mMapList,R.layout.item_listview_dummyfragment,new String[]{"text"},new int[]{R.id.textView_item_title});
        setListAdapter(adapter);
    }
}
