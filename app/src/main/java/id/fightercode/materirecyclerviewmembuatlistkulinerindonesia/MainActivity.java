package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import id.fightercode.materirecyclerviewmembuatlistkulinerindonesia.adapter.AdapterListKuliner;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> namaKuliner;
    private ArrayList<String> lokasiKuliner;
    private ArrayList<String> namaTempat;
    private ArrayList<String> hargaMakanan;
    private List<Integer> rattingKuliner;
    private ArrayList<Integer> gambarKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("List Kuliner Indonesia");
        
        initItemView();
    }

    private void initItemView() {
        final RecyclerView rvListData = (RecyclerView)findViewById(R.id.listKuliner);
        rvListData.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvListData.setLayoutManager(layoutManager);

        namaKuliner = new ArrayList<>();
        namaKuliner.add("Bakso");
        namaKuliner.add("Soto");
        namaKuliner.add("Sate");
        namaKuliner.add("Nasi Goreng");
        namaKuliner.add("Ayam Bakar");

        lokasiKuliner = new ArrayList<>();
        lokasiKuliner.add("Bekasi");
        lokasiKuliner.add("Cikarang");
        lokasiKuliner.add("Jogja");
        lokasiKuliner.add("Haurgeulis");
        lokasiKuliner.add("Indramayu");

        namaTempat = new ArrayList<>();
        namaTempat.add("RM. Butet");
        namaTempat.add("RM. Pasar");
        namaTempat.add("RM. Serang");
        namaTempat.add("RM. Barat");
        namaTempat.add("RM. Timur");

        hargaMakanan = new ArrayList<>();
        hargaMakanan.add("5000");
        hargaMakanan.add("7500");
        hargaMakanan.add("10000");
        hargaMakanan.add("15000");
        hargaMakanan.add("18000");

        rattingKuliner = new ArrayList<>();
        rattingKuliner.add(6);
        rattingKuliner.add(5);
        rattingKuliner.add(8);
        rattingKuliner.add(10);
        rattingKuliner.add(9);

        gambarKuliner = new ArrayList<>();
        gambarKuliner.add(R.drawable.bakso);
        gambarKuliner.add(R.drawable.soto);
        gambarKuliner.add(R.drawable.kuliner_sate);
        gambarKuliner.add(R.drawable.nasigoreng_special);
        gambarKuliner.add(R.drawable.ayam_bakar);

        RecyclerView.Adapter adapter = new AdapterListKuliner(namaKuliner, lokasiKuliner, namaTempat, hargaMakanan, rattingKuliner, gambarKuliner);
        rvListData.setAdapter(adapter);

        rvListData.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvListData.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvListData.getChildAdapterPosition(child);

                    String namamakanan, lokasi, tempat;
                    Integer harga;

                    namamakanan = namaKuliner.get(position);
                    lokasi = lokasiKuliner.get(position);
                    tempat = namaTempat.get(position);
                    harga = Integer.valueOf(hargaMakanan.get(position));

                    prosesPesanKuliner(namamakanan, harga, lokasi, tempat, gambarKuliner.get(position), rattingKuliner.get(position));
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
    }

    public void prosesPesanKuliner(
            String pushNamaMakanan,
            Integer pushHarga,
            String pushLokasi,
            String pushRumahMakan,
            Integer pushGambar,
            Integer pushRating) {

        Bundle paketData = new Bundle();
        paketData.putString("NAMA_MAKANAN", pushNamaMakanan);
        paketData.putString("LOKASI_RUMAHMAKANAN", pushLokasi);
        paketData.putString("NAMA_RUMAHMAKANAN", pushRumahMakan);
        paketData.putInt("HARGA_MAKANAN", pushHarga);
        paketData.putInt("GAMBAR_MAKANAN", pushGambar);
        paketData.putInt("RATING_MAKANAN", pushRating);

        Intent prosesKirim = new Intent(MainActivity.this, PesanActivity.class);
        prosesKirim.putExtras(paketData);
        startActivity(prosesKirim);
        return;
    }
}
