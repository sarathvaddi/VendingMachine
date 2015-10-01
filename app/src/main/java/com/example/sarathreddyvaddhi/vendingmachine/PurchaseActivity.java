package com.example.sarathreddyvaddhi.vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by sarathreddyvaddhi on 9/30/15.
 */
public class PurchaseActivity extends AppCompatActivity{


    Button purchase;
    RadioGroup radioBtn;
    RadioButton btn,ckbtn,pepbtn,dewbtn,wbtn;

//   Prices of the items
    static double vc=2.30;
    static double vp=3.50;
    static double vd=4.20;
    static double vw=2.00;

//  HashMap for stock information
    HashMap st = new HashMap<String, Integer>();
//HashMap for Prices of the items
    HashMap pr = new HashMap<String,Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_activity);
        purchase=(Button)findViewById(R.id.pbutton);

        radioBtn = (RadioGroup)findViewById(R.id.rg);
        ckbtn=(RadioButton)findViewById(R.id.rcoke);
        pepbtn=(RadioButton)findViewById(R.id.rpepsi);
        dewbtn=(RadioButton)findViewById(R.id.rdew);
        wbtn=(RadioButton)findViewById(R.id.rwater);
//
//        hardcoded the stock and price infromation
        st.put(ckbtn.getText(), 3);
        st.put(pepbtn.getText(), 3);
        st.put(dewbtn.getText(),3);
        st.put(wbtn.getText(),3);

        pr.put(ckbtn.getText(),vc);
        pr.put(pepbtn.getText(),vp);
        pr.put(dewbtn.getText(),vd);
        pr.put(wbtn.getText(),vw);




        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioBtn.getCheckedRadioButtonId();

                btn=(RadioButton)findViewById(id);

                Intent i = new Intent(PurchaseActivity.this,ConfirmationActivity.class);

//                Pass the information through bundle
                Bundle b= new Bundle();
                b.putDouble("Cost", (double) pr.get(btn.getText()));
                i.putExtras(b);


//          Check if the items are out of Stock

                if((int)st.get(btn.getText())>0) {
                    startActivity(i);
                    st.put(btn.getText(), (int) st.get(btn.getText()) - 1);
                    Toast.makeText(getApplicationContext(),btn.getText()+"Remaining: "+st.get(btn.getText()),Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"Sorry we are out of "+btn.getText(),Toast.LENGTH_LONG).show();

            }
        });




    }
}
