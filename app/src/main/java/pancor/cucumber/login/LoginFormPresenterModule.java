package pancor.cucumber.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginFormPresenterModule {

    private final LoginForm.View mView;

    public LoginFormPresenterModule(LoginForm.View view){

        mView = view;
    }

    @Provides
    LoginForm.View provideLoginFormView(){

        return mView;
    }
}