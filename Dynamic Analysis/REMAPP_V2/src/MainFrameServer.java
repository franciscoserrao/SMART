
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author franciscoserrao
 */
public class MainFrameServer extends javax.swing.JFrame {

    public MainFrameServer() {
        initComponents();
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        activityBtn = new javax.swing.JButton();
        fragmentsBtn = new javax.swing.JButton();
        mainLabelTitle = new javax.swing.JLabel();
        combinedBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        activityBtn.setText("Activities' analysis");
        activityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityBtnActionPerformed(evt);
            }
        });

        fragmentsBtn.setText("Fragments' analysis");
        fragmentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fragmentsBtnActionPerformed(evt);
            }
        });

        mainLabelTitle.setFont(new java.awt.Font("Apple Color Emoji", 0, 17)); // NOI18N
        mainLabelTitle.setText("Welcome to SEMANTIC Desktop Tool !");

        combinedBtn.setText("Combined Analysis");
        combinedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combinedBtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/feup.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(mainLabelTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(activityBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fragmentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(combinedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(mainLabelTitle)
                .addGap(18, 18, 18)
                .addComponent(activityBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fragmentsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combinedBtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityBtnActionPerformed
        ActivityJFrame n = new ActivityJFrame();
        n.setVisible(true);
        
        try {
            n.startThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_activityBtnActionPerformed

    private void fragmentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fragmentsBtnActionPerformed
        FragmentsJFrame fragments = new FragmentsJFrame();
        fragments.setVisible(true);
        
        try {
            fragments.startThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_fragmentsBtnActionPerformed

    private void combinedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combinedBtnActionPerformed
        CombinedAnalysisJFrame combined = new CombinedAnalysisJFrame();
        combined.setVisible(true);
        
        try {
            combined.startThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_combinedBtnActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activityBtn;
    private javax.swing.JButton combinedBtn;
    private javax.swing.JButton fragmentsBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mainLabelTitle;
    // End of variables declaration//GEN-END:variables
}
