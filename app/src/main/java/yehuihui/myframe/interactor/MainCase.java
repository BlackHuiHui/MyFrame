package yehuihui.myframe.interactor;

import javax.inject.Inject;

import rx.Observable;
import yehuihui.myframe.data.service.MyService;

/**
 * Created by 洁 on 2016/4/6.
 * 提供Observable
 */
public class MainCase extends BaseCase{
    private final MyService myService;

    @Inject
    public MainCase(MyService myService){
        this.myService = myService;
    }
    @Override
    protected Observable buildUseCaseObservable() {
        return myService.getUser("octocat");
    }
}
