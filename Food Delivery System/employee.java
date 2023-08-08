import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
class EMPLOYEE extends javax.swing.JFrame {
    Connection Con=null;
    PreparedStatement pst=null;

    ResultSet rs=null;
    public EMPLOYEE() {
        initComponents();
        setTitle("EMPLOYEE");
        DefaultTableModel DM=(DefaultTableModel)jTable1.getModel();
        DM.setRowCount(0);

        try{
            String sql="select * from EMPLOYEE";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_database","root","");
            JOptionPane.showMessageDialog(null,"connected");
            String colhead[]={"EMPID","FNAME","LNAME","DOB","EMAILID","PWD","ADDRESS","PHONENO","GENDER","SALARY"};
            DM.setColumnIdentifiers(colhead);
            Statement stmt=Con.createStatement();
            rs=stmt.executeQuery(sql);
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            while(rs.next()){
                Object[] obj=new Object[cols];
                for(int i=0;i<cols;i++)
                {
                    obj[i]=rs.getObject(i+1);

                }
                DM.addRow(obj);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null," not connected");
        }
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jTable1.setRowHeight(30);
        for(int i=0;i< jTable1.getColumnCount();i++)
        {
            jTable1.getColumnModel().getColumn(i).setPreferredWidth(jTable1.getWidth() / jTable1.getColumnCount());
        }
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        jButton1.setText("EMPLOYEE DATA");

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(349, 349, 349)
                                                .addComponent(jButton2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(313, 313, 313)
                                                .addComponent(jButton1)))
                                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(7, 7, 7))
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
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new f6().setVisible(true);
        this.dispose();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUSTOMER().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
