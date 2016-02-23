package fi.metropolia.marias.tankv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView avg_rate;
    TextView max_gas;
    TextView min_gas;
    RadioButton lkm_unit;
    RadioButton mpg_unit;
    TextView unit;
    double avg_gas_value; /*Average consumption rate*/
    double max_gas_value; /*Maximum consumption rate*/
    double min_gas_value; /*Minimum consumption rate*/
    double current_gas_value = 0; /*Consumption rate for the last ride*/
    double current_odo; /*Odometer readings taken during the last refuel*/
    double current_fuel; /*Amount of gas loaded into the tank during last refuel*/
    double previous_odo; /*Odometer readings taken during the previous refuel*/
    double previous_gas_value; /*Consumption rate for the previous ride*/
    int amountOfRefuels = 0;
    Button btn;
    double odoDiff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avg_rate = (TextView) findViewById(R.id.avgConsumRate);
        max_gas = (TextView) findViewById(R.id.max_gas);
        min_gas = (TextView) findViewById(R.id.min_gas);
        unit = (TextView) findViewById(R.id.unit);
        lkm_unit = (RadioButton) findViewById(R.id.lkm_unit);
        mpg_unit = (RadioButton) findViewById(R.id.mpg_unit);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        lkm_unit.setOnClickListener(this);
        mpg_unit.setOnClickListener(this);
        current_odo = getIntent().getDoubleExtra("odo", current_odo);
        current_fuel = getIntent().getDoubleExtra("fuel", current_fuel);
        amountOfRefuels = getIntent().getIntExtra("refuels", amountOfRefuels);
        odoDiff = getIntent().getDoubleExtra("odoDiff",odoDiff);
        previous_odo=getIntent().getDoubleExtra("previous_odo", previous_odo);
        current_gas_value = (current_fuel/odoDiff);
        avg_gas_value= (((amountOfRefuels-1)*avg_gas_value) + current_gas_value)/(amountOfRefuels);
        String avgString = ""+avg_gas_value + " " + current_odo +"  "+previous_odo;
        avg_rate.setText(avgString);
        unit.setText("l/km");
        max_gas.setText(Double.toString(max_gas_value));
        min_gas.setText(Double.toString(min_gas_value));
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.lkm_unit:
                mpg_unit.setChecked(false);
                double value1 = (Math.round((avg_gas_value*100) * 100.0))/100.0;
                String value1String = ""+value1;
                avg_rate.setText(value1String);
                unit.setText("L/100km");
                break;


            case R.id.mpg_unit:
                lkm_unit.setChecked(false);
                double value2= (Math.round(((avg_gas_value*100)*235.215)*100.0))/100.0;
                String value2String = ""+value2;
                avg_rate.setText(value2String);
                unit.setText("mpg");
                break;

            case R.id.btn:
                Intent MyIntent = new Intent(this,SecAct.class);
                startActivityForResult(MyIntent,123);
        }
    }

}
