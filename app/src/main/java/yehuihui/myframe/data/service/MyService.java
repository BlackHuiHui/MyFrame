package yehuihui.myframe.data.service;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import yehuihui.myframe.data.bean.User;

/**
 * Created by 洁 on 2016/4/6.
 * 获取数据，返回Observable对象
 */
public interface MyService {
    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String user);
}
