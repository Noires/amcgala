package org.amcgala.framework.renderer;

import org.amcgala.Framework;
import org.amcgala.framework.camera.Camera;
import org.amcgala.framework.math.Matrix;
import org.amcgala.framework.math.Vector3d;
import org.amcgala.framework.math.Vertex3f;
import org.amcgala.framework.shape.primitives.LinePrimitive;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import javax.swing.*;
import java.awt.*;

import static org.lwjgl.opengl.GL11.*;


/**
 * Renderer, der die grafische Ausgabe über OpenGL beschleunigt.
 */
public class GLRenderer implements Renderer {
    private Camera camera;
    private Matrix transformationMatrix;
    private Color currentColor;
    private Framework framework;

    public GLRenderer(int width, int height, Framework framework) {
        this.framework = framework;
        try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setTitle("amCGAla Framework GL");
            Display.setInitialBackground(1f, 1f, 1f);
            Display.create();
            glMatrixMode(GL_PROJECTION);
            glLoadIdentity();
            glOrtho(0, width, height, 0, 1, -1);
            glMatrixMode(GL_MODELVIEW);
        } catch (LWJGLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public int getWidth() {
        return Display.getWidth();
    }

    @Override
    public int getHeight() {
        return Display.getHeight();
    }

    @Override
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void setTransformationMatrix(Matrix transformationMatrix) {
        this.transformationMatrix = transformationMatrix;
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public Matrix getTransformationMatrix() {
        return transformationMatrix;
    }

    @Override
    public void drawPixel(Pixel pixel) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void drawPixel(Pixel pixel, Color color) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Pixel getPixel(Vector3d vector) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setColor(Color color) {
        float[] colorComp = color.getColorComponents(null);
        glColor3f(colorComp[0], colorComp[1], colorComp[2]);
        currentColor = color;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        glBegin(GL_LINE_STRIP);
        glVertex2f(x1, y1);
        glVertex2f(x2, y2);
        glEnd();
    }

    @Override
    public void drawCircle(double x, double y, double radius) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void show() {
        DisplayList list = framework.getCurrentState();
        glBegin(GL_LINE_STRIP);
        for (LinePrimitive line : list.lines) {
            for (Vertex3f v : line.vertices) {
                glVertex3f(v.x, v.y, v.z);
            }
        }
        glEnd();
        Display.update();
    }

    @Override
    public void drawLine(Vector3d start, Vector3d end) {
        Pixel s = camera.getImageSpaceCoordinates(start);
        Pixel e = camera.getImageSpaceCoordinates(end);
        glBegin(GL_LINE_STRIP);
        glVertex2f(s.getX(), s.getY());
        glVertex2f(e.getX(), s.getY());
        glEnd();
    }

    @Override
    public void drawCircle(Vector3d pos, double radius) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void drawPixel(Vector3d point, Color color) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFrame(JFrame frame) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void fillRect(Pixel pos, int width, int height, Color color) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Color getColor() {
        return currentColor;
    }
}
