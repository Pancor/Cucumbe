package pancor.cucumber.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Inject;

import pancor.cucumber.R;
import pancor.cucumber.base.App;
import pancor.cucumber.base.BaseActivity;
import pancor.cucumber.base.MyPreferenceManager;
import pancor.cucumber.fragments.LoginFormFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MyPreferenceManager mMyPreferenceManager;

    @Inject
    FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.getAppComponent(this).inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar(getString(R.string.app_name));

        if (savedInstanceState == null) {

            startFragment(new LoginFormFragment());
        } else {

            Fragment fragment = getSupportFragmentManager().findFragmentByTag(LoginFormFragment.class.getSimpleName());
            startFragment(fragment);
        }
    }
}
