package id.fightercode.materirecyclerviewmembuatlistkulinerindonesia.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import id.fightercode.materirecyclerviewmembuatlistkulinerindonesia.R;

public class AdapterListKuliner extends RecyclerView.Adapter<AdapterListKuliner.ViewHolder> {

    private ArrayList<String> namaKuliner;
    private ArrayList<String> lokasiKuliner;
    private ArrayList<String> namaTempat;
    private ArrayList<String> hargaMakanan;
    private List<Integer> rattingKuliner;
    private ArrayList<Integer> gambarKuliner;

    public AdapterListKuliner(
            ArrayList<String> namaKuliner,
            ArrayList<String> lokasiKuliner,
            ArrayList<String> namaTempat,
            ArrayList<String> hargaMakanan,
            List<Integer> rattingKuliner,
            ArrayList<Integer> gambarKuliner) {

        this.namaKuliner = namaKuliner;
        this.lokasiKuliner = lokasiKuliner;
        this.namaTempat = namaTempat;
        this.hargaMakanan = hargaMakanan;
        this.rattingKuliner = rattingKuliner;
        this.gambarKuliner = gambarKuliner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_listkuliner, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvNamaKuliner.setText(namaKuliner.get(i));
        viewHolder.tvLokasi.setText(lokasiKuliner.get(i));
        viewHolder.tvTempat.setText(namaTempat.get(i));
        viewHolder.tvHarga.setText("Harga / Porsi Rp. " + hargaMakanan.get(i) + "-,");
        viewHolder.rtKuliner.setRating(rattingKuliner.get(i));
        Picasso.get().load(gambarKuliner.get(i)).into(viewHolder.picKuliner);
    }

    @Override
    public int getItemCount() {
        return namaKuliner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaKuliner, tvTempat, tvLokasi, tvHarga;
        private RatingBar rtKuliner;
        private ImageView picKuliner;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNamaKuliner = (TextView)itemView.findViewById(R.id.txtNamaKuliner);
            tvTempat = (TextView)itemView.findViewById(R.id.txtNamaRestoran);
            tvLokasi = (TextView)itemView.findViewById(R.id.txtLokasi);
            tvHarga = (TextView)itemView.findViewById(R.id.txtHarga);
            rtKuliner = (RatingBar)itemView.findViewById(R.id.rbKuliner);
            picKuliner = (ImageView)itemView.findViewById(R.id.imgKuliner);
        }
    }
}
