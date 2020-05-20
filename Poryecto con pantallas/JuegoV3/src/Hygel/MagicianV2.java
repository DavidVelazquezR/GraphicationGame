package Hygel;

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
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class MagicianV2 extends JFrame implements GLEventListener,
        KeyListener, MouseListener, MouseMotionListener {

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[250];
    Clip clip=null;
    private int in = 0;
    static DrawMagician mage = new DrawMagician();
    static Moneda moneda = new Moneda();
    GL gl;
    public static char tec = ' ';
    public static boolean fw = true;

static Thread caer = new Thread(new Runnable() {
        @Override
        public void run() {
            do {
                    if (mage.up) {
                        mage.setZ_POSITION(mage.getZ_POSITION() - .002f);
                        if (mage.getZ_POSITION()<=0) {
                            tec = ' ';
                        }
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                    }   
            } while (true);
        }
    });

    public static void main(String[] args) {
        Frame frame = new Frame("Magician");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new MagicianV2());
        frame.add(canvas);
        frame.setSize(600, 600);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
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

    public void init(GLAutoDrawable drawable) {
        //caer.start();
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);
        float light_ambient[] = {0.9f, 0.9f, 0.9f, 1.0f};
        float light_diffuse[] = {0.3f, 0.3f, 0.3f, 1.0f};
        float light_specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {1.0f, 1.5f, 1.0f, 0.0f};
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

        gl.glShadeModel(GL.GL_SMOOTH);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);

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

    public void display(GLAutoDrawable drawable) {

        gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        gl.glLoadIdentity();
        glu.gluLookAt(0.1f, 0.0f, 4.0f,// eye
                0.0f, 0.0f, 0.0f, // looking at
                0.0f, 0.0f, 1.0f // is up
        );

        //gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);//g,x,y,-inv
        //gl.glRotatef(60, 0.0f,1.0f, 0.0f);
        //gl.glRotatef(view_rotx, 0.0f, 1.0f, 0.0f);
        //gl.glRotatef(view_roty, -1.0f, 0.0f, 0.0f);
//        if (in==0) {
//            mage.rot = 60;
//            in=1;
//        }
        mage.draw_mage(gl, tec);
        //moneda.draw_moneda(gl);
        gl.glFlush();
        
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()!=87){
            tec = ' ';
        }
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("key press " + e.getKeyChar());
        switch (e.getKeyCode()) {
            case 'D':
                mage.rot = 60;
                mage.setY_POSITION((float) (mage.getY_POSITION() + 0.04));
                tec = 'D';
                break;
            case 'A':
                mage.rot = -60;
                mage.setY_POSITION((float) (mage.getY_POSITION() - 0.04));
                tec = 'A';
                break;
            case 'W':
                tec = 'W';
                reproducir("sj");
                if (!mage.up) {
                    Thread hilo = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < 150; i++) {
                                try {
                                    mage.setZ_POSITION(mage.getZ_POSITION() + .01f);
                                    Thread.sleep(1);
                                } catch (InterruptedException ex) {
                                }
                            }
                        }
                    });
                    hilo.start();
                }
                break;
            case 'C':
                tec = 'C';
                break;
            case 'F':
                tec = 'F';
                break;
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        oldMouseX = e.getX();
        oldMouseY = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
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
    public void reproducir(String ef) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("src/sonidos/"+ef+".wav")));
            clip.start();
            if (!ef.equals("sc") && !ef.equals("s4")) {
                //clip.loop(1000);
                clip.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }
}
