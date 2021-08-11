package com.devenicio.forbegineer.view.fragments;


import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.devenicio.forbegineer.R;



public class MainFragment extends Fragment implements View.OnClickListener {


    CardView cvCep, cvQuotation, cvNotes, cvAbout;
    View screen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        screen = inflater.inflate(R.layout.fragment_main, container, false);

        cvCep = screen.findViewById(R.id.cv_cep);
        cvQuotation = screen.findViewById(R.id.cv_quotation);
        cvNotes = screen.findViewById(R.id.cv_notes);
        cvAbout = screen.findViewById(R.id.cv_about);

        cvCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_root, CepFragment.class, null)
                        .addToBackStack("")
                        .setReorderingAllowed(true)
                        .commit();

            }
        });

        cvQuotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_root, QuotationFragment.class, null)
                        .addToBackStack("")
                        .setReorderingAllowed(true)
                        .commit();

            }
        });
        cvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container_root, AboutFragment.class, null)
                        .addToBackStack("")
                        .setReorderingAllowed(true)
                        .commit();

            }
        });

        return screen;


    }


    @Override
    public void onClick(View v) {


        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container_root, CepFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("")
                .commit();

    }
}