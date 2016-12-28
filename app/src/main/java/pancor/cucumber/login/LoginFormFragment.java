package pancor.cucumber.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pancor.cucumber.R;

public class LoginFormFragment extends Fragment implements LoginForm.View {

    private static final String TAG = LoginFormFragment.class.getSimpleName();

    //ButterKnife unbinder
    private Unbinder unbinder;

    @BindView(R.id.emailView) AutoCompleteTextView emailView;
    @BindView(R.id.passwordView) TextInputEditText passwordView;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.loginFormLayout) LinearLayout loginFormLayout;

    private LoginForm.Presenter mPresenter;

    public LoginFormFragment() {

    }

    public static LoginFormFragment newInstance() {

        return new LoginFormFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login_form, container, false);

        unbinder = ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

        progressBar.setVisibility(active ? View.VISIBLE : View.GONE);
        loginFormLayout.setVisibility(active ? View.GONE : View.VISIBLE);
    }

    @Override
    public void wrongEmail() {

    }

    @Override
    public void wrongPassword() {

    }

    @Override
    public void setPresenter(@NonNull LoginForm.Presenter presenter) {

        mPresenter = presenter;
    }

    @OnClick(R.id.email_sign_in_button)
    void signInByEmail(){

        mPresenter.signInByEmail(emailView.getText().toString(),
                passwordView.getText().toString());
    }
}
