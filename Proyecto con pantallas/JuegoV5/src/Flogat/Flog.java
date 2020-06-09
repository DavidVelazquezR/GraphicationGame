/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flogat;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author arele
 */
public class Flog {

    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private GLUquadric q2 = null;
    private static int mvt = 0;
    private static float mv2 = 0f;
    private static float mv = 0f;
    private static final float HEIGHT_BODY = 0.5f;
    private static final float HEIGHT_LEGS = 0.25f;
    private static final float WIDTH_LEGS = 0.15f;
    private static final float HEIGHT_ARMS = 0.27f;
    private static final float WIDTH_ARMS = 0.1f;
    private static final float WIDTH_HEAD = 0.6f;
    private static final float WIDTH_HANDS = 0.1f;
    private static final float WIDTH_OPEN_MOUTH = 0.5f;
    private static final float WIDTH_PUPILS = 0.03f;
    private static final float RADIO_PICO = 0.1525f;
    private static final float ALTURA_PICO = 0.5f;
    static float co = (float) 2.5;
    private static final float WIDTH_BALLON = 0.08f;
    private static final float WIDTH_EYES = 0.1f;

    public void dibujaFlog(GL gl, char tec, int lvl) {
        switch(lvl){
            case 1:
                set_orange_material(gl);
            break;
            case 2:
                set_purp_material(gl);
                
            break;
            case 3:
                set_green_material(gl);
            break;
            case 4:
                set_brown_material(gl);
            break;
        }
        
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

            if (tec=='W' && mvt % 20 + 10 > 20)
        {
            mv = mv2 = 0;
            piernas(gl, glu, 'W', false);
            piernas(gl, glu, ' ', true);
            brazoI(gl, glu, 'W');
            brazoD(gl, glu, ' ');
            draw_cuerpo(gl, glu,false, ' ');
            boca(gl);
            ojos(gl, glu);
            
        } else if (tec=='W' && mvt % 20 + 10 < 20)
        {
            mv = mv2 = 0;
            piernas(gl, glu, ' ', false);
            piernas(gl, glu, 'W', true);
            brazoI(gl, glu, ' ');
            brazoD(gl, glu, 'W');
           draw_cuerpo(gl, glu,false, ' ');
            ojos(gl, glu);
            boca(gl);
        } else
        {
//            System.out.println("normal");
            mv = mv2 = 0;
           
            piernas(gl, glu, ' ', false);
            piernas(gl, glu, ' ', true);
            brazoI(gl, glu, ' ');
            brazoD(gl, glu, ' ');
            draw_cuerpo(gl, glu,false, ' ');
             ojos(gl, glu);
            boca(gl);
            
            
        }
        mvt++;
        mv += 0.02;
        mv2 += 0.02;
    }

    //Cuerpo
    public void draw_cuerpo(GL gl, GLU glu, boolean jump, char c) {

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.1f, 0f);
        glu.gluSphere(q, WIDTH_HEAD, SLICES, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.51f, 0.30f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.50f, 0.0f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.51f, -0.30f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0.29f, 0.51f, 0.0f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-0.29f, 0.51f, 0.0f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-0.20f, 0.51f, -0.21f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-0.20f, 0.51f, 0.21f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0.20f, 0.51f, -0.21f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0.20f, 0.51f, 0.21f);
        gl.glRotatef(-150, 1f, 0.5f, 0.50f);
        gl.glRotatef(50, 1f, 0.5f, 0.50f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

    }

