package hu.unideb.oocwc;

import com.gluonhq.attach.util.Platform;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Observer extends Application {

    public static class Loc {
        double lat;
        double lon;

        public Loc(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }
    }

    private static final Logger LOGGER = Logger.getLogger(Observer.class.getName());

    static {
        try {
            LogManager.getLogManager().readConfiguration(Observer.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading logging properties file", e);
        }
    }

    private final String logFile = "../../../../../porto_10_1000.txt";
    private final Map<Long, Loc> lmap = new HashMap<>();
    private final String mapFile = "../../../../../porto_lmap.txt";
    private final Loc portoLocation = new Loc(41.1, -8.6);
    private static boolean useSocket = false;

    @Override
    public void start(Stage stage) {

        readMap(lmap, mapFile);

        MapView view = new MapView();
        view.setZoom(11);

        view.addLayer(carLayer());

        StackPane bp = new StackPane();
        bp.getChildren().addAll(view);

        Scene scene;

        if (Platform.isDesktop()) {
            scene = new Scene(bp, 2560, 1440);
            stage.setTitle("Robocar Observer");
        } else {
            Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
            scene = new Scene(bp, bounds.getWidth(), bounds.getHeight());
        }

        stage.setScene(scene);
        stage.show();

        view.setCenter(portoLocation.lat, portoLocation.lon);
    }

    private MapLayer carLayer() {

        CarsLayer answer = new CarsLayer();

        Service<Void> drawPOIService = new Service<>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<>() {
                    @Override
                    protected Void call() {

                        Scanner scan = null;
                        try {
                            if(useSocket)
                            {
                                Socket trafficSocket = new Socket("localhost", 10007);

                                if (trafficSocket.isConnected())
                                    LOGGER.log(Level.INFO, "Socket connected");

                                OutputStream os = trafficSocket.getOutputStream();
                                DataOutputStream dos = new DataOutputStream(os);
                                dos.writeUTF("<disp>");

                                scan = new Scanner(trafficSocket.getInputStream());
                            }
                            else {
                                scan = new Scanner(new File(logFile));
                            }
                        } catch (FileNotFoundException e) {
                            LOGGER.log(Level.SEVERE, "logfile open problem", e);
                        } catch (UnknownHostException e) {
                            LOGGER.log(Level.SEVERE, "socketproblem", e);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        int time = 0, minutes = 0, size = 0;

                        time = scan.nextInt();
                        minutes = scan.nextInt();
                        size = scan.nextInt();

                        LOGGER.log(Level.INFO, "File open. Time: " + time + ", minutes: " + minutes + ", size: " + size);

                        long ref_from = 0, ref_to = 0;
                        int step = 0, maxstep = 1, type = 0;
                        double lat, lon;
                        double lat2, lon2;

                        Set<MapPoint> carsPosition = new HashSet<>(size);

                        for (int i = 0; i < size; i++)
                            carsPosition.add(new MapPoint(portoLocation.lat, portoLocation.lon));

                        for (MapPoint mp : carsPosition)
                            answer.addPoint(mp, new Circle(7, Color.RED));

                        while (scan.hasNext()) {

                            Iterator<MapPoint> carIterator = carsPosition.iterator();

                            for (int i = 0; i < size; ++i) {

                                ref_from = scan.nextLong();
                                ref_to = scan.nextLong();
                                maxstep = scan.nextInt();
                                step = scan.nextInt();
                                type = scan.nextInt();

                                lat = lmap.get(ref_from).lat;
                                lon = lmap.get(ref_from).lon;

                                lat2 = lmap.get(ref_to).lat;
                                lon2 = lmap.get(ref_to).lon;

                                if (maxstep == 0) {
                                    maxstep = 1;
                                }

                                lat += step * ((lat2 - lat) / maxstep);
                                lon += step * ((lon2 - lon) / maxstep);

                                MapPoint car = carIterator.next();
                                car.update(lat, lon);
                            }

                            try {
                                sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            answer.updatePoints(carsPosition);

                            time = scan.nextInt();
                            minutes = scan.nextInt();
                            size = scan.nextInt();
                        }
                        return null;
                    }
                };
            }
        };

        drawPOIService.start();

        return answer;
    }

    private static void readMap(Map<Long, Loc> lmap, String name) {

        java.util.Scanner scan;
        java.io.File file = new java.io.File(name);

        long ref = 0;
        double lat = 0.0, lon = 0.0;
        try {
            scan = new Scanner(file);
            scan.useLocale(java.util.Locale.ENGLISH);

            while (scan.hasNext()) {

                ref = scan.nextLong();
                lat = scan.nextDouble();
                lon = scan.nextDouble();

                lmap.put(ref, new Loc(lat, lon));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "noderef2GPS problem", e);
        }
        LOGGER.log(Level.INFO, "Map read finished.");
    }

    public static void main(String[] args) {

        for(String arg : args) {
            if (arg.equals("socket")) {
                useSocket = true;
                break;
            }
        }

        Application.launch(args);
    }
}
