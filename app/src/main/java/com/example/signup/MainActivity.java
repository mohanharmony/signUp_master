package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView etName;
    TextView etName2;
    String s="";
    public static String tag= MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etName2 = findViewById(R.id.etName2);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"onPause");
        saveAppState();
    }

    private void saveAppState() {
        //get the date from 2 edittexts
        String name = etName.getText().toString();
        String pin = etName2.getText().toString();

        //create a file
        SharedPreferences preferences = getSharedPreferences("harmanfile",MODE_PRIVATE);
        //open file in edit mode
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString("cname",name);
        editor.putString("cpin",pin);
        editor.putString("cradio",s);
        //save the file
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"onResume");
        restoreAppState();
    }

    private void restoreAppState() {
        //read from the file
        SharedPreferences preferences = getSharedPreferences("harmanfile",MODE_PRIVATE);
        String name = preferences.getString("cname","");
        String pin = preferences.getString("cpin","");
        //put the data back into the edittexts
        etName.setText(name);
        etName2.setText(pin);

        Log.i(tag,"name - "+name+" and pin - "+pin);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"onDestroy");
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton2:
                if (checked)
                    s="Male";
                    break;
            case R.id.radioButton:
                if (checked)
                    s="Female";
                    break;
        }
    }

    public void launchHomeActivity(View view) {
        String input = etName.getText().toString();
        String input2 = etName2.getText().toString();

        Toast.makeText(this, "Welcome " + input, Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, secondActivity.class);
        hIntent.putExtra("ip", input);
        hIntent.putExtra("ip2", input2);
        hIntent.putExtra("radio", s);
        startActivity(hIntent);
    }

}
