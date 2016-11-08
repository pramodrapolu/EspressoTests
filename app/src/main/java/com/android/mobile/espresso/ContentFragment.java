package com.android.mobile.espresso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.staples.mobile.espresso.R;

public class ContentFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = ContentFragment.class.getSimpleName();

    private TextView espressoTest;
    private Button testClick;

    private boolean changeText = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);

        espressoTest = (TextView) view.findViewById(R.id.espresso_test);
        testClick = (Button) view.findViewById(R.id.test_click);

        testClick.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.test_click) {
            if (changeText) {
                espressoTest.setText("Button is clicked");
                changeText = false;
            } else {
                espressoTest.setText("Espresso Test");
                changeText = true;
            }
        }
    }
}
