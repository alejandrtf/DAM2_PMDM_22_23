package es.alejandra.android.ejerrepasofragmentsestticos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SumaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SumaFragment extends Fragment {
    TextView tvSuma;




    public SumaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SumaFragment.
     */

    public static SumaFragment newInstance(String param1, String param2) {
        SumaFragment fragment = new SumaFragment();
        Bundle args = new Bundle();
            return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_suma, container, false);
        tvSuma=v.findViewById(R.id.tvSuma);
        return v;
    }

    public void mostrarResultado(float valor){
        tvSuma.setText(String.valueOf(valor));
    }

    public void incrementarResultado(int porcentaje){
        if(!TextUtils.isEmpty(tvSuma.getText())){
            float suma=Float.parseFloat(tvSuma.getText().toString());
            suma=suma*(1+porcentaje/100f);
            tvSuma.setText(String.format(Locale.getDefault(),"%.2f",suma));
        } else {
            Toast.makeText(getContext(), "Debes calcular primero una suma", Toast.LENGTH_SHORT).show();
        }
    }
}