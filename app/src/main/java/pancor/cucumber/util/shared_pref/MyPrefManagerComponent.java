package pancor.cucumber.util.shared_pref;


import javax.inject.Singleton;

import dagger.Component;
import pancor.cucumber.base.AppModule;
import pancor.cucumber.login.LoginFormActivity;

@Singleton
@Component(modules = {MyPrefManagerModule.class, AppModule.class})
public interface MyPrefManagerComponent {

    MyPreferenceManager getMyPreferenceManager();
}
