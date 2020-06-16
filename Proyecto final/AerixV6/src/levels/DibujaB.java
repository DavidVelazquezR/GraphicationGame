/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author arele
 */
public class DibujaB
{

    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private static final float altura_p = 1.4f;
    private static final float ancho_p = 0.05f;
    
    public void dibujaB(GL gl)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
  
           palito(gl, glu);
           bandera(gl);
         
    }

   
   
   
    
    public void bandera(GL gl){
            gl.glPushMatrix();
            gl.glBegin(GL.GL_TRIANGLES);///van
            set_red_material(gl);
            gl.glVertex3f(0f, 0.95f,0f);
            gl.glVertex3f(0f, 0.45f,0f);
            gl.glVertex3f(-0.5f, 0.45f,0f);
            gl.glEnd();
            gl.glPopMatrix();
            
    }
    

    public void palito(GL gl,GLU glu)
    {
        gl.glPushMatrix();
        set_brown_material(gl);
        gl.glTranslatef(0.0f, 0.90f, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, ancho_p, ancho_p, altura_p, SLICES, STACKS);
        glu.gluSphere(q, ancho_p, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        gl.glTranslatef(0f, -altura_p, 0f);
        gl.glRotatef(90f, 0f, 0f, 0f);
        glu.gluDisk(q, 0f, ancho_p, SLICES, STACKS);
        gl.glPopMatrix();

    }

   
    

    //Materiales
    public void set_green_material(GL gl)
    {
        float[] mat_ambient =
        {
            0.1f, 1.f, 0.0f, 0.0f
        };
        float[] mat_diffuse =
        {
            0.59f, 0.44f, 0.41f, 0.0f
        };
        float[] mat_specular =
        {
            0.7f, 0.6f, 0.6f, 1.0f
        };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_brown_material(GL gl)
    {
        float[] mat_ambient =
        {
            0.616f, 0.42f, 0.224f
        };
        float[] mat_diffuse =
        {
            0.4f, 0.1f, 0.0f, 0.0f
        };
        float[] mat_specular =
        {
            0.7f, 0.6f, 0.6f, 1.0f
        };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }


    public void set_red_material(GL gl)
    {
        float[] mat_ambient =
        {
            0.62f, 0.129f, 0.063f
        };
        float[] mat_diffuse =
        {
            0.4f, 0.4f, 0.4f, 1.0f
        };
        float[] mat_specular =
        {
            0.7f, 0.6f, 0.6f, 1.0f
        };
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

}
