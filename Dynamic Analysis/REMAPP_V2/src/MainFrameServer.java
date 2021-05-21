
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
        usBtn = new javax.swing.JButton();
        intentBtn = new javax.swing.JButton();
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
        mainLabelTitle.setText("Welcome to REMAPP Tool !");

        usBtn.setText("About Us");
        usBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usBtnActionPerformed(evt);
            }
        });

        intentBtn.setText("Intents' Analysis");
        intentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intentBtnActionPerformed(evt);
            }
        });

        combinedBtn.setText("Fragments and Activity Analysis");
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
                        .addGap(100, 100, 100)
                        .addComponent(mainLabelTitle)))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(usBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(intentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(activityBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fragmentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(combinedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(intentBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usBtn)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void activityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityBtnActionPerformed
        new ActivityJFrame().setVisible(true);
    }//GEN-LAST:event_activityBtnActionPerformed

    private void fragmentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fragmentsBtnActionPerformed
        new FragmentsJFrame().setVisible(true);
    }//GEN-LAST:event_fragmentsBtnActionPerformed

    private void usBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usBtnActionPerformed
        
    }//GEN-LAST:event_usBtnActionPerformed

    private void intentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intentBtnActionPerformed
        
    }//GEN-LAST:event_intentBtnActionPerformed

    private void combinedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combinedBtnActionPerformed
        new CombinedAnalysisJFrame().setVisible(true);
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
    private javax.swing.JButton intentBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel mainLabelTitle;
    private javax.swing.JButton usBtn;
    // End of variables declaration//GEN-END:variables
}
