package com.project.rsr23.daynightmode;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //For Day Night Mode:
        sharedPref = new SharedPref(this);

        if(sharedPref.loadNightModeState()==true){
            setTheme(R.style.DarkTheme);
        }
        else{
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);

        //For Remove Title Bar:
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        //Add Switch Button to Action Bar:
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.switch_layout);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);


        //For Theme:
        final Switch mSwitch = findViewById(R.id.switchForActionBar);

        if(sharedPref.loadNightModeState()==true){
            mSwitch.setChecked(true);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    sharedPref.setNightModeState(true);
                    RestartApp();

                    Toast.makeText(MainActivity.this, "Night Mode", Toast.LENGTH_SHORT).show();
                }

                else{
                    sharedPref.setNightModeState(false);
                    RestartApp();
                    Toast.makeText(MainActivity.this, "Day Mode", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //End

    }


    //For Theme: Refresh
    public void RestartApp(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

}
