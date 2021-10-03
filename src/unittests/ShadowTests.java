package unittests; 
import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import primitives.Material;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
//import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class ShadowTests {

    /**
     * Produce a picture of a sphere and triangle with point light and shade
     */
    @Test
    public void SphereTriangleInitial() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Sphere(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                        //
                        60,
                        new Point3D(0, 0, 200)), //
                new Triangle(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                        //
                        new Point3D(-70, 40, 0),
                        new Point3D(-40, 70, 0),
                        new Point3D(-68, 68, 4)));

        scene.addLights(
                new SpotLight(
                          new Vector(1, -1, 3),
                          new Color(400, 240, 0), //
                        new Point3D(-100, 100, -200),
                      
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("sphereTriangleInitial", 200, 200, 400, 400);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Sphere-Triangle shading - move triangle up-right
     */
    @Test
    public void SphereTriangleMove1() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Sphere(
                		new Material(0.5, 0.5, 30), 
                        new Color(java.awt.Color.BLUE),
                       //
                        60,
                        new Point3D(0, 0, 200)), //
                new Triangle(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                         //
                        new Point3D(-60, 30, 0),
                        new Point3D(-30, 60, 0),
                        new Point3D(-58, 58, 4)));

        scene.addLights(
                new SpotLight(
                		new Vector(1, -1, 3),
                        new Color(400, 240, 0), //
                        new Point3D(-100, 100, -200),
                        
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("sphereTriangleMove1", 200, 200, 400, 400);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Sphere-Triangle shading - move triangle upper-righter
     */
    @Test
    public void SphereTriangleMove2() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Sphere(
                		new Material(0.5, 0.5, 30), //
                		new Color(java.awt.Color.BLUE),                 
                        60,
                        new Point3D(0, 0, 200)), //
                new Triangle(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                         //
                        new Point3D(-50, 20, 0),
                        new Point3D(-20, 50, 0),
                        new Point3D(-48, 48, 4)));

        scene.addLights(
                new SpotLight(
                		new Vector(1, -1, 3),
                        new Color(400, 240, 0), //
                        new Point3D(-100, 100, -200),                 
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("sphereTriangleMove2", 200, 200, 400, 400);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Sphere-Triangle shading - move spot closer
     */
    @Test
    public void SphereTriangleSpot1() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Sphere(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                         //
                        60,
                        new Point3D(0, 0, 200)), //
                new Triangle(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                         //
                        new Point3D(-70, 40, 0),
                        new Point3D(-40, 70, 0),
                        new Point3D(-68, 68, 4)));

        scene.addLights(
                new SpotLight(
                		new Vector(1, -1, 3),
                        new Color(400, 240, 0), //
                        new Point3D(-100, 100, -200),
                        
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("sphereTriangleSpot1", 200, 200, 400, 400);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Sphere-Triangle shading - move spot even more close
     */
    @Test
    public void SphereTriangleSpot2() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries(
                new Sphere(
                		new Material(0.5, 0.5, 30), //
                        new Color(java.awt.Color.BLUE),
                        
                        60,
                        new Point3D(0, 0, 200)), //
                new Triangle(
                		new Material(0.5, 0.5, 30), //
                        new Color(java.awt.Color.BLUE),
                        
                        new Point3D(-70, 40, 0),
                        new Point3D(-40, 70, 0),
                        new Point3D(-68, 68, 4)));

        scene.addLights(
                new SpotLight(
                		new Vector(1, -1, 3),
                        new Color(400, 240, 0), //
                        new Point3D(-100, 100, -200),
                        
                        1, 1E-5, 1.5E-7));

        ImageWriter imageWriter = new ImageWriter("sphereTriangleSpot2", 200, 200, 400, 400);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Produce a picture of a two triangles lighted by a spot light with a Sphere producing a shading
     */
    @Test
    public void trianglesSphere() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                new Triangle(
                		new Material(0, 0.8, 60), //
                        Color.BLACK,
                       
                        new Point3D(-150, 150, 115),
                        new Point3D(150, 150, 135),
                        new Point3D(75, -75, 150)), //
                new Triangle(
                        new Material(0, 0.8, 60),Color.BLACK,  //
                        new Point3D(-150, 150, 115),
                        new Point3D(-70, -70, 140),
                        new Point3D(75, -75, 150)), //
                new Sphere(
                		new Material(0.5, 0.5, 30),
                        new Color(java.awt.Color.BLUE),
                         // )
                        30,
                        new Point3D(0, 0, 115)));

        scene.addLights(
                new SpotLight(
                		new Vector(-1, 1, 4),
                        new Color(700, 400, 400), //
                        new Point3D(40, -40, -115),
                        
                        1, 4E-4, 2E-5));

        ImageWriter imageWriter = new ImageWriter("trianglesSphere", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}