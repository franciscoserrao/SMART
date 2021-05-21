
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author franciscoserrao
 */
public class Intent_BroadJFrame extends javax.swing.JFrame {
    static Socket socket;
    static ServerSocket serverSocket;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;
    static Boolean socketBool;
    private Integer serverPort;
 
   
    public Intent_BroadJFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        intentTextArea = new javax.swing.JTextArea();
        titleLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        intentTextArea.setColumns(20);
        intentTextArea.setRows(5);
        intentTextArea.setText("Start analysis to display log of intents ");
        jScrollPane1.setViewportView(intentTextArea);

        titleLabel.setFont(new java.awt.Font("Apple Color Emoji", 0, 17)); // NOI18N
        titleLabel.setText("Intents / Broadcast Services' Analysis");

        backBtn.setText("Go Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        startBtn.setText("Start Analysis");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn)
                        .addGap(18, 18, 18)
                        .addComponent(startBtn)
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startBtnActionPerformed

   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intent_BroadJFrame().setVisible(true);
            }
         });
        new Intent_BroadJFrame().socketCreation();
    }
     
    
    public void socketCreation(){
        System.out.println("------------------------------");
        System.out.println("        Creating socket       ");
        serverPort = 5500;
        
        try{
            serverSocket = new ServerSocket(5500);
            System.out.println("Server Port: " + serverPort);
            System.out.println("Socket successfully established");
            while(true){
                socket = serverSocket.accept();
                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr); 
                message = br.readLine(); 
                System.out.println(message);
                if(message.contains("Fragment")){
                    intentTextArea.setText(intentTextArea.getText() + "\n" +  message);
                    scrollDown();
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }  
    
     public void scrollDown(){
        intentTextArea.setCaretPosition(intentTextArea.getText().length());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextArea intentTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
