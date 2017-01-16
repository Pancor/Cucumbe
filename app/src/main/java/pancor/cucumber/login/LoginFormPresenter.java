package pancor.cucumber.login;

import android.content.Context;

import javax.inject.Inject;

import pancor.cucumber.R;
import pancor.cucumber.util.LoginFormUtil;
import pancor.cucumber.util.shared_pref.MyPreferenceManager;

final class LoginFormPresenter implements LoginForm.Presenter {

    private static final String TAG = LoginFormPresenter.class.getSimpleName();

    private MyPreferenceManager mMyPreferenceManager;
    private final LoginForm.View mLoginFormView;
    private final Context mContext;

    @Inject
    LoginFormPresenter(LoginForm.View view, Context context){

        mLoginFormView = view;
        mContext = context;
    }

    @Inject
    void setupListeners(){

        mLoginFormView.setPresenter(this);
    }

    @Override
    public void signInByEmail(String email, String password) {

        mLoginFormView.setLoadingIndicator(true);
        checkLoginData(email, password);
    }

    @Override
    public void incorrectCredidentials() {

    }

    @Override
    public void start() {

    }

    private void checkLoginData(String email, String password){

        boolean isCorrect = true;

        if (!email.isEmpty()) {
            if (!LoginFormUtil.isEmailValid(email)) {

                mLoginFormView.wrongEmail(mContext.getString(R.string.wrong_email));
                isCorrect = false;
            }
        } else {

            mLoginFormView.wrongEmail(mContext.getString(R.string.required_field));
            isCorrect = false;
        }

        if (!password.isEmpty()) {
            if (!LoginFormUtil.isPasswordValid(password)) {

                mLoginFormView.wrongPassword(mContext.getString(R.string.to_short_paswd));
                isCorrect = false;
            }
        } else {

            mLoginFormView.wrongPassword(mContext.getString(R.string.required_field));
            isCorrect = false;
        }

        if (isCorrect){

            //TODO create user
        } else {

            mLoginFormView.setLoadingIndicator(false);
        }
    }
}
