package com.kupeli.counter;

import android.content.Context;
import android.content.SharedPreferences;

public class SetClass {
    int upperLimit , lowerLimit , currentValue;

    boolean lowerVib ,lowerSound,upperSound,upperVib;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    static SetClass setClass = null;

    private SetClass(Context context){
        sharedPreferences = context.getSharedPreferences("settings",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SetClass getSetClass(Context context){
        if(setClass==null){
            setClass = new SetClass(context);
        }
        return setClass;
    }

    public void saveValues(){
        editor.putInt("upperLimit",upperLimit);
        editor.putInt("lowerLimit",lowerLimit);
        editor.putInt("currentValue",currentValue);
        editor.putBoolean("lowerVib",lowerVib);
        editor.putBoolean("lowerSound",lowerSound);
        editor.putBoolean("upperSound",upperSound);
        editor.putBoolean("upperVib",upperVib);
        editor.commit();

    }

    public void loadValues(){
        upperLimit =sharedPreferences.getInt("upperLimit",20);
        lowerLimit =sharedPreferences.getInt("lowerLimit",0);
        currentValue =sharedPreferences.getInt("currentValue",0);
        lowerVib  =sharedPreferences.getBoolean("lowerVib",true);
        lowerSound  =sharedPreferences.getBoolean("lowerSound",true);
        upperVib =sharedPreferences.getBoolean("upperVib",true);
        upperSound  =sharedPreferences.getBoolean("lowerSound",true);



    }


}
