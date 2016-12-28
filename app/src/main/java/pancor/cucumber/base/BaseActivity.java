package pancor.cucumber.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import pancor.cucumber.R;

/**
 * Created by Pawel on 2016-12-18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.coordinatorLayout)
    protected CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    //ButterKnife unbinder
    private Unbinder unbinder;

    @Override
    public void setContentView(@NonNull int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    protected void setupToolbar(){

        setupToolbar(null);
    }


    /**
     * @param title -> toolbar's title
     */
    protected void setupToolbar(@Nullable String title){

        if (mToolbar != null){

            setSupportActionBar(mToolbar);

            if (title != null)
                getSupportActionBar().setTitle(title);
        }
    }

    /**
     *  @param mFragment -> it's fragment, that, we want to start
     */
    protected void startFragment(Fragment mFragment){

        startFragment(mFragment, false);
    }

    /**
     *  @param mFragment -> it's fragment, that, we want to start
     *  @param addToBackStack -> if true, then add mFragment to back stack
     *                        else, don't do it
     */
    protected void startFragment(Fragment mFragment, boolean addToBackStack){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        String fragmentTag = mFragment.getClass().getSimpleName();

        transaction.add(R.id.containerLayout, mFragment, fragmentTag);

        if (addToBackStack)
            transaction.addToBackStack(fragmentTag);

        transaction.commit();
    }
}
