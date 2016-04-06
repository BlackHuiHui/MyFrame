package yehuihui.myframe.internal.di.components;

import dagger.Component;
import yehuihui.myframe.MainActivity;
import yehuihui.myframe.data.service.module.MyServiceModule;
import yehuihui.myframe.internal.di.PerActivity;
import yehuihui.myframe.internal.di.modules.ActivityModule;
import yehuihui.myframe.internal.di.modules.MainModule;

/**
 * Created by 洁 on 2016/4/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ActivityModule.class, MainModule.class, MyServiceModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}