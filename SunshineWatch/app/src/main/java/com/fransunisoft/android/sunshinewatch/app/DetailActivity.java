package com.fransunisoft.android.sunshinewatch.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fransunisoft.sunshinewatch.R;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            Bundle arguments = new Bundle();
            arguments.putParcelable(com.fransunisoft.android.sunshinewatch.app.DetailFragment.DETAIL_URI, getIntent().getData());
            arguments.putBoolean(com.fransunisoft.android.sunshinewatch.app.DetailFragment.DETAIL_TRANSITION_ANIMATION, true);

            com.fransunisoft.android.sunshinewatch.app.DetailFragment fragment = new com.fransunisoft.android.sunshinewatch.app.DetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.weather_detail_container, fragment)
                    .commit();

            // Being here means we are in animation mode
            supportPostponeEnterTransition();
        }
    }
}