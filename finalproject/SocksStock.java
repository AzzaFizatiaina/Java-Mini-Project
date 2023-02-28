import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.io.IOException;
 
public class SocksStock extends javax.swing.JFrame {

    /**
     * Creates new form SocksStock
     */
    public SocksStock() {
        initComponents();
    }

 
    @SuppressWarnings("unchecked")
    // initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        image1 = new javax.swing.ImageIcon();
        jLabel2 = new javax.swing.JLabel();
        image2 = new javax.swing.ImageIcon();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        
        setTitle("Stock !");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("IMAZMIM'S Sockx !");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        image1 = new ImageIcon(getClass().getResource("socks.jpg"));
        jLabel2 = new JLabel(image1);
        jLabel2.setPreferredSize(new Dimension(200, 100));
        jLabel2.setSize(new Dimension(image1.getIconWidth(), image1.getIconHeight()));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 40, -1, -1));
        
        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("All Stock Available atm :)))"+"\n1. Fruit Design"+"\n2. Love Design"+
        "\n3. Animal Design"+"\n4. Fluffy Design"+"\n5. Short Animal Design"+
        "\n6. Polkadot Design"+"\n7. Flower Design"+"\n8. Pastel Design"+"\n9. Korea Design");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 270, 100));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 260));
  
        pack();
        setLocationRelativeTo(null);
    }// initComponents
  
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SocksStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SocksStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SocksStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SocksStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SocksStock().setVisible(true);
               
            }
        });
    }

    // Variables declaration 
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.ImageIcon image1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.ImageIcon image2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration
}
