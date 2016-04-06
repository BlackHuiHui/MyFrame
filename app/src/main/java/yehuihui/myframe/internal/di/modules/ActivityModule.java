package yehuihui.myframe.internal.di.modules;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import yehuihui.myframe.internal.di.PerActivity;

/**
 * Created by 洁 on 2016/4/6.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }
}
