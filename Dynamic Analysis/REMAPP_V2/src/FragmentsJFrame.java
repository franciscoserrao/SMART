
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author franciscoserrao
 */
public class FragmentsJFrame extends javax.swing.JFrame {
    static Socket socket;
    static ServerSocket serverSocket;
    static InputStreamReader isr;
    static BufferedReader br;
    static String message;
    static Boolean socketBool;
    private Integer serverPort;
 
    
    public FragmentsJFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actTitleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fragsTextArea = new javax.swing.JTextArea();
        fragsLabelFrame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actTitleLabel.setFont(new java.awt.Font("Apple Color Emoji", 0, 17)); // NOI18N
        actTitleLabel.setText("Fragments' Lifecycle Analysis");

        fragsTextArea.setColumns(20);
        fragsTextArea.setFont(new java.awt.Font("Apple Braille", 0, 14)); // NOI18N
        fragsTextArea.setRows(5);
        fragsTextArea.setText("Start exploring the app in order to display log...\n");
        jScrollPane1.setViewportView(fragsTextArea);

        fragsLabelFrame.setBackground(new java.awt.Color(255, 255, 255));
        fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fragsDefault.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(fragsLabelFrame)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(actTitleLabel)
                .addGap(450, 450, 450))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(actTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(fragsLabelFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FragmentsJFrame().setVisible(true);
            }
        });
        new FragmentsJFrame().socketCreation();
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
                    fragsTextArea.setText(fragsTextArea.getText() + "\n" + "Info: " + message);
                    scrollDown();
                    fragmentImages();
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }  
    
    public void scrollDown(){
        fragsTextArea.setCaretPosition(fragsTextArea.getText().length());
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
         if(message.contains("onViewStateRestored")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnViewStateRestored.png")));
        }
         if(message.contains("onStart")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnStart.png")));
        }
        if(message.contains("onStop")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnStop.png")));
        }
        if(message.contains("onResume")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnResume.png")));
        }
        if(message.contains("onPause")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnPause.png")));
        }
        if(message.contains("onSaveInstance")){
            fragsLabelFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/fragsOnSaveInstance.png")));
        }
        if(message.contains("onDestroyView")){
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
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actTitleLabel;
    static javax.swing.JLabel fragsLabelFrame;
    private static javax.swing.JTextArea fragsTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
