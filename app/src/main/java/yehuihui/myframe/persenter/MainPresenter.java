package yehuihui.myframe.persenter;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;
import yehuihui.myframe.data.bean.User;
import yehuihui.myframe.interactor.BaseCase;
import yehuihui.myframe.view.MainView;

/**
 * Created by 洁 on 2016/4/6.
 */
public class MainPresenter implements Presenter{
    private MainView mainView;
    private BaseCase mainCase;
    @Inject
    public MainPresenter(@Named("MainCase")BaseCase mainCase){
        this.mainCase = mainCase;
    }
    public void setView(@NonNull MainView mainView){
        this.mainView = mainView;
    }
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
    @Override
    public void destroy() {
        this.mainCase.unsubscribe();
        this.mainCase = null;
    }
    public void loadMain(){
        this.mainCase.execute(new MainSubscriber());
    }
    private final class MainSubscriber extends Subscriber<User>{
        @Override
        public void onCompleted() {
            MainPresenter.this.mainView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(User user) {
            MainPresenter.this.mainView.updateView(user);
        }
    }
}
