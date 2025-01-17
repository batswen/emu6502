package com.batswen.emu6502;

import com.batswen.emu6502.cpu.CPU;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

public class Win extends javax.swing.JFrame {
    private static final Color[] COLORS = { 
        Color.BLACK, Color.BLUE, Color.GREEN, Color.CYAN,
        Color.RED, Color.MAGENTA, new Color(170, 85, 0), Color.LIGHT_GRAY,
        Color.DARK_GRAY, new Color(85, 85, 255), new Color(85, 255, 255),
        new Color(255, 85, 85), new Color(255, 85, 255), Color.YELLOW, Color.WHITE};
    private static final int PXWIDTH = 8, PXHEIGHT = 8;
    private static final int XOFFSET = 8, YOFFSET = 8;
    private final CPU cpu;
    
    public Win(CPU cpu) {
        this.cpu = cpu;
        initComponents();
    }
    
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {  // invoke via repaint()
            super.paintComponent(g); 
            setBackground(Color.CYAN);

            Graphics2D g2d = (Graphics2D) g;
            for (int y = 0; y < 25; y++) {
                for (int x = 0; x < 40; x++) {
                    g2d.setColor(getColor(x + 40 * y));
                    g2d.fillRect(x * PXWIDTH + XOFFSET, y * PXHEIGHT + YOFFSET, PXWIDTH, PXHEIGHT);
                }
            }
        }
    }
    private Color getColor(int addr) {
        return COLORS[cpu.peekByte(addr + 0x0400) % COLORS.length];
    }
    private Color getRandomColor() {
        int rnd = new Random().nextInt(COLORS.length);
        return COLORS[rnd];
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new DrawCanvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
