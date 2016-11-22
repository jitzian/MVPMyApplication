package examples.edwin.android.mac.com.org.mvpsample.presenter;

import android.util.Log;

import examples.edwin.android.mac.com.org.mvpsample.view.MainView;

/**
 * Created by User on 11/22/2016.
 */

public class MainPresenter implements MainMvpPresenter{
    private static final String TAG = MainPresenter.class.getSimpleName();
    MainView mainView;

    @Override
    public void loadData() {
        Log.d(TAG, "loadData");
        mainView.showProgress();
        try {
            String fakeData = "Fireflies";
            mainView.showText(fakeData);
        } catch (Exception e) {
//            e.printStackTrace();
            mainView.showError(e.getMessage());
        }
        mainView.hideProgress();
    }

    @Override
    public void attachView(MainView view) {
        Log.d(TAG, "attachView");
        this.mainView = view;
    }

    @Override
    public void detachView() {
        Log.d(TAG, "detachView");
        mainView = null;
    }
}
