package com.example.pyb.profile;

import static android.app.ProgressDialog.show;
import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pyb.R;
import com.example.pyb.database.UserDatabase;
import com.example.pyb.database.UserPreferences;
import com.example.pyb.editAddress.GeoLocationActivity;
import com.example.pyb.model.User;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditFragment extends Fragment {

    public static final int GEO_LOCATION_RESULT = 11001;
    private TextInputEditText editNama, editNpm, editEmail, editPhonenum, editAddress;
    private TextInputLayout editPhonenumLayout, editAddressLayout;
    private User user;
    private UserPreferences userPreferences;
    private MaterialButton btnUpdate,btnAddress;
    private String addressLocation="-";

    public EditFragment() {
        // Required empty public constructor
    }

    private void updateProfile(final User user) {
        class UpdateUserProfile extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                UserDatabase.getInstance(getActivity().getApplicationContext())
                        .getAppDatabase()
                        .userDao()
                        .update(user);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "Your profile is updated!", Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_fragment, new DetailFragment()).commit();
            }
        }
        UpdateUserProfile updateUserProfile = new UpdateUserProfile();
        updateUserProfile.execute();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GeoLocationActivity.class);
                intent.putExtra("My Location",addressLocation);
                startActivityForResult(intent,GEO_LOCATION_RESULT);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = (User) getActivity().getIntent().getSerializableExtra("Address Data");
                addressLocation = user.getJsonAddress();

                user.setPhone_num(String.valueOf(editPhonenum.getText()));
                user.setAddress(String.valueOf(editAddress.getText()));
                updateProfile(user);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        container.removeAllViews();
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        user = (User) getArguments().getSerializable("user_profile");
        editNama = view.findViewById(R.id.etNama);
        editNpm = view.findViewById(R.id.etNpm);
        editEmail = view.findViewById(R.id.etEmail);
        editAddress = view.findViewById(R.id.etAddress);
        editAddressLayout = view.findViewById(R.id.twAddress);
        editPhonenum = view.findViewById(R.id.etPhoneNum);
        editPhonenumLayout = view.findViewById(R.id.twPhoneNum);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        btnAddress = view.findViewById(R.id.btnEditAdd);

        try {
            if(user.getName() != null) {
                editNama.setText(user.getName());
            } else {
                editNama.setText("-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(user.getNpm() != null) {
                editNpm.setText(user.getNpm());
            } else {
                editNpm.setText("-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(user.getMail() != null) {
                editEmail.setText(user.getMail());
            } else {
                editEmail.setText("-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(user.getPhone_num() != null) {
                editPhonenum.setText(user.getPhone_num());
            } else {
                editPhonenum.setText("-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(user.getAddress() != null) {
                editAddress.setText(user.getAddress());
            } else {
                editAddress.setText("-");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    public void changeFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment,fragment)
                .commit();
    }
}