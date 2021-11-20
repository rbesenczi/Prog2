package hu.unideb.prog2.networkingdemoapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkService extends Service {

    private Socket socket;
    private DataOutputStream dos;
    private NetworkingThread networkingThread;

    public NetworkService() {
    }

    class NetworkingThread extends Thread {
        public void run(){
            try {
                socket = new Socket("10.0.2.2", 10009);
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        if(intent.getStringExtra("activity").equals("startnetworking")) {

            networkingThread = new NetworkingThread();
            networkingThread.start();
        }

        if(intent.getStringExtra("activity").equals("sendmessage")){
            String message = intent.getStringExtra("message");
            if(socket != null && socket.isConnected()) {
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            dos.writeUTF(message);
                            System.out.printf("Message sent.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
            else
                System.out.println("We have some problem...");
        }

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}