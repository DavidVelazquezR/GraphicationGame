package Hygel;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import javax.media.opengl.glu.GLUquadric;

public class Llave {
    private GLUquadric q = null;
    private static int rot=0;

    public Llave() {
    }
    public void draw_moneda(GL gl) {
        GLU glu = new GLU();
        GLUT glut = new GLUT();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        
        //gl.glTranslatef(getX_POSITION(), getY_POSITION(),getZ_POSITION());
        gl.glRotatef(rot, 0f, 1f, 0f);
        draw(gl, glut,glu);
        
        //rot+=4;
    }


    public void draw(GL gl, GLUT glut, GLU glu) {
        set_platinum(gl);
        
        gl.glPushMatrix();
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        glut.glutSolidTorus(0.1f, 0.3f, 20, 40);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0.30);
        glu.gluCylinder(q, 0.1, 0.1, 0.9, 20, 40);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 1.20);
        glu.gluDisk(q, 0f, 0.1, 20, 40);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.13f, 1.125f);
        glut.glutSolidCube(0.15f);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.13f, 0.8f);
        glut.glutSolidCube(0.15f);
        gl.glPopMatrix();
    }
    
    public void set_platinum(GL gl) {///color cuerpo
        float mat_ambient[] = {0.6f, 0.604f, 0.608f, 1.0f};
        float mat_diffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float mat_specular[] = {0.4f, 0.3f, 0.2f, 1.0f};
        float shine = 168f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    
}
