package yehuihui.myframe.internal.di.modules;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import yehuihui.myframe.data.service.MyService;
import yehuihui.myframe.interactor.BaseCase;
import yehuihui.myframe.interactor.MainCase;
import yehuihui.myframe.internal.di.PerActivity;

/**
 * Created by 洁 on 2016/4/6.
 */
@Module
public class MainModule {
    @PerActivity
    @Provides
    @Named("MainCase")
    BaseCase ProviderMainCase(MyService myService) {
        return new MainCase(myService);
    }

}
