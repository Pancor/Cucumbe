package pancor.cucumber.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import javax.inject.Inject;

import pancor.cucumber.R;
import pancor.cucumber.base.App;
import pancor.cucumber.base.BaseActivity;
import pancor.cucumber.util.shared_pref.MyPreferenceManager;

public class LoginFormActivity extends BaseActivity {

    private static final String TAG = LoginFormActivity.class.getSimpleName();

    @Inject LoginFormPresenter mLoginFormPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar(getString(R.string.app_name));

        LoginFormFragment loginFormFragment = (LoginFormFragment) getSupportFragmentManager()
                .findFragmentByTag(LoginFormFragment.class.getSimpleName());

        if (loginFormFragment == null){

            loginFormFragment = LoginFormFragment.newInstance();
            startFragment(loginFormFragment);
        }

        DaggerLoginFormComponent.builder()
                .loginFormPresenterModule(new LoginFormPresenterModule(loginFormFragment))
                .build().inject(this);


    }
}
