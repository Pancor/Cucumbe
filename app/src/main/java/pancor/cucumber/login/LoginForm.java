package pancor.cucumber.login;

import pancor.cucumber.base.BasePresenter;
import pancor.cucumber.base.BaseView;

/**
 * Created by Pawel on 2016-12-26.
 */

public interface LoginForm {

    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);

        void wrongEmail();

        void wrongPassword();
    }

    interface Presenter extends BasePresenter{

        void signInByEmail(String email, String password);

        void incorrectCredidentials();
    }
}
