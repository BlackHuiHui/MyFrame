package yehuihui.myframe;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yehuihui.myframe.internal.di.components.ApplicationComponent;
import yehuihui.myframe.internal.di.components.DaggerApplicationComponent;
import yehuihui.myframe.internal.di.modules.ApplicationModule;

/**
 * Created by 洁 on 2016/4/6.
 */
public class MyApplication extends Application{
    private static MyApplication instance;
    //activity集合
    public static List<Activity> activityList = new LinkedList<>();

    private ApplicationComponent applicationComponent;
    private Retrofit retrofit;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initializeInjector();
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")  // TODO 线下
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    public static MyApplication getInstance(){
        return instance;
    }
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void remove(Activity activity) {
        if (activityList.contains(activity)) {
            activityList.remove(activity);
        }
    }
}
