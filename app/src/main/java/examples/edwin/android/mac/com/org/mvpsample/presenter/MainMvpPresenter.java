package examples.edwin.android.mac.com.org.mvpsample.presenter;

import examples.edwin.android.mac.com.org.mvpsample.BasePresenter;
import examples.edwin.android.mac.com.org.mvpsample.view.MainView;

/**
 * Created by User on 11/22/2016.
 */

public interface MainMvpPresenter extends BasePresenter<MainView> {
    void loadData();
}
