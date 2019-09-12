package com.example.mvvm_ac.viewmodels;

import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvm_ac.BR;
import com.example.mvvm_ac.models.LoginModel;

public class LoginViewModel extends BaseObservable {

    private final int PASSWORD_MIN_LENGTH = 8;

    private LoginModel loginModel;

    private boolean isSuccess;

    public LoginViewModel(){
        this.loginModel = new LoginModel("","");
        this.setIsSuccess(true);
    }

    /**
     * Bindable annotation expose and allow that property
     * to be bind with the UI.
     * @return flag if login is success or not.
     */
    @Bindable
    public boolean getIsSuccess(){
        return this.isSuccess;
    }

    private void setIsSuccess(boolean isSuccess){
        //It´s better for performance check before if value really changed
        //and notify property changed
        if(this.isSuccess != isSuccess){
            this.isSuccess = isSuccess;
            notifyPropertyChanged(com.example.mvvm_ac.BR.isSuccess);
        }
    }

    @Bindable
    public String getEmail() {
        return this.loginModel.getEmail();
    }

    public void setEmail(String email) {
        this.loginModel.setEmail(email);
        //BR class is generated automatically after build project.
        notifyPropertyChanged(com.example.mvvm_ac.BR.email);
    }

    @Bindable
    public String getPassword() {
        return this.loginModel.getPassword();
    }


    public void setPassword(String password) {
        this.loginModel.setPassword(password);
        //Notify property changed notify that property changed to UI.
        notifyPropertyChanged(com.example.mvvm_ac.BR.password);
    }

    public void OnLogin(){
        this.setIsSuccess(validateLogin());
    }

    private boolean validateLogin()
    {
        return !this.loginModel.getEmail().isEmpty() && !this.loginModel.getPassword().isEmpty()
                && Patterns.EMAIL_ADDRESS.matcher(this.loginModel.getEmail()).matches()
                && this.loginModel.getPassword().length() >= PASSWORD_MIN_LENGTH;
    }
}
