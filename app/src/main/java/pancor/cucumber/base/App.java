package pancor.cucumber.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

/**
 * Created by Pawel on 2016-12-22.
 */

public class App extends Application {

    private AppComponent appComponent;

    @VisibleForTesting
    protected AppComponent createComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(Context context) {

        App app = (App) context.getApplicationContext();
        if (app.appComponent == null){
            app.appComponent = app.createComponent();
        }
        return  app.appComponent;
    }
}
