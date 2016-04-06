package yehuihui.myframe.view;

import android.content.Context;

/**
 * Created by 洁 on 2016/4/6.
 */
public interface LoadDataView {
    void showLoading();

    void hideLoading();

    void showError(String message);

    Context context();
}
