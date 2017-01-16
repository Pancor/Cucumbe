package pancor.cucumber.base;

import android.app.Application;
import android.content.Context;

import pancor.cucumber.util.shared_pref.DaggerMyPrefManagerComponent;
import pancor.cucumber.util.shared_pref.MyPrefManagerComponent;
import pancor.cucumber.util.shared_pref.MyPrefManagerModule;

public class App extends Application {

    private Context mContext;
    private MyPrefManagerComponent myPrefManagerComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        myPrefManagerComponent = DaggerMyPrefManagerComponent.builder()
                .myPrefManagerModule(new MyPrefManagerModule())
                .appModule(new AppModule(mContext))
                .build();
    }

    public MyPrefManagerComponent getMyPrefManagerComponent(){

        return myPrefManagerComponent;
    }

    public Context getAppContext(){

        return mContext;
    }
}
