package pancor.cucumber.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import pancor.cucumber.R;

/**
 * Created by Pawel on 2016-12-18.
 */

public class LoginFormFragment extends Fragment {

    private static final String TAG = LoginFormFragment.class.getSimpleName();

    //ButterKnife unbinder
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login_form, container, false);
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

}
