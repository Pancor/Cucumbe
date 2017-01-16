package pancor.cucumber.util.shared_pref;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyPrefManagerModule {

    @Singleton
    @Provides
    MyPreferenceManager provideMyPreferenceManager(Context context){

        return new MyPreferenceManager(context);
    }
}
