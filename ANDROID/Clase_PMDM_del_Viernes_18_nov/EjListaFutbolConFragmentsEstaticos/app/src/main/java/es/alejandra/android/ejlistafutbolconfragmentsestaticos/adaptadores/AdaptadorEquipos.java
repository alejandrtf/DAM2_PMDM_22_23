package es.alejandra.android.ejlistafutbolconfragmentsestaticos.adaptadores;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.alejandra.android.ejlistafutbolconfragmentsestaticos.R;
import es.alejandra.android.ejlistafutbolconfragmentsestaticos.fragments.ListaEquiposFragment;
import es.alejandra.android.ejlistafutbolconfragmentsestaticos.modelo.Equipo;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.EquiposViewHolder> {


    private List<Equipo> listaEquipos;
   private ListaEquiposFragment.OnListFragmentInteraccionListener mListener;


    public AdaptadorEquipos(List<Equipo> listaEquipos) {

        this.listaEquipos = listaEquipos;
    }


    public void setOnItemClickListener(ListaEquiposFragment.OnListFragmentInteraccionListener listener) {
        this.mListener = listener;
    }

    @Override
    public EquiposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_equipos, parent, false);
        EquiposViewHolder equiposViewHolder = new EquiposViewHolder(itemView, mListener);
        return equiposViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EquiposViewHolder holder, int position) {
        Equipo equipo = listaEquipos.get(position);
        holder.bindEquipo(equipo);
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }


    /**
     * VIEWHOLDER
     */
    public static class EquiposViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvPuntosEquipo;
        ImageView ivEscudo;


        public EquiposViewHolder(View itemView, final ListaEquiposFragment.OnListFragmentInteraccionListener listener) {
            super(itemView);

            //asigno listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onListFragmentInteraccion(getAdapterPosition());
                }
            });

            tvNombre = itemView.findViewById(R.id.tvNombreEquipoItem);
            tvPuntosEquipo = itemView.findViewById(R.id.tvPuntosItem);
            ivEscudo = itemView.findViewById(R.id.ivEscudo);

        }

        public void bindEquipo(Equipo equipo) {
            tvNombre.setText(equipo.getNombreEquipo());
            tvPuntosEquipo.setText(String.valueOf(equipo.getPuntos()));
            ivEscudo.setImageDrawable(equipo.getImagenEscudo());

        }
    }



}


