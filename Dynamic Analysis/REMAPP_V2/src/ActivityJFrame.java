
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franciscoserrao
 */
public class ActivityJFrame extends javax.swing.JFrame {
    static Socket socket;
    static ServerSocket serverSocket;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;
    static Boolean socketBool;
    private Integer serverPort = 5500;
    private Boolean startS;
    
    
    public ActivityJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actTitleLabel = new javax.swing.JLabel();
        actLabelImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        actTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actTitleLabel.setFont(new java.awt.Font("Apple Color Emoji", 0, 17)); // NOI18N
        actTitleLabel.setText("Activities' Lifecycle Analysis");

        actLabelImage.setBackground(new java.awt.Color(255, 255, 255));
        actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actDefault.png"))); // NOI18N

        actTextArea.setColumns(20);
        actTextArea.setFont(new java.awt.Font("Apple Braille", 0, 14)); // NOI18N
        actTextArea.setRows(5);
        actTextArea.setText("Start exploring the app in order to display log...\n");
        jScrollPane1.setViewportView(actTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(actTitleLabel)
                .addGap(392, 392, 392))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(actLabelImage)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(actTitleLabel)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(actLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) throws InterruptedException {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivityJFrame().setVisible(true);
               

            }
        });
        new ActivityJFrame().startThread();

    }



    public void startThread() throws InterruptedException{
        try{
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server Port: " + serverPort);
            System.out.println("Socket successfully established");
              Thread t = new Thread(() -> {
                int count = 0;

                while(true){
                    try {
                        socket = serverSocket.accept();
                        isr = new InputStreamReader(socket.getInputStream());
                        br = new BufferedReader(isr);
                        message = br.readLine();
                        System.out.println(message);
                        if(message.contains("Activity")){
                            actTextArea.setText(actTextArea.getText() + "\n" + "Info: " + message);
                            scrollDown();
                            activityImages();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        t.setDaemon(true);
        t.start();
        Thread.currentThread().sleep(1000);

        }   
        catch (IOException ex) {
            ex.printStackTrace();

        }
    }
    
        
    
    public void scrollDown(){
        actTextArea.setCaretPosition(actTextArea.getText().length());
    }
    
    
    public void activityImages() {
         
        if(message.contains("onCreate")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/createAct.png")));
        }
         if(message.contains("onStart")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/startAct.png")));
        }
        if(message.contains("onStop")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/stopAct.png")));
        }
        if(message.contains("onResume")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/resumeAct.png")));
        }
        if(message.contains("onPause")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/pauseAct.png")));
        }
        if(message.contains("onRestart")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/restartAct.png")));
        }
        if(message.contains("onDestroy")){
            actLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/destroyAct.png")));
        }
        try{        
            Thread.sleep(1500);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
   
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JLabel actLabelImage;
    private static javax.swing.JTextArea actTextArea;
    private javax.swing.JLabel actTitleLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
