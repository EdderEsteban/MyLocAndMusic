package com.ddrssoft.mylocandmusic;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


public class MainActivityViewModel extends AndroidViewModel {
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void login(String usuario, String password) {

        if (usuario.equals("usuario") && password.equals("123")) {
            Intent intent = new Intent(context, NavActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            //Toast.makeText(context, "Ingreso al Login", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "Los datos  ingresados son incorrectos", Toast.LENGTH_SHORT).show();

        }
    }
}