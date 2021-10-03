package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

public class miniPro1
{

	@Test
	public void MiniProject1test()
	{
		
		Scene scene = new Scene("Test scene");
        scene.set_camera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.set_distance(1000);
        scene.set_background(Color.BLACK);
        scene.set_ambientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));
      
        
        scene.addGeometries(
                new Plane( new Material(0.5, 0.5, 0),new Color(java.awt.Color.BLACK), new Point3D(0, 20, 0), new Point3D(4, 20, 0),new Point3D(4,20, 2)),
     /*   new Sphere(
				new Material(0.2, 0.2, 30, 0.6, 0.5),
				new Color(java.awt.Color.BLUE), 
				30,
				new Point3D(60, -50, 50)),*/
	    new Sphere(
        		new Material(0.5, 0.5, 30,0.6,0.5), 
                new Color(java.awt.Color.BLACK),            
                20,
                new Point3D(0, -50,-50)), 
      /* new Sphere(
        		new Material(0.5, 0.5, 30,0.6,0.5),
                new Color(java.awt.Color.green),
                30,
                new Point3D(80, -10,150)),*/
        new Sphere(
        		new Material(0.25, 0.25, 20, 0.5,0.5),
        		new Color(java.awt.Color.RED),
        		50,
        		new Point3D(-50, -50, 50)),
        new Sphere(
        		new Material(0.25, 0.1, 20,0.45,0.5), 
                new Color(java.awt.Color.BLACK),            
                20,
                new Point3D(-70, 10, 80)), 
		new Sphere(
				new Material(0.25, 0.1, 20,0.65,0.5),
				new Color(java.awt.Color.BLUE),
				33,
				new Point3D(-65,60, 60)));
      
          
        
          
          scene.addLights(new SpotLight(new Color(700, 400, 400), //
  				new Vector(0, 0, -1), new Point3D(0,-150,500), 1, 4E-5, 2E-7,10));
        
           
        
        ImageWriter imageWriter = new ImageWriter("miniPro1", 200, 200, 500, 500);
        Render render = new Render(imageWriter, scene).setMultithreading(3).setDebugPrint();

        render.renderImage();
        render.writeToImage();
	}
}