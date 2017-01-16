package pancor.cucumber.login;

import dagger.Component;
import pancor.cucumber.base.AppModule;
import pancor.cucumber.base.FragmentScope;
import pancor.cucumber.util.shared_pref.MyPrefManagerComponent;

@FragmentScope
@Component(dependencies = MyPrefManagerComponent.class,
        modules = {LoginFormPresenterModule.class, AppModule.class})
public interface LoginFormComponent {

    void inject(LoginFormActivity activity);
}
