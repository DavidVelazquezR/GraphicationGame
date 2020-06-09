/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels;

import Hygel.*;
import Aria.GLRenderAria;
import Aria.GLRenderBox;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureCoords;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pantallas.Inicio;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public class levelFour extends JFrame implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {

    public levelFour(int per) {
        typeCharacter = per;
    }

    private Animator animator;
    float view_rotx = 0.1f;
    float view_roty = 0.1f;
    float angle_rotZ = 90;

    AudioStream audio;
    InputStream sounds;

    //variable que controla la rotacion de la figura *vista perfil*
    public int rotFigure = 90;
    //variable que se encaga de realizar movimientos en las instancias de personajes
    public char controlActions = 'O';
    //variable que se encarga de escoger un perosnaje a usar en el nivel

    //textures utilizada para cargara imagenes
    private Texture texture1;
    private Texture texture2;
    private File arch1;
    private File arch2;
    private boolean newTexture = true;

    //Variables para el control de las Coordenadas de las figuras 3D
    public float coordXPersonaje = -19.5f;
    public float coordYPersonaje = -5.2f;

    //primera caja
    public float coordX1 = -13.0f;
    public float coordY1 = -4.7f;
    public boolean enableF1 = true;

    //segunda caja
    public float coordX2 = -8.0f;
    public float coordY2 = -4.7f;
    public boolean enableF2 = true;
    //tercera caja
    public float coordX3 = -6.0f;
    public float coordY3 = -2.7f;
    public boolean enableF3 = true;

    //cuarta caja
    public float coordX4 = -4.0f;
    public float coordY4 = -0.7f;
    public boolean enableF4 = true;

    //quinta caja
    public float coordX5 = -2.0f;
    public float coordY5 = 1.3f;
    public boolean enableF5 = true;

    //sexta caja
    public float coordX6 = -0.0f;
    public float coordY6 = 3.3f;
    public boolean enableF6 = true;

    public float coordX8 = 12.0f;
    public float coordY8 = -4.7f;
    public boolean enableF8 = true;

    public float coordX9 = 12.0f;
    public float coordY9 = -2.7f;
    public boolean enableF9 = true;

    public float coordX10 = 14.0f;
    public float coordY10 = -4.7f;
    public boolean enableF10 = true;

    public float coordX11 = 14.0f;
    public float coordY11 = -2.7f;
    public boolean enableF11 = true;

    public boolean up = false;
    public float flag = 0.0f;

    GLRenderAria ariaCharacter = new GLRenderAria();
    GLRenderHygel mage = new GLRenderHygel();
    public int typeCharacter = 0;
    boolean terminado = false;
    int f = 0;
    File clic = new File("src/sonidos/08.wav");
    Clip clip, clip2;
    JFrame frame;
    boolean[] flagmoneda = {true, true, true};

    public levelFour(int per, JFrame j) {
        frame = j;
        typeCharacter = per;
    }

    public void init(GLAutoDrawable drawable) {

        Thread caer = new Thread(new Runnable() {
            @Override
            public void run() {
                do {
                    if (up) {
                        controlActions = 'O';
                        coordYPersonaje = coordYPersonaje - 0.01f;
                        if (coordYPersonaje <= -5.2f) {
                            up = false;
                            flag = 0.0f;
                            System.out.println("Caida normal");
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        } else if (coordYPersonaje <= -3.3f && coordXPersonaje >= -14.0f && coordXPersonaje <= -12.0f) {
                            System.out.println("Tapa Caja 1");
                            up = false;
                            flag = 0.0f;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        } else if (coordYPersonaje <= -3.3f && coordXPersonaje >= -9.0f && coordXPersonaje <= -7.5f) {
                            System.out.println("Tapa Caja 2");
                            up = false;
                            flag = 0.0f;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        } else if (coordYPersonaje <= -1.4f && coordXPersonaje >= -7.0f && coordXPersonaje <= -5.5f) {
                            System.out.println("Tapa Caja 3");
                            up = false;
                            flag = 0.0f;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        } else if (coordYPersonaje <= 0.5f && coordXPersonaje >= -5.0f && coordXPersonaje <= -3.5f) {
                            System.out.println("Tapa Caja 4");
                            up = false;
                            flag = 0.0f;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        } else if (coordYPersonaje <= 2.4f && coordXPersonaje >= -3.0f && coordXPersonaje <= -1.5f) {
                            System.out.println("Tapa Caja 5");
                            up = false;
                            flag = 0.0f;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        } else if (coordYPersonaje <= 4.3f && coordXPersonaje >= -1.0f && coordXPersonaje <= 1.0f) {
                            System.out.println("Tapa Caja 6");
                            up = false;
                            flag = 0.0f;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);
                            coordYPersonaje = bd.floatValue();
                        }
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                    }
                } while (!terminado);

            }
        });

        caer.start();

        GL gl = drawable.getGL();

        System.err.println(
                "Init gl is: " + gl.getClass().getName());

        gl.setSwapInterval(
                1);
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

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ligth_ambient,
                0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, ligth_difuse,
                0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, ligth_specular,
                0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, ligth_position,
                0);
        gl.glEnable(GL.GL_LIGHTING);

        gl.glEnable(GL.GL_LIGHT0);

        gl.glEnable(GL.GL_DEPTH_TEST);

        gl.glShadeModel(GL.GL_SMOOTH);

        drawable.addMouseListener(
                this);
        drawable.addMouseMotionListener(
                this);
        drawable.addKeyListener(
                this);

    }

    public void display(GLAutoDrawable drawable) {
        //Se genera una instancia que dibuja al personaje

        GLRenderBox box1 = new GLRenderBox();

        Moneda mo1 = new Moneda();
        DibujaB ban = new DibujaB();

        //Hacemos uso de GL y GLU
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        //seleccionamos la matriz modelo/vista
        gl.glMatrixMode(GL.GL_MODELVIEW);

        //configuramos la matriz modelo/vista
        gl.glLoadIdentity();
        glu.gluLookAt(
                0.0f, 0.0f, 16.0f,
                0.0f, -1.5f, 0.0f,
                0.0f, 1.0f, 0.0f
        );

        //Matriz con el angulo y cordenadas (X, Y, Z)
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        //Carga las imagenes para el cubo de la CAMARA
        texturaFondo(gl);

        //Establecemos el origen
        gl.glTranslatef(0.0f, 0.0f, 0.0f);

        //Dibujamos el primer obstaculo 
        gl.glTranslatef(coordX1, coordY1, 0.0f);
        box1.drawBox(gl, 'B', enableF1);
        //Retorno al origen
        gl.glTranslatef(-coordX1, -coordY1, 0.0f);

        //Dibujamos el segundo obstaculo 
        gl.glTranslatef(coordX2, coordY2, 0.0f);
        box1.drawBox(gl, 'B', enableF2);
        //Retorno al origen
        gl.glTranslatef(-coordX2, -coordY2, 0.0f);

        //Dibujamos el tercer obstaculo 
        gl.glTranslatef(coordX3, coordY3, 0.0f);
        box1.drawBox(gl, 'B', enableF3);
        //Retorno al origen
        gl.glTranslatef(-coordX3, -coordY3, 0.0f);

        //Dibujamos el cuarto obstaculo 
        gl.glTranslatef(coordX4, coordY4, 0.0f);
        box1.drawBox(gl, 'B', enableF4);
        //Retorno al origen
        gl.glTranslatef(-coordX4, -coordY4, 0.0f);

        //Dibujamos el quinto obstaculo 
        gl.glTranslatef(coordX5, coordY5, 0.0f);
        box1.drawBox(gl, 'B', enableF5);
        //Retorno al origen
        gl.glTranslatef(-coordX5, -coordY5, 0.0f);

        //Dibujamos el sexto obstaculo 
        gl.glTranslatef(coordX6, coordY6, 0.0f);
        box1.drawBox(gl, 'B', enableF6);
        //Retorno al origen
        gl.glTranslatef(-coordX6, -coordY6, 0.0f);

        gl.glPushMatrix();/////bandera
        gl.glTranslatef(19.5f, -5.2f, -0.2f);
        gl.glScaled(2f, 2f, 2f);
        ban.dibujaB(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        if (typeCharacter == 1) {
            //Dibuja la figura 3d dependiendo de la tecla que se presione
            //Mueve la escena en la psoicion de la matriz
            gl.glTranslatef(coordXPersonaje, coordYPersonaje, 0.0f);
            gl.glRotatef(rotFigure, 0.0f, 1.0f, 0.0f);
            ariaCharacter.accionesAria(gl, controlActions);
        } else if (typeCharacter == 2) {
            gl.glTranslatef(coordXPersonaje, coordYPersonaje, 0.0f);
            gl.glRotatef(rotFigure, 0.0f, 1.0f, 0.0f);
            mage.accionesHygel(gl, controlActions, 2);
        }
        gl.glPopMatrix();

        if (terminado & f != 1) {
            try {
                //Ponemos a "Dormir" el programa durante los ms que queremos
                Thread.sleep(3 * 1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            Inicio in = new Inicio(2);
            in.setVisible(true);
            f = 1;
            frame.dispose();
        }
    }

    public boolean recoge_moneda(float xmon, float ymon, int fmo) {
        if (coordXPersonaje >= xmon - 1f && coordXPersonaje <= xmon + 1f
                && coordYPersonaje <= ymon && flagmoneda[fmo]) {
            System.out.println("entra 3");
            Sound("coin");
            flagmoneda[fmo] = false;
            return false;
        }

        return true;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        //Definimos el marco
        gl.glViewport(0, 0, width, height);
        //Seleccionamos la matrix de proyeccion
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(80.0f, h, 5.0, 20.0);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void texturaFondo(GL gl) {
        arch1 = new File("src/fondos/aLandscape4.jpg");
        arch2 = new File("src/fondos/texture_floor2.jpg");
        if (newTexture) {
            newTexture = false;

            if (texture1 != null && texture2 != null) {
                texture1.dispose();
                texture1 = null;
            }

            try {
                System.err.println("Cargando Fondo...");
                texture1 = TextureIO.newTexture(arch1, true);
                texture2 = TextureIO.newTexture(arch2, true);
                System.err.println("Tamaño estimado del fondo escenario " + texture1.getEstimatedMemorySize());
                System.err.println("Tamaño estimado del fondo piso " + texture2.getEstimatedMemorySize());

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
        if (texture1 != null) {

            gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
            TextureCoords coords1 = texture1.getImageTexCoords();
            TextureCoords coords2 = texture2.getImageTexCoords();

            //Dibujamos varios cuadrads para crear 6 caras que serian las de un cubo
            //Pared Atras
            texture1.enable();
            texture1.bind();
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords1.left(), coords1.bottom());
            gl.glVertex3f(40f, -30f, -3f);
            gl.glTexCoord2f(coords1.right(), coords1.bottom());
            gl.glVertex3f(-30f, -30f, -3f);
            gl.glTexCoord2f(coords1.right(), coords1.top());
            gl.glVertex3f(-30f, 30f, -3f);
            gl.glTexCoord2f(coords1.left(), coords1.top());
            gl.glVertex3f(40f, 30f, -3f);
            gl.glEnd();
            texture1.disable();

            //Piso
            texture2.enable();
            texture2.bind();
            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords2.left(), coords2.bottom());
            gl.glVertex3f(50f, -6f, -10f);
            gl.glTexCoord2f(coords2.right(), coords2.bottom());
            gl.glVertex3f(-30f, -6f, -10f);
            gl.glTexCoord2f(coords2.right(), coords2.top());
            gl.glVertex3f(-30f, -6f, 10f);
            gl.glTexCoord2f(coords2.left(), coords2.top());
            gl.glVertex3f(50f, -6f, 10f);
            gl.glEnd();

            texture2.disable();
        }
    }

    public void keyPressed(KeyEvent ke) {

        if (coordYPersonaje >= 6.0f) {
            this.dispose();
        }

        System.out.println("Cord X: " + coordXPersonaje + " Cord Y: " + coordYPersonaje + " -->Valor de entrada");

        switch (ke.getKeyCode()) {
            case 'A':
                controlActions = 'W';
                if (coordXPersonaje == -11.5f && coordYPersonaje >= -5.2f && coordYPersonaje <= -3.4f) {
                    System.out.println("Pared Caja 1 Dere ");
                    coordXPersonaje = -11.5f;
                } else if (coordXPersonaje == 1.5f && coordYPersonaje >= -3.3f && coordYPersonaje <= 4.2f) {
                    System.out.println("Pared Caja 6 Dere ");
                    coordXPersonaje = 1.5f;
                } else if (coordYPersonaje == -3.3f && coordXPersonaje == -14.0f) {
                    System.out.println("Caida Caja 1 Izq");
                    coordXPersonaje = -14.5f;
                    up = true;
                    Sound("fall");
                } else if (coordYPersonaje == -3.3f && coordXPersonaje == -9.0f) {
                    System.out.println("Caida Caja 2 Izq");
                    coordXPersonaje = -9.5f;
                    up = true;
                    Sound("fall");
                } else if (coordYPersonaje == -1.4f && coordXPersonaje == -7.0f) {
                    System.out.println("Caida Caja 3 Izq");
                    coordXPersonaje = -7.5f;
                    up = true;
                    Sound("fall");
                } else if (coordYPersonaje == 0.5f && coordXPersonaje == -5.0f) {
                    System.out.println("Caida Caja 4 Izq");
                    coordXPersonaje = -5.5f;
                    up = true;
                    Sound("fall");
                } else if (coordYPersonaje == 2.4f && coordXPersonaje == -3.0f) {
                    System.out.println("Caida Caja 5 Izq");
                    coordXPersonaje = -3.5f;
                    up = true;
                    Sound("fall");
                } else if (coordYPersonaje == 4.3f && coordXPersonaje == -1.0f) {
                    System.out.println("Caida Caja 6 Izq");
                    coordXPersonaje = -1.5f;
                    up = true;
                    Sound("fall");
                } else {
                    if (coordXPersonaje <= -19.5) {
                    } else {
                        //Camina normala la izquierda
                        coordXPersonaje = coordXPersonaje - 0.5f;
                        rotFigure = 270;
                    }
                }
                break;

            case 'D':
                controlActions = 'W';
                if (coordXPersonaje == -14.5f && coordYPersonaje >= -5.2f && coordYPersonaje <= -3.2f) {
                    System.out.println("Pared Caja 1 Izqu ");
                    coordXPersonaje = -14.5f;
                } else if (coordXPersonaje == -9.5f && coordYPersonaje >= -5.2f && coordYPersonaje <= -3.2f) {
                    System.out.println("Pared Caja 2 Izqu ");
                    coordXPersonaje = -9.5f;
                } else if (coordXPersonaje == -7.5f && coordYPersonaje >= -3.3f && coordYPersonaje <= -1.3f) {
                    System.out.println("Pared Caja 3 Izqu ");
                    coordXPersonaje = -7.5f;
                } else if (coordXPersonaje == -5.5f && coordYPersonaje >= -1.4f && coordYPersonaje <= -0.4f) {
                    System.out.println("Pared Caja 4 Izqu ");
                    coordXPersonaje = -5.5f;
                } else if (coordXPersonaje == -3.5f && coordYPersonaje >= 0.5f && coordYPersonaje <= 2.3f) {
                    System.out.println("Pared Caja 5 Izqu ");
                    coordXPersonaje = -3.5f;
                } else if (coordXPersonaje == -1.5f && coordYPersonaje >= 2.4f && coordYPersonaje <= 4.2f) {
                    System.out.println("Pared Caja 6 Izqu ");
                    coordXPersonaje = -1.5f;
                } else if (coordYPersonaje == -3.3f && coordXPersonaje == -12.0f) {
                    System.out.println("Caida Caja 1 Der");
                    coordXPersonaje = -11.5f;
                    up = true;
                    Sound("fall");
                } else if (coordYPersonaje == 4.3f && coordXPersonaje == 1.0f) {
                    System.out.println("Caida Caja 6 Der");
                    coordXPersonaje = 1.5f;
                    up = true;
                    Sound("fall");
                } else {
                    if (coordXPersonaje < 19.5) {
                        //Camina normala la derecha
                        coordXPersonaje = coordXPersonaje + 0.5f;
                        rotFigure = 90;
                    } else if (coordXPersonaje >= 19.5) {
                        //No permite caminar por que es el inicio de mapa
                        rotFigure = 270;
                        controlActions = 'W';
                        flag = coordYPersonaje;
                        System.out.println("FINNN");
                        if (!terminado) {
                            Sound("fin");
                        }
                        terminado = true;
                    }
                }
                break;

            case 'W':
                flag = coordYPersonaje;
                Thread t = new Thread() {
                    public void run() {
                        if (coordYPersonaje == -5.2f || coordYPersonaje == -3.3f || coordYPersonaje == -1.4f || coordYPersonaje == 0.5f || coordYPersonaje == 2.4f || coordYPersonaje == 4.3f) {
                            for (float i = 0.0f; i < 300.0f; i++) {
                                if (i == 0) {
                                    Sound("sj");
                                }

                                try {
                                    Thread.sleep(1);
                                    controlActions = 'J';
                                    coordYPersonaje = coordYPersonaje + 0.01f;
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(levelThree.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                            up = true;
                            BigDecimal bd = new BigDecimal(coordYPersonaje);
                            bd = bd.setScale(1, RoundingMode.HALF_UP);
                            System.out.println(bd);

                            coordYPersonaje = bd.floatValue();
                            System.out.println("saltoo");
                        }
                    }
                };
                t.start();
                break;
        }

        System.out.println("Cord X: " + coordXPersonaje + " Cord Y: " + coordYPersonaje + " -->Valor de salida");
    }

    public void keyReleased(KeyEvent ke) {
        if (controlActions != 'D' || controlActions != 'A' || controlActions != 'W') {
            //se hace if para especificar que perosnaje se usa y asi estblecer variables dependiendo de que perosnaje se eligio

            controlActions = 'O';

        }
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {

    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
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

    public void Sound(String a) {
        if (clip2 != null) {
            clip2.stop();
        }
        reproducir_corto(a);
    }

    public void reproducir_corto(String ef) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("src/sonidos/" + ef + ".wav")));
            clip.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }

}
