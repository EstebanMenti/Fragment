package com.example.fragment.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private Button btnSend;
    private EditText editTextSend;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback = (DataListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " show implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container,false);

        btnSend = view.findViewById(R.id.btnSend);
        editTextSend = view.findViewById(R.id.editTextData);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendData( editTextSend.getText().toString() );
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public interface DataListener{
        void sendData(String text);
    }

}
