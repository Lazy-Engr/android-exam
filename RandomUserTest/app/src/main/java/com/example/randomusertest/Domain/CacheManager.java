package com.example.randomusertest.Domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class CacheManager {

    private static final String TAG = "CacheManager";
    private static final String PREF_NAME = "PersonCache";
    private static final String KEY_PERSONS = "persons";

    private SharedPreferences sharedPreferences;

    public CacheManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void savePersons(String json) {
        sharedPreferences.edit().putString(KEY_PERSONS, json).apply();
        Log.d(TAG, "Saved JSON to cache: " + json);
    }

    public String getPersons() {
        String cachedJson = sharedPreferences.getString(KEY_PERSONS, null);
        Log.d(TAG, "Retrieved JSON from cache: " + cachedJson);
        return cachedJson;
    }

    public void clearCache() {
        sharedPreferences.edit().remove(KEY_PERSONS).apply();
        Log.d(TAG, "Cache cleared");
    }
}
