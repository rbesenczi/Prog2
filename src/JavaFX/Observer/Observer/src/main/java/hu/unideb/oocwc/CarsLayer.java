package hu.unideb.oocwc;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Pair;

import java.util.Iterator;
import java.util.Set;

public class CarsLayer extends MapLayer {

    private final ObservableList<Pair<MapPoint, Node>> cars = FXCollections.observableArrayList();
    
    public CarsLayer() { }

    public void addPoint(MapPoint p, Node icon) {
        cars.add(new Pair<>(p, icon));
        this.getChildren().add(icon);
        this.markDirty();
    }

    public void updatePoints(Set<MapPoint> mp) {
        Iterator<MapPoint> carIterator = mp.iterator();

        for(Pair<MapPoint, Node> c : cars) {
            MapPoint car = carIterator.next();
            c.getKey().update(car.getLatitude(),car.getLongitude());
            this.markDirty();
        }
    }

    @Override
    protected void layoutLayer() {
        for (Pair<MapPoint, Node> candidate : cars) {
            MapPoint point = candidate.getKey();
            Node icon = candidate.getValue();
            Point2D mapPoint = getMapPoint(point.getLatitude(), point.getLongitude());
            icon.setVisible(true);
            icon.setTranslateX(mapPoint.getX());
            icon.setTranslateY(mapPoint.getY());
        }
    }
}
