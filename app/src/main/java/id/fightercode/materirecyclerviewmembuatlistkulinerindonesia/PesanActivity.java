package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesanActivity extends AppCompatActivity {

    @BindView(R.id.getTxtHarga)
    TextView getTxtHarga;
    @BindView(R.id.getTxtLokasi)
    TextView getTxtLokasi;
    @BindView(R.id.getTxtTempat)
    TextView getTxtTempat;
    @BindView(R.id.getImgKuliner)
    ImageView getImgKuliner;
    @BindView(R.id.getRatingKuliner)
    RatingBar getRatingKuliner;

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;

    private boolean appBarExpanded = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        setSupportActionBar(toolbar);

        Bundle ambilData = getIntent().getExtras();

        String getNamaKuliner = ambilData.getString("NAMA_MAKANAN");
        int getHarga = getIntent().getIntExtra("HARGA_MAKANAN", 0);
        String getLokasiKuliner = ambilData.getString("LOKASI_RUMAHMAKANAN");
        String getRumahMakana = ambilData.getString("NAMA_RUMAHMAKANAN");
        Integer getGambarMakanan = ambilData.getInt("GAMBAR_MAKANAN");
        Integer getRatingMakanan = ambilData.getInt("RATING_MAKANAN");

        getTxtHarga.setText("Rp " + getHarga + "/porsi");
        getTxtLokasi.setText(getLokasiKuliner);
        getTxtTempat.setText(getRumahMakana);
        Picasso.get().load(getGambarMakanan).into(getImgKuliner);
        getRatingKuliner.setRating(getRatingMakanan);
        collapsingToolbar.setTitle(getNamaKuliner);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PesanActivity.this, MainKulinerActivity.class));
        finish();
    }
}
