/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flogat;

import com.sun.opengl.util.Animator;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

/**
 *
 * @author Elizabeth
 */
public class CorreF extends JFrame implements GLEventListener,
        KeyListener, MouseListener, MouseMotionListener
{

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[256]; //to know which key is pressed

    //position of stan in the window
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;

    public static void main(String[] args)
    {

        Frame frame = new Frame("South Park : Stan (Press J to jump and press W to walk)");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new CorreF());
        frame.add(canvas);
        frame.setSize(600, 600);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable()
                {
                    public void run()
                    {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();

    }

    public void init(GLAutoDrawable drawable)
    {

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);
        // set up lighting
        float light_ambient[] =
        {
            0.9f, 0.9f, 0.9f, 1.0f
        };
        float light_diffuse[] =
        {
            0.3f, 0.3f, 0.3f, 1.0f
        };
        float light_specular[] =
        {
            1.0f, 1.0f, 1.0f, 1.0f
        };
        float light_position[] =
        {
            1.0f, 1.5f, 1.0f, 0.0f
        };
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        // Setup the drawing area and shading mode
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
        gl.glShadeModel(GL.GL_SMOOTH);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0)
        { // avoid a divide by zero error!
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();

    }

    public void display(GLAutoDrawable drawable)
    {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        glu.gluLookAt(0.1f, 0.0f, 4.0f,// eye
                0.0f, 0.0f, 0.0f, // looking at
                0.0f, 0.0f, 1.0f // is up
        );
        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);
        //we draw Stan in the window
        Flog stan = new Flog();
        stan.dibujaFlog(gl, keys['W'], keys['J'], keys['D'], keys['Q'], keys['E'],
                keys['R'], keys['T'], keys['L'], keys['X'], keys['Y'],
                keys['Z'], keys['O'], keys['C'], keys['V'], keys['M'], keys['F'], keys['N']);
//        stan.pintaNivel(gl, keys['V'],keys['M'], keys['F'], keys['N']);

//                keys['T'], keys['A'], keym,s['X'], keys['Y'], keys['Z'], keys['O'], keys['P']);
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
        oldMouseX = e.getX();
        oldMouseY = e.getY();
    }

    public void mouseDragged(MouseEvent e)
    {

        int x = e.getX();
        int y = e.getY();
        Dimension size = e.getComponent().getSize();
        float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
    }

    public void keyPressed(KeyEvent ke)
    {
        if (ke.getKeyCode() < 250 && keys[ke.getKeyCode()] == false)
        {
            keys['O'] = false;
            keys['W'] = false;
            keys['Q'] = false;
            keys['E'] = false;
            keys['R'] = false;
            keys['J'] = false;
            keys['T'] = false;
            keys['A'] = false;
            keys['X'] = false;
            keys['Y'] = false;
            keys['Z'] = false;
            keys['P'] = false;

//            keys['W'] = false;//caminar
//            keys['J'] = false;//saltar
//            keys['D'] = false;//saltar con manos abajo
//            keys['Q'] = false;//caminar a la izquierda
//            keys['E'] = false;//caminar a la derecha
//            keys['R'] = false;//rotar
//            keys['T'] = false;//traslacion
//            keys['L'] = false;//escalacion
//            keys['X'] = false;//reflexionx
//            keys['Y'] = false;//reflexion y
//            keys['Z'] = false;//reflexion z
//            keys['O'] = false;//original
//            keys['C'] = false;//colicion
//            keys['V'] = false;//nivel1 verde
//            keys['M'] = false;//nivel 2 morado
//            keys['F'] = false;//nivel 3cafe
//            keys['N'] = false;

            keys[ke.getKeyCode()] = true;
            System.out.println("Key press " + ke.getKeyChar());
            switch (ke.getKeyCode())
            {
                case 'J':
//
////                    reproducir(j2);
////                    break;
////                case 'W':
////                case 'Q':
////                case 'E':
////                    clip.close();
////                    Sonido(clic);
////                    reproducir(walk);
////                    break;
////                case 'D':
////                    clip.close();
////                    reproducir(d);
////                    break;
////                case 'R':
////                    clip.close();
////                    Sonido(clic);
////                    reproducir(ret);
                    break;
                default:
                    break;
            }
        } else
        {
            keys[ke.getKeyCode()] = false;

        }
    }
}
