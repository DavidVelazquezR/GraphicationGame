package Terluks;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


public class DrawJF {
    //variables globales:

    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private static final int REBANADAS = 40;
    private static final int PILAS = 40;
    private GLUquadric q = null;
    private static int mvt = 0;
    static float co = (float) 2.5;

    //medidas de cangrejo:
    //cuerpo de cangrejo:
    //patas:
    private static final float HEIGHT_LEGS = 0.70f;
    private static final float WIDTH_LEGS = 0.15f;

    //cabeza:
    private static final float anchura_cabeza = 0.6f;
    private static final float anchura_ojos = 0.22f;
    private static final float WIDTH_HEAD = 0.41f;
    private static final float WIDTH_EYES = 0.22f;
    private static final float WIDTH_HANDS = 0.16f;

    private static final float ataque = 0.05f;

    private static final float WIDTH_PUPILS = 0.07f;
    private static final float RADIO_PICO = 0.1525f;
    private static final float ALTURA_PICO = 0.5f;

    public DrawJF() {
    }

    public void DIBU_jf(GL gl, boolean walk, boolean jump, boolean rotacion_X, boolean rotacion_Y, boolean rotacion_Z,
            boolean Traslacion, boolean Escalacion, boolean reflexion_X, boolean reflexion_Y, boolean reflexion_Z,
            boolean corte_X, boolean corte_Y, boolean corte_Z, boolean original, boolean colicion) {
        //llamado de paquetes de O.0PENGL, instancia de GLU como variable para llmado de funciones
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        //robot camina 
        if (walk && mvt % 20 + 10 > 20) {
            gl.glTranslatef(0.0f, 1.5f, 0f);
            draw_legs(gl, glu, 'W', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, 'W');
//            draw_ojos(gl, glu);
//            dibujar_caparason(gl, glu);
//            dibujar_luktita_c(gl, glu);
        } else if (walk && mvt % 20 + 10 <= 20) {
              gl.glTranslatef(0.0f, 1.5f, 0f);
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, 'W', true, false);
            draw_arm_left(gl, glu, 'W');
            draw_arm_right(gl, glu, ' ');
//            draw_ojos(gl, glu);
//            draw_pupila(gl, glu);
//            dibujar_caparason(gl, glu);
//            dibujar_luktita_c(gl, glu);
        } //robot saltando 
        else if (jump && mvt % 20 + 10 > 20) {
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'J', false, true);
            draw_legs(gl, glu, 'J', true, false);
            draw_arm_left(gl, glu, 'J');
            draw_arm_right(gl, glu, 'J');
//            draw_ojos(gl, glu);
//            draw_pupila(gl, glu);
//            dibujar_caparason(gl, glu);
//            dibujar_luktita_c(gl, glu);
        }//robot is jumping
        else if (jump && mvt % 20 + 10 <= 20) {
            gl.glTranslatef(0f, 0.35f, 0f);
            draw_legs(gl, glu, 'J', false, true);
            draw_legs(gl, glu, 'J', true, false);
            draw_arm_left(gl, glu, 'J');
            draw_arm_right(gl, glu, 'J');
//            draw_body(gl, glu, ' ');
//            dibujar_caparason(gl, glu);
        }//rortacion en x 
        else if (rotacion_X) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            gl.glRotatef(40f, 1f, 0f, 0f);
            draw_ojos(gl, glu);
            gl.glRotatef(-40f, 1f, 0f, 0f);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);

//rotacion en y
        } else if (rotacion_Y) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            gl.glRotatef(40f, 0f, 1f, 0f);
            draw_ojos(gl, glu);
            gl.glRotatef(-40f, 0f, 1f, 0f);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);

//rotacion en z
        } else if (rotacion_Z) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            gl.glRotatef(40f, 0f, 0f, 1f);
            draw_ojos(gl, glu);
            gl.glRotatef(-40f, 0f, 0f, 1f);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);

//traslacion
        } else if (Traslacion) {
            gl.glTranslatef(-0.3f, -0.2f, 0f);
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            gl.glTranslatef(0.3f, 0.2f, 0f);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            //escalacion
        } else if (Escalacion) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            gl.glScalef(0.5f, 0.5f, 0.5f);
            draw_body(gl, glu, ' ');
            gl.glScalef(2f, 2f, 2f);
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            //reflexionx
        } else if (reflexion_X) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            gl.glRotatef(180, 0f, 1f, 0f);
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            gl.glRotatef(-180, 0f, 1f, 0f);
            //reflexiony
        } else if (reflexion_Y) {

            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            gl.glRotatef(180, 0f, 0f, 1f);
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            gl.glRotatef(-180, 0f, 0f, 1f);
            //reflexionz
        } else if (reflexion_Z) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            gl.glTranslatef(0.1f, 0f, 0f);
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            gl.glTranslatef(-0.1f, 0f, 0f);
            //cortex
        } else if (corte_X) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            //cortey
        } else if (corte_Y) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            //cortez
        } else if (corte_Z) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
        } //original
        else if (original) {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            dibujar_luktita_c(gl, glu);
            //colision
        } else if (colicion) {
            set_orange_material(gl);
//            draw_legs(gl, glu, ' ', false, true);
//            draw_legs(gl, glu, ' ', true, false);
//            draw_arm_left(gl, glu, ' ');
//            draw_arm_right(gl, glu, ' ');
            draw_ojos(gl, glu);
            draw_body(gl, glu, ' ');
            dibujar_caparason(gl, glu);
            co = (float) (co - 0.3);
            ataque(gl, glu, co);

        } //stan is normal
        else {
            draw_legs(gl, glu, ' ', false, true);
            draw_legs(gl, glu, ' ', true, false);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
        }

        mvt++;
        draw_body(gl, glu, ' ');
        dibujar_caparason(gl, glu);
        draw_ojos(gl, glu);
        draw_pupila(gl, glu);
        dibujar_luktita_c(gl, glu);
    }

    public void draw_ojos(GL gl, GLU glu) {
        //dibijamos cabeza
        colo_piel(gl);
        set_brown_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.36f, -0.15f, -1.35f);
        glu.gluSphere(q, WIDTH_HEAD, SLICES, STACKS);
        gl.glPopMatrix();
        //dibujamos ojos
        set_purp_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.9f, -0.2f, -1.4f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.45f, -0.72f, -1.4f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void draw_pupila(GL gl, GLU glu) {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(1f, -0.25f, -1.6f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.45f, -0.72f, -1.6f);
        glu.gluSphere(q, WIDTH_PUPILS, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void draw_body(GL gl, GLU glu, char c) {
        float anchura_cuerpo = 0.9f;
        colo_piel(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, 0f);
        glu.gluSphere(q, anchura_cuerpo, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void dibujar_caparason(GL gl, GLU glu) {
        float anchur_caparason = 0.82f;
        colo_luktita(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.05f, 0.32f, -0.38f);
        glu.gluSphere(q, anchur_caparason * 0.99, SLICES, STACKS);
        gl.glPopMatrix();

        //creacion de luktita en caparason:
        float radio_picas = 0.33f;
        colo_luktita2(gl);
        gl.glTranslatef(0.05f, 1f, -0.38f);
        gl.glRotatef(-155, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, radio_picas, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

        colo_luktita2(gl);
        gl.glTranslatef(-0.2f, 0.75f, -0.7f);
        gl.glRotatef(-200, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, radio_picas, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

    }

    public void dibujar_luktita_c(GL gl, GLU glu) {
        float radio_picas = 0.33f;
        colo_luktita2(gl);
        gl.glTranslatef(0.2f, 0.8f, -0.7f);
        gl.glRotatef(-200, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, radio_picas, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

        gl.glTranslatef(-0.099f, 0.6f, -0.4f);
        gl.glRotatef(-100, 1f, 0.4f, 0.10f);
        gl.glRotatef(10, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, radio_picas, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

        gl.glTranslatef(0.002f, -0.45f, 0.05f);
        gl.glRotatef(-250, 1.05f, 0.8f, 0.15f);
        gl.glRotatef(-80, 1.05f, 0.8f, 0.15f);
        glu.gluCylinder(q, radio_picas, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();
    }

    public void draw_legs(GL gl, GLU glu, char c, boolean left, boolean r) {
        gl.glPushMatrix();
//        metodo de salto y caminar

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
//   creamos piernas
        set_orange_material(gl);
        gl.glPushMatrix();
        if (left) {
            gl.glTranslatef(-0.2f, -0.55f, -0.3f);
            gl.glRotatef(130, 0f, -180f, 0f);
        } else {
            gl.glTranslatef(0.2f, -0.55f, -0.3f);
            gl.glRotatef(130, 0f, 180f, 0f);
        }

        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
        gl.glTranslatef(0f, 0.0f, 0f);
        gl.glRotatef(-60, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

        set_orange_material(gl);
        gl.glPushMatrix();
        if (r) {
            gl.glTranslatef(-0.2f, -0.55f, 0.3f);
            gl.glRotatef(60, 0f, -180f, 0f);
        } else {
            gl.glTranslatef(0.2f, -0.55f, 0.3f);
            gl.glRotatef(60, 0f, 180f, 0f);
        }

        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);

        gl.glTranslatef(0f, 0.0f, 0f);
        gl.glRotatef(-60, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

    }

    public void draw_arm_left(GL gl, GLU glu, char c) {
        set_orange_material(gl);
        gl.glPushMatrix();
        if (c == 'J') {
            gl.glTranslatef(-0.2f, -0.55f, -0.3f);
            gl.glRotatef(130, 0f, -180f, 0f);
        }
        if (c == 'W') {
            gl.glTranslatef(0.2f, -0.55f, -0.3f);
            gl.glRotatef(130, 0f, 180f, 0f);
        }
//cambio de rotacion
        gl.glTranslatef(-0.6f, 0.045f, 0.5f);
        gl.glRotatef(5f, -0.3f, -0.8f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);

        gl.glRotatef(90f, -0.2f, 0.1f, 0f);
        gl.glTranslatef(-0.35f, -HEIGHT_LEGS * 0.7f, -0.1f);

        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
        gl.glTranslatef(0f, 0.0f, 0f);
        gl.glRotatef(-60, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

        gl.glPopMatrix();

    }

    public void draw_arm_right(GL gl, GLU glu, char c) {
        set_orange_material(gl);
        gl.glPushMatrix();
        if (c == 'J') {
            gl.glTranslatef(-0.2f, -0.55f, -0.3f);
            gl.glRotatef(130, 0f, -180f, 0f);
        }
        if (c == 'W') {
            gl.glTranslatef(0.2f, -0.55f, -0.3f);
            gl.glRotatef(130, 0f, 180f, 0f);
        }
//cambio de rotacion
        gl.glTranslatef(0.6f, 0.045f, 0.5f);
        gl.glRotatef(-15f, -0.3f, -0.8f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);

        gl.glRotatef(90f, -0.2f, 0.1f, 0f);
        gl.glTranslatef(-0.35f, -HEIGHT_LEGS * 0.7f, -0.09f);

        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
        gl.glTranslatef(0f, 0.0f, 0f);
        gl.glRotatef(-60, 1f, 0.4f, 0.10f);
        gl.glRotatef(50, 1f, 0.4f, 0.10f);
        glu.gluCylinder(q, RADIO_PICO, 0, ALTURA_PICO, 53, STACKS);
        gl.glPopMatrix();

    }

    public void ataque(GL gl, GLU glu, float cl) {

        colo_luktita(gl);
        if (co > 0.5) {
            gl.glPushMatrix();
            gl.glTranslatef(co + 0f, 0.5f, 0.1f);
            glu.gluSphere(q, ataque * 2, REBANADAS, PILAS);
            gl.glPopMatrix();
        }
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

    private void colo_luktita2(GL gl) {
        float[] mat_ambient
                = {
                    1.0f, 0.0f, 1.0f, 0.0f
                };
        float[] mat_diffuse
                = {
                    1.0f, 0.0f, 1.0f, 0.0f
                };
        float[] mat_specular
                = {
                    1.0f, 0.0f, 1.0f, 0.0f
                };
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    private void colo_luktita(GL gl) {
        float[] mat_ambient
                = {
                    0.5f, 0.5f, 0.5f, 0.0f
                };
        float[] mat_diffuse
                = {
                    0.5f, 0.5f, 0.5f, 0.0f
                };
        float[] mat_specular
                = {
                    0.5f, 0.5f, 0.5f, 0.0f
                };
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    private void colo_piel(GL gl) {
        float[] mat_ambient
                = {
                    1.0f, 0.0f, 0.0f, 0.0f
                };
        float[] mat_diffuse
                = {
                    1.0f, 0.5f, 0.0f, 0.0f
                };
        float[] mat_specular
                = {
                    0.1f, 0.0f, 0.0f, 0.0f
                };
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    private void color_Blanco(GL gl) {
        float[] mat_ambient
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
                };
        float[] mat_diffuse
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
                };
        float[] mat_specular
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
                };
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

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

    private void MaterialOJos(GL gl) {
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

    public void material_boca(GL gl) {
        float[] mat_ambient
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float mat_diffuse[]
                = {
                    0.0f, 0.0f, 0.0f, 0.0f
                };
        float mat_specular[]
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void azul(GL gl) {
        float[] mat_ambient
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float mat_diffuse[]
                = {
                    0.5f, 0.5f, 0.5f, 0.0f
                };
        float mat_specular[]
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void gris(GL gl) {

        float[] mat_ambient
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float mat_diffuse[]
                = {
                    0.0f, 0.0f, 0.0f, 0.0f
                };
        float mat_specular[]
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void material_lengua(GL gl) {

        float[] mat_ambient
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
                };
        float mat_diffuse[]
                = {
                    0.0f, 0.0f, 0.0f, 0.0f
                };
        float mat_specular[]
                = {
                    0.1f, 0.1f, 0.1f, 0.0f
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
                    0.59f, 0.44f, 0.41f, 0.0f
                };
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
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
                        (R + rr * Math.cos(v)) * Math.cos(w)
                        - (R + r * Math.cos(v)) * Math.cos(w),
                        (R + rr * Math.cos(v)) * Math.sin(w)
                        - (R + r * Math.cos(v)) * Math.sin(w),
                        (rr * Math.sin(v) - r * Math.sin(v)));
                gl.glVertex3d((R + r * Math.cos(v)) * Math.cos(w),
                        (R + r * Math.cos(v)) * Math.sin(w),
                        r * Math.sin(v));
                gl.glNormal3d(
                        (R + rr * Math.cos(v + dv)) * Math.cos(w + dw)
                        - (R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + rr * Math.cos(v + dv)) * Math.sin(w + dw)
                        - (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
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

}
