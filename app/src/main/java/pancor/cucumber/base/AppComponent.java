package pancor.cucumber.base;

import javax.inject.Singleton;

import dagger.Component;
import pancor.cucumber.activities.MainActivity;

/**
 * Created by Pawel on 2016-12-22.
 */

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
    MainActivity inject(MainActivity activity);
}

