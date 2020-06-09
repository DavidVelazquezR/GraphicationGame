/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myDraw;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureCoords;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public class MainAria extends JFrame implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {

    private Animator animator;
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private float angle_rotZ = 90;

    private int oldMouseX;
    private int oldMouseY;
    public static ImageIcon imagen = new ImageIcon("src/fondos/sample.jpg");
    public static ImageIcon pastoImg = new ImageIcon("src/fondos/sample.jpg");

    AudioStream audio;
    static InputStream sounds;
    GLRenderAria Aria = new GLRenderAria();
    public static char tecla = 'O';

    private Texture texture;
    private boolean newTexture = true;
    String f = "aLandscape1";
    private File arch;
    int s = 0;
    int tipoEscenario = 0;
    GLRenderAria kirby = new GLRenderAria();

    static String s1 = "src/sonidos/01.wav";
    static String s2 = "src/sonidos/02.wav";
    static String s3 = "src/sonidos/03.wav";
    static String s4 = "src/sonidos/04.wav";
    static String s5 = "src/sonidos/05.wav";
    static String s6 = "src/sonidos/06.wav";
    static String s7 = "src/sonidos/07.wav";
    File clic = new File("src/sonidos/08.wav");
    Clip clip;

    static JLabel etiqueta = new JLabel();
    boolean[] keys = new boolean[256]; //saber que tecla se presiona

    private static final float X_POSITION = 0.5f;
    private static final float Y_POSITION = 0.0f;
    private static final float Z_POSITION = -1.0f;

    public static void main(String[] args) throws IOException {
        final Frame frame = new Frame("Aria");
        GLCanvas canvas = new GLCanvas();

        //Agregamos un menubar para las instrucciones
        MenuBar mb = new MenuBar();

        frame.setMenuBar(mb);

        Menu firstMenu = new Menu("Instrucciones");
        Menu secondMenu = new Menu("Instrucciones rapidas");
        Menu thirdMenu = new Menu("Salir");

        mb.add(firstMenu);
        mb.add(secondMenu);
        mb.add(thirdMenu);

        MenuItem firstItem = new MenuItem("Abreme");
        MenuItem op1 = new MenuItem("W: Caminar");
        MenuItem op4 = new MenuItem("R: Rotar como spinner");
        MenuItem op5 = new MenuItem("M: Agacharse o reverencia ;D");
        MenuItem op6 = new MenuItem("J: Saltar");
        MenuItem op7 = new MenuItem("C: Colision");
        MenuItem op8 = new MenuItem("O: Original");
        MenuItem op9 = new MenuItem("1: Rotacion en X");
        MenuItem op10 = new MenuItem("2: Rotacion en Y");
        MenuItem op11 = new MenuItem("3: Rotacion en Z");
        MenuItem op12 = new MenuItem("4: Reflexion en X");
        MenuItem op13 = new MenuItem("5: Reflexion en Y");
        MenuItem op14 = new MenuItem("6: Reflexion en Z");
        MenuItem op15 = new MenuItem("T: Mover arriba");
        MenuItem op16 = new MenuItem("G: Mover abajo");
        MenuItem op17 = new MenuItem("F: Mover Izquierda");
        MenuItem op18 = new MenuItem("H: Mover Derecha");
        MenuItem op19 = new MenuItem("7: Traslacion");
        MenuItem op20 = new MenuItem("8: Escalacion");
        MenuItem thirdItem = new MenuItem("Adios...");


        thirdMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        firstMenu.add(firstItem);
        secondMenu.add(op1);
        secondMenu.add(op4);
        secondMenu.add(op5);
        secondMenu.add(op6);
        secondMenu.add(op7);
        secondMenu.add(op8);
        secondMenu.add(op9);
        secondMenu.add(op10);
        secondMenu.add(op11);
        secondMenu.add(op12);
        secondMenu.add(op13);
        secondMenu.add(op14);
        secondMenu.add(op15);
        secondMenu.add(op16);
        secondMenu.add(op17);
        secondMenu.add(op18);
        secondMenu.add(op19);
        secondMenu.add(op20);
        thirdMenu.add(thirdItem);
        //--------------------------------------------------------------------

        canvas.addGLEventListener(new MainAria()); //con la clase en la que este el personaje
        frame.add(canvas);
        frame.setSize(800, 600);
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

        gl.glShadeModel(GL.GL_SMOOTH);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
    }

    public void display(GLAutoDrawable drawable) {
        //Hacemos uso de GL y GLU
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);

        gl.glLoadIdentity();
        glu.gluLookAt(
                0.1f, 0.0f, 4.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f
        );

        //Se genera una instancia que dibuja al personaje
        GLRenderAria ariaCharacter = new GLRenderAria();

        //Mueve la escena en la psoicion de la matriz
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);

        //Matriz con el angulo y cordenadas (X, Y, Z)
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(angle_rotZ, 0.0f, 0.0f, 1.0f);

        //Carga las imagenes para el cubo de la CAMARA
        texturaFondo(gl);

        //Dibuja la figura 3d dependiendo de la tecla que se presione
        ariaCharacter.accionesAria(gl, tecla);

        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) {
            height = 1;
        }

        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void texturaFondo(GL gl) {
        arch = new File("src/fondos/" + f + ".jpg");
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

            //Dibujamos varios cuadrads para crear 6 caras que serian las de un cubo
            //Pared Atras
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

            //Pared Frente
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

            //Techo
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

            //Pared Izquierda
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

            //Pared Derecha
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

    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() < 250 && keys[ke.getKeyCode()] == false) {
            try {
                clip.close();
            } catch (NullPointerException ex) {

            }
            keys['W'] = false;
            keys['J'] = false;
            keys['D'] = false;
            keys['Q'] = false;
            keys['E'] = false;
            keys['R'] = false;
            keys['S'] = false;
            keys['F'] = false;
            keys['G'] = false;
            keys['T'] = false;
            keys['H'] = false;
            keys['P'] = false;
            keys['O'] = false;

            keys[ke.getKeyCode()] = true;

            System.out.println("Se presiono --> " + ke.getKeyChar());
            switch (ke.getKeyCode()) {
                case 'O': //Original
                    tecla = 'O';
                    detAudio();
                    Aria.colision = 2;
                    f = "aLandscape1";
                    newTexture = true;
                    break;
                case 'W'://Caminar
                    tecla = 'W';
                    detAudio();
                    reproducir(s2);
                    Aria.colision = 2;
                    f = "aLandscape1";
                    newTexture = true;
                    break;
                case 'J'://Salto
                    tecla = 'J';
                    detAudio();
                    reproducir(s3);
                    Aria.colision = 2;
                    f = "aLandscape2";
                    newTexture = true;
                    break;
                case 'M'://Inclinarse
                    tecla = 'M';
                    detAudio();
                    reproducir(s4);
                    Aria.colision = 2;
                    f = "aLandscape3";
                    newTexture = true;
                    break;
                case 'R'://Modo spinner
                    tecla = 'R';
                    detAudio();
                    reproducir(s5);
                    Aria.colision = 2;
                    f = "aLandscape4";
                    newTexture = true;
                    break;
                case 'C'://Colision
                    tecla = 'C';
                    detAudio();
                    reproducir(s6);
                    Aria.colision = 2;
                    f = "aLandscape5";
                    newTexture = true;
                    break;
                case 'H':
                    view_rotx = view_rotx + 3.0f;
                    break;
                case 'G':
                    view_roty = view_roty + 3.0f;
                    break;
                case 'F':
                    view_rotx = view_rotx - 3.0f;
                    break;
                case 'T':
                    view_roty = view_roty - 3.0f;
                    break;
                case '1':
                    tecla = '1';
                    break;
                case '2':
                    tecla = '2';
                    break;
                case '3':
                    tecla = '3';
                    break;
                case '4':
                    tecla = '4';
                    break;
                case '5':
                    tecla = '5';
                    break;
                case '6':
                    tecla = '6';
                    break;
                case '7':
                    tecla = '7';
                    break;
                case '8':
                    tecla = '8';
                    break;
                default:
                    detAudio();
                    break;
            }
        } else {
            keys[ke.getKeyCode()] = false;

        }

    }

    public void keyReleased(KeyEvent ke) {
    }

    public void mouseClicked(MouseEvent me) {
        Sonido(clic);
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

    public void Sonido(File sonido) {
        try {
            sounds = new FileInputStream(sonido);
            audio = new AudioStream(sounds);
            AudioPlayer.player.start(audio);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }

    }

    public void reproducir(String efecto) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(efecto)));
            clip.start();
            clip.loop(1000);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void detAudio() {
        if (audio != null) {
            AudioPlayer.player.stop(audio);
        }
    }

}
