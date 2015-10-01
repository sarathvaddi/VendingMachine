package com.example.sarathreddyvaddhi.vendingmachine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sarathreddyvaddhi on 9/30/15.
 */
public class ConfirmationActivity extends AppCompatActivity {


    Double Cost,chn,M;
    EditText et;
    TextView st,chng;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_activity);
        et=(EditText)findViewById(R.id.et);
        st=(TextView)findViewById(R.id.st);
        chng=(TextView)findViewById(R.id.chng);
        confirm=(Button)findViewById(R.id.button);


        Bundle b = getIntent().getExtras();
        Cost= b.getDouble("Cost");

        st.setText("Cost of the item is "+Cost);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    M = Double.parseDouble(et.getText().toString());
                }
                catch (Exception e){

                }
// Checking if the user entered the value in the field
                if(M==null)
                    Toast.makeText(getApplicationContext(),"Please Enter the Amount",Toast.LENGTH_LONG).show();


// Check if the entered amount is greater than or equal to actuall cost of the item
       else if(M>=Cost)
            chn=M-Cost;
        else
            Toast.makeText(getApplicationContext(),"Please Enter the Valid Amount",Toast.LENGTH_LONG).show();


        chng.setText("Change: "+chn+" Thank You");
            }
        });

    }
}

