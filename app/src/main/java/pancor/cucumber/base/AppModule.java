package pancor.cucumber.base;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pancor.cucumber.util.shared_pref.MyPreferenceManager;

/**
 * Created by Pawel on 2016-12-22.
 */

@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context){

        mContext = context;
    }

    @Provides
    Context provideContext(){

        return mContext;
    }
}
