package com.example.android1homework2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {
        private TextView textView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_second, container, false);
            textView = view.findViewById(R.id.text_fragmentSecond);
            return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Создаем объект ThirdFragment и передаем данные через bundle
                    ThirdFragment thirdFragment = new ThirdFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", "admin");
                    bundle.putString("password", "admin");
                    thirdFragment.setArguments(bundle);
                    // Вызываем метод transationToTirdFragment() для перехода на третий фрагмент
                    transationToTirdFragment(thirdFragment);
                }
            });
        }

        private void transationToTirdFragment(ThirdFragment thirdFragment) {
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, thirdFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

