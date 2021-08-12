
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class JDBC extends javax.swing.JFrame {

    Connection datacon;
    PreparedStatement prestm;
    ResultSet result;

    public JDBC() {
        initComponents();
        load();

    }

    public void load() {
        int J_table;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            datacon = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo", "root", "");

            prestm = datacon.prepareStatement("select * from students");
            result = prestm.executeQuery();

            ResultSetMetaData rsmd = result.getMetaData();
            J_table = rsmd.getColumnCount();
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.setRowCount(0);

            while (result.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= J_table; i++) {

                    v.add(result.getString("id"));
                    v.add(result.getString("fname"));
                    v.add(result.getString("course"));
                    v.add(result.getString("fee"));
                }
                dtm.addRow(v);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stname = new javax.swing.JTextField();
        stcourse = new javax.swing.JTextField();
        btninsert = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        stfee = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Database");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 120, 35));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Course");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, 35));

        stname.setBackground(new java.awt.Color(204, 204, 255));
        stname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stname.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(stname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 200, 35));

        stcourse.setBackground(new java.awt.Color(204, 204, 255));
        stcourse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stcourse.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(stcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 200, 35));

        btninsert.setBackground(new java.awt.Color(0, 153, 153));
        btninsert.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btninsert.setForeground(new java.awt.Color(255, 255, 255));
        btninsert.setText("Save");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });
        jPanel1.add(btninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 100, 35));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Student Information");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 380, -1));

        btnupdate.setBackground(new java.awt.Color(0, 153, 153));
        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Edit");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 100, 35));

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 100, 35));

        table.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Course", "Fee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 660, 160));

        stfee.setBackground(new java.awt.Color(204, 204, 255));
        stfee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        stfee.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(stfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 200, 35));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Fee");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 120, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        try {
            DefaultTableModel update = (DefaultTableModel) table.getModel();

            int selectedindex = table.getSelectedRow();

            stname.setText(update.getValueAt(selectedindex, 1).toString());
            stcourse.setText(update.getValueAt(selectedindex, 2).toString());
            stfee.setText(update.getValueAt(selectedindex, 3).toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        DefaultTableModel update = (DefaultTableModel) table.getModel();
        int selectedindex = table.getSelectedRow();

        int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

        int showresult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record ? ", "Warring", JOptionPane.YES_NO_OPTION);

        if (showresult == JOptionPane.YES_NO_OPTION) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                datacon = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo", "root", "");
                prestm = datacon.prepareStatement("delete from students where ID =? ");

                prestm.setInt(1, id);
                prestm.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data has been Deleted");
                load();

                stname.setText("");
                stcourse.setText("");
                stfee.setText("");
                stname.requestFocus();

            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
 
        DefaultTableModel update = (DefaultTableModel) table.getModel();
        int selectedindex = table.getSelectedRow();

        int id = Integer.parseInt(update.getValueAt(selectedindex, 0).toString());

         String name, course, fee;

        name = stname.getText();
        course = stcourse.getText();
        fee = stfee.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            datacon = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo", "root", "");

            prestm = datacon.prepareStatement("update students set fname=?,course=?,fee=? where id =? ");
            prestm.setString(1, name);
            prestm.setString(2, course);
            prestm.setString(3, fee);
            prestm.setInt(4, id);
            prestm.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data has been Updated");

            stname.setText("");
            stcourse.setText("");
            stfee.setText("");
            stname.requestFocus();

            load();

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed

        String id, name, course, fee;

        name = stname.getText();
        course = stcourse.getText();
        fee = stfee.getText();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            datacon = DriverManager.getConnection("jdbc:mysql://localhost/studentinfo", "root", "");

            prestm = datacon.prepareStatement("Insert into students(fname,course,fee)values(?,?,?) ");

            prestm.setString(1, name);
            prestm.setString(2, course);
            prestm.setString(3, fee);
            prestm.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data has been Inserted");

            stname.setText("");
            stcourse.setText("");
            stfee.setText("");
            stname.requestFocus();

            load();

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(this, ex);

        }

    }//GEN-LAST:event_btninsertActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new JDBC().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField stcourse;
    private javax.swing.JTextField stfee;
    private javax.swing.JTextField stname;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
