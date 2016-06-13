package udacity.pawan.popularmoviesstage1.ui;

import android.content.Context;

import com.orm.SugarApp;

public class App extends SugarApp {
    private static App instance;


    public static Context getContext() {
        return instance;
    }

    public static App getInstance() {
        return instance;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

}