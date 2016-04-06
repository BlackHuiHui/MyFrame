package yehuihui.myframe.internal.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import yehuihui.myframe.MyBaseActivity;
import yehuihui.myframe.internal.di.modules.ApplicationModule;

/**
 * Created by 洁 on 2016/4/6.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MyBaseActivity myBaseActivity);

    Context context();
}
