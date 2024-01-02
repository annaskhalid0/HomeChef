
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author IT Garage
 */
public class Admin_reciepecreate extends javax.swing.JFrame {

    Connection conn = null ;
    PreparedStatement pst;
    ResultSet rs;
    public Admin_reciepecreate() {
        initComponents();
        conn = DBC.ConnecrDB();
        reciepeid();
        reciepetable();
    }

    public void reciepeid()
    {
         try {
             Statement s = conn.createStatement();
             rs = s.executeQuery("select MAX(ID) from reciepes");
             rs.next();
             rs.getString("MAX(ID)");
             
             if(rs.getString("MAX(ID)") == null)
             {
                 rid_admin.setText("R001");
             }
             else
             {
                 long rno = Long.parseLong(rs.getString("MAX(ID)").substring(2, rs.getString("MAX(ID)").length()));
                 rno++;
                 rid_admin.setText("R"+ String.format("%03d", rno));
             }   
             
         } catch (SQLException ex) {
             Logger.getLogger(Admin_reciepecreate.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
    public void reciepetable()
    {
        try {
             JTableHeader head = rtable_admin.getTableHeader();
             Font font = new Font("Arial",Font.BOLD,15);
             head.setFont(font);
             rtable_admin.setBackground(Color.WHITE);
             rtable_admin.setFont(new Font("Tahoma",Font.BOLD,12));
             rtable_admin.setForeground(Color.RED);            
            
             pst = conn.prepareStatement("select * from reciepes");
             rs = pst.executeQuery();
             ResultSetMetaData rsmd = rs.getMetaData();
             int r;
             r = rsmd.getColumnCount();
             
             DefaultTableModel rtab = (DefaultTableModel) rtable_admin.getModel();
             rtab.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v = new Vector();
                 
                 for(int i=1 ; i<=r ; i++)
                 {
                 v.add(rs.getString("ID"));
                 v.add(rs.getString("RECIEPENAME"));
                 v.add(rs.getString("RECIEPETYPE"));
                 v.add(rs.getString("COOKTIME"));
                 v.add(rs.getString("ITEMS"));
                 v.add(rs.getString("METHOD"));
                 }
                 
                 rtab.addRow(v);
                 
             }
 
         } catch (SQLException ex) {
             Logger.getLogger(Admin_reciepecreate.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rname_admin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rtype_admin = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ctime_admin = new javax.swing.JComboBox<>();
        add_reciepe = new javax.swing.JButton();
        update_reciepe = new javax.swing.JButton();
        delete_reciepe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        method_admin = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rtable_admin = new javax.swing.JTable();
        home_login = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        items_admin = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        rid_admin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));

        jLabel1.setBackground(new java.awt.Color(102, 0, 0));
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\IT Garage\\Downloads\\icons8-chef-100.png")); // NOI18N

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Reciepe Name");

        rname_admin.setBackground(new java.awt.Color(255, 255, 255));
        rname_admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rname_admin.setForeground(new java.awt.Color(102, 0, 0));
        rname_admin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Reciepe Type");

        rtype_admin.setBackground(new java.awt.Color(255, 255, 255));
        rtype_admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rtype_admin.setForeground(new java.awt.Color(102, 0, 0));
        rtype_admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desi", "Fast Food", "BBQ", "Drinks", "Desserts" }));
        rtype_admin.setBorder(null);

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Cooking Time");

        ctime_admin.setBackground(new java.awt.Color(255, 255, 255));
        ctime_admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctime_admin.setForeground(new java.awt.Color(102, 0, 0));
        ctime_admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "15-30 Mins", "30-60 Mins", "01-02 Hrs", "02-03 Hrs", " " }));
        ctime_admin.setBorder(null);

