package org.amcgala.framework.testing;


import org.amcgala.Framework;
import org.amcgala.FrameworkMode;
import org.amcgala.Scene;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.shape.Polygon;

/**
 * Testklasse für die GL Funktionalität.
 */
public class PolygonTestMain {
    final Framework framework = Framework.getInstance(FrameworkMode.GL);

    public PolygonTestMain() {
        Scene scene = new Scene("line");
        Polygon polygon = new Polygon(
                new Vector3d(100, 100, 1),
                new Vector3d(100, 150, 1),
                new Vector3d(150, 150, 1),
                new Vector3d(120, 160, 1)
        );
        scene.addShape(polygon);
        framework.addScene(scene);
    }

    public static void main(String[] args) {
        new PolygonTestMain();
    }
}
