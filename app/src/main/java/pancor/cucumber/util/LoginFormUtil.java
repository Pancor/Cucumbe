package pancor.cucumber.util;

import android.text.TextUtils;

public class LoginFormUtil {

    /**
     * @param email -> email, that user gave
     * @return true if email is valid, else false
     */
    public static boolean isEmailValid(String email){

        return !TextUtils.isEmpty(email) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * @param password -> password, that user gave
     * @return true if {@param password} >= 6, else return false
     */
    public static boolean isPasswordValid(String password){

        if (password.length() < 6)
            return false;

        return true;
    }
}