    public void piernas(GL gl, GLU glu, char c, boolean left) {
        gl.glPushMatrix();
        //we orientate axes if stan is jumping or is walking
        if (c == 'W') {

            gl.glTranslatef(0f, -0.1f, -0.2f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'J') {
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left) {
                gl.glRotatef(30, -100f, -100f, 0f);
            } else {
                gl.glRotatef(30, -100f, 100f, 0f);
            }
        }

        //we create legs
        gl.glPushMatrix();
        if (left) {
            gl.glTranslatef(-0.18f, -0.45f, 0f);
        } else {
            gl.glTranslatef(0.18f, -0.45f, 0f);
        }
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void brazoI(GL gl, GLU glu, char c) {

        gl.glPushMatrix();
        //we orientate axes if stan is walking or is jumping
        if (c == 'J') {
            gl.glTranslatef(-0.70f, 0.12f, -0.01f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        }
        if (c == 'W') {
            gl.glTranslatef(-0.58f, -0.38f, 0.12f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        }
        if (c == ' ') {
            gl.glTranslatef(-0.60f, -0.39f, 0f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        }

        gl.glPopMatrix();
        //we create left arm

        gl.glPushMatrix();
        gl.glTranslatef(-0.50f, -0.1f, 0f);
        gl.glRotatef(90f, 1f, -0.39f, 0f);
        if (c == 'J') {
            gl.glRotatef(110, 0f, -100f, 0f);
        }
        if (c == 'W') {
            gl.glRotatef(20, -0.50f, 0.35f, 0f);
        }
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(-0.05f, -HEIGHT_ARMS, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        if (c != 'J') {
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        }
        gl.glPopMatrix();
    }

    public void brazoD(GL gl, GLU glu, char c) {

        gl.glPushMatrix();
        //we orientate axes if stan is walking or is jumping
        if (c == 'J') {
            gl.glTranslatef(0.71f, 0.11f, -0.01f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        }
        if (c == 'W') {
            gl.glTranslatef(0.69f, -0.34f, 0.12f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        }
        if (c == ' ') {
            gl.glTranslatef(0.60f, -0.39f, 0f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        }
        gl.glPopMatrix();
        //we create right arm

        gl.glPushMatrix();
        gl.glTranslatef(0.50f, -0.1f, 0f);
        gl.glRotatef(90f, 1f, 0.39f, 0f);
        if (c == 'J') {
            gl.glRotatef(110, 0f, 100f, 0f);
        }
        if (c == 'W') {
            gl.glRotatef(20, -0.50f, 0.35f, 0f);
        }
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, -0.20f, 0f);
        gl.glTranslatef(0.05f, -HEIGHT_ARMS, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        if (c == ' ') {
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        }
        gl.glPopMatrix();
    }

    public void draw_pelota(GL gl, GLU glu, float cl) {

        if (co < 0.5) {
            gl.glPushMatrix();
            gl.glTranslatef(-co + 0f, +0.3f, 0.1f);
            glu.gluSphere(q, WIDTH_BALLON * 2, SLICES, STACKS);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslatef(-co + 0.f, -0.1f, 0.3f);
            glu.gluSphere(q, WIDTH_BALLON * 2, SLICES, STACKS);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslatef(co + 0f, -0.3f, 0.1f);
            glu.gluSphere(q, WIDTH_BALLON * 2, SLICES, STACKS);
            gl.glPopMatrix();
            gl.glPushMatrix();
            gl.glTranslatef(co + 0f, +0.1f, 0.3f);
            glu.gluSphere(q, WIDTH_BALLON * 2, SLICES, STACKS);
            gl.glPopMatrix();
        }
    }

    public void ojos_C(GL gl, GLU glu) {

        set_yellow_material(gl);

        gl.glPushMatrix();
        gl.glTranslatef(-0.12f, 0.18f, 0.565f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();

        set_yellow_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.12f, 0.18f, 0.565f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();

        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.12f, 0.18f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-0.12f, 0.18f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();

        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.05f, 0.25f, 0.560f);
        gl.glRotatef(0f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.08f, 0.08f);
        box(gl);
        gl.glPopMatrix();

        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.05f, 0.25f, 0.560f);
        gl.glRotatef(0f, 1f, 0f, 0f);
        gl.glScalef(0.2f, 0.08f, 0.08f);
        box(gl);
        gl.glPopMatrix();

    }

    public void ojos_Fur(GL gl, GLU glu) {
        set_yellow_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.12f, 0.18f, 0.565f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        set_yellow_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.12f, 0.18f, 0.565f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.12f, 0.18f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-0.12f, 0.18f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.05f, 0.25f, 0.550f);
        gl.glRotatef(-40f, 1f, -3f, 0f);
        gl.glScalef(-0.2f, 0.08f, 0.08f);
        box(gl);
        gl.glPopMatrix();
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.05f, 0.25f, 0.560f);
        gl.glRotatef(-40f, 1f, 3f, 0f);
        gl.glScalef(0.2f, 0.08f, 0.08f);
        box(gl);
        gl.glPopMatrix();
    }

    public void boca(GL gl) {
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.14f, -0.10f, 0.560f);
        gl.glRotatef(0f, 1f, 0f, 0f);
        gl.glScalef(-0.3f, 0.1f, 0.05f);
        box(gl);
        gl.glPopMatrix();
    }

    public void boca_salta(GL gl, GLU glu) {
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.0f, 0.0f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS * 2, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void ojos(GL gl, GLU glu) {
        set_yellow_material(gl);

        gl.glPushMatrix();
        gl.glTranslatef(-0.12f, 0.18f, 0.565f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        set_yellow_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.12f, 0.18f, 0.565f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.12f, 0.18f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-0.12f, 0.18f, 0.650f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();

    }

    //-----------------------Materiales-----------------------------
    public void set_orange_material(GL gl) {
        float mat_ambient[]
                = {
                    1.0f, 0.4f, 0.0f, 1.0f
                };
        float mat_diffuse[]
                = {
                    1.0f, 0.4f, 0.0f, 1.0f
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

    public void set_purp_material(GL gl) {
        float[] mat_ambient
                = {
                    0.53f, 0.16f, 0.67f, 0.0f
                };
        float[] mat_diffuse
                = {
                    0.53f, 0.90f, 0.107f, 0.0f
                };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_skin_material(GL gl) {
        float[] mat_ambient
                = {
                    1.0f, 0.79f, 0.68f, 0.0f
                };
        float[] mat_diffuse
                = {
                    0.59f, 0.44f, 0.41f, 0.0f
                };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_green_material(GL gl) {
        float[] mat_ambient
                = {
                    0.055f, 0.443f, 0.122f, 0.0f
                };
        float[] mat_diffuse
                = {
                    0.59f, 0.44f, 0.41f, 0.0f
                };
        float[] mat_specular
                = {
                    0.7f, 0.6f, 0.6f, 1.0f
                };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_brown_material(GL gl) {
        float[] mat_ambient
                = {
                    0.4f, 0.1f, 0.0f, 0.0f
                };
        float[] mat_diffuse
                = {
                    0.4f, 0.1f, 0.0f, 0.0f
                };
        float[] mat_specular
                = {
                    0.7f, 0.6f, 0.6f, 1.0f
                };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_shirt_material(GL gl) {
        float mat_ambient[]
                = {
                    0.5f, 0.45f, 0.3f, 1.0f
                };
        float[] mat_diffuse
                = {
                    0.8f, 0.8f, 0.8f, 1.0f
                };
        float mat_specular[]
                = {
                    0.4f, 0.3f, 0.2f, 1.0f
                };

        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_red_material(GL gl) {
        float[] mat_ambient
                = {
                    0.8f, 0.05f, 0.15f, 0.2f
                };
        float[] mat_diffuse
                = {
                    0.4f, 0.4f, 0.4f, 1.0f
                };
        float[] mat_specular
                = {
                    0.7f, 0.6f, 0.6f, 1.0f
                };
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_White_material(GL gl) {
        float mat_ambient[]
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
                };
        float mat_diffuse[]
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
                };
        float mat_specular[]
                = {
                    0.8f, 0.8f, 0.8f, 1.0f
                };
        float shine = 51.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_blue_material(GL gl) {
        float mat_ambient[]
                = {
                    0.2f, 0.2f, 0.6f, 1.0f
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

    public void set_grey_material(GL gl) {

        float mat_ambient[]
                = {
                    0.07f, 0.07f, 0.07f, 0.0f
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

    public void set_black_material(GL gl) {

        float mat_ambient[]
                = {
                    0.0f, 0.0f, 0.0f, 1.0f
                };
        float mat_diffuse[]
                = {
                    0.0f, 0.0f, 0.0f, 1.0f
                };
        float mat_specular[]
                = {
                    0.0f, 0.0f, 0.0f, 1.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_yellow_material(GL gl) {

        float mat_ambient[]
                = {
                    0.99f, 0.93f, 0.45f, 1.0f
                };
        float mat_diffuse[]
                = {
                    0.0f, 0.0f, 0.0f, 1.0f
                };
        float mat_specular[]
                = {
                    0.0f, 0.0f, 0.0f, 1.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void box(GL gl) {
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
    }
}
