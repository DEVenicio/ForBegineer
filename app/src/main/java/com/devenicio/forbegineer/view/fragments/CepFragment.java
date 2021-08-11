package com.devenicio.forbegineer.view.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.devenicio.forbegineer.R;
import com.devenicio.forbegineer.network.ApiService;
import com.devenicio.forbegineer.model.CEP;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CepFragment extends Fragment {


    EditText inputCep;
    Button btnSearch;
    TextView txtResult;
    View screenCep;


    public CepFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        screenCep = inflater.inflate(R.layout.fragment_cep, container, false);

        btnSearch = screenCep.findViewById(R.id.btn_buscar_cep);
        txtResult = screenCep.findViewById(R.id.resultado_api_cep);
        inputCep = screenCep.findViewById(R.id.input_tiet_cep);

        inputCep.addTextChangedListener(new TextWatcher() {
            Boolean isUpdating = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }


        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recoveryCEPRetrofit();
            }
        });

        return screenCep;

    }


    private void recoveryCEPRetrofit() {

        ApiService.getInstance().getCep(inputCep.getText().toString()).enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {

                if (response.isSuccessful()) {

                    CEP cep = response.body();

                    txtResult.setVisibility(View.VISIBLE);
                    txtResult.setText(  cep.getCep() + "\n"  + cep.getLogradouro() +"\n"+ cep.getBairro()+"\n"+cep.getLocalidade()+"\n"+cep.getUf());

                }

            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });
    }
}