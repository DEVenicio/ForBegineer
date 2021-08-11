package com.devenicio.forbegineer.view.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import com.devenicio.forbegineer.R;
import com.devenicio.forbegineer.view.fragments.MainFragment;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container_root, MainFragment.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }

    }
}