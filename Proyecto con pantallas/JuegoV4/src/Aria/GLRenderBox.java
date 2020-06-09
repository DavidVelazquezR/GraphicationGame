/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aria;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author TOSHIBA
 */
public class GLRenderBox {

    private GLUquadric q = null;
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private static int mvt = 0;
    private static float mv = 0f;
    private static float mv2 = 0f;
    static float colision = (float) 2.5;

    public void drawBox(GL gl, char tecla, boolean activeObject) {

        GLU glu = new GLU();
        GLUT glut = new GLUT();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        if (activeObject) {
            draw_cube(gl, glut, tecla);
        } else {
        }
        
    }

    //Metodos que dibujan las partes del cuerpo de Aria
    public void draw_cube(GL gl, GLUT glut, char c) {
        //Caja
        
        if (c == 'B') {
            set_brown_material(gl);
        }else if (c == 'C') {
            set_blue_material(gl);
        }
        
        gl.glPushMatrix();
        gl.glRotatef(-90.0f, 2.0f, 0f, 0f);
        gl.glTranslatef(0.0f, 0.0f, -0.3f);
        //glut.glutWireCube(2);
        glut.glutSolidCube(2);
        gl.glPopMatrix();


    }

    public void draw_torus(GL gl, float R, float r, int N, int n) {
        int maxn = 1000;
        n = Math.min(n, maxn - 1);
        N = Math.min(N, maxn - 1);
        float rr = 1.5f * r;
        double dv = 2 * Math.PI / n;
        double dw = 2 * Math.PI / N;
        double v = 0.0f;
        double w = 0.0f;
        while (w < 2 * Math.PI + dw) {
            v = 0.0f;
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            while (v < 2 * Math.PI + dv) {
                gl.glNormal3d(
                        (R + rr * Math.cos(v)) * Math.cos(w) - (R + r * Math.cos(v)) * Math.cos(w),
                        (R + rr * Math.cos(v)) * Math.sin(w) - (R + r * Math.cos(v)) * Math.sin(w),
                        (rr * Math.sin(v) - r * Math.sin(v)));
                gl.glVertex3d((R + r * Math.cos(v)) * Math.cos(w),
                        (R + r * Math.cos(v)) * Math.sin(w),
                        r * Math.sin(v));
                gl.glNormal3d(
                        (R + rr * Math.cos(v + dv)) * Math.cos(w + dw) - (R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + rr * Math.cos(v + dv)) * Math.sin(w + dw) - (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        rr * Math.sin(v + dv) - r * Math.sin(v + dv));
                gl.glVertex3d((R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        r * Math.sin(v + dv));
                v += dv;
            }
            gl.glEnd();
            w += dw;
        }
    }

    //Colores utiliados para las figuras 3D
    public void set_skin_material(GL gl) {
        float[] mat_ambient
                = {
                    0.902f, 0.878f, 0.788f, 1.0f
                };
        float[] mat_diffuse
                = {
                    0.902f, 0.878f, 0.788f, 1.0f
                };
        float[] mat_specular
                = {
                    0.902f, 0.878f, 0.788f, 1.0f
                };
        float shine = 125.0f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_blue_material(GL gl) {
        float mat_ambient[]
                = {
                    0.0f, 0.682f, 1.0f, 1.0f
                };
        float mat_diffuse[]
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
                };
        float mat_specular[]
                = {
                    0.8f, 0.8f, 0.8f, 1.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_brown_material(GL gl) {
        float mat_ambient[]
                = {
                    0.353f, 0.278f, 0.165f, 1.0f
                };
        float mat_diffuse[]
                = {
                    0.353f, 0.278f, 0.165f, 1.0f
                };
        float mat_specular[]
                = {
                    0.353f, 0.278f, 0.165f, 1.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }
}
