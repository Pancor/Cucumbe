package pancor.cucumber.login;

import org.json.JSONObject;

import pancor.cucumber.base.BasePresenter;
import pancor.cucumber.base.BaseView;
import pancor.cucumber.model.User;

/**
 * Created by Pawel on 2016-12-26.
 */

public interface LoginForm {

    interface View extends BaseView<Presenter>{

        void setLoadingIndicator(boolean active);

        void wrongEmail(String error);

        void wrongPassword(String error);
    }

    interface Presenter extends BasePresenter{

        void signInByEmail(String email, String password);

        void incorrectCredidentials();
    }
}
