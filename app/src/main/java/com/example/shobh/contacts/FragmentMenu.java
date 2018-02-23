package com.example.shobh.contacts;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMenu extends Fragment {

    Button b1,b2,b3,b4,b5;
    private FragmentInteractionListener listener;

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(context instanceof FragmentInteractionListener){
            listener=(FragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException("must implement interface");
        }
    }

    public FragmentMenu() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_menu, container, false);

        b1=v.findViewById(R.id.b1);
        b2=v.findViewById(R.id.b2);
        b3=v.findViewById(R.id.b3);
        b4=v.findViewById(R.id.b4);
        b5=v.findViewById(R.id.b5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemClicked(5);
            }
        });
        return v;
    }

    public interface FragmentInteractionListener{
        void itemClicked(int p0);
    }
}
