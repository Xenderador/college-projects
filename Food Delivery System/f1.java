import java.sql.*;
import javax.swing.*;

class f1 extends javax.swing.JFrame {
    Connection Con=null;
    PreparedStatement pst=null;

    ResultSet rs=null;

    /**
     * Creates new form f1
     */
    public f1() {
        initComponents();
        setTitle("online food delivery");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_database","root","");
            JOptionPane.showMessageDialog(null,"connected");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null," not connected");
        }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(945, 0, 0, 0);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nihal Mohan\\Documents\\GitHub\\Online-Food-Delivery\\images\\ofd.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 0, 790, 557);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 204));
        jButton1.setText("proceed");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(690, 460, 111, 50);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new f4().setVisible(true);
        this.dispose();
    }
    public static void main(String args[])
    {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(f1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new f1().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
}
