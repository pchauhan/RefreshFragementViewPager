package com.sn.RefreshFragementViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.ViewGroup;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    HashMap<Integer,Demo_Fragment> mPageReferenceMap ;
    ViewPagerAdapter mAdapter ;
    ViewPager mViewPager;
    SmartTabLayout mViewPagerTab;
    ProgressDialog mProgressDialog ;
    ArrayList<String> mArrString ;
    Handler mHandler ;
    Runnable mRunnable ;
    private int randomInt = 0;
    Random randomGenerator ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Updating...");
        mProgressDialog.setCancelable(false);

        mPageReferenceMap = new HashMap<>();
        mArrString = new ArrayList<>();
        int size =10;
        for (int i = 0; i < size; i++) {

            mArrString.add(String.valueOf("Position ="+i));
        }
        mHandler = new Handler();

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(),mArrString );
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);
        mViewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        mViewPagerTab.setViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                final Demo_Fragment demo_Fragment = getFragment(mViewPager.getCurrentItem());
                final String str = mArrString.get(mViewPager.getCurrentItem());
                demo_Fragment.updateView(str);
                showDialog();
                mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        randomGenerator = new Random();
                        randomInt = randomGenerator.nextInt(10000);
                        demo_Fragment.updateView(str +"\n" +randomInt+"-Updated Value");
                        hideDialog();
                    }
                };
                mHandler.postDelayed(mRunnable, 2000);


            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(10000);

        showDialog();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                final Demo_Fragment demo_Fragment = getFragment(mViewPager.getCurrentItem());
                final String str = mArrString.get(mViewPager.getCurrentItem());
                randomInt = randomGenerator.nextInt(10000);
                demo_Fragment.updateView(str+"\n" +randomInt+"-Updated Value");
                hideDialog();
            }
        };
        mHandler.postDelayed(mRunnable, 2000);
    }
    public void showDialog(){
        mProgressDialog.show();
    }
    public void hideDialog(){
        mProgressDialog.dismiss();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public Demo_Fragment getFragment(int key) {
        return mPageReferenceMap.get(key);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        List<String> mList;

        public ViewPagerAdapter(FragmentManager fm, List<String> list) {
            super(fm);
            mList = list;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String  title = mList.get(position);
            return title;
        }

        public int getCount() {
            return mList.size();
        }

        public Fragment getItem(int position) {
            Demo_Fragment fragment = new Demo_Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("text",mList.get(position));
            fragment.setArguments(bundle);
            fragment.setTags(position);
            mPageReferenceMap.put(position, fragment);

            return fragment;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            mPageReferenceMap.remove(position);
        }

        public int getItemPosition(Object item) {
            Demo_Fragment fragment = (Demo_Fragment) item;
            int position = fragment.getTags();
            if (position >= 0) {
                return position;
            } else {
                return POSITION_NONE;
            }
        }
    }

}
