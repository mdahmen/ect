/**
 * *
 * Global license :  *
 * CC Attribution
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package beziers;

import info.emptycanvas.library.nurbs.SurfaceParametriquePolynomialeBezier;
import info.emptycanvas.library.object.P;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.VideoTexture;
import info.emptycanvas.library.testing.TestObjetSub;
import java.io.File;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestBezierTextVideo extends TestObjetSub {

    private final Point3D[][] coeff = new Point3D[][]{
        {P.n(2, -2, 0), P.n(2, -1, 0), P.n(2, 0, 0), P.n(2, 1, 0), P.n(2, 2, 0)},
        {P.n(1, -2, 0), P.n(1, -1, 0), P.n(1, 0, 0), P.n(1, 1, 0), P.n(1, 2, 0)},
        {P.n(0, -2, 0), P.n(0, -1, 0), P.n(0, 0, 0), P.n(0, 1, 0), P.n(0, 2, 0)},
        {P.n(-1, -2, 0), P.n(-1, -1, 0), P.n(-1, 0, 0), P.n(-1, 1, 0), P.n(-1, 2, 0)},
        {P.n(-2, -2, 0), P.n(-2, -1, 0), P.n(-2, 0, 0), P.n(-2, 1, 0), P.n(-2, 2, 0)}
    };
    private SurfaceParametriquePolynomialeBezier s = new SurfaceParametriquePolynomialeBezier(coeff);
    VideoTexture videoTexture;

    @Override
    public void testScene(File f) throws Exception {
    }

    @Override
    public void ginit() {
        videoTexture = new VideoTexture("C:\\Emptycanvas\\textures\\Il embrasse sur la bouche.mp4");
        s.texture(videoTexture);
        scene().add(s);
        scene().cameraActive().setEye(Point3D.Z.mult(-6));
    }

    @Override
    public void finit() {
        videoTexture.nextFrame();
    }

    public TestBezierTextVideo() {
    }

    @Override
    public void testScene() throws Exception {

    }

    public static void main(String[] args) {

        TestBezierTextVideo tss = new TestBezierTextVideo();
        tss.setMaxFrames(2000);
        tss.loop(true);
        tss.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        new Thread(tss).start();
    }

}
