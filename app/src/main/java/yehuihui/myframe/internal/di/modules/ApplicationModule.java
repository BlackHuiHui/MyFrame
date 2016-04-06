package yehuihui.myframe.internal.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import yehuihui.myframe.MyApplication;

/**
 * Created by 洁 on 2016/4/6.
 */
@Module
public class ApplicationModule {
    private final MyApplication application;

    public ApplicationModule(MyApplication application){
        this.application = application;
    }
    @Provides
    @Singleton
    Context provideApplicationContext(){
        return this.application;
    }
}
