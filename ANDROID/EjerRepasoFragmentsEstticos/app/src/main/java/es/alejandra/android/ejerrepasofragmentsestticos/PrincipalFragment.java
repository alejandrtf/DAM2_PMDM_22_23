package es.alejandra.android.ejerrepasofragmentsestticos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrincipalFragment extends Fragment {
    private OnOperacionCalculadaListener mListener;

    // VISTAS
    EditText etN1,etN2;
    RadioGroup rgOperacion;
    Button btCalcular;

     public PrincipalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PrincipalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PrincipalFragment newInstance() {
        PrincipalFragment fragment = new PrincipalFragment();
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
        View v= inflater.inflate(R.layout.fragment_principal, container, false);
        etN1=v.findViewById(R.id.etNumero1);
        etN2=v.findViewById(R.id.etNumero2);
        rgOperacion=v.findViewById(R.id.rgOperaciones);
        btCalcular=v.findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etN1.getText().toString().length()!=0 && etN2.getText().toString().length()!=0){
                    float resu;
                    char operacion;
                     if(rgOperacion.getCheckedRadioButtonId()==R.id.rbSuma){
                         resu=Float.parseFloat(etN1.getText().toString())+Float.parseFloat(etN2.getText().toString());
                         operacion='+';
                    }else{
                         resu=Float.parseFloat(etN1.getText().toString())-Float.parseFloat(etN2.getText().toString());
                         operacion='-';
                    }
                     mListener.onOperacionCalculada(resu,operacion);
                }else{
                    Toast.makeText(getContext(), "Debes introducir algún número", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }

    /** Método que incrementa los 2 EditText del fragment en el porcentaje que se le pasa
     *
     * @param porcentaje en el que se deben incrementar
     */
    public void incrementarResultado(int porcentaje){
        if(!TextUtils.isEmpty(etN1.getText()) && !TextUtils.isEmpty(etN2.getText())){
            float num1=Float.parseFloat(etN1.getText().toString());
            float num2=Float.parseFloat(etN2.getText().toString());
            num1=num1*(1+porcentaje/100f);
            num2=num2*(1+porcentaje/100f);
            etN1.setText(String.format(Locale.getDefault(),"%.2f",num1));
            etN2.setText(String.format(Locale.getDefault(),"%.2f",num2));
        } else {
            Toast.makeText(getContext(), "Debes introducir dos números", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnOperacionCalculadaListener){
            mListener= (OnOperacionCalculadaListener) context;
        }else{
            throw new ClassCastException(context.toString()+ "debe implementar el interface OnOperacionCalculadaListener");
        }
    }

    public interface OnOperacionCalculadaListener{
        public void onOperacionCalculada(float resultado, char operacion);
    }
}