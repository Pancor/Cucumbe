package pancor.cucumber.login;

import android.util.Log;

import javax.inject.Inject;

import pancor.cucumber.util.LoginFormUtil;

final class LoginFormPresenter implements LoginForm.Presenter {

    private static final String TAG = LoginFormPresenter.class.getSimpleName();

    private final LoginForm.View mLoginFormView;

    @Inject
    LoginFormPresenter(LoginForm.View view){

        mLoginFormView = view;
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

        if (!LoginFormUtil.isEmailValid(email)){

            mLoginFormView.wrongEmail();
            isCorrect = false;
        }
        if (!LoginFormUtil.isPasswordValid(password)){

            mLoginFormView.wrongPassword();
            isCorrect = false;
        }
        if (isCorrect){

            //TODO: send data to server, create user
        } else {

            mLoginFormView.setLoadingIndicator(false);
        }
    }
}
