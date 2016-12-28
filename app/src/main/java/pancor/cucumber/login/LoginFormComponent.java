package pancor.cucumber.login;

import dagger.Component;
import pancor.cucumber.base.FragmentScope;

@FragmentScope
@Component(modules = LoginFormPresenterModule.class)
public interface LoginFormComponent {

    void inject(LoginFormActivity activity);
}
