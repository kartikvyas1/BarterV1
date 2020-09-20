package com.example.barterv1.UtilityPackage1;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference1 {

    private static String PREFERENCE_NAME = "BarterV1";
    private static SharedPreference1 sharedPreference1;
    private SharedPreferences sharedPreferences;

    private SharedPreference1(Context context) {

        // this context is to be refered from MyApp class
        PREFERENCE_NAME = PREFERENCE_NAME + context.getPackageName();
        this .sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreference1 getInstance() {
        if (sharedPreference1 == null){  sharedPreference1 = new SharedPreference1(MyApp.getContext()) ;}
        return sharedPreference1;
    }

    // this method will save the shared preference from the user for login attempt
    public void saveString(String userId, String passWord) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(userId, passWord);
        editor.commit(); // most important
    }

    // the default value can be no password set
    public String getString(String userId, String defaultValue){
        return sharedPreferences.getString(userId, defaultValue);
    }
}
