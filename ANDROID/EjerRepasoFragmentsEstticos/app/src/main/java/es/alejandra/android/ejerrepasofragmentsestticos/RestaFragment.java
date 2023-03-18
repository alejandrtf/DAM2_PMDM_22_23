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
 * Use the {@link RestaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaFragment extends Fragment {
TextView tvResta;

    public RestaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
        * @return A new instance of fragment RestaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestaFragment newInstance(String param1, String param2) {
        RestaFragment fragment = new RestaFragment();
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
        View v= inflater.inflate(R.layout.fragment_resta, container, false);
        tvResta=v.findViewById(R.id.tvResta);
        return v;
    }

    public void mostrarResultado(float valor){
        tvResta.setText(String.valueOf(valor));
    }

    public void incrementarResultado(int porcentaje){
        if(!TextUtils.isEmpty(tvResta.getText())){
            float resta=Float.parseFloat(tvResta.getText().toString());
            resta=resta*(1+porcentaje/100f);
            tvResta.setText(String.format(Locale.getDefault(),"%.2f",resta));
        } else {
            Toast.makeText(getContext(), "Debes calcular primero una resta", Toast.LENGTH_SHORT).show();
        }
    }
}