/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Terluks;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureCoords;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioStream;

/**
 *
 * @author Alan
 */
public class ACC extends JFrame implements GLEventListener,
        KeyListener, MouseListener, MouseMotionListener {

    int s = 0;
    float v = (float) 4.0;
    float l = (float) 0.0;
    private static int ban = 0;
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    private static String f = "cueva";
    private static int mvt = 0;
    AudioStream audio;
    InputStream sonidos;
    Texture t;
    boolean[] keys = new boolean[256];
    private File arch;
    private Texture texture;
    private boolean newTexture = true;
    Dibujo_cangrejo JF = new Dibujo_cangrejo();

    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = -0.08f;
    private static final float Z_POSITION = 0f;
    private Animator ani;

    public ACC() {
    }

    public void setVisible(boolean show) {
        if (!show) {
            ani.stop();
        }
        super.setVisible(show);
        if (!show) {
            ani.start();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Frame frame = new Frame("JEFE");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new ACC());
        frame.add(canvas);
        frame.setSize(600, 600);

        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GLCanvas canvas;
    // End of variables declaration//GEN-END:variables

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("Init gl is: " + gl.getClass().getName());

        gl.setSwapInterval(1);
        //añadir luz
        float ligth_ambient[]
                = {
                    0.9f, 0.9f, 0.9f, 1.0f
                };
        float ligth_difuse[]
                = {
                    0.3f, 0.3f, 0.3f, 1.0f

                };
        float ligth_specular[]
                = {
                    1.0f, 1.0f, 1.0f, 1.0f

                };
        float ligth_position[]
                = {
                    1.0f, 1.5f, 1.0f, 0.0f

                };

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ligth_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, ligth_difuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, ligth_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, ligth_position, 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        /*
        try
        {
            File im = new File("src/Imagen/fondo.jpg");
            t = TextureIO.newTexture(im, true);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
         */
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);

        gl.glShadeModel(GL.GL_SMOOTH);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        glu.gluLookAt(0.1f, l, v,// eye
                l, 0.0f, 0.0f, // looking at
                0.0f, 0.0f, 1.0f // is up
        );

        
        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);

        //we draw Stan in the window
        JF.DIBU_jf(gl, keys['W'],
                keys['J'],
                keys['P']
        );

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!
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

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() < 250 && keys[ke.getKeyCode()] == false) {
            //agregade otras funciones si se requiren 
            keys['O'] = false;//Figura original*
            keys['W'] = false;//Camina*
            keys['J'] = false;//Salta*
            keys['C'] = false;//Agacha
            keys['S'] = false;//Activa sonido
            keys['R'] = false;//Rotacion X
            keys['F'] = false;//Rotacion Y
            keys['G'] = false;//Rotacion Z
            keys['T'] = false;//Traslacion
            keys['E'] = false;//Escalacion
            keys['X'] = false;//Reflexion X
            keys['Y'] = false;//Reflexion Z
            keys['Z'] = false;//Reflexion Y
            keys['V'] = false;//Abre boca
            keys['B'] = false;//camara atras
            keys['D'] = false;//camara frente
            keys['N'] = false;//camara arriba
            keys['M'] = false;//camara abajo
            keys['P'] = false;//colision
            keys[ke.getKeyCode()] = true;

            System.out.println("Presioanste la tecla " + ke.getKeyChar());
            switch (ke.getKeyCode()) {
                //original 
                case 'O':
                    JF.co = 2;
                    f = "cueva2";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'J':
                    JF.co = 2;
                    //reproducirAudio("src/Sonido/salto.wav");
                    f = "salto";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'W':
                    JF.co = 2;
                    //reproducirAudio("src/Sonido/pasos.wav");
                    f = "ciudad";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;

                case 'R':
                    JF.co = 2;
                    f = "espacio";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'F':
                    JF.co = 2;
                    f = "3000";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'G':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s5.wav");
                    f = "enfrentamiento";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'T':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s6.wav");
                    f = "cosmos";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'E':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s7.wav");
                    f = "biblioteca";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'X':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s8.wav");
                    f = "bosque";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'Y':
                    JF.co = 2;
                    f = "playa";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'Z':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s10.wav");
                    f = "sala";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'C':
                    JF.co = 2;
                    //reproducirAudio("src/Sonido/Skullgirls OST 01 - Echoes.wav");
                    f = "paisaje";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'V':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s13.wav");
                    f = "stanlee";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'B':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s14.wav");
                    f = "tortuga";
                    v = (float) -4.0;
                    l = (float) 0.5;
                    newTexture = true;
                    break;
                case 'D':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s15.wav");
                    f = "spider";
                    newTexture = true;
                    v = (float) 2.0;
                    l = (float) -0.2;
                    break;
                case 'N':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s14.wav");
                    f = "tortuga";
                    v = (float) 1.0;
                    l = (float) 1.5;
                    newTexture = true;
                    break;
                case 'M':
                    JF.co = 2;
                    //repAudio("src/Imagenes/s15.wav");
                    f = "ass";
                    newTexture = true;
                    v = (float) 2.0;
                    l = (float) -1.5;
                    break;
                case 'P':
                    JF.co = 2;
                    //reproducirAudio("src/Sonido/golpe.wav");
                    f = "cueva2";
                    v = (float) 4.0;
                    l = (float) 0.0;
                    newTexture = true;
                    break;
                case 'S':
                    if (s == 1) {
                        //detenerAudio();
                        s = 0;
                    } else {
                        //reproducirAudio("src/Sonido/Skullgirls OST 22 - Skull Heart Arrhythmia.wav");
                        s = 1;
                    }
                    break;
                default:
                    break;
            }
        } else {
            keys[ke.getKeyCode()] = false;
        }
        System.out.println("key press " + ke.getKeyChar());
    }

    public void keyReleased(KeyEvent ke) {
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        oldMouseX = me.getX();
        oldMouseY = me.getY();
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        Dimension size = me.getComponent().getSize();
        float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
    }

    public void mouseMoved(MouseEvent me) {
    }

    public void texturaFondo(GL gl) {
        arch = new File("src/Imagen/" + f + ".jpg");
        if (newTexture) {
            newTexture = false;

            if (texture != null) {
                texture.dispose();
                texture = null;
            }

            try {
                System.err.println("Cargando Fondo...");
                texture = TextureIO.newTexture(arch, true);
                System.err.println("Tamaño estimado del fondo " + texture.getEstimatedMemorySize());
            } catch (IOException e) {
                e.printStackTrace();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                e.printStackTrace(new PrintStream(bos));
                JOptionPane.showMessageDialog(null,
                        bos.toString(),
                        "Error loading texture",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (texture != null) {
            texture.enable();
            texture.bind();
            gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
            TextureCoords coords = texture.getImageTexCoords();

            //Atras
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(6f, -6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(-6f, -6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(-6f, 6f, -6f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(6f, 6f, -6f);
            gl.glEnd();

            //Frente
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(6f, -6f, 6f);
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(-6f, -6f, 6f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(-6f, 6f, 6f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(6f, 6f, 6f);
            gl.glEnd();

            //Piso
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(6f, -6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(-6f, -6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(-6f, -6f, 6f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(6f, -6f, 6f);
            gl.glEnd();

            //techo
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(6f, 6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(-6f, 6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(-6f, 6f, 6f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(6f, 6f, 6f);
            gl.glEnd();

            //paredIzqu
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(6f, -6f, 6f);
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(6f, -6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(6f, 6f, -6f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(6f, 6f, 6f);
            gl.glEnd();

            //paredDerecha
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(-6f, -6f, -6f);
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(-6f, -6f, 6f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(-6f, 6f, 6f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(-6f, 6f, -6f);
            gl.glEnd();

            texture.disable();
        }
    }
}
