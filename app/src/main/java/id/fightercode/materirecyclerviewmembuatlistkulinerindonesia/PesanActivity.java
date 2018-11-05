package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PesanActivity extends AppCompatActivity {

    @BindView(R.id.getTxtNama)
    TextView getTxtNama;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        ButterKnife.bind(this);

        Bundle ambilData = getIntent().getExtras();

        String getNamaKuliner = ambilData.getString("NAMA_MAKANAN");
        int getHarga = getIntent().getIntExtra("HARGA_MAKANAN", 0);
        String getLokasiKuliner = ambilData.getString("LOKASI_RUMAHMAKANAN");
        String getRumahMakana = ambilData.getString("NAMA_RUMAHMAKANAN");
        Integer getGambarMakanan = ambilData.getInt("GAMBAR_MAKANAN");
        Integer getRatingMakanan = ambilData.getInt("RATING_MAKANAN");

        getTxtNama.setText(getNamaKuliner);
        getTxtHarga.setText("" + getHarga);
        getTxtLokasi.setText(getLokasiKuliner);
        getTxtTempat.setText(getRumahMakana);
        Picasso.get().load(getGambarMakanan).into(getImgKuliner);
        getRatingKuliner.setRating(getRatingMakanan);
    }
}
