package Terluks;



import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureCoords;
import com.sun.opengl.util.texture.TextureIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SelectJF extends JFrame implements GLEventListener {

    private Animator animator;
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private float angle_rotZ = 90;

    private int oldMouseX;
    private int oldMouseY;

    private static String f = "j5";
    private File arch;
    private Texture texture;
    private boolean newTexture = true;

    boolean[] keys = new boolean[256]; //saber que tecla se presiona

    private static final float X_POSITION = 0.5f;
    private static final float Y_POSITION = 0.0f;
    private static final float Z_POSITION = -1.0f;

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

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
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
        DrawJF jf = new DrawJF();

        //Mueve la escena en la psoicion de la matriz
        gl.glTranslatef(X_POSITION + 1.2f, Y_POSITION, Z_POSITION + 1.5f);

        //Matriz con el angulo y cordenadas (X, Y, Z)
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(angle_rotZ, 0.0f, 0.0f, 1.0f);

        texturaFondo(gl);
        gl.glRotatef(view_rotx, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(view_roty, -1.0f, 0.0f, 0.0f);
        //Dibuja la figura 3d dependiendo de la tecla que se presione
        gl.glPopMatrix();
        
        
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(0, 0, 0.5f);
        jf.DIBU_jf(gl,'W');

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

    public void texturaFondo(GL gl) {
        arch = new File("src/img/" + f + ".jpg");
        if (newTexture) {
            newTexture = false;

            if (texture != null) {
                texture.dispose();
                texture = null;
            }

            try {
                System.err.println("Loading texture...");
                texture = TextureIO.newTexture(arch, true);
                System.err.println("Texture estimated memory size = " + texture.getEstimatedMemorySize());
            } catch (IOException e) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                e.printStackTrace(new PrintStream(bos));
                JOptionPane.showMessageDialog(null, bos.toString(), "Error loading texture", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (texture != null) {
            texture.enable();
            texture.bind();
            gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
            TextureCoords coords = texture.getImageTexCoords();

            gl.glBegin(GL.GL_QUADS);
            gl.glTexCoord2f(coords.left(), coords.bottom());
            gl.glVertex3f(4.2f, -2.5f, -1f);//(x,y,z)
            gl.glTexCoord2f(coords.right(), coords.bottom());
            gl.glVertex3f(-4.2f, -2.5f, -1f);
            gl.glTexCoord2f(coords.right(), coords.top());
            gl.glVertex3f(-4.2f, 4.0f, -1f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(4.3f, 4.0f, -1f);
            gl.glEnd();
            texture.disable();
        }
    }
}
