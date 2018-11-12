package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenActivity extends AppCompatActivity {

    @BindView(R.id.pgSplashScreen)
    ProgressBar pgSplashScreen;
    @BindView(R.id.progressStatus)
    TextView progressStatus;

    private int progressStatusDefault = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);

        splashrun();

    }

    private void splashrun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatusDefault < 100) {
                    progressStatusDefault += 1;

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressStatus.setText(progressStatusDefault + "%");
                            pgSplashScreen.setProgress(progressStatusDefault);

                            int hasil = progressStatusDefault;
                            if (hasil == 100) {
                                startActivity(new Intent(SplashScreenActivity.this, MenuActivity.class));
                                finish();
                            }
                        }
                    });
                }
            }
        }).start();
    }
}
