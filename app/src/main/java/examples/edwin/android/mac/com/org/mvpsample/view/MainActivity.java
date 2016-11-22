package examples.edwin.android.mac.com.org.mvpsample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import examples.edwin.android.mac.com.org.mvpsample.R;
import examples.edwin.android.mac.com.org.mvpsample.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainPresenter mainPresenter;
    private ProgressBar progressBar;
    private Button mButton;
    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);

        progressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mButton = (Button) findViewById(R.id.mButton);
        mTextView = (TextView) findViewById(R.id.mTextView);

    }

    @Override
    public void showText(String text) {
        mTextView.setText(text);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
    }

    public void doMagic(View view) {
        Log.d(TAG, "doMagic");
        mainPresenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainPresenter != null)
            mainPresenter.detachView();
    }
}
