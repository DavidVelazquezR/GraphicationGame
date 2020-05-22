package pantallas;

import Aria.SelectAria;
import Aria.levelOne;
import Aria.lvl1;
import Hygel.levelTwo;
import Flogat.SelectFlog;
import Hygel.SelectMage;
import Hygel.lvl2;
import Terluks.SelectJF;
import com.sun.opengl.util.Animator;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame {
    int xy, xx;//pantalla barra
    boolean musicf=true;
    private int lvl = 0;
    Clip ambient=null;
    Clip clip=null;
    public int personaje = 0;
    
    private Animator anma;// se encarga de mover el mono
    private Animator animaria;
    private Animator anim;
    private Animator anmin;
    
    static SelectMage mage = new SelectMage();///tu mono
    static SelectAria aria = new SelectAria();
    static SelectFlog flog;
    static SelectJF jf = new SelectJF();
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        jPOverlay.setBackground(new Color(223, 227, 238, 150));
        jPOverlayCre.setBackground(new Color(223, 227, 238, 150));
        jpventanas.add(jlp);
        setpane(jpprincipal);
        if (musicf) {
            ambientacion("03");
        }
    }
    public Inicio(int f) {
        initComponents();
        this.setLocationRelativeTo(null);
        jPOverlay.setBackground(new Color(223, 227, 238, 150));
        jPOverlayCre.setBackground(new Color(223, 227, 238, 150));
        jpventanas.add(jlp);
        setpane(jpselectlv);
        if (musicf) {
            ambientacion("03");
        }
    }
    
    public void ChargeMono() {
        canar.addGLEventListener(aria);////////ari
        anma=new Animator(canar);
        setLocationRelativeTo(null);
        setVisible(true);
        anma.start();
        
        canma.addGLEventListener(mage);////////mag
        animaria=new Animator(canma);
        setLocationRelativeTo(null);
        setVisible(true);
        animaria.start();
        
        flog = new SelectFlog();
        glpenemigo2areli.addGLEventListener(flog);///flogat
        anim = new Animator(glpenemigo2areli);
        setLocationRelativeTo(null);
        setVisible(true);
        anim.start();
        
        if(lvl==4){
            glpenemigo1alan.addGLEventListener(jf);//cangrejo
        }else{
             glpenemigo1alan.addGLEventListener(flog);//are
        }
        anmin = new Animator(glpenemigo1alan);
            setLocationRelativeTo(null);
            setVisible(true);
            anmin.start();
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpbarrasup = new javax.swing.JPanel();
        jLClose1 = new javax.swing.JLabel();
        jLMinimize1 = new javax.swing.JLabel();
        jpventanas = new javax.swing.JPanel();
        jlp = new javax.swing.JLayeredPane();
        jpprincipal = new javax.swing.JPanel();
        jPOverlay = new javax.swing.JPanel();
        jLVersion = new javax.swing.JLabel();
        jLCredits = new javax.swing.JLabel();
        jLInstructions = new javax.swing.JLabel();
        jLStart = new javax.swing.JLabel();
        jLTitulo1 = new javax.swing.JLabel();
        jlconfig = new javax.swing.JLabel();
        jlbackground = new javax.swing.JLabel();
        jjpcredits = new javax.swing.JPanel();
        jPOverlayCre = new javax.swing.JPanel();
        jLTitulo2 = new javax.swing.JLabel();
        jLStart2 = new javax.swing.JLabel();
        jLInstructions2 = new javax.swing.JLabel();
        jLCredits1 = new javax.swing.JLabel();
        jLCredits3 = new javax.swing.JLabel();
        jLTitulo4 = new javax.swing.JLabel();
        jLStart3 = new javax.swing.JLabel();
        jlinicio = new javax.swing.JLabel();
        jlbackcred = new javax.swing.JLabel();
        jpconfig = new javax.swing.JPanel();
        jPOverlayCre1 = new javax.swing.JPanel();
        jLTitulo3 = new javax.swing.JLabel();
        jlpausa = new javax.swing.JLabel();
        jLTitulo5 = new javax.swing.JLabel();
        jloff = new javax.swing.JLabel();
        jlinicio2 = new javax.swing.JLabel();
        jlon = new javax.swing.JLabel();
        jlsaltar = new javax.swing.JLabel();
        jlcader1 = new javax.swing.JLabel();
        jlcamizq1 = new javax.swing.JLabel();
        jpselectlv = new javax.swing.JPanel();
        jOselectlvl = new javax.swing.JPanel();
        jllvl1 = new javax.swing.JLabel();
        jllv2 = new javax.swing.JLabel();
        jltitulo = new javax.swing.JLabel();
        jllv4 = new javax.swing.JLabel();
        jllv3 = new javax.swing.JLabel();
        jlsig = new javax.swing.JLabel();
        jlbackgr = new javax.swing.JLabel();
        jpselectcharacter = new javax.swing.JPanel();
        jlsptit = new javax.swing.JLabel();
        jlspenem = new javax.swing.JLabel();
        jlp1 = new javax.swing.JLabel();
        jlp2 = new javax.swing.JLabel();
        jliniciar = new javax.swing.JLabel();
        jpp1 = new javax.swing.JPanel();
        canar = new javax.media.opengl.GLCanvas();
        jpp2 = new javax.swing.JPanel();
        canma = new javax.media.opengl.GLCanvas();
        jpp3 = new javax.swing.JPanel();
        glpenemigo2areli = new javax.media.opengl.GLJPanel();
        glpenemigo1alan = new javax.media.opengl.GLJPanel();
        jlbacksp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpbarrasup.setBackground(java.awt.Color.white);
        jpbarrasup.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpbarrasupMouseDragged(evt);
            }
        });
        jpbarrasup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpbarrasupMousePressed(evt);
            }
        });
        jpbarrasup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-minimizar-la-ventana-32.png"))); // NOI18N
        jLClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLClose1MouseClicked(evt);
            }
        });
        jpbarrasup.add(jLClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 5, 30, 30));

        jLMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cerrar-ventana-32.png"))); // NOI18N
        jLMinimize1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLMinimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLMinimize1MouseClicked(evt);
            }
        });
        jpbarrasup.add(jLMinimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 5, 30, 30));

        jpventanas.setPreferredSize(new java.awt.Dimension(820, 533));

        jpprincipal.setMaximumSize(new java.awt.Dimension(820, 533));
        jpprincipal.setMinimumSize(new java.awt.Dimension(820, 533));
        jpprincipal.setPreferredSize(new java.awt.Dimension(820, 533));
        jpprincipal.setLayout(null);

        jPOverlay.setMaximumSize(new java.awt.Dimension(820, 533));
        jPOverlay.setMinimumSize(new java.awt.Dimension(820, 533));
        jPOverlay.setPreferredSize(new java.awt.Dimension(820, 533));
        jPOverlay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLVersion.setText("Early Version: 3.0");
        jPOverlay.add(jLVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, -1));

        jLCredits.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLCredits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCredits.setText("Creditos");
        jLCredits.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLCredits.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLCredits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCreditsMouseClicked(evt);
            }
        });
        jPOverlay.add(jLCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, -1, -1));

        jLInstructions.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLInstructions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInstructions.setText("Ayuda");
        jLInstructions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLInstructions.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLInstructions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLInstructionsMouseClicked(evt);
            }
        });
        jPOverlay.add(jLInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jLStart.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLStart.setText("Start game");
        jLStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLStartMouseClicked(evt);
            }
        });
        jPOverlay.add(jLStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLTitulo1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo1.setText("Aerix");
        jLTitulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlay.add(jLTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jlconfig.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jlconfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlconfig.setText("Configuración");
        jlconfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlconfig.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlconfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlconfigMouseClicked(evt);
            }
        });
        jPOverlay.add(jlconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        jpprincipal.add(jPOverlay);
        jPOverlay.setBounds(0, 0, 820, 533);

        jlbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        jpprincipal.add(jlbackground);
        jlbackground.setBounds(0, 0, 820, 533);

        jjpcredits.setPreferredSize(new java.awt.Dimension(820, 533));
        jjpcredits.setLayout(null);

        jPOverlayCre.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTitulo2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo2.setText("Developers");
        jLTitulo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 67, 541, -1));

        jLStart2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLStart2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLStart2.setText("Carlos López Palma");
        jLStart2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLStart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 127, 541, -1));

        jLInstructions2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLInstructions2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInstructions2.setText("Areli Lara Silva");
        jLInstructions2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLInstructions2, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 169, 541, -1));

        jLCredits1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLCredits1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCredits1.setText("Alan Alexis Velázquez Romero");
        jLCredits1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLCredits1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 211, 541, -1));

        jLCredits3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLCredits3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCredits3.setText("David Velázquez Ramírez");
        jLCredits3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLCredits3, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 253, 541, -1));

        jLTitulo4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo4.setText("Teacher");
        jLTitulo4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 325, 541, -1));

        jLStart3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLStart3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLStart3.setText("Elizabeth Pulido Alba");
        jLStart3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre.add(jLStart3, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 373, 541, -1));

        jlinicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlinicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlinicio.setText("Inicio");
        jlinicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlinicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlinicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlinicioMouseClicked(evt);
            }
        });
        jPOverlayCre.add(jlinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 129, -1));

        jjpcredits.add(jPOverlayCre);
        jPOverlayCre.setBounds(0, 0, 820, 533);

        jlbackcred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/credits.jpg"))); // NOI18N
        jlbackcred.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlbackcred.setAlignmentY(0.0F);
        jlbackcred.setPreferredSize(new java.awt.Dimension(820, 846));
        jjpcredits.add(jlbackcred);
        jlbackcred.setBounds(0, 0, 820, 533);

        jpconfig.setBackground(new java.awt.Color(51, 51, 51));
        jpconfig.setMaximumSize(new java.awt.Dimension(820, 533));
        jpconfig.setMinimumSize(new java.awt.Dimension(820, 533));
        jpconfig.setPreferredSize(new java.awt.Dimension(820, 533));
        jpconfig.setLayout(null);

        jPOverlayCre1.setBackground(new java.awt.Color(51, 51, 51));
        jPOverlayCre1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTitulo3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLTitulo3.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo3.setText("Controles");
        jLTitulo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre1.add(jLTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 541, -1));

        jlpausa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlpausa.setForeground(new java.awt.Color(255, 255, 255));
        jlpausa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpausa.setText("Pausa   -   ESC");
        jlpausa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre1.add(jlpausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 260, -1));

        jLTitulo5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLTitulo5.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo5.setText("Audio");
        jLTitulo5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre1.add(jLTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 541, -1));

        jloff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jloff.setForeground(new java.awt.Color(153, 153, 153));
        jloff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jloff.setText("OFF");
        jloff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jloff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jloff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jloffMouseClicked(evt);
            }
        });
        jPOverlayCre1.add(jloff, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 60, -1));

        jlinicio2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlinicio2.setForeground(new java.awt.Color(255, 255, 255));
        jlinicio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlinicio2.setText("Inicio");
        jlinicio2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlinicio2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlinicio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlinicio2MouseClicked(evt);
            }
        });
        jPOverlayCre1.add(jlinicio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 129, -1));

        jlon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlon.setForeground(new java.awt.Color(102, 0, 0));
        jlon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlon.setText("ON");
        jlon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlonMouseClicked(evt);
            }
        });
        jPOverlayCre1.add(jlon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 60, -1));

        jlsaltar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlsaltar.setForeground(new java.awt.Color(255, 255, 255));
        jlsaltar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlsaltar.setText("Saltar   -   W");
        jlsaltar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre1.add(jlsaltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 260, -1));

        jlcader1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlcader1.setForeground(new java.awt.Color(255, 255, 255));
        jlcader1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlcader1.setText("Caminar a derecha   -   D");
        jlcader1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre1.add(jlcader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 260, -1));

        jlcamizq1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlcamizq1.setForeground(new java.awt.Color(255, 255, 255));
        jlcamizq1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlcamizq1.setText("Caminar a izquierda   -   A");
        jlcamizq1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPOverlayCre1.add(jlcamizq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 260, -1));

        jpconfig.add(jPOverlayCre1);
        jPOverlayCre1.setBounds(0, 0, 820, 533);

        jpselectlv.setAlignmentX(0.0F);
        jpselectlv.setAlignmentY(0.0F);
        jpselectlv.setPreferredSize(new java.awt.Dimension(820, 533));
        jpselectlv.setLayout(null);

        jOselectlvl.setAlignmentX(0.0F);
        jOselectlvl.setAlignmentY(0.0F);
        jOselectlvl.setMaximumSize(new java.awt.Dimension(820, 533));
        jOselectlvl.setMinimumSize(new java.awt.Dimension(820, 533));
        jOselectlvl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jllvl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lvl1.png"))); // NOI18N
        jllvl1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jllvl1.setPreferredSize(new java.awt.Dimension(70, 70));
        jllvl1.setRequestFocusEnabled(false);
        jllvl1.setVerifyInputWhenFocusTarget(false);
        jllvl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jllvl1MouseClicked(evt);
            }
        });
        jOselectlvl.add(jllvl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 110, 110));

        jllv2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lvl2.png"))); // NOI18N
        jllv2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jllv2.setPreferredSize(new java.awt.Dimension(70, 70));
        jllv2.setRequestFocusEnabled(false);
        jllv2.setVerifyInputWhenFocusTarget(false);
        jllv2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jllv2MouseClicked(evt);
            }
        });
        jOselectlvl.add(jllv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 110, 110));

        jltitulo.setBackground(new java.awt.Color(153, 0, 51));
        jltitulo.setFont(new java.awt.Font("Sitka Small", 3, 36)); // NOI18N
        jltitulo.setForeground(new java.awt.Color(0, 51, 102));
        jltitulo.setText("Nivel");
        jOselectlvl.add(jltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 27, 110, 50));

        jllv4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lvl4.png"))); // NOI18N
        jllv4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jllv4.setPreferredSize(new java.awt.Dimension(70, 70));
        jllv4.setRequestFocusEnabled(false);
        jllv4.setVerifyInputWhenFocusTarget(false);
        jllv4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jllv4MouseClicked(evt);
            }
        });
        jOselectlvl.add(jllv4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 110, 110));

        jllv3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lvl3.png"))); // NOI18N
        jllv3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jllv3.setPreferredSize(new java.awt.Dimension(70, 70));
        jllv3.setRequestFocusEnabled(false);
        jllv3.setVerifyInputWhenFocusTarget(false);
        jllv3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jllv3MouseClicked(evt);
            }
        });
        jOselectlvl.add(jllv3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 110, 110));

        jlsig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sig.png"))); // NOI18N
        jlsig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlsigMouseClicked(evt);
            }
        });
        jOselectlvl.add(jlsig, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, -1, -1));

        jlbackgr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoselectlvl.jpg"))); // NOI18N
        jlbackgr.setMaximumSize(new java.awt.Dimension(820, 600));
        jlbackgr.setMinimumSize(new java.awt.Dimension(820, 600));
        jOselectlvl.add(jlbackgr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 533));

        jpselectlv.add(jOselectlvl);
        jOselectlvl.setBounds(0, 0, 820, 533);

        jpselectcharacter.setLayout(null);

        jlsptit.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jlsptit.setForeground(new java.awt.Color(255, 255, 255));
        jlsptit.setText("Selecciona tu personaje");
        jpselectcharacter.add(jlsptit);
        jlsptit.setBounds(270, 20, 290, 50);

        jlspenem.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jlspenem.setForeground(new java.awt.Color(255, 255, 255));
        jlspenem.setText("Enemigos");
        jpselectcharacter.add(jlspenem);
        jlspenem.setBounds(100, 318, 120, 40);

        jlp1.setFont(new java.awt.Font("Harlow Solid Italic", 2, 36)); // NOI18N
        jlp1.setForeground(new java.awt.Color(255, 255, 255));
        jlp1.setText("Aria");
        jpselectcharacter.add(jlp1);
        jlp1.setBounds(190, 240, 80, 50);

        jlp2.setFont(new java.awt.Font("Harlow Solid Italic", 2, 36)); // NOI18N
        jlp2.setForeground(new java.awt.Color(255, 255, 255));
        jlp2.setText("Hygel");
        jpselectcharacter.add(jlp2);
        jlp2.setBounds(510, 240, 100, 50);

        jliniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iniciar.png"))); // NOI18N
        jliniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jliniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jliniciarMouseClicked(evt);
            }
        });
        jpselectcharacter.add(jliniciar);
        jliniciar.setBounds(620, 420, 151, 65);

        jpp1.setBackground(new java.awt.Color(202, 230, 255));
        jpp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpp1MouseExited(evt);
            }
        });

        canar.setForeground(new java.awt.Color(255, 255, 255));
        canar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                canarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jpp1Layout = new javax.swing.GroupLayout(jpp1);
        jpp1.setLayout(jpp1Layout);
        jpp1Layout.setHorizontalGroup(
            jpp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpp1Layout.setVerticalGroup(
            jpp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpselectcharacter.add(jpp1);
        jpp1.setBounds(150, 77, 170, 170);

        jpp2.setBackground(new java.awt.Color(202, 230, 255));
        jpp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpp2MouseExited(evt);
            }
        });

        canma.setForeground(new java.awt.Color(255, 255, 255));
        canma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canmaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                canmaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jpp2Layout = new javax.swing.GroupLayout(jpp2);
        jpp2.setLayout(jpp2Layout);
        jpp2Layout.setHorizontalGroup(
            jpp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpp2Layout.setVerticalGroup(
            jpp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpselectcharacter.add(jpp2);
        jpp2.setBounds(480, 77, 170, 170);

        jpp3.setBackground(new java.awt.Color(0, 0, 102));
        jpp3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpp3.setMaximumSize(new java.awt.Dimension(280, 140));

        glpenemigo2areli.setForeground(new java.awt.Color(255, 255, 255));
        glpenemigo2areli.setPreferredSize(new java.awt.Dimension(120, 120));

        javax.swing.GroupLayout glpenemigo2areliLayout = new javax.swing.GroupLayout(glpenemigo2areli);
        glpenemigo2areli.setLayout(glpenemigo2areliLayout);
        glpenemigo2areliLayout.setHorizontalGroup(
            glpenemigo2areliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        glpenemigo2areliLayout.setVerticalGroup(
            glpenemigo2areliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        glpenemigo1alan.setForeground(new java.awt.Color(255, 255, 255));
        glpenemigo1alan.setPreferredSize(new java.awt.Dimension(130, 130));

        javax.swing.GroupLayout glpenemigo1alanLayout = new javax.swing.GroupLayout(glpenemigo1alan);
        glpenemigo1alan.setLayout(glpenemigo1alanLayout);
        glpenemigo1alanLayout.setHorizontalGroup(
            glpenemigo1alanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        glpenemigo1alanLayout.setVerticalGroup(
            glpenemigo1alanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpp3Layout = new javax.swing.GroupLayout(jpp3);
        jpp3.setLayout(jpp3Layout);
        jpp3Layout.setHorizontalGroup(
            jpp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpp3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(glpenemigo2areli, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(glpenemigo1alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jpp3Layout.setVerticalGroup(
            jpp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpp3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(glpenemigo2areli, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(glpenemigo1alan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jpselectcharacter.add(jpp3);
        jpp3.setBounds(100, 355, 280, 150);

        jlbacksp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoselectlvl.jpg"))); // NOI18N
        jlbacksp.setPreferredSize(new java.awt.Dimension(820, 600));
        jpselectcharacter.add(jlbacksp);
        jlbacksp.setBounds(0, 0, 820, 533);

        jlp.setLayer(jpprincipal, javax.swing.JLayeredPane.POPUP_LAYER);
        jlp.setLayer(jjpcredits, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlp.setLayer(jpconfig, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlp.setLayer(jpselectlv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlp.setLayer(jpselectcharacter, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpLayout = new javax.swing.GroupLayout(jlp);
        jlp.setLayout(jlpLayout);
        jlpLayout.setHorizontalGroup(
            jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addComponent(jjpcredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpselectlv, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpselectcharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpconfig, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jlpLayout.setVerticalGroup(
            jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addComponent(jjpcredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpselectlv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpselectcharacter, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jlpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jlpLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jpconfig, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpventanasLayout = new javax.swing.GroupLayout(jpventanas);
        jpventanas.setLayout(jpventanasLayout);
        jpventanasLayout.setHorizontalGroup(
            jpventanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpventanasLayout.createSequentialGroup()
                .addComponent(jlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jpventanasLayout.setVerticalGroup(
            jpventanasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlp)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpbarrasup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpventanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpbarrasup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpventanas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClose1MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLClose1MouseClicked

    private void jLMinimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMinimize1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLMinimize1MouseClicked

    private void jpbarrasupMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpbarrasupMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jpbarrasupMouseDragged

    private void jpbarrasupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpbarrasupMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jpbarrasupMousePressed

    private void jLCreditsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCreditsMouseClicked
        setpane(jjpcredits);
    }//GEN-LAST:event_jLCreditsMouseClicked

    private void jLInstructionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInstructionsMouseClicked
        //setpane();
    }//GEN-LAST:event_jLInstructionsMouseClicked

    private void jLStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLStartMouseClicked
        setpane(jpselectlv);
    }//GEN-LAST:event_jLStartMouseClicked

    private void jlinicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlinicioMouseClicked
        setpane(jpprincipal);
    }//GEN-LAST:event_jlinicioMouseClicked

    private void jllvl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jllvl1MouseClicked
        lvl=1;
        SetIcon("lvl1s", jllvl1);
        SetIcon("lvl2", jllv2);
        SetIcon("lvl3", jllv3);
        SetIcon("lvl4", jllv4);
        Sound("select");
    }//GEN-LAST:event_jllvl1MouseClicked

    private void jllv2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jllv2MouseClicked
        lvl=2;
        SetIcon("lvl2s", jllv2);
        SetIcon("lvl1", jllvl1);
        SetIcon("lvl3", jllv3);
        SetIcon("lvl4", jllv4);
        Sound("select");
    }//GEN-LAST:event_jllv2MouseClicked

    private void jllv4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jllv4MouseClicked
        lvl=4;
        SetIcon("lvl4s", jllv4);
        SetIcon("lvl2", jllv2);
        SetIcon("lvl3", jllv3);
        SetIcon("lvl1", jllvl1);
        Sound("select");
    }//GEN-LAST:event_jllv4MouseClicked

    private void jllv3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jllv3MouseClicked
        lvl=3;
        SetIcon("lvl3s", jllv3);
        SetIcon("lvl2", jllv2);
        SetIcon("lvl1", jllvl1);
        SetIcon("lvl4", jllv4);
        Sound("select");
    }//GEN-LAST:event_jllv3MouseClicked

    private void jlsigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlsigMouseClicked
        if (lvl==0) {
            Sound("nod");
        }else{
            //Sound("sig");
            ChargeMono();
            setpane(jpselectcharacter);
        }
    }//GEN-LAST:event_jlsigMouseClicked

    private void jpp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpp1MouseEntered
        float[] ar = Color.RGBtoHSB(225, 236, 116,null);
        jpp1.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
    }//GEN-LAST:event_jpp1MouseEntered

    private void jpp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpp1MouseExited
        if(personaje==0||personaje==2){
            float[] ar = Color.RGBtoHSB(202,230,255,null);
            jpp1.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
        }else{
            float[] ar = Color.RGBtoHSB(223, 212, 63,null);
            jpp1.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
        }
    }//GEN-LAST:event_jpp1MouseExited

    private void jpp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpp2MouseEntered
        float[] ar = Color.RGBtoHSB(225, 236, 116,null);
        jpp2.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
    }//GEN-LAST:event_jpp2MouseEntered

    private void jpp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpp2MouseExited
        if(personaje==0||personaje==1){
            float[] ar = Color.RGBtoHSB(202,230,255,null);
            jpp2.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
        }else{
            float[] ar = Color.RGBtoHSB(223, 212, 63,null);
            jpp2.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
        }
    }//GEN-LAST:event_jpp2MouseExited

    private void canmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canmaMouseClicked
        float[] ar = Color.RGBtoHSB(223, 212, 63,null);
        jpp2.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
        float[] ar2 = Color.RGBtoHSB(202,230,255,null);
        jpp1.setBackground(Color.getHSBColor(ar2[0],ar2[1],ar2[2]));
        personaje=2;
        if (clip!=null) {
            clip.stop();
        }
        reproducir("select");
    }//GEN-LAST:event_canmaMouseClicked

    private void canmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canmaMouseEntered
        float[] ar = Color.RGBtoHSB(225, 236, 116,null);
        jpp2.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
    }//GEN-LAST:event_canmaMouseEntered

    private void canarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canarMouseClicked
        float[] ar = Color.RGBtoHSB(223, 212, 63,null);
        jpp1.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
        float[] ar2 = Color.RGBtoHSB(202,230,255,null);
        jpp2.setBackground(Color.getHSBColor(ar2[0],ar2[1],ar2[2]));
        personaje=1;
        if (clip!=null) {
            clip.stop();
        }
        reproducir("select");
    }//GEN-LAST:event_canarMouseClicked

    private void canarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canarMouseEntered
        float[] ar = Color.RGBtoHSB(225, 236, 116,null);
        jpp1.setBackground(Color.getHSBColor(ar[0],ar[1],ar[2]));
    }//GEN-LAST:event_canarMouseEntered

    private void jliniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jliniciarMouseClicked
        if (personaje==0) {
            reproducir("nod");
        }else{
            reproducir("inicia");
            System.out.println("lvl:"+lvl);
            System.out.println("personaje:"+personaje);
            switch(lvl){
                case 1:
                    if(ambient.isRunning()) ambient.stop();
                    lvl1 nv1 = new lvl1(personaje);
                    break;
                case 2:
                    if(ambient.isRunning()) ambient.stop();
                    lvl2 nv2 = new lvl2(personaje);
                    
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            this.dispose();
        }
    }//GEN-LAST:event_jliniciarMouseClicked

    private void jlconfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlconfigMouseClicked
        setpane(jpconfig);
    }//GEN-LAST:event_jlconfigMouseClicked

    private void jlinicio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlinicio2MouseClicked
        setpane(jpprincipal);
    }//GEN-LAST:event_jlinicio2MouseClicked

    private void jlonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlonMouseClicked
        if (musicf==false) {
            ambientacion("03");
            jloff.setForeground(new Color(153,153,153));
            jlon.setForeground(new Color(102,0,0));
            musicf=true;
        }
    }//GEN-LAST:event_jlonMouseClicked

    private void jloffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jloffMouseClicked
        if (musicf==true) {
            ambient.stop();
            jloff.setForeground(new Color(102,0,0));
            jlon.setForeground(new Color(153,153,153));
            musicf=false;
        }
    }//GEN-LAST:event_jloffMouseClicked
    
    void setpane(JPanel a){
        jlp.removeAll();
        a.setLocation(0, 0);
        a.setSize(820, 533);
        jlp.add(a);
    }
    
    public void SetIcon(String ic, JLabel j){
        ImageIcon icon = new ImageIcon("src\\img\\"+ic+".PNG");
        j.setIcon(icon);
    }
    
    public void Sound(String a){
        if (clip!=null) {
            clip.stop();
        }
        reproducir(a);
    }
    
    public void reproducir(String ef) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("src/sonidos/"+ef+".wav")));
            clip.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void ambientacion(String ef) {
        try {
            ambient = AudioSystem.getClip();
            ambient.open(AudioSystem.getAudioInputStream(new File("src/sonidos/"+ef+".wav")));
            ambient.loop(1000);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println(e.getMessage());
        } catch (UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.media.opengl.GLCanvas canar;
    private javax.media.opengl.GLCanvas canma;
    private javax.media.opengl.GLJPanel glpenemigo1alan;
    private javax.media.opengl.GLJPanel glpenemigo2areli;
    private javax.swing.JLabel jLClose1;
    private javax.swing.JLabel jLCredits;
    private javax.swing.JLabel jLCredits1;
    private javax.swing.JLabel jLCredits3;
    private javax.swing.JLabel jLInstructions;
    private javax.swing.JLabel jLInstructions2;
    private javax.swing.JLabel jLMinimize1;
    private javax.swing.JLabel jLStart;
    private javax.swing.JLabel jLStart2;
    private javax.swing.JLabel jLStart3;
    private javax.swing.JLabel jLTitulo1;
    private javax.swing.JLabel jLTitulo2;
    private javax.swing.JLabel jLTitulo3;
    private javax.swing.JLabel jLTitulo4;
    private javax.swing.JLabel jLTitulo5;
    private javax.swing.JLabel jLVersion;
    private javax.swing.JPanel jOselectlvl;
    private javax.swing.JPanel jPOverlay;
    private javax.swing.JPanel jPOverlayCre;
    private javax.swing.JPanel jPOverlayCre1;
    private javax.swing.JPanel jjpcredits;
    private javax.swing.JLabel jlbackcred;
    private javax.swing.JLabel jlbackgr;
    private javax.swing.JLabel jlbackground;
    private javax.swing.JLabel jlbacksp;
    private javax.swing.JLabel jlcader1;
    private javax.swing.JLabel jlcamizq1;
    private javax.swing.JLabel jlconfig;
    private javax.swing.JLabel jliniciar;
    private javax.swing.JLabel jlinicio;
    private javax.swing.JLabel jlinicio2;
    private javax.swing.JLabel jllv2;
    private javax.swing.JLabel jllv3;
    private javax.swing.JLabel jllv4;
    private javax.swing.JLabel jllvl1;
    private javax.swing.JLabel jloff;
    private javax.swing.JLabel jlon;
    private javax.swing.JLayeredPane jlp;
    private javax.swing.JLabel jlp1;
    private javax.swing.JLabel jlp2;
    private javax.swing.JLabel jlpausa;
    private javax.swing.JLabel jlsaltar;
    private javax.swing.JLabel jlsig;
    private javax.swing.JLabel jlspenem;
    private javax.swing.JLabel jlsptit;
    private javax.swing.JLabel jltitulo;
    private javax.swing.JPanel jpbarrasup;
    private javax.swing.JPanel jpconfig;
    private javax.swing.JPanel jpp1;
    private javax.swing.JPanel jpp2;
    private javax.swing.JPanel jpp3;
    private javax.swing.JPanel jpprincipal;
    private javax.swing.JPanel jpselectcharacter;
    private javax.swing.JPanel jpselectlv;
    private javax.swing.JPanel jpventanas;
    // End of variables declaration//GEN-END:variables
}
