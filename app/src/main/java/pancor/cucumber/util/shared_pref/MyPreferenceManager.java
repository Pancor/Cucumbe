package pancor.cucumber.util.shared_pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import pancor.cucumber.model.User;

@Singleton
public class MyPreferenceManager {

    private static final String TAG = MyPreferenceManager.class.getSimpleName();

    //file name of preferences
    private static final String PREF_NAME = "pancor_cucumber";
    private static final int PRIVATE_MODE = 10;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private static final String USER_NAME_KEY = "userName";
    private static final String AUTH_KEY = "authKey";

    @Inject
    MyPreferenceManager(Context context){

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * clears data of sharedPreferences
     */
    public void clear(){

        editor.clear();
        editor.commit();
        Log.i(TAG, "SharedPreferences cleared");
    }

    /**
     * store user in SharedPreferences
     * @param user {@link User}, which contain information about user
     */
    public void storeUser(User user){

        editor.putString(USER_NAME_KEY, user.getmName());
        editor.putString(AUTH_KEY, user.getmAuthKey());
        editor.commit();
    }

    /**
     * gets user model from SharedPreferences
     * @retur {@link User}, may be null if there is no user stored
     * in Shared Preferences
     */
    public User getUser(){

        String userName = pref.getString(USER_NAME_KEY, null);
        String userAuthKey = pref.getString(AUTH_KEY, null);

        if (userName != null && userAuthKey != null)
            return new User(userName, userAuthKey);

        return null;
    }
}
