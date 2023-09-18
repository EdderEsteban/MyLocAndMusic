package com.ddrssoft.mylocandmusic.ui.gallery;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.ddrssoft.mylocandmusic.R;

public class ServicioMusical extends Service {
    private MediaPlayer mp;
    //No vamos a usar el contructor, por ahora hasta que creemos una lista de audios.
    public ServicioMusical() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Instancear un media player con el audio a reproducir
        mp = MediaPlayer.create(this, R.raw.music123);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();
        //despues de hacer toda la tarea del startcommand, retornar esta constante.
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}