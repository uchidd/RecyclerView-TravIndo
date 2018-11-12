package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void clickToKuliner(View view) {
        startActivity(new Intent(MenuActivity.this, MainKulinerActivity.class));
        finish();
    }

    public void clickToWisata(View view) {
        startActivity(new Intent(MenuActivity.this, MainWisataActivity.class));
        finish();
    }

    public void clickToAboutDeveloper(View view) {
        startActivity(new Intent(MenuActivity.this, AboutDeveloperActivity.class));
        finish();
    }
    public void clickToAboutApp(View view) {
        startActivity(new Intent(MenuActivity.this, AboutAppActivity.class));
        finish();
    }
}
