package yehuihui.myframe.internal.di.components;

import android.app.Activity;

import dagger.Component;
import yehuihui.myframe.internal.di.PerActivity;
import yehuihui.myframe.internal.di.modules.ActivityModule;

/**
 * Created by 洁 on 2016/4/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity activity();
}
