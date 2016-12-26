package pancor.cucumber.base;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.firebase.analytics.FirebaseAnalytics;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pawel on 2016-12-22.
 */

@Module
public class AppModule {

    private App app;

    public AppModule(App app){

        this.app = app;
    }

    @Provides @Singleton
    MyPreferenceManager provideMyPreferenceManager(){

        return new MyPreferenceManager(app);
    }

    @Provides @Singleton
    FirebaseAnalytics provideFirebaseAnalytics(){

        return FirebaseAnalytics.getInstance(app);
    }
}
