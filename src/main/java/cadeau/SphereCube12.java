/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package cadeau;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SphereCube12 extends TestObjetStub 

{
    double d = 90;
    private final double t0 = -1;
    private final double t1 = 1;
    private TRISphere s;

    private double F = 3;
    private Camera cam;
    @Override
    public void ginit() {
        
        Cube c;
        
        //c.texture(new TColor(Color.RED));
        c = new Cube(d/10, Point3D.O0);
        
        
        c.texture(new ColorTexture(Color.BLUE));
        
        s = new TRISphere(Point3D.X.mult(t0), d/10);
        
        s.texture(new TColor(Color.YELLOW));
        
        scene().add(c);
        scene().add(s);
        
        cam = new Camera(s.getCentre().mult(F), Point3D.O0);
        
        scene().cameraActive(cam);
        
        scene().lumieres().add(new LumierePonctuelle(Point3D.O0, Color.GREEN));
    }
    
    
    
    @Override
    public void testScene() throws Exception {
        
        double pc  = 1.0 * frame() / getMaxFrames();
        
        double TT;
        TT = t0+(t1-t0)*pc;
        
        s.setCentre(Point3D.X.mult(TT*d));
        
        cam.setCamera(s.getCentre().plus(Point3D.Z.mult(d/3)).plus(Point3D.X.mult(-t0-d/5)));
    }
    
    public static void main(String [] args)
    {
        
        
        SphereCube12 sc = new SphereCube12();
        
        sc.setMaxFrames(500);
        
        sc.loop(true);
        
        new Thread(sc).start();
        
        
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