        add_reciepe.setBackground(new java.awt.Color(255, 255, 255));
        add_reciepe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_reciepe.setForeground(new java.awt.Color(102, 0, 0));
        add_reciepe.setText("ADD");
        add_reciepe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_reciepeActionPerformed(evt);
            }
        });

        update_reciepe.setBackground(new java.awt.Color(255, 255, 255));
        update_reciepe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update_reciepe.setForeground(new java.awt.Color(102, 0, 0));
        update_reciepe.setText("UPDATE");
        update_reciepe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_reciepeActionPerformed(evt);
            }
        });

        delete_reciepe.setBackground(new java.awt.Color(255, 255, 255));
        delete_reciepe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete_reciepe.setForeground(new java.awt.Color(102, 0, 0));
        delete_reciepe.setText("DELETE");
        delete_reciepe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_reciepeActionPerformed(evt);
            }
        });

        method_admin.setBackground(new java.awt.Color(255, 255, 255));
        method_admin.setColumns(20);
        method_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        method_admin.setForeground(new java.awt.Color(0, 51, 51));
        method_admin.setRows(5);
        method_admin.setText("\n");
        method_admin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane2.setViewportView(method_admin);

        jLabel5.setBackground(new java.awt.Color(204, 255, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("INGRIDIENTS");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("METHOD");

        rtable_admin.setBackground(new java.awt.Color(255, 255, 255));
        rtable_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rtable_admin.setForeground(new java.awt.Color(0, 51, 51));
        rtable_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "RECIEPE NAME", "RECIEPE TYPE", "COOKING TIME", "ITEMS", "METHOD"
            }
        ));
        rtable_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rtable_adminMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(rtable_admin);

        home_login.setBackground(new java.awt.Color(255, 255, 255));
        home_login.setIcon(new javax.swing.ImageIcon("C:\\Users\\IT Garage\\Downloads\\icons8-home-38.png")); // NOI18N
        home_login.setBorder(null);
        home_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_loginActionPerformed(evt);
            }
        });

        items_admin.setBackground(new java.awt.Color(255, 255, 255));
        items_admin.setColumns(20);
        items_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        items_admin.setForeground(new java.awt.Color(0, 51, 51));
        items_admin.setRows(5);
        items_admin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane4.setViewportView(items_admin);

        jLabel7.setBackground(new java.awt.Color(204, 255, 204));
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Reciepe ID");

        rid_admin.setBackground(new java.awt.Color(204, 255, 204));
        rid_admin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rid_admin.setForeground(new java.awt.Color(102, 0, 0));
        rid_admin.setText("jLabel8");
        rid_admin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add_reciepe)
                        .addGap(18, 18, 18)
                        .addComponent(update_reciepe)
                        .addGap(18, 18, 18)
                        .addComponent(delete_reciepe))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ctime_admin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(rtype_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rname_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(rid_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(home_login)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(home_login)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rid_admin))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(rname_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rtype_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ctime_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_reciepe)
                            .addComponent(update_reciepe)
                            .addComponent(delete_reciepe)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(99, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_reciepeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_reciepeActionPerformed
        // TODO add your handling code here:
        String rno = rid_admin.getText();
        String reciepe = rname_admin.getText();
        String type = rtype_admin.getSelectedItem().toString();
        String time = ctime_admin.getSelectedItem().toString();
        String items = items_admin.getText();
        String method = method_admin.getText();
        
        try {
             pst = conn.prepareStatement("insert into reciepes (ID,RECIEPENAME,RECIEPETYPE,COOKTIME,ITEMS,METHOD) values (?,?,?,?,?,?) ");
             
             pst.setString(1, rno);
             pst.setString(2, reciepe);
             pst.setString(3, type);
             pst.setString(4, time);
             pst.setString(5, items);
             pst.setString(6, method);
            
             
             pst.executeUpdate();
             
             JOptionPane.showMessageDialog(this, "RECIEPE INSERTED SUCCESSFULY");
             
             reciepeid();
             rname_admin.setText("");
             items_admin.setText("");
             method_admin.setText("");
             rtype_admin.setSelectedIndex(-1);
             ctime_admin.setSelectedIndex(-1);
             rname_admin.requestFocus();
             
             //reciepeid();
             reciepetable();
             
         } catch (SQLException ex) {
             Logger.getLogger(Admin_reciepecreate.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_add_reciepeActionPerformed

    private void update_reciepeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_reciepeActionPerformed
        // TODO add your handling code here:
        String reciepe = rname_admin.getText();
        String type = rtype_admin.getSelectedItem().toString();
        String time = ctime_admin.getSelectedItem().toString();
        String items = items_admin.getText();
        String method = method_admin.getText();
        String rno = rid_admin.getText();
        
        try {
             pst = conn.prepareStatement(" update reciepes set RECIEPENAME = ?, RECIEPETYPE = ?, COOKTIME = ?, ITEMS = ?, METHOD = ? where ID = ? ");
             
             pst.setString(1, reciepe);
             pst.setString(2, type);
             pst.setString(3, time);
             pst.setString(4, items);
             pst.setString(5, method);
             pst.setString(6, rno);
            
             
             pst.executeUpdate();
             
             JOptionPane.showMessageDialog(this, "RECIEPE UPDATED SUCCESSFULY");
             
             reciepeid();
             rname_admin.setText("");
             items_admin.setText("");
             method_admin.setText("");
             rtype_admin.setSelectedIndex(-1);
             ctime_admin.setSelectedIndex(-1);
             rname_admin.requestFocus();
             
             //reciepeid();
             reciepetable();
             add_reciepe.setEnabled(true);
             
         } catch (SQLException ex) {
             Logger.getLogger(Admin_reciepecreate.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_update_reciepeActionPerformed

    private void rtable_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtable_adminMouseClicked
        // TODO add your handling code here:
        DefaultTableModel rtab = (DefaultTableModel)rtable_admin.getModel();
        int SelectIndex = rtable_admin.getSelectedRow();
        
        rid_admin.setText(rtab.getValueAt(SelectIndex, 0).toString());
        rname_admin.setText(rtab.getValueAt(SelectIndex, 1).toString());
        rtype_admin.setSelectedItem(rtab.getValueAt(SelectIndex, 2).toString());
        ctime_admin.setSelectedItem(rtab.getValueAt(SelectIndex, 3).toString());
        items_admin.setText(rtab.getValueAt(SelectIndex, 4).toString());
        method_admin.setText(rtab.getValueAt(SelectIndex, 5).toString());
        
        add_reciepe.setEnabled(false);
    }//GEN-LAST:event_rtable_adminMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void delete_reciepeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_reciepeActionPerformed
        // TODO add your handling code here:
        String rno = rid_admin.getText();
        try {
             pst = conn.prepareStatement(" delete from reciepes where ID = ? ");
             pst.setString(1, rno);
             pst.executeUpdate();
             
             JOptionPane.showMessageDialog(this, "RECIEPE DELETED SUCCESSFULY");
             
             reciepeid();
             rname_admin.setText("");
             items_admin.setText("");
             method_admin.setText("");
             rtype_admin.setSelectedIndex(-1);
             ctime_admin.setSelectedIndex(-1);
             
             //reciepeid();
             reciepetable();
             add_reciepe.setEnabled(true);
             
         } catch (SQLException ex) {
             Logger.getLogger(Admin_reciepecreate.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_delete_reciepeActionPerformed

    private void home_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_loginActionPerformed
        // TODO add your handling code here:
        Admin_main u = new Admin_main();
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_home_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_reciepecreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_reciepecreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_reciepecreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_reciepecreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_reciepecreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_reciepe;
    private javax.swing.JComboBox<String> ctime_admin;
    private javax.swing.JButton delete_reciepe;
    private javax.swing.JButton home_login;
    private javax.swing.JTextArea items_admin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea method_admin;
    private javax.swing.JLabel rid_admin;
    private javax.swing.JTextField rname_admin;
    private javax.swing.JTable rtable_admin;
    private javax.swing.JComboBox<String> rtype_admin;
    private javax.swing.JButton update_reciepe;
    // End of variables declaration//GEN-END:variables
}
