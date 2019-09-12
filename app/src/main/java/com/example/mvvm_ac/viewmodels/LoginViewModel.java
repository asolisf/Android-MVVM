package com.example.mvvm_ac.viewmodels;

import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvm_ac.BR;
import com.example.mvvm_ac.models.LoginModel;

public class LoginViewModel extends BaseObservable {

    private LoginModel loginModel;

    private boolean isSuccess;

    public LoginViewModel(){
        this.loginModel = new LoginModel("","");
        this.setIsSuccess(true);
    }

    @Bindable
    public boolean getIsSuccess(){
        return this.isSuccess;
    }

    private void setIsSuccess(boolean isSuccess){
        this.isSuccess = isSuccess;
        notifyPropertyChanged(com.example.mvvm_ac.BR.isSuccess);
    }

    @Bindable
    public String getEmail() {
        return this.loginModel.getEmail();
    }

    public void setEmail(String email) {
        this.loginModel.setEmail(email);
        notifyPropertyChanged(com.example.mvvm_ac.BR.email);
    }

    @Bindable
    public String getPassword() {
        return this.loginModel.getPassword();
    }


    public void setPassword(String password) {
        this.loginModel.setPassword(password);
        notifyPropertyChanged(com.example.mvvm_ac.BR.password);
    }

    public void OnLogin(){
        this.setIsSuccess(validateLogin());
    }

    private boolean validateLogin()
    {
        return !this.loginModel.getEmail().isEmpty() && !this.loginModel.getPassword().isEmpty()
                && Patterns.EMAIL_ADDRESS.matcher(this.loginModel.getEmail()).matches()
                && this.loginModel.getPassword().length() >= 8;
    }
}
