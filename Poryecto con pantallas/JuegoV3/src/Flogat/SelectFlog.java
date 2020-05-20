package Flogat;

import Hygel.*;
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

public class SelectFlog extends JFrame implements GLEventListener{

    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    static Flog Flog = new Flog();
    GL gl;

    private static String f = "j5";
    private File arch;
    private Texture texture;
    private boolean newTexture = true;


    public void init(GLAutoDrawable drawable) {
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
        gl.glTranslatef(0.0f, 0.0f, 1.0f);//z,y,x
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);//g,x,y,-inv
        
        texturaFondo(gl);
        gl.glRotatef(view_rotx, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(view_roty, -1.0f, 0.0f, 0.0f);
        
        Flog.dibujaFlog(gl, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
        gl.glFlush();

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
            gl.glVertex3f(-4.2f, 2.5f, -1f);
            gl.glTexCoord2f(coords.left(), coords.top());
            gl.glVertex3f(4.3f, 2.5f, -1f);
            gl.glEnd();
            texture.disable();
        }
    }

        
}
