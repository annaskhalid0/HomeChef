
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
public class User_drinks extends javax.swing.JFrame {

    Connection conn = null ;
    PreparedStatement pst;
    ResultSet rs;
    public User_drinks() {
        initComponents();
        conn = DBC.ConnecrDB();
        showreciepe();
        feedbacktable();
        username();
        rimg();
    }

    
    public void showreciepe()
    {
        try {
            pst = conn.prepareStatement("select RECIEPENAME from reciepes where RECIEPETYPE = 'Drinks' ");
            rs = pst.executeQuery();
            user_drinks.removeAll();
            
            while(rs.next())
            {
                user_drinks.addItem(rs.getString(1));
            }
            user_drinks.setSelectedIndex(-1);
            
        } catch (SQLException ex) {
            Logger.getLogger(User_drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void feedbacktable()
    {
        try {
             JTableHeader head = user_drinkstab.getTableHeader();
             Font font = new Font("Arial",Font.BOLD,20);
             head.setFont(font);
             user_drinkstab.setBackground(Color.WHITE);
             user_drinkstab.setFont(new Font("Consolas",Font.BOLD,15));
             user_drinkstab.setForeground(Color.RED);
            
             pst = conn.prepareStatement("select * from desicomments where RECIEPETYPE='Drinks'");
             rs = pst.executeQuery();
             ResultSetMetaData rsmd = rs.getMetaData();
             int feed;
             feed = rsmd.getColumnCount();
             
             DefaultTableModel desitab = (DefaultTableModel) user_drinkstab.getModel();
             desitab.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v = new Vector();
                 
                 for(int i=1 ; i<=feed ; i++)
                 {
                 v.add(rs.getString("NAME"));
                 v.add(rs.getString("RECIEPENAME"));
                 v.add(rs.getString("FEEDBACK"));
                 v.add(rs.getString("RATING"));
                 }
                 
                 desitab.addRow(v);
                 
             }
 
         } catch (SQLException ex) {
             Logger.getLogger(User_drinks.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void username()
    {
        user_name.setText(User_login.uname_login.getText());
    }
    
    public void rimg()
    {
        user_drinkimg.setText("Drinks");
        user_drinkimg.setFont(new Font("Consolas",Font.BOLD,15));
        user_drinkimg.setForeground(Color.RED);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home_login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        user_drinks = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_items = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        user_method = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user_ctime = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        user_drinkimg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        user_slider = new javax.swing.JSlider();
        user_rating = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        user_drinksfeed = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        user_drinkstab = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\IT Garage\\Downloads\\icons8-chef-100.png")); // NOI18N

        home_login.setBackground(new java.awt.Color(255, 255, 255));
        home_login.setIcon(new javax.swing.ImageIcon("C:\\Users\\IT Garage\\Downloads\\icons8-home-38.png")); // NOI18N
        home_login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        home_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_loginActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 255, 204));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Reciepes");

        user_drinks.setBackground(new java.awt.Color(255, 255, 255));
        user_drinks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        user_drinks.setForeground(new java.awt.Color(0, 51, 51));
        user_drinks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        user_drinks.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                user_drinksItemStateChanged(evt);
            }
        });
        user_drinks.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                user_drinksPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        user_items.setEditable(false);
        user_items.setBackground(new java.awt.Color(255, 255, 255));
        user_items.setColumns(20);
        user_items.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user_items.setForeground(new java.awt.Color(0, 51, 51));
        user_items.setRows(5);
        user_items.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(user_items);

        user_method.setEditable(false);
        user_method.setBackground(new java.awt.Color(255, 255, 255));
        user_method.setColumns(20);
        user_method.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user_method.setForeground(new java.awt.Color(0, 51, 51));
        user_method.setRows(5);
        user_method.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        user_method.setMinimumSize(new java.awt.Dimension(300, 340));
        jScrollPane2.setViewportView(user_method);

        jLabel3.setBackground(new java.awt.Color(204, 255, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("INGRIDIENTS");

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("METHOD");

        jLabel5.setBackground(new java.awt.Color(204, 255, 204));
        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Estd. Cooking Time");

        user_ctime.setEditable(false);
        user_ctime.setBackground(new java.awt.Color(255, 255, 255));
        user_ctime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        user_ctime.setForeground(new java.awt.Color(0, 51, 51));
        user_ctime.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\IT Garage\\Downloads\\icons8-next-30.png")); // NOI18N
        jButton1.setText("Next Item");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        user_drinkimg.setBackground(new java.awt.Color(204, 255, 204));
        user_drinkimg.setIcon(new javax.swing.ImageIcon("C:\\Users\\IT Garage\\Downloads\\icons8-drink-40.png")); // NOI18N

        jLabel9.setBackground(new java.awt.Color(204, 255, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("USERNAME");

        user_name.setBackground(new java.awt.Color(204, 255, 204));
        user_name.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        user_name.setForeground(new java.awt.Color(0, 51, 51));
        user_name.setText("jLabel8");
        user_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setBackground(new java.awt.Color(204, 255, 204));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("RATING");

        user_slider.setBackground(new java.awt.Color(204, 255, 204));
        user_slider.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        user_slider.setForeground(new java.awt.Color(0, 51, 51));
        user_slider.setMajorTickSpacing(1);
        user_slider.setMaximum(10);
        user_slider.setPaintLabels(true);
        user_slider.setPaintTicks(true);
        user_slider.setSnapToTicks(true);
        user_slider.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        user_rating.setBackground(new java.awt.Color(255, 255, 255));
        user_rating.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        user_rating.setForeground(new java.awt.Color(0, 51, 51));
        user_rating.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setBackground(new java.awt.Color(204, 255, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("FEEDBACK");

        user_drinksfeed.setBackground(new java.awt.Color(255, 255, 255));
        user_drinksfeed.setColumns(20);
        user_drinksfeed.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user_drinksfeed.setForeground(new java.awt.Color(0, 51, 51));
        user_drinksfeed.setRows(5);
        user_drinksfeed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane4.setViewportView(user_drinksfeed);

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Comment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        user_drinkstab.setBackground(new java.awt.Color(255, 255, 255));
        user_drinkstab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        user_drinkstab.setForeground(new java.awt.Color(0, 51, 51));
        user_drinkstab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NAME", "RECIEPENAME", "FEEDBACK", "RATING"
            }
        ));
        jScrollPane3.setViewportView(user_drinkstab);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user_drinks, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user_ctime, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(user_drinkimg)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(home_login)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addGap(98, 98, 98))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel9)
                                                .addComponent(jScrollPane4)
                                                .addComponent(user_slider, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(user_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(user_rating, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(user_drinkimg))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(home_login)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(user_drinks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(user_ctime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(user_name)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(user_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(user_rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void home_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_loginActionPerformed
        // TODO add your handling code here:
        User_main um = new User_main();
        um.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_home_loginActionPerformed

    private void user_drinksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_user_drinksItemStateChanged

    }//GEN-LAST:event_user_drinksItemStateChanged

    private void user_drinksPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_user_drinksPopupMenuWillBecomeInvisible
        try {
            String RECIEPENAME = user_drinks.getSelectedItem().toString();
            pst = conn.prepareStatement("select ITEMS, METHOD, COOKTIME from reciepes where RECIEPENAME = ? and RECIEPETYPE = 'Drinks' ");
            pst.setString(1,RECIEPENAME);
            rs = pst.executeQuery();

            if(rs.next())
            {
                String ITEMS, METHOD, COOKTIME;
                ITEMS = rs.getString(1);
                METHOD = rs.getString(2);
                COOKTIME = rs.getString(3);

                user_items.setText(ITEMS);
                user_method.setText(METHOD);
                user_ctime.setText(COOKTIME);
            }

            user_drinksfeed.setText("");
            user_rating.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(User_drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_user_drinksPopupMenuWillBecomeInvisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         User_desserts udess = new User_desserts();
        udess.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String name = user_name.getText();
        String drinkimg = user_drinkimg.getText();
        String feed = user_drinksfeed.getText();
        String rtype = user_drinks.getSelectedItem().toString();
        int val = Integer.parseInt(user_rating.getText());
        user_slider.setValue(val);
        try
        {
            pst = conn.prepareStatement("insert into desicomments (NAME,RECIEPETYPE,RECIEPENAME,FEEDBACK,RATING) values (?,?,?,?,?) ");
            pst.setString(1, name);
            pst.setString(2, drinkimg);
            pst.setString(3, rtype);
            pst.setString(4, feed);
            pst.setInt(5, val);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "THANKYOU FOR FEEDBACK");
            user_drinksfeed.setText("");
            user_drinks.setSelectedIndex(-1);
            user_ctime.setText("");
            user_items.setText("");
            user_method.setText("");
            user_rating.setText("");
            feedbacktable();

        }catch(Exception ex)
        {
            Logger.getLogger(User_drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(User_drinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_drinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_drinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_drinks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_drinks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField user_ctime;
    private javax.swing.JLabel user_drinkimg;
    private javax.swing.JComboBox<String> user_drinks;
    private javax.swing.JTextArea user_drinksfeed;
    private javax.swing.JTable user_drinkstab;
    private javax.swing.JTextArea user_items;
    private javax.swing.JTextArea user_method;
    private javax.swing.JLabel user_name;
    private javax.swing.JTextField user_rating;
    private javax.swing.JSlider user_slider;
    // End of variables declaration//GEN-END:variables
}
