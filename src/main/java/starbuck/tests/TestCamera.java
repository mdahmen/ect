package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import java.awt.Color;

/**
 *
 * @author Atelier
 */
public class TestCamera extends TestObjetSub {

    @Override
    public void ginit() {
        super.ginit();
        Cube c = new Cube(2, Point3D.O0);
        c.texture(new ColorTexture(Color.RED));
        scene().add(c);
    }

    double a = 0;
    
    double d = 3;
    
    @Override
    public void testScene() {
        a += 2*Math.PI/getMaxFrames();
        scene().cameras().clear();
        scene().cameraActive(
                new Camera(
                    new Point3D(d*Math.cos(a), d*Math.sin(a),d),
                    Point3D.O0
                ));
    }
    
    public static void main(String [] args)
    {
        TestCamera tc = new TestCamera();
        
        tc.setResx(640);
        tc.setResy(480);
        
        tc.loop(true);
        tc.setMaxFrames(100);
        
        
        tc.run();
    }
}
