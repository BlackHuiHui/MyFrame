package yehuihui.myframe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yehuihui.myframe.data.bean.User;
import yehuihui.myframe.data.service.MyService;
import yehuihui.myframe.data.service.module.MyServiceModule;
import yehuihui.myframe.internal.di.components.DaggerMainComponent;
import yehuihui.myframe.internal.di.components.MainComponent;
import yehuihui.myframe.internal.di.modules.MainModule;
import yehuihui.myframe.persenter.MainPresenter;
import yehuihui.myframe.view.MainView;

public class MainActivity extends MyBaseActivity implements MainView {
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.id)
    TextView id;
    @InjectView(R.id.avatar_url)
    TextView avatar_url;
    @InjectView(R.id.company)
    TextView company;
    @InjectView(R.id.pb)
    ProgressBar pb;

    MainComponent mainComponent;
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initializeInjector();
        mainPresenter.setView(this);
        mainPresenter.loadMain();
    }

    public void initializeInjector() {
        mainComponent = DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .myServiceModule(new MyServiceModule(getRetrofit()))
                .mainModule(new MainModule())
                .build();
        mainComponent.inject(this);
    }

    @Override
    public void updateView(User user) {
        name.setText(user.getLogin());
        id.setText(""+user.getId());
        avatar_url.setText(user.getAvatar_url());
        company.setText(user.getCompany());
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
    }

    @Override
    public Context context() {
        return MainActivity.this;
    }

}
