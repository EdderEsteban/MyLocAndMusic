package com.ddrssoft.mylocandmusic.ui.gallery;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.ddrssoft.mylocandmusic.R;

public class ServicioMusical extends Service {
    public static final String ACTION_PAUSE = "com.ddrssoft.mylocandmusic.PAUSE";
    public static final String ACTION_STOP = "com.ddrssoft.mylocandmusic.STOP";

    private MediaPlayer mp;
    //No vamos a usar el contructor, por ahora hasta que creemos una lista de audios.
    public ServicioMusical() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Instancear un media player con el audio a reproducir
        mp = MediaPlayer.create(this, R.raw.savin);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();

        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_PAUSE.equals(action)) {
                pausa(); // Llama al método para pausar la música
            } else if (ACTION_STOP.equals(action)) {
                stop(); // Llama al método para detener la música
            }
        }

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

    public void pausa() {
        if (mp != null && mp.isPlaying()) {
            mp.pause();
        }
    }

    private void stop() {
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            // Vuelve a preparar el reproductor para que pueda reproducir desde el principio si se inicia nuevamente.
            mp.prepareAsync();
        }
    }


}