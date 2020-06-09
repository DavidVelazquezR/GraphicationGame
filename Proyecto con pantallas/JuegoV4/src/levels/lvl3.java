package levels;

import Hygel.*;
import com.sun.opengl.util.Animator;

public class lvl3 extends javax.swing.JFrame {
    private Animator anima;
    levelThree n;
    
    public lvl3(int p) {
        initComponents();
        n=new levelThree(p, this);
        glcjuego.addGLEventListener(n);
        anima=new Animator(glcjuego);
        setLocationRelativeTo(null);
        setVisible(true);
        anima.start();
        
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        glcjuego = new javax.media.opengl.GLCanvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(glcjuego, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(glcjuego, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.media.opengl.GLCanvas glcjuego;
    // End of variables declaration//GEN-END:variables
}
