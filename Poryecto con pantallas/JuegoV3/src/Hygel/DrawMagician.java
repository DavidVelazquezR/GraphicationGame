package Hygel;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import javax.media.opengl.glu.GLUquadric;

public class DrawMagician {
    
    public static  float X_POSITION = 0f;
    public static  float Y_POSITION = 0f;
    public static  float Z_POSITION = 0f;
    public static int rot=0;
    
    public static boolean up = false;
    
    
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    
    private static int mvt = 0;
    
    
    private static final float HEIGHT_BODY = 1.0f;
    private static final float TOP_BODY = 0.2f;
    private static final float BOTTOM_BODY = 0.45f;

    private static final float HEIGHT_LEGS = 0.2f;
    private static final float WIDTH_LEGS = 0.185f;

    private static final float HEIGHT_ARMS = 0.42f;
    private static final float WIDTH_ARMS = 0.085f;

    private static final float WIDTH_HEAD = 0.35f;

    private static final float WIDTH_MASK = 0.32f;
    private static final float WIDTH_MIMIMASK = 0.34f;

    private static final float WIDTH_EYES = 0.15f;

    private static final float WIDTH_HANDS = 0.08f;

    private static final float WIDTH_FINGERS = 0.0525f;

    private static final float WIDTH_SHOES = 1.55f;
    private static final float HEIGHT_SHOES = 1.58f;

    private static final float WIDTH_OPEN_MOUTH = 0.1f;
    private static final float WIDTH_MOUTH = 0.01f;

    private static final float WIDTH_BUTTONS = 0.02f;
    private static final float SPACE_BETWEEN_BUTTONS = 0.12f;

    private static final float WIDTH_BOTTOM_BONNET = 0.4f;
    private static final float HEIGHT_BOTTOM_BONNET = 0.42f;

    private static final float PUNTA = 0f;
    private static final float BASE = 0.36f;
    private static final float MIMI_BASE = 0.08f;

    private static final float WIDTH_PUPILS = 0.06f;
    private static final float WIDTH_POMPON = 0.12f;

    private static final float WIDTH_CENTRO = 0.03f;
    private static final float HEIGHT_CENTER = 1.0f;
    private static final float WIDTH_BASE_CENTER = 0.1f;
    private static final float WIDTH_GEMA = 0.08f;

    public DrawMagician() {
    }

    public void draw_mage(GL gl, char m, int pantalla) {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        //up = getZ_POSITION() > 0;
        if(pantalla!=1){
            gl.glTranslatef(getX_POSITION(), getY_POSITION()+0.5f,getZ_POSITION());
        }
        
        if(m=='D' || m =='A'){
            if (mvt % 20 + 10 > 20) {
                draw_legs(gl, glu, 'D', false);
                draw_legs(gl, glu, ' ', true);
                draw_arm_left(gl, glu, ' ');
                draw_arm_right(gl, glu, 'D');
                draw_centro(gl, glu, ' ');
                draw_head(gl, glu, ' ');
            } else if(mvt % 20 + 10 <= 20) {
                draw_legs(gl, glu, ' ', false);
                draw_legs(gl, glu, 'D', true);
                draw_arm_left(gl, glu, 'D');
                draw_arm_right(gl, glu, ' ');
                draw_head(gl, glu, ' ');
                draw_centro(gl, glu, 'D');
            }
        } else if (m=='W'){
            draw_legs(gl, glu, 'W', false);
            draw_legs(gl, glu, 'W', true);
            draw_arm_left(gl, glu, 'W');
            draw_arm_right(gl, glu, 'W');
            draw_centro(gl, glu, 'W');
            draw_head(gl, glu, 'W');
        }else if (m=='F'){
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, 'F');
            draw_arm_right(gl, glu, 'F');
            draw_centro(gl, glu, 'F');
            draw_head(gl, glu, 'F');
            draw_barrier(gl, glu);
        } else if (m=='C') {
            draw_legs(gl, glu, ' ', false);
                draw_legs(gl, glu, ' ', true);
                draw_arm_left(gl, glu, 'C');
                draw_arm_right(gl, glu, 'C');
                draw_centro(gl, glu, 'C');
                draw_head(gl, glu, 'C');
        }  else{
            draw_legs(gl, glu, ' ', false);
            draw_legs(gl, glu, ' ', true);
            draw_arm_left(gl, glu, ' ');
            draw_arm_right(gl, glu, ' ');
            draw_centro(gl, glu, ' ');
            draw_head(gl, glu, ' ');
        }
        mvt++;
        draw_body(gl, glu);
        draw_hat(gl, glu);
    }
/// ---------------------- cuerpo ---------------------------

    public void draw_body(GL gl, GLU glu) {

        //we create stan body
        set_shirt_material(gl);
        gl.glPushMatrix();
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BODY, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
        gl.glPopMatrix();

        // buttons
        set_grey_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0f, -0.11f, 0.25f);//(y,z,x)
        glu.gluSphere(q, WIDTH_BUTTONS, SLICES, STACKS);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -SPACE_BETWEEN_BUTTONS * 2, 0.27f);
        glu.gluSphere(q, WIDTH_BUTTONS, SLICES, STACKS);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -SPACE_BETWEEN_BUTTONS * 3, 0.3f);
        glu.gluSphere(q, WIDTH_BUTTONS, SLICES, STACKS);
        gl.glPopMatrix();

    }
/// ---------------------- cabeza ---------------------------

    public void draw_head(GL gl, GLU glu, char c) {

        //we create head
        set_skin_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.3f, 0f);//(y,z,x)
        glu.gluSphere(q, WIDTH_HEAD, SLICES, STACKS);
        gl.glPopMatrix();

        set_grey_material(gl);///mascara
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.3f, 0.1f);//(y,z,x)
        glu.gluSphere(q, WIDTH_MASK, SLICES, STACKS);
        gl.glPopMatrix();

        set_grey_material(gl);//orejaizq
        gl.glPushMatrix();
        gl.glTranslatef(-0.19f, 0.69f, 0.3f);//(y,z,x)
        gl.glRotatef(95f, 0.3f, 0.1f, 0f);//,frente,izq,
        glu.gluCylinder(q, PUNTA, MIMI_BASE, 0.2f, SLICES, STACKS);
        gl.glPopMatrix();
        set_grey_material(gl);//orejaizq
        gl.glPushMatrix();
        gl.glTranslatef(0.18f, 0.7f, 0.3f);//(y,z,x)
        gl.glRotatef(95f, 0.5f, -0.15f, 0f);//atras,frente,izq,atbafr
        glu.gluCylinder(q, PUNTA, MIMI_BASE, 0.2f, SLICES, STACKS);
        gl.glPopMatrix();

        gl.glPushMatrix();
        set_black_material(gl);
        if (c == 'W') {
            gl.glRotatef(30f, 90f, 0f, 0f);//°,x +at,y +dr,z +
            gl.glScalef(0.1f, 0.1f, 0.1f);
            gl.glTranslatef(-1.9f, 2.2f, 1.65f);//(y,z,x)
            boca(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(0.22f, 0.3f, 0.35f);//(y,z,x)
            gl.glRotatef(10f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.03f, 0.1f);
            ojos_jump(gl);
            gl.glPopMatrix();
        }
        if (c == 'F') {
            gl.glTranslatef(-0.5f, -0.03f, -0.24f);
            gl.glRotatef(10f, 1f, 0f, 0f);//°,x +at,y +dr,z +
            gl.glScalef(0.4f, 0.4f, 0.6f);
            boca_ab(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(0.22f, 0.3f, 0.35f);//(y,z,x)
            gl.glRotatef(10f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.03f, 0.1f);
            ojos_ce(gl);
            gl.glPopMatrix();
        }
        if (c == 'C') {
            gl.glTranslatef(-0.5f, -0.03f, -0.24f);
            gl.glRotatef(10f, 1f, 0f, 0f);//°,x +at,y +dr,z +
            gl.glScalef(0.4f, 0.4f, 0.6f);
            boca_ab(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glTranslatef(0.22f, 0.3f, 0.35f);//(y,z,x)
            gl.glRotatef(10f, 1f, 0f, 0f);
            gl.glScalef(-0.2f, 0.03f, 0.1f);
            ojos_co(gl);
            gl.glPopMatrix();
        }
        if (c == ' ') {
            gl.glRotatef(30f, 90f, 0f, 0f);//°,x +at,y +dr,z +
            gl.glScalef(0.1f, 0.1f, 0.1f);
            gl.glTranslatef(-1.9f, 2.2f, 1.65f);//(y,z,x)
            boca(gl);
            gl.glPopMatrix();

            gl.glPushMatrix();
            gl.glRotatef(-15f, 90f, 0f, 0f);//°,x +at,y +dr,z +
            gl.glScalef(0.2f, 0.5f, 0.5f);
            gl.glTranslatef(-1.1f, -0.65f, 0.005f);//(y,z,x)
            ojos(gl);
            gl.glPopMatrix();
        }

    }

/// ---------------------- sombrero ---------------------------
    public void draw_hat(GL gl, GLU glu) {
        //we create bottom of bonnet
        gl.glPushMatrix();
        set_shirt_material(gl);
        gl.glTranslatef(0.0f, HEIGHT_BOTTOM_BONNET + 0.005f, 0.02f);
        gl.glRotatef(80f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, 0.527, SLICES, STACKS);
        gl.glPopMatrix();

        //we create bonnet  
        gl.glPushMatrix();
        set_shirt_material(gl);
        gl.glTranslatef(0.0f, 1.4f, -0.2f);//(y,z,x)
        gl.glRotatef(80f, 0.4f, 0f, 0f);//,frente,izq,,
        glu.gluCylinder(q, PUNTA, BASE, HEIGHT_BODY, SLICES, STACKS);
        gl.glPopMatrix();

    }
/// ---------------------- pies ---------------------------

    public void draw_legs(GL gl, GLU glu, char c, boolean left) {
        gl.glPushMatrix();
        if (c == 'D') {
            gl.glTranslatef(0f, -0.1f, -0.25f);
            gl.glRotatef(30, -100f, 0f, 0f);
        }
        if (c == 'W') {
            gl.glTranslatef(0f, -0.05f, -0.1f);
            if (left) {
                gl.glRotatef(30, -100f, -100f, 0f);
            } else {
                gl.glRotatef(30, -100f, 100f, 0f);
            }
        }

        set_black_material(gl);
        gl.glPushMatrix();
        if (left) {
            gl.glTranslatef(-0.18f, -1.0f, 0.0f);//(y,z,x)
        } else {
            gl.glTranslatef(0.18f, -1.0f, 0.0f);
        }
        glu.gluSphere(q, WIDTH_BASE_CENTER, SLICES, STACKS);
        gl.glPopMatrix();

    }
/// ---------------------- brazoz ---------------------------

    public void draw_arm_left(GL gl, GLU glu, char c) {
        set_skin_material(gl);
        gl.glPushMatrix();
        //mano
        if (c == 'W') {
            gl.glTranslatef(-0.75f, -0.19f, -0.14f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'D') {
            gl.glTranslatef(-0.5f, -0.48f, 0.13f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'F') {
            gl.glTranslatef(-.148f, 0.02f, 0.45f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.08f, 0.00f, 0.0f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'C') {
            gl.glTranslatef(-0.6f, 0.28f, 0.02f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.08f, 0.00f, 0.0f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == ' ') {
            gl.glTranslatef(-0.495f, -0.55f, 0f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(0.07f, 0.00f, 0.0f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }

        gl.glPopMatrix();
        //brazo
        set_shirt_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.31f, -0.125f, 0f);//(y,z,x)
        gl.glRotatef(90f, 1f, -0.385f, 0f);//
        if (c == 'W') {
            gl.glRotatef(60, 0f, -100f, 0f);///circulo pos (enfrente,atras,izq,45 aariv)
        }
        if (c == 'D') {
            gl.glRotatef(20, -1f, 0f, 0f);
        }
        if (c == 'F') {
            gl.glRotatef(247, 1.5f, -1.0f, 0f);//°,x +at,y +dr,z +
        }
        if (c == 'C') {
            gl.glRotatef(200, 1.0f, 0.0f, -0.5f);//°,x +at,y +dr,z +
        }
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);//brazo
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);//hombro
        gl.glRotatef(90f, -1f, 0.17f, 0f);///circulo pos (enfrente,atras,izq,45 aariv)
        gl.glTranslatef(-0.068f, -HEIGHT_ARMS, 0f);///(y,z,x)
        //gl.glRotatef(90f, 1f, -0.18f, 0f);
        if (c != 'W') {
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        }
        gl.glPopMatrix();
    }

    public void draw_arm_right(GL gl, GLU glu, char c) {
        set_skin_material(gl);
        gl.glPushMatrix();
        //mano
        if (c == 'W') {
            gl.glTranslatef(0.75f, -0.19f, -0.14f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'D') {
            gl.glTranslatef(0.5f, -0.48f, 0.13f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.05f, 0.015f, 0.05f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'F') {
            gl.glTranslatef(.145f, 0.045f, 0.42f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.08f, 0.010f, 0.0f);///(y,z,x)
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == 'C') {
            gl.glTranslatef(0.6f, 0.28f, 0.02f);//(y,z,x)
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.08f, 0.00f, 0.0f);
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        if (c == ' ') {
            gl.glTranslatef(0.5f, -0.55f, 0f);
            glu.gluSphere(q, WIDTH_HANDS, SLICES, STACKS);
            gl.glTranslatef(-0.07f, 0.010f, 0.0f);///(y,z,x)
            glu.gluSphere(q, WIDTH_FINGERS, SLICES, STACKS);
        }
        gl.glPopMatrix();

        //brazo
        set_shirt_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.30f, -0.110f, 0f);///(y,z,x) posicion
        gl.glRotatef(90f, 1f, 0.40f, 0f);//(enfrente,sube,45 sube,45 enfrente) rotar
        if (c == 'W') {
            gl.glRotatef(60, 0f, 100f, 0f);
        }
        if (c == 'D') {
            gl.glRotatef(20, -1f, 0f, 0f);
        }
        if (c == 'F') {
            gl.glRotatef(247, 1.9f, 1.1f, 0f);//°,x +at,y +dr,z +
        }
        if (c == 'C') {
            gl.glRotatef(200, 1.0f, 0.0f, 0.5f);//°,x +at,y +dr,z +
        }
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);//brazo
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);///hombro
        gl.glRotatef(90f, -1f, -0.05f, -0.12f);///circulo pos (enfrente,atras,izq,45 aariv)
        gl.glTranslatef(0.062f, -HEIGHT_ARMS, 0.01f);///(y,z,x)
        gl.glRotatef(90f, 1f, 0.15f, 0f);//abenf,abjder,derarr
        if (c != 'W') {
            glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        }
        gl.glPopMatrix();
    }
/// ---------------------- centro ---------------------------

    public void draw_centro(GL gl, GLU glu, char c) {
        set_wood_material(gl);
        gl.glPushMatrix();
            if (c == 'W') {
                gl.glTranslatef(-0.73f, -0.14f, -0.55f);
            }
            if (c == 'D') {
                gl.glTranslatef(-0.45f, -0.40f, -0.45f);
            }
            if (c == 'F') {
                gl.glRotatef(275, 1f, 0.02f, 0f);//°,x +at,y +dr,z +
                gl.glTranslatef(0.05f, -0.37f, -0.49f);//(y,z,x)
            }
            if (c == 'C') {
                gl.glRotatef(275, 1f, 0.02f, 0f);//°,x +at,y +dr,z +
                gl.glTranslatef(-1.10f, -0.30f, -0.45f);//(x,y,z)
            }
            if (c == ' ') {
                gl.glTranslatef(-0.47f, -0.47f, -0.55f);//(y,z,x)
            }
            gl.glRotatef(10f, 1f, -0.385f, 0f);//(enfrente,sube,45 sube,45 enfrente) rotar
            glu.gluCylinder(q, WIDTH_CENTRO, WIDTH_CENTRO, HEIGHT_CENTER, SLICES, STACKS);//brazo
            gl.glTranslatef(0f, 0f, 1f);//(y,z,x)
            gl.glRotatef(10f, 1f, -0.385f, 0f);//(enfrente,sube,45 sube,45 enfrente) rotar
            glu.gluSphere(q, WIDTH_BASE_CENTER, SLICES, STACKS);//hombro
            gl.glTranslatef(0f, 0f, 0.004f);//(y,z,x)
            set_blue_material(gl);
            glu.gluSphere(q, WIDTH_BASE_CENTER, SLICES, STACKS);//hombro
        

        gl.glPopMatrix();

    }
    public void draw_barrier(GL gl, GLU glu){
        //set_barrier_material(gl);
        //gl.glPushMatrix();
        //gl.glRotatef(90f, 1f, 0f, 0f);//(
        //glu.gluCylinder(q, 0.6, 0.6, 1.5, SLICES, STACKS);
        //gl.glPopMatrix();
    }
    
/// ---------------------- colores ---------------------------  
    public void set_barrier_material(GL gl) {////piel clor
        float[] mat_ambient = {1f, 0.859f, 0.42f, 0.1f};
        float[] mat_diffuse = {0.59f, 0.44f, 0.91f, 0.0f};
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
    
    public void set_skin_material(GL gl) {////piel clor
        float[] mat_ambient = {0.9f, 0.67f, 0.450f, 1.0f};
        float[] mat_diffuse = {0.59f, 0.44f, 0.91f, 0.0f};
        float shine = 128f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_shirt_material(GL gl) {///color cuerpo
        float mat_ambient[] = {0.294f, 0.224f, 0.529f, 1.0f};
        float mat_diffuse[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float mat_specular[] = {0.4f, 0.3f, 0.2f, 1.0f};
        float shine = 168f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_red_material(GL gl) {//manos
        float[] mat_ambient = {0.8f, 0.05f, 0.15f, 0.2f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 15.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_blue_material(GL gl) {
        float mat_ambient[] = {0f, 0.78f, 0.953f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_grey_material(GL gl) {

        float mat_ambient[] = {0.584f, 0.584f, 0.584f, 0.0f};
        float mat_diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float mat_specular[] = {0.8f, 0.8f, 0.8f, 1.0f};
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_black_material(GL gl) {

        float mat_ambient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_diffuse[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_specular[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_wood_material(GL gl) {//manos
        float[] mat_ambient = {0.325f, 0.227f, 0.051f, 1f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 90.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void set_eye_material(GL gl) {//manos
        float[] mat_ambient = {1f, 1f, 11f, 1f};
        float[] mat_diffuse = {0.4f, 0.4f, 0.4f, 1.0f};
        float[] mat_specular = {0.7f, 0.6f, 0.6f, 1.0f};
        float shine = 90.0f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }
/// ---------------------- rostro ---------------------------

    public void boca(GL gl) {
        gl.glBegin(GL.GL_LINES);
        float y=0;
        for (float i = 0; i < 2.1; i+=0.1) {
            y = (float) (-2*i)+(i*i)+1;
            gl.glVertex3f(i, y,1);
            if(i%2!=0){
                gl.glVertex3f(i, y,1);
            }
        }
        gl.glEnd();
        gl.glBegin(GL.GL_LINES);
        y=0;
        for (float i = 2; i < 4.1; i+=0.1) {
            y = (float) (i*i)-(6*i)+9;
            gl.glVertex3f(i, y,1);
            if(i%2!=0){
                gl.glVertex3f(i, y,1);
            }
        }
        gl.glEnd();
    }

    public void boca_ab(GL gl) {
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(1.1f, 1f, 1f);
        gl.glVertex3f(1.3f, 1f, 1f);
        gl.glVertex3f(1.4f, 0.6f, 1f);
        gl.glVertex3f(1.0f, 0.6f, 1f);
        gl.glEnd();

        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex3f(1.25f, 1f, 1f);
        gl.glVertex3f(1.3f, 1f, 1f);
        gl.glVertex3f(1.4f, 0.6f, 1f);

        gl.glEnd();

    }

    public void ojos_jump(GL gl) {
        gl.glBegin(GL.GL_LINES);/* f1: front */
        gl.glLineWidth(10);

        gl.glVertex3f(2f, 1f, 1f);
        gl.glVertex3f(1.5f, 0f, 1f);//(x<-,yab,zenf)

        gl.glVertex3f(1.5f, 0f, 1f);
        gl.glVertex3f(2f, -1f, 1f);

        gl.glVertex3f(0.2f, 1f, 1f);
        gl.glVertex3f(0.7f, 0f, 1f);//(x<-,yab,zenf)

        gl.glVertex3f(0.7f, 0f, 1f);//
        gl.glVertex3f(0.2f, -1f, 1f);

        gl.glEnd();
    }

    public void ojos(GL gl) {
        gl.glBegin(GL.GL_LINES);/* f1: front */
        float y=0;
        for (float i = 0; i < 1.1; i+=0.1) {
            y = (float) i-(i*i)+1;
            gl.glVertex3f(i, y,1);
            if(i%2!=0){
                gl.glVertex3f(i, y,1);
            }
        }
        gl.glEnd();
        gl.glTranslatef(-0.5f, 0.0f, 0.0f);//(y,z,x)
        gl.glBegin(GL.GL_LINES);/* f1: front */
        y=0;
        for (float i = 2; i < 3; i+=0.1) {
            y = (float) -(i*i)+(5*i)-5;
            gl.glVertex3f(i, y,1);
            if(i%2!=0){
                gl.glVertex3f(i, y,1);
            }
        }
        gl.glEnd();
    }

    public void ojos_ce(GL gl) {
        gl.glBegin(GL.GL_LINES);/* f1: front */

        gl.glVertex3f(1.1f, 1f, 0.75f);
        gl.glVertex3f(0.3f, 2f, 0.75f);//(x<-,yab,zenf)

        gl.glVertex3f(1.4f, 1f, 0.75f);
        gl.glVertex3f(2.1f, 2f, 0.75f);//(x<-,yab,zenf)

        gl.glEnd();
    }
    
    public void ojos_co(GL gl) {
        gl.glBegin(GL.GL_LINES);/* f1: front */

        gl.glVertex3f(2f, 1f, 1f);
        gl.glVertex3f(1.5f, 0f, 1f);//(x<-,yab,zenf)

        gl.glVertex3f(1.5f, 1f, 1f);
        gl.glVertex3f(2f, 0f, 1f);

        gl.glVertex3f(0.2f, 1f, 1f);
        gl.glVertex3f(0.7f, 0f, 1f);//(x<-,yab,zenf)

        gl.glVertex3f(0.7f, 1f, 1f);//
        gl.glVertex3f(0.2f, 0f, 1f);

        gl.glEnd();
    }
    
    public static float getX_POSITION() {
        return X_POSITION;
    }
    public static void setX_POSITION(float X_POSITION) {
        DrawMagician.X_POSITION = X_POSITION;
    }
    public static float getY_POSITION() {
        return Y_POSITION;
    }

    public static void setY_POSITION(float Y_POSITION) {
        DrawMagician.Y_POSITION = Y_POSITION;
    }

    public static float getZ_POSITION() {
        return Z_POSITION;
    }

    public static void setZ_POSITION(float Z_POSITION) {
        DrawMagician.Z_POSITION = Z_POSITION;
    }
    
}
