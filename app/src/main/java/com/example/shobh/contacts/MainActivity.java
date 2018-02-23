package com.example.shobh.contacts;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentMenu.FragmentInteractionListener {

    private android.support.v4.app.FragmentManager fragmentmanager;
    private Fragment fragment;
    private FrameLayout f1,f2;
    private android.support.v4.app.FragmentTransaction fragmenttransaction;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentmanager=getSupportFragmentManager();
        fragment=new FragmentMenu();
        fragmenttransaction=fragmentmanager.beginTransaction();
        fragmenttransaction.replace(R.id.fragment_container,fragment);
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
        f1=(findViewById(R.id.fragment_container));
        f2=(findViewById(R.id.front2));
    }

    @Override
    public void itemClicked(int position){

        fragmentmanager=getSupportFragmentManager();

        switch(position){
            case 1:
                fragment=new Bookfragment();
                break;

            case 2:
                fragment=new magfragent();
                break;

            case 3:
            fragment=new newsfragment();
                break;

            case 4:
                fragment=new comicfragment();
                break;

            case 5:
                fragment=new weeklyfargment();
                break;
        }
        fragmenttransaction=fragmentmanager.beginTransaction();
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
            fragmenttransaction.replace(R.id.front2,fragment);
        else
            fragmenttransaction.replace(R.id.fragment_container,fragment);
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
    }
}
