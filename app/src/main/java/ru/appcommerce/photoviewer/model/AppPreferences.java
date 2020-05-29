package ru.appcommerce.photoviewer.model;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class AppPreferences {
    private final String PREFERENCES_SETTINGS = "preferences_settings";
    private final String PREFERENCES_LOAD_FROM_DB = "preferences_load_from_db";
    private final String PREFERENCES_UPDATE_TIMESTAMP = "preferences_update_timestamp";

    private SharedPreferences preferences;

    public AppPreferences(Context context) {
        preferences = context.getSharedPreferences(PREFERENCES_SETTINGS, MODE_PRIVATE);
    }

    public void saveIsLoadFromDb(Boolean isLoadFromDb){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFERENCES_LOAD_FROM_DB, isLoadFromDb);
        editor.apply();
    }

    public boolean getIsLoadFromDb(){
        return preferences.getBoolean(PREFERENCES_LOAD_FROM_DB, false);
    }

    public void saveUpdateTimestamp(long updateTimestamp){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(PREFERENCES_UPDATE_TIMESTAMP, updateTimestamp);
        editor.apply();
    }

    public long getUpdateTimestamp(){
        return preferences.getLong(PREFERENCES_UPDATE_TIMESTAMP, 0);
    }
}
