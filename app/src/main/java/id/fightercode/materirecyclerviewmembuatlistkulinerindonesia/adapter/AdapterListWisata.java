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

public class AdapterListWisata extends RecyclerView.Adapter<AdapterListWisata.ViewHolder> {

    private ArrayList<String> namaTempatWisata;
    private ArrayList<String> lokasiTempatWisata;
    private ArrayList<Integer> deskripsiTempatWisata;
    private ArrayList<Integer> gambarTempatWisata;
    private ArrayList<String> wikipediaTempatWisata;
    private ArrayList<String> mapsTempatWisata;

    public AdapterListWisata(
            ArrayList<String> namaTempatWisata,
            ArrayList<String> lokasiTempatWisata,
            ArrayList<Integer> deskripsiTempatWisata,
            ArrayList<Integer> gambarTempatWisata,
            ArrayList<String> wikipediaTempatWisata,
            ArrayList<String> mapsTempatWisata) {

        this.namaTempatWisata = namaTempatWisata;
        this.lokasiTempatWisata = lokasiTempatWisata;
        this.deskripsiTempatWisata = deskripsiTempatWisata;
        this.gambarTempatWisata = gambarTempatWisata;
        this.wikipediaTempatWisata = wikipediaTempatWisata;
        this.mapsTempatWisata = mapsTempatWisata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_listwisata, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.namaWisata.setText(namaTempatWisata.get(i));
        viewHolder.deskripsiWisata.setText(lokasiTempatWisata.get(i));
        viewHolder.lokasiWisata.setText(deskripsiTempatWisata.get(i));
        Picasso.get().load(gambarTempatWisata.get(i)).into(viewHolder.gambarWisata);
    }

    @Override
    public int getItemCount() {
        return namaTempatWisata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView namaWisata, lokasiWisata, deskripsiWisata;
        private ImageView gambarWisata;

        public ViewHolder(View itemView) {
            super(itemView);
            namaWisata = (TextView)itemView.findViewById(R.id.namaWisata);
            lokasiWisata = (TextView)itemView.findViewById(R.id.lokasiWisata);
            deskripsiWisata = (TextView)itemView.findViewById(R.id.deskripsiWisata);
            gambarWisata = (ImageView)itemView.findViewById(R.id.gambarWisata);
        }
    }
}
