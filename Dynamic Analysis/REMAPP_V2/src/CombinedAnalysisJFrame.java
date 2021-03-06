
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franciscoserrao
 */
public class CombinedAnalysisJFrame extends javax.swing.JFrame {
    static Socket socket;
    static ServerSocket serverSocket;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;
    static Boolean socketBool;
    private Integer serverPort = 5500;

    
    
    public CombinedAnalysisJFrame() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actImage = new javax.swing.JLabel();
        fragsLabelFrame = new javax.swing.JLabel();
        actTitleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        frameTextArea = new javax.swing.JTextArea();
        fragLabelText = new javax.swing.JLabel();
        actLabelText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actImage.setBackground(new java.awt.Color(255, 255, 255));
        actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actDefault.png"))); // NOI18N

        fragsLabelFrame.setBackground(new java.awt.Color(255, 255, 255));
        fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fragsDefault.png"))); // NOI18N

        actTitleLabel.setFont(new java.awt.Font("Apple Color Emoji", 0, 17)); // NOI18N
        actTitleLabel.setText("Combined Activities and Fragments' Lifecycle Analysis");

        frameTextArea.setColumns(20);
        frameTextArea.setFont(new java.awt.Font("Apple Braille", 0, 15)); // NOI18N
        frameTextArea.setRows(5);
        frameTextArea.setText("Start exploring the app in order to display log...\n");
        jScrollPane1.setViewportView(frameTextArea);

        fragLabelText.setBackground(new java.awt.Color(255, 204, 255));
        fragLabelText.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        fragLabelText.setText("Fragments being used");

        actLabelText.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        actLabelText.setText("Activities being used");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(actTitleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(actImage, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(actLabelText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fragLabelText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fragsLabelFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(actTitleLabel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(actImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fragsLabelFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fragLabelText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actLabelText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CombinedAnalysisJFrame().setVisible(true);
            }
        });
        new CombinedAnalysisJFrame().startThread();
    }
    
    
    public void startThread() throws InterruptedException{
        try{
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server Port: " + serverPort);
            System.out.println("Socket successfully established");
            Thread t = new Thread(() -> {
                while(true){
                    try {
                        socket = serverSocket.accept();
                        isr = new InputStreamReader(socket.getInputStream());
                        br = new BufferedReader(isr);
                        message = br.readLine();
                        System.out.println(message);
                        if(message.contains("Activity")){
                            actLabelText.setText(message.substring(8));
                            frameTextArea.setText(frameTextArea.getText()  + "\n"+ "Info: " + message);
                            scrollDown();
                            activityImages();
                        }
                        else if(message.contains("Fragment")){
                            fragLabelText.setText(message.substring(8));

                            if(message.contains("onCreate()")){
                                frameTextArea.setText(frameTextArea.getText() + "\n" + "Info: " + message);
                                scrollDown();
                            }
                            fragmentImages();
                        }
                    } 
                    catch (IOException ex) {
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
    
    
    public void fragmentImages() {
        if(message.contains("onCreate()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnCreate.png")));
        } 
        if(message.contains("onViewCreated()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnViewCreated.png")));
        }
         if(message.contains("onCreateView()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnCreateView.png")));
        }
         if(message.contains("onViewStateRestored()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnViewStateRestored.png")));
        }
         if(message.contains("onStart()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnStart.png")));
        }
        if(message.contains("onStop()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnStop.png")));
        }
        if(message.contains("onResume()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnResume.png")));
        }
        if(message.contains("onPause()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnPause.png")));
        }
        if(message.contains("onSaveInstance")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnSaveInstance.png")));
        }
        if(message.contains("onDestroyView()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnDestroyView.png")));
        }
        if(message.contains("onDestroy()")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnDestroy.png")));
        }
        try{        
            Thread.sleep(1500);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
   
    
    public void scrollDown(){
        frameTextArea.setCaretPosition(frameTextArea.getText().length());
    }
    
    
    public void activityImages() {
         
        if(message.contains("onCreate")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/createAct.png")));
        }
         if(message.contains("onStart")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/startAct.png")));
        }
        if(message.contains("onStop")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/stopAct.png")));
        }
        if(message.contains("onResume")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/resumeAct.png")));
        }
        if(message.contains("onPause")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/pauseAct.png")));
        }
        if(message.contains("onRestart")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/restartAct.png")));
        }
        if(message.contains("onDestroy")){
            actImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/destroyAct.png")));
        }
        try{        
            Thread.sleep(1500);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JLabel actImage;
    private static javax.swing.JLabel actLabelText;
    private javax.swing.JLabel actTitleLabel;
    private static javax.swing.JLabel fragLabelText;
    static javax.swing.JLabel fragsLabelFrame;
    private static javax.swing.JTextArea frameTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
