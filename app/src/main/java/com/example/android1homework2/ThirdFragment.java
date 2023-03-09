package com.example.android1homework2;

import static android.app.ProgressDialog.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class ThirdFragment extends Fragment {

    EditText editPassword;
    EditText editName;
    MaterialButton loginButton;

    private final static String PASSWORD = "admin";
    private final static String NAME = "admin";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editPassword = view.findViewById(R.id.inputPas);
        editName = view.findViewById(R.id.inputName);
        loginButton = view.findViewById(R.id.reg_button);

        registerButton();
    }

    private void registerButton() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String editNameText = editName.getText().toString();
                String editPas = editPassword.getText().toString();
                if (editNameText.equals(NAME) && editPas.equals(PASSWORD)) {
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, new FirstFragment())
                            .addToBackStack(null)
                            .commit();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        editName.addTextChangedListener(textWatcher);
        editPassword.addTextChangedListener(textWatcher);
    }
}