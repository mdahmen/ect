package spherestournent;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRISphere;

import java.awt.*;

/**
 * Created by Win on 24-01-16.
 */
public class TestSpheresTournent extends TestObjetSub {
    private TRISphere[] sps;
    private Trajectoire tr;
    private Matrix33[] matricess = new Matrix33[]{Matrix33.I, Matrix33.XYZ, Matrix33.YZX, Matrix33.ZXY};
    private Matrix33 matrix;

    public static void main(String[] args) {
        TestSpheresTournent ts = new TestSpheresTournent();

        ts.setMaxFrames(3000);
    }

    public void ginit() {
        sps = new TRISphere[12];

        int i = 0;
        for (TRISphere sp : sps) {
            sp = new TRISphere(Point3D.X.mult(i), 1);

            sp.texture(new ColorTexture(Color.blue));
            i++;
        }

        camera(new Camera(Point3D.Z.mult(-15), Point3D.O0));
    }

    public void testScene() {
        int i = 0;
        if (frame < getMaxFrames()) {
            i = 3;
        }
        if (frame < getMaxFrames() * 2 / 3) {
            i = 2;
        }
        if (frame < getMaxFrames() / 3) {
            i = 1;
        }

        matrix = matricess[i % 3].pourcents(matricess[(i + 1) % 3], (frame() / (frame() % 3)) / (frame() / 3));

        for (i = 0; i < sps.length; i++) {
            sps[i].setRotation(new Rotation(matrix, Point3D.O0));
        }
    }
}
