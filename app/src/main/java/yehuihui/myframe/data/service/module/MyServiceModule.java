package yehuihui.myframe.data.service.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import yehuihui.myframe.data.service.MyService;
import yehuihui.myframe.internal.di.PerActivity;

/**
 * Created by 洁 on 2016/4/6.
 * 提供MyService的Module
 */
@Module
public class MyServiceModule {
    private Retrofit retrofit;

    public MyServiceModule(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Provides
    @PerActivity
    MyService getMyService() {
        return retrofit.create(MyService.class);
    }

}
