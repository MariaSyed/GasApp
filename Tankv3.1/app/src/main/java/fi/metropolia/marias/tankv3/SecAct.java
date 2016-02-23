package fi.metropolia.marias.tankv3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by maria on 16.2.2016.
 */
public class SecAct extends AppCompatActivity implements View.OnClickListener {

    EditText odoValue;
    EditText fuelAmt;
    Button enter;
    double current_odo;
    double current_fuel;
    double previous_odo;
    int amountOfRefuels;
    double odoDiff;
    String MyPREFERENCES = "thirdActivity";
    SharedPreferences sharedPreferences;
    int key=0;
    String keyString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_act);

        odoValue = (EditText) findViewById(R.id.odo_value);
        fuelAmt = (EditText) findViewById(R.id.fuel_amt);
        enter = (Button) findViewById(R.id.enter_amt);
        enter.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        key++;
        keyString = Integer.toString(key);
        editor.putString(keyString,odoValue.getText().toString() + fuelAmt.getText().toString());
        editor.apply();

    }

    public void onClick(View v){
        previous_odo = current_odo; /*Assign current odometer readings to the previous odometer readings variable*/
        current_odo =  Double.parseDouble(odoValue.getText().toString()); /*Receives odometer readings entered by user*/
        current_fuel = Double.parseDouble(fuelAmt.getText().toString()); /*Receives gas refueling readings entred by user*/
        amountOfRefuels ++; /*Increase refuel counter by 1*/
        odoDiff = current_odo - previous_odo;
       switch(v.getId()) {
           case R.id.enter_amt:
               Intent newIntent = new Intent(this, MainActivity.class);
               newIntent.putExtra("odo", current_odo);
               newIntent.putExtra("fuel", current_fuel);
               newIntent.putExtra("previous_odo", previous_odo);
               newIntent.putExtra("refuels", amountOfRefuels);
               newIntent.putExtra("odoDiff", odoDiff);
               startActivityForResult(newIntent, 123);
               break;

           case R.id.see_values:

       }
    }
}
