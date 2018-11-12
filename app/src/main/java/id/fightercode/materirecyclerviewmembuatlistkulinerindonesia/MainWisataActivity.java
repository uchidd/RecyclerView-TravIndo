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


import id.fightercode.materirecyclerviewmembuatlistkulinerindonesia.adapter.AdapterListWisata;

public class MainWisataActivity extends AppCompatActivity {

    private ArrayList<String> namaTempatWisata;
    private ArrayList<String> lokasiTempatWisata;
    private ArrayList<Integer> deskripsiTempatWisata;
    private ArrayList<Integer> gambarTempatWisata;
    private ArrayList<String> wikipediaTempatWisata;
    private ArrayList<String> mapsTempatWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wisata);
        initItemView();
    }

    private void initItemView() {
        final RecyclerView rvListData = (RecyclerView) findViewById(R.id.listWisata);
        rvListData.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvListData.setLayoutManager(layoutManager);

        namaTempatWisata = new ArrayList<>();
        namaTempatWisata.add("Pulau Komodo");
        namaTempatWisata.add("Trio Gili");
        namaTempatWisata.add("Raja Ampat");
        namaTempatWisata.add("Danau Sentani");
        namaTempatWisata.add("Bali");
        namaTempatWisata.add("Taman Laut Bunaken");
        namaTempatWisata.add("Puncak Jayawijaya");
        namaTempatWisata.add("Tana Toraja");
        namaTempatWisata.add("Candi Borobudur");
        namaTempatWisata.add("Taman Mini Indonesia Indah");

        lokasiTempatWisata = new ArrayList<>();
        lokasiTempatWisata.add("Kepuluan Nusa Tenggara");
        lokasiTempatWisata.add("Lombok");
        lokasiTempatWisata.add("Papua");
        lokasiTempatWisata.add("Papua");
        lokasiTempatWisata.add("Denpasar");
        lokasiTempatWisata.add("Sulawesi Utara");
        lokasiTempatWisata.add("Papua");
        lokasiTempatWisata.add("Sulawesi Selatan");
        lokasiTempatWisata.add("Jogja");
        lokasiTempatWisata.add("Jakarta");

        deskripsiTempatWisata = new ArrayList<>();
        deskripsiTempatWisata.add(R.string.pulau_komodo);
        deskripsiTempatWisata.add(R.string.trio_gili);
        deskripsiTempatWisata.add(R.string.raja_ampat);
        deskripsiTempatWisata.add(R.string.danau_sentani);
        deskripsiTempatWisata.add(R.string.bali);
        deskripsiTempatWisata.add(R.string.taman_laut_bunaken);
        deskripsiTempatWisata.add(R.string.puncak_jayawijaya);
        deskripsiTempatWisata.add(R.string.tana_toraja);
        deskripsiTempatWisata.add(R.string.candi_borobudur);
        deskripsiTempatWisata.add(R.string.taman_mini_indonesia_indah);

        gambarTempatWisata = new ArrayList<>();
        gambarTempatWisata.add(R.drawable.pulau_komodo);
        gambarTempatWisata.add(R.drawable.trio_gili);
        gambarTempatWisata.add(R.drawable.raja_ampat);
        gambarTempatWisata.add(R.drawable.danau_sentani);
        gambarTempatWisata.add(R.drawable.bali);
        gambarTempatWisata.add(R.drawable.taman_laut_bunaken);
        gambarTempatWisata.add(R.drawable.puncak_jayawijaya);
        gambarTempatWisata.add(R.drawable.tana_toraja);
        gambarTempatWisata.add(R.drawable.candi_borobudur);
        gambarTempatWisata.add(R.drawable.taman_mini_indonesia_indah);

        wikipediaTempatWisata = new ArrayList<>();
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Pulau_Komodo");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Kepulauan_Gili");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Kepulauan_Raja_Ampat");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Danau_Sentani");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Bali");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Taman_Nasional_Bunaken");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Puncak_Jaya");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Kabupaten_Tana_Toraja");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Borobudur");
        wikipediaTempatWisata.add("https://id.wikipedia.org/wiki/Taman_Mini_Indonesia_Indah");

        mapsTempatWisata = new ArrayList<>();
        mapsTempatWisata.add("https://bit.ly/maps_pulau_komodo");
        mapsTempatWisata.add("https://bit.ly/maps_trio_gili");
        mapsTempatWisata.add("https://bit.ly/maps_raja_ampat");
        mapsTempatWisata.add("https://bit.ly/maps_danau_sentani");
        mapsTempatWisata.add("https://bit.ly/maps_bali");
        mapsTempatWisata.add("https://bit.ly/maps_taman_laut_bunaken");
        mapsTempatWisata.add("https://bit.ly/maps_puncak_jayawijaya");
        mapsTempatWisata.add("https://bit.ly/maps_tana_toraja");
        mapsTempatWisata.add("https://bit.ly/maps_candi_borobudur");
        mapsTempatWisata.add("https://bit.ly/maps_taman_mini_indonesia_indah");

        RecyclerView.Adapter adapter = new AdapterListWisata(namaTempatWisata, lokasiTempatWisata, deskripsiTempatWisata, gambarTempatWisata, wikipediaTempatWisata, mapsTempatWisata);
        rvListData.setAdapter(adapter);

        rvListData.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvListData.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvListData.getChildAdapterPosition(child);

                    String nama, lokasi, wikipedia, maps;
                    Integer deskripsi, gambar;

                    nama = namaTempatWisata.get(position);
                    lokasi = lokasiTempatWisata.get(position);
                    wikipedia = wikipediaTempatWisata.get(position);
                    maps = mapsTempatWisata.get(position);
                    deskripsi = deskripsiTempatWisata.get(position);
                    gambar = gambarTempatWisata.get(position);

                    prosesPesanKuliner(nama, lokasi, wikipedia, maps, deskripsi, gambar);
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
            String pushNamaWisata, String pushLokasiWisata, String pushWikipediaWisata, String pushMapsWisata, Integer pushDeskripsiWisata, Integer pushGambarWisata) {

        Bundle dataTempatWisata = new Bundle();

        dataTempatWisata.putString("NAMA TEMPAT WISATA", pushNamaWisata);
        dataTempatWisata.putString("LOKASI TEMPAT WISATA", pushLokasiWisata);
        dataTempatWisata.putString("WIKIPEDIA TEMPAT WISATA", pushWikipediaWisata);
        dataTempatWisata.putString("MAPS TEMPAT WISATA", pushMapsWisata);
        dataTempatWisata.putInt("DESKRIPSI TEMPAT WISATA", pushDeskripsiWisata);
        dataTempatWisata.putInt("GAMBAR TEMPAT WISATA", pushGambarWisata);

        Intent prosesKirim = new Intent(MainWisataActivity.this, DetailActivity.class);
        prosesKirim.putExtras(dataTempatWisata);
        startActivity(prosesKirim);
        finish();
        return;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MainWisataActivity.this, MenuActivity.class));
        finish();
    }
}
