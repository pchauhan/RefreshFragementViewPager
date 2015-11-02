package com.sn.RefreshFragementViewPager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by parag on 2/11/2015.
 */
public class Demo_Fragment extends Fragment {
    TextView mTextView;

    int position ;


    public void setTags(int position){
        this.position = position;
    }

    public  int getTags(){
        return position;
    }


    public  void updateView(String mText){
     mTextView.setText(mText);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_fragment, container, false);
        mTextView = (TextView) view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        String text = bundle.getString("text");
        mTextView.setText(text);
        return view;
    }



}
