package pancor.cucumber.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Pawel on 2016-12-22.
 */

public class MyPreferenceManager {

    private static final String TAG = MyPreferenceManager.class.getSimpleName();

    //file name of preferences
    private static final String PREF_NAME = "pancor_cucumber";
    private static final int PRIVATE_MODE = 10;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public MyPreferenceManager(Context context){

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * clears data of sharedPreferences
     */
    public void clear(){

        Log.i(TAG, "SharedPreferences cleared");

        editor.clear();
        editor.commit();
    }
}
