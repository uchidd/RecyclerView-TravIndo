package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AboutAppActivity.this, MenuActivity.class));
        finish();
    }
}
