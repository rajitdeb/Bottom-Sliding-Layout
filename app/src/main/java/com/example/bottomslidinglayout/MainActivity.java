package com.example.bottomslidinglayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    LinearLayout mBottomCart;
    BottomSheetBehavior bottomSheetBehavior;
    Button mCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomCart = findViewById(R.id.bottom_cart);
        bottomSheetBehavior = BottomSheetBehavior.from(mBottomCart);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

                switch(bottomSheetBehavior.getState()){

                    case BottomSheetBehavior.STATE_DRAGGING :
                        mCheckout.setText("Cancel");
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        mCheckout.setText("Cancel");
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mCheckout.setText("Show Cart");
                        break;
                }

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        mCheckout = findViewById(R.id.checkout);
        mCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCheckout.getText().toString().equals("Show Cart")){

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    mCheckout.setText("Cancel");
                }else if(mCheckout.getText().toString().equals("Cancel")){

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    mCheckout.setText("Show Cart");
                }


            }
        });
    }
}
