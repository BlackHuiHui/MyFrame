package yehuihui.myframe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import retrofit2.Retrofit;
import yehuihui.myframe.internal.di.components.ApplicationComponent;
import yehuihui.myframe.internal.di.modules.ActivityModule;

/**
 * Created by 洁 on 2016/4/6.
 */
public class MyBaseActivity extends FragmentActivity {
    public MyApplication myApplication = MyApplication.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myApplication.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        myApplication.remove(this);
        super.onDestroy();
    }

    public ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    public Retrofit getRetrofit() {
        return ((MyApplication) getApplication()).getRetrofit();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
