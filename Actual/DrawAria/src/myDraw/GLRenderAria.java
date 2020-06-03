/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myDraw;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author TOSHIBA
 */
public class GLRenderAria {

    private GLUquadric q = null;
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private static int mvt = 0;
    private static float mv = 0f;
    private static float mv2 = 0f;
    static float colision = (float) 2.5;

    public void accionesAria(GL gl, char tecla) {

        GLU glu = new GLU();
        GLUT glut = new GLUT();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);

        //Aria hace movimientos para caminar---------------------------------------------------------------------------Tecla W
        if (tecla == 'W' && mvt % 20 + 10 >= 20) {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, 'W'); //La primera que se va a mover sera la derecha
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, 'W', true);
        } else if (tecla == 'W' && mvt % 20 + 10 <= 20) {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, 'W');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, 'W'); //Despues se movera a la izquierda
            draw_legsD(gl, glu, 'W', true);
            draw_legsI(gl, glu, ' ', true);
            //Aria salta con movimientos-------------------------------------------------------------------------------------Tecla J
        } else if (tecla == 'J' && mvt % 40 + 10 > 20) {
            gl.glTranslatef(0f, 0.8f, 0f);
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, 'J');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, 'J');
            draw_handD(gl, glu, 'W');
            draw_handI(gl, glu, 'W');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
        } else if (tecla == 'J' && mvt % 40 + 10 <= 20) {
            gl.glTranslatef(0f, 0.0f, 0f);
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Aria se agacha con movimientos----------------------------------------------------------------------------Tecla M
        } else if (tecla == 'M' && mvt % 40 + 10 > 20) {
            gl.glTranslatef(0f, -0.3f, 0f);
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, 'J');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, 'J');
            draw_handD(gl, glu, 'W');
            draw_handI(gl, glu, 'W');
            draw_legsD(gl, glu, 'M', true);
            draw_legsI(gl, glu, 'M', true);
        } else if (tecla == 'M' && mvt % 40 + 10 <= 20) {
            gl.glTranslatef(0f, 0.0f, 0f);
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Aria rota como spinner-------------------------------------------------------------------------------------------Tecla R
        } else if (tecla == 'R') {
            gl.glRotatef(mvt * 10, 0f, 1f, 0f);
            draw_head(gl, glu, 'J');
            draw_face(gl, glu, 'R');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, 'W');
            draw_handI(gl, glu, 'W');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Aria es golpeada por pelota------------------------------------------------------------------------------------Tecla C
        } else if (tecla == 'C') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            colision = (float) (colision - 0.1);
            dibujaPelota(gl, glu, colision);
            //Rotacion en X--------------------------------------------------------------------------------------------------------Tecla 1
        } else if (tecla == '1') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            gl.glRotatef(40f, 1f, 0f, 0f);
            draw_body(gl, glut, ' ');
            gl.glRotatef(-40f, 1f, 0f, 0f);
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Rotacion en Y--------------------------------------------------------------------------------------------------------Tecla 2
        } else if (tecla == '2') {
            draw_head(gl, glu, ' ');
            gl.glRotatef(40f, 0f, 1f, 0f);
            draw_face(gl, glu, ' ');
            gl.glRotatef(-40f, 0f, 1f, 0f);
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Rotacion en Z--------------------------------------------------------------------------------------------------------Tecla 3
        } else if (tecla == '3') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            gl.glRotatef(40f, 0f, 0f, 1f);
            draw_body(gl, glut, ' ');
            gl.glRotatef(-40f, 0f, 0f, 1f);
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Refleccion en X-----------------------------------------------------------------------------------------------------Tecla 4
        } else if (tecla == '4') {
            draw_head(gl, glu, ' ');
            gl.glRotatef(180, 0f, 1f, 0f);
            draw_face(gl, glu, ' ');
            gl.glRotatef(-180, 0f, 1f, 0f);
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Refleccion en Y-----------------------------------------------------------------------------------------------------Tecla 5
        } else if (tecla == '5') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            gl.glRotatef(180, 0f, 0f, 1f);
            draw_body(gl, glut, ' ');
            gl.glRotatef(-180, 0f, 0f, 1f);
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Refleccion en Z-----------------------------------------------------------------------------------------------------Tecla 6
        } else if (tecla == '6') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            gl.glTranslatef(0.1f, 0f, 0f);
            draw_body(gl, glut, ' ');
            gl.glTranslatef(-0.1f, 0f, 0f);
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            //Traslacion-------------------------------------------------------------------------------------------------------------Tecla 7
        } else if (tecla == '7') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            gl.glTranslatef(-0.3f, -0.2f, 0f);
            draw_hat(gl, glu, ' ');
            gl.glTranslatef(0.3f, -0.2f, 0f);
            //Escalacion------------------------------------------------------------------------------------------------------------Tecla 8
        } else if (tecla == '8') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
            gl.glScalef(0.5f, 0.5f, 0.5f);
            draw_hat(gl, glu, ' ');
            gl.glScalef(2f, 2f, 2f);
            //Original----------------------------------------------------------------------------------------------------------------Tecla O
        } else if (tecla == 'O') {
            draw_head(gl, glu, ' ');
            draw_face(gl, glu, ' ');
            draw_body(gl, glut, ' ');
            draw_hat(gl, glu, ' ');
            draw_handD(gl, glu, ' ');
            draw_handI(gl, glu, ' ');
            draw_legsD(gl, glu, ' ', true);
            draw_legsI(gl, glu, ' ', true);
        }

        mvt++;
    }

    //Metodos que dibujan las partes del cuerpo de Aria
    public void draw_head(GL gl, GLU glu, char c) {
        //Cabeza de Aria
        set_skin_material(gl);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 1.2f, 0.0f);
        glu.gluSphere(q, 0.35f, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void draw_body(GL gl, GLUT glut, char c) {
        //Cuerpo de Aria
        set_blue_material(gl);

        gl.glPushMatrix();
        //glut.glutSolidCone(1.0f, 1.0f, SLICES, STACKS);
        gl.glRotatef(-90.0f, 2.0f, 0f, 0f);
        gl.glTranslatef(0.0f, 0.0f, -0.3f);
        glut.glutSolidCone(0.6f, 1.5f, 10, 5);
        glut.glutSolidCone(0.6f, 0.0f, 10, 5);
        gl.glPopMatrix();
    }

    public void draw_face(GL gl, GLU glu, char c) {
        //Ojos de aria
        if (colision < 0.5) {
            //ojo izquierdo
            set_black_material(gl);

            gl.glBegin(GL.GL_POLYGON);
            for (int i = -1; i < 359; i++) {
                float y = (float) ((0.07) * Math.sin(i) + 1.3);//alto
                float x = (float) ((0.06) * Math.cos(i) + -0.1);//ancho
                gl.glVertex3d(x, y, 0.35f);

            }
            gl.glEnd();

            //ojo derecho
            gl.glBegin(GL.GL_POLYGON);
            for (int i = -1; i < 359; i++) {
                float y = (float) ((0.07) * Math.sin(i) + 1.3); //alto
                float x = (float) ((0.06) * Math.cos(i) + 0.1); //ancho
                gl.glVertex3d(x, y, 0.35f);
            }
            gl.glEnd();

            //Boca de Aria
            set_black_material(gl);
            gl.glBegin(GL.GL_POLYGON);
            for (int j = -1; j < 359; j++) {
                float y1 = (float) ((0.1) * Math.sin(j) + 1.12);//alto
                float x1 = (float) ((0.1) * Math.cos(j) + 0.0);//ancho
                gl.glVertex3d(x1, y1, 0.35f);
            }
            gl.glEnd();
        } else {
            switch (c) {
                case 'W'://---------------------------------------------------------------------Opcion para cuando esta caminando
                    //pupila izquierdo
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.02) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.04) * Math.cos(i) + -0.1); //ancho
                        gl.glVertex3d(x, y, 0.36f);
                    }
                    gl.glEnd();
                    //pupila derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.02) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.04) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.36f);
                    }
                    gl.glEnd();

                    //ojo izquierdo
                    set_blue_material(gl);

                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.3);//alto
                        float x = (float) ((0.06) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.35f);

                    }
                    gl.glEnd();

                    //ojo derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.06) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.35f);
                    }
                    gl.glEnd();

                    //Boca de Aria
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int j = -1; j < 359; j++) {
                        float y1 = (float) ((0.05) * Math.sin(j) + 1.12);//alto
                        float x1 = (float) ((0.1) * Math.cos(j) + 0.0);//ancho
                        gl.glVertex3d(x1, y1, 0.35f);
                    }
                    gl.glEnd();
                    break;
                case 'J': //-------------------------------------------------------------------------------Opcion para cuando Aria salta
                    //pupila izquierdo
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.06) * Math.sin(i) + 1.4);//alto
                        float x = (float) ((0.05) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.34f);
                    }
                    gl.glEnd();
                    //pupila derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.06) * Math.sin(i) + 1.4); //alto
                        float x = (float) ((0.05) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.34f);
                    }
                    gl.glEnd();

                    //ojo izquierdo
                    set_blue_material(gl);

                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.4);//alto
                        float x = (float) ((0.06) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.33f);

                    }
                    gl.glEnd();

                    //ojo derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.4); //alto
                        float x = (float) ((0.06) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.33f);
                    }
                    gl.glEnd();

                    //Boca de Aria
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int j = -1; j < 359; j++) {
                        float y1 = (float) ((0.05) * Math.sin(j) + 1.22);//alto
                        float x1 = (float) ((0.1) * Math.cos(j) + 0.0);//ancho
                        gl.glVertex3d(x1, y1, 0.35f);
                    }
                    gl.glEnd();
                    break;
                case 'R': //------------------------------------------Opcion para cuando rota como spinner
                    //pupila izquierdo
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.04) * Math.sin(i) + 1.3);//alto
                        float x = (float) ((0.01) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.36f);
                    }
                    gl.glEnd();
                    //pupila derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.06) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.03) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.36f);
                    }
                    gl.glEnd();

                    //ojo izquierdo
                    set_blue_material(gl);

                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.3);//alto
                        float x = (float) ((0.06) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.35f);

                    }
                    gl.glEnd();

                    //ojo derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.06) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.35f);
                    }
                    gl.glEnd();

                    //Boca de Aria
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int j = -1; j < 359; j++) {
                        float y1 = (float) ((0.05) * Math.sin(j) + 1.12);//alto
                        float x1 = (float) ((0.3) * Math.cos(j) + 0.0);//ancho
                        gl.glVertex3d(x1, y1, 0.35f);
                    }
                    gl.glEnd();

                    gl.glBegin(GL.GL_POLYGON);
                    for (int j = -1; j < 359; j++) {
                        float y1 = (float) ((0.05) * Math.sin(j) + 1);//alto
                        float x1 = (float) ((0.1) * Math.cos(j) + 0.0);//ancho
                        gl.glVertex3d(x1, y1, 0.35f);
                    }
                    gl.glEnd();
                    break;
                case ' ': //---------------------------------------------------------------------------Opcion para cuando esta estatica
                    //pupila izquierdo
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.06) * Math.sin(i) + 1.3);//alto
                        float x = (float) ((0.03) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.36f);
                    }
                    gl.glEnd();
                    //pupila derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.06) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.03) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.36f);
                    }
                    gl.glEnd();

                    //ojo izquierdo
                    set_blue_material(gl);

                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.3);//alto
                        float x = (float) ((0.06) * Math.cos(i) + -0.1);//ancho
                        gl.glVertex3d(x, y, 0.35f);

                    }
                    gl.glEnd();

                    //ojo derecho
                    gl.glBegin(GL.GL_POLYGON);
                    for (int i = -1; i < 359; i++) {
                        float y = (float) ((0.07) * Math.sin(i) + 1.3); //alto
                        float x = (float) ((0.06) * Math.cos(i) + 0.1); //ancho
                        gl.glVertex3d(x, y, 0.35f);
                    }
                    gl.glEnd();

                    //Boca de Aria
                    set_black_material(gl);
                    gl.glBegin(GL.GL_POLYGON);
                    for (int j = -1; j < 359; j++) {
                        float y1 = (float) ((0.05) * Math.sin(j) + 1.12);//alto
                        float x1 = (float) ((0.1) * Math.cos(j) + 0.0);//ancho
                        gl.glVertex3d(x1, y1, 0.35f);
                    }
                    gl.glEnd();
                    break;
                default:
                    break;
            }
        }

    }

    private void dibujaPelota(GL gl, GLU glu, float co) {
        set_black_material(gl);
        if (co > 0.5) {
            gl.glPushMatrix();
            gl.glTranslatef(co + 0f, 0.5f, 0.1f);
            glu.gluSphere(q, 0.08f * 2, SLICES, STACKS);
            gl.glPopMatrix();
        }
    }

    public void draw_hat(GL gl, GLU glu, char c) {

        if (c == 'J') {//------------------------------------------------------------Opcion para cuando Aria salta
            //Contorno del sombrero
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 1.4f, 0.0f);
            gl.glRotatef(110.0f, -10.0f, 1.0f, 0.0f);
            glu.gluCylinder(q, 0.6f, 0.6f, 0.05f, 32, 32); //Grosor del sombrero
            gl.glPopMatrix();

            //Punta del sombrero
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 1.45f, 0.0f);
            gl.glRotatef(110.0f, -10.0f, 1.0f, 0.0f);
            glu.gluCylinder(q, 0.6f, 0.0f, 0.1f, 32, 32); //Tapa superior
            set_blue_material(gl);
            glu.gluCylinder(q, 0.35f, 0.0f, 0.6f, 32, 32); //Cono del sombrero
            gl.glPopMatrix();

            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 1.4f, 0.0f);
            gl.glRotatef(110.0f, -10.0f, 1.0f, 0.0f);
            glu.gluCylinder(q, 0.6f, 0.0f, 0.1f, 32, 32); //Tapa inferior
            gl.glPopMatrix();
        } else if (c == ' ') {//-----------------------------------------Opcion para cuando Aria esta normal
            //Contorno del sombrero
            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 1.4f, 0.0f);
            gl.glRotatef(90.0f, -10.0f, 1.0f, 0.0f);
            glu.gluCylinder(q, 0.6f, 0.6f, 0.05f, 32, 32); //Grosor del sombrero
            gl.glPopMatrix();

            //Punta del sombrero
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 1.45f, 0.0f);
            gl.glRotatef(90.0f, -10.0f, 1.0f, 0.0f);
            glu.gluCylinder(q, 0.6f, 0.0f, 0.1f, 32, 32); //Tapa superior
            set_blue_material(gl);
            glu.gluCylinder(q, 0.35f, 0.0f, 0.6f, 32, 32); //Cono del sombrero
            gl.glPopMatrix();

            set_black_material(gl);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 1.4f, 0.0f);
            gl.glRotatef(90.0f, -10.0f, 1.0f, 0.0f);
            glu.gluCylinder(q, 0.6f, 0.0f, 0.1f, 32, 32); //Tapa inferior
            gl.glPopMatrix();
        }
    }

    public void draw_handD(GL gl, GLU glu, char c) {
        //Brazo derecho de Aria

        if (c == 'W') {
            set_skin_material(gl);

            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.7f, 0.0f);
            gl.glRotatef(90f, 0f, 1f, 0f);
            gl.glRotatef(-30f, 1f, 50f, 0f);
            glu.gluCylinder(q, 0.1f, 0.1f, 0.4f, SLICES, STACKS);
            set_blue_material(gl);
            glu.gluSphere(q, 0.12f, SLICES, STACKS); //Hombro
            gl.glTranslatef(0.0f, 0.0f, 0.4f);
            set_skin_material(gl);
            glu.gluSphere(q, 0.1f, SLICES, STACKS);
            gl.glPopMatrix();
        } else if (c == ' ') {
            set_skin_material(gl);

            gl.glPushMatrix();
            gl.glTranslatef(0.25f, 0.7f, 0.0f);
            gl.glRotatef(90f, 0f, 1f, 0f);
            gl.glRotatef(30f, 1f, 0f, 0f);
            glu.gluCylinder(q, 0.1f, 0.1f, 0.4f, SLICES, STACKS);
            set_blue_material(gl);
            glu.gluSphere(q, 0.12f, SLICES, STACKS); //Hombro
            gl.glTranslatef(0.0f, 0.0f, 0.4f);
            set_skin_material(gl);
            glu.gluSphere(q, 0.1f, SLICES, STACKS);
            gl.glPopMatrix();
        }

    }

    public void draw_handI(GL gl, GLU glu, char c) {
        //Brazo izquierdo de Aria

        if (c == 'W') {
            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.7f, 0.0f);
            gl.glRotatef(-90f, 0f, 1f, 0f);
            gl.glRotatef(-30f, 1f, -50f, 0f);
            glu.gluCylinder(q, 0.1f, 0.1f, 0.4f, SLICES, STACKS);
            set_blue_material(gl);
            glu.gluSphere(q, 0.12f, SLICES, STACKS); //Hombro
            gl.glTranslatef(0.0f, 0.0f, 0.4f);
            set_skin_material(gl);
            glu.gluSphere(q, 0.1f, SLICES, STACKS);
            gl.glPopMatrix();
        } else if (c == ' ') {
            set_skin_material(gl);

            gl.glPushMatrix();
            gl.glTranslatef(-0.25f, 0.7f, 0.0f);
            gl.glRotatef(-90f, 0f, 1f, 0f);
            gl.glRotatef(30f, 1f, 0f, 0f);
            glu.gluCylinder(q, 0.1f, 0.1f, 0.4f, SLICES, STACKS);
            set_blue_material(gl);
            glu.gluSphere(q, 0.12f, SLICES, STACKS); //Hombro
            gl.glTranslatef(0.0f, 0.0f, 0.4f);
            set_skin_material(gl);
            glu.gluSphere(q, 0.1f, SLICES, STACKS);
            gl.glPopMatrix();
        }

    }

    public void draw_legsD(GL gl, GLU glu, char c, boolean left) {
        //Pierna derecha de Aria
        switch (c) {
            case 'W':
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.25f, -0.1f, 0.0f);
                gl.glRotatef(90f, 0f, 1f, 0f);
                gl.glRotatef(90f, 1f, 0f, 0f);
                glu.gluCylinder(q, 0.1f, 0.1f, 0.3f, SLICES, STACKS);
                gl.glTranslatef(0.0f, 0.0f, 0.3f);
                glu.gluSphere(q, 0.1f, SLICES, STACKS);
                gl.glPopMatrix();
                break;
            case 'M':
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.25f, -0.1f, 0.0f);
                gl.glRotatef(90f, 0f, 1f, 0f);
                gl.glRotatef(90f, 1f, 0f, 0f);
                glu.gluCylinder(q, 0.1f, 0.1f, 0.3f, SLICES, STACKS);
                gl.glTranslatef(0.0f, 0.0f, 0.3f);
                glu.gluSphere(q, 0.1f, SLICES, STACKS);
                gl.glPopMatrix();
                break;
            case ' ':
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(0.25f, -0.2f, 0.0f);
                gl.glRotatef(90f, 0f, 1f, 0f);
                gl.glRotatef(90f, 1f, 0f, 0f);
                glu.gluCylinder(q, 0.1f, 0.1f, 0.3f, SLICES, STACKS);
                gl.glTranslatef(0.0f, 0.0f, 0.3f);
                glu.gluSphere(q, 0.1f, SLICES, STACKS);
                gl.glPopMatrix();
                break;
            default:
                break;
        }

    }

    public void draw_legsI(GL gl, GLU glu, char c, boolean left) {
        //Pierna izquierda de Aria
        switch (c) {
            case 'W':
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(-0.25f, -0.1f, 0.0f);
                gl.glRotatef(90f, 0f, 1f, 0f);
                gl.glRotatef(90f, 1f, 0f, 0f);
                glu.gluCylinder(q, 0.1f, 0.1f, 0.3f, SLICES, STACKS);
                gl.glTranslatef(0.0f, 0.0f, 0.3f);
                glu.gluSphere(q, 0.1f, SLICES, STACKS);
                gl.glPopMatrix();
                break;
            case 'M':
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(-0.25f, -0.1f, 0.0f);
                gl.glRotatef(90f, 0f, 1f, 0f);
                gl.glRotatef(90f, 1f, 0f, 0f);
                glu.gluCylinder(q, 0.1f, 0.1f, 0.3f, SLICES, STACKS);
                gl.glTranslatef(0.0f, 0.0f, 0.3f);
                glu.gluSphere(q, 0.1f, SLICES, STACKS);
                gl.glPopMatrix();
                break;
            case ' ':
                set_black_material(gl);
                gl.glPushMatrix();
                gl.glTranslatef(-0.25f, -0.2f, 0.0f);
                gl.glRotatef(90f, 0f, 1f, 0f);
                gl.glRotatef(90f, 1f, 0f, 0f);
                glu.gluCylinder(q, 0.1f, 0.1f, 0.3f, SLICES, STACKS);
                gl.glTranslatef(0.0f, 0.0f, 0.3f);
                glu.gluSphere(q, 0.1f, SLICES, STACKS);
                gl.glPopMatrix();
                break;
            default:
                break;
        }

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

    public void set_black_material(GL gl) {
        float mat_ambient[]
                = {
                    0.0f, 0.0f, 0.0f, 1.0f
                };
        float mat_diffuse[]
                = {
                    1.0f, 1.0f, 1.0f, 1.0f
//            0.0f, 0.0f, 0.0f, 1.0f
                };
        float mat_specular[]
                = {
                    //            0.0f, 0.0f, 0.0f, 1.0f
                    0.8f, 0.8f, 0.8f, 1.0f
                };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }
}
