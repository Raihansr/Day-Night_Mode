package com.project.rsr23.daynightmode;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by rsr23 on 5/9/2018.
 */

public class SharedPref {

    private SharedPreferences mySharedPref;

    public SharedPref(Context context){

        mySharedPref = context.getSharedPreferences("colorChoose",Context.MODE_PRIVATE);
    }

    //This method will save the Night Mode State : true or false
    public void setNightModeState(boolean state){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("NightMode",state);
        editor.apply();
    }

    //This method will load the Night Mode State:
    public Boolean loadNightModeState(){
        Boolean nightState = mySharedPref.getBoolean("NightMode",false);
        return nightState;
    }
}
