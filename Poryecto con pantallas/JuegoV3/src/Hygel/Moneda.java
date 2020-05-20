package Hygel;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import javax.media.opengl.glu.GLUquadric;

public class Moneda {
    
    public static  float X_POSITION = 0f;
    public static  float Y_POSITION = 0f;
    public static  float Z_POSITION = -0f;
    
    public static boolean up = false;
    
    
    private static final int SLICES = 30;
    private static final int STACKS = 30;
    private GLUquadric q = null;
    
    private static int rot=0;

    public Moneda() {
    }

    public void draw_moneda(GL gl) {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        
        gl.glTranslatef(getX_POSITION(), getY_POSITION(),getZ_POSITION());
        gl.glRotatef(rot, 0f, 0f, 1f);
        gl.glTranslatef(getX_POSITION(), getY_POSITION(),getZ_POSITION());
        draw(gl, glu);
        
        rot+=6;
    }


    public void draw(GL gl, GLU glu) {
        set_gold(gl);
        gl.glPushMatrix();
        //gl.glTranslatef(-0.31f, -0.125f, 0f);//(y,z,x)
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        
        glu.gluCylinder(q, 1, 1, 0.5, SLICES, STACKS);//brazo
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        glu.gluDisk(q, 0f, 1, SLICES, STACKS);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        gl.glTranslated(0, 0, 0.5);
        glu.gluDisk(q, 0f, 1, SLICES, STACKS);
        gl.glPopMatrix();
    }
    
    public void set_gold(GL gl) {///color cuerpo
        float mat_ambient[] = {0.8f, 0.643f, 0.204f, 1.0f};
        float mat_diffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float mat_specular[] = {0.4f, 0.3f, 0.2f, 1.0f};
        float shine = 168f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    

    
    
    public static float getX_POSITION() {
        return X_POSITION;
    }
    public static void setX_POSITION(float X_POSITION) {
        Moneda.X_POSITION = X_POSITION;
    }
    public static float getY_POSITION() {
        return Y_POSITION;
    }

    public static void setY_POSITION(float Y_POSITION) {
        Moneda.Y_POSITION = Y_POSITION;
    }

    public static float getZ_POSITION() {
        return Z_POSITION;
    }

    public static void setZ_POSITION(float Z_POSITION) {
        Moneda.Z_POSITION = Z_POSITION;
    }
    
}
