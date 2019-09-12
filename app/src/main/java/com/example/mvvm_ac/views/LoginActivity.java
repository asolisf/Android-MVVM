package com.example.mvvm_ac.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvvm_ac.R;
import com.example.mvvm_ac.databinding.ActivityLoginBinding;
import com.example.mvvm_ac.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding
                = DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityLoginBinding.setViewModel(new LoginViewModel());
    }

    @BindingAdapter({"isSuccess"})
    public static void showMessage(View view, boolean isSuccess){
        if(!isSuccess){
            Toast.makeText(
                    view.getContext(),
                    R.string.login_failed,
                    Toast.LENGTH_SHORT).show();
        }
    }
}
