package com.raven.main;

import com.raven.controller.Zingmp3Controller;
import com.raven.model.Model_Menu;
import com.raven.swing.ScrollBar;

import com.raven.form.Form_Artists;
import com.raven.form.SearchArtist;
import com.raven.form.AlbumSongs;
import com.raven.form.New_Release;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
    
public class Main extends javax.swing.JFrame {
    public static Zingmp3Controller controller = new Zingmp3Controller("localhost", 5000);
	 AlbumSongs albums = new AlbumSongs();
     //New_Release news = new New_Release();
     Form_Artists artists = new Form_Artists();
     SearchArtist search = new SearchArtist();
    public Main() {
    	controller.setKey();
        initComponents();
        init();
        artists.setSongs(controller.getInfo("newRelease"));
        menuClicked(artists);
     //  news.setSongs(controller.getInfo("aumy"));
        
    }
    JPanel panel;
    private void init() {
        //JScrollPane sc = new JScrollPane(new JScrollBar());
        JPanel panel = new JPanel();
        //albums.setVisible(true);
        panel.add(albums);
        panel.add(search);
        panel.add(artists);
        panel.setVisible(true);
        //sc.add(panel);
        panel.setBounds(268, 0, 980, 1000);
        getContentPane().add(panel);
        //setBackground(new Color(0, 0, 0, 0));  //  Remove background color  
        list1.addItem(new Model_Menu("Nổi bật", "artists"));
        list1.addItem(new Model_Menu("Tìm Kiếm", "albums"));
        list1.addItem(new Model_Menu("Ca Sĩ", "song"));
//        list2.addItem(new Model_Menu("Store", "store"));
//        list2.addItem(new Model_Menu("Radio", "radio"));
//        list2.addItem(new Model_Menu("For You", "love"));
//        list2.addItem(new Model_Menu("Browse", "browse"));
        
        
       
    }
    public void menuClicked(JPanel jpanel){
    	albums.setVisible(false);
    	search.setVisible(false);
    	artists.setVisible(false);
    	jpanel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panel1 = new com.raven.swing.Panel();
        menu1 = new com.raven.component.Menu();
        list1 = new com.raven.component.ListMenu<>();
        jLabel1 = new javax.swing.JLabel();
        list2 = new com.raven.component.ListMenu<>();
        jLabel2 = new javax.swing.JLabel();
        panelMoving = new javax.swing.JPanel();
        bottom1 = new com.raven.component.Bottom();
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 229));
        jLabel1.setText("LIBRARY");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));

        list2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                list2MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 229));
        jLabel2.setText("DISCOVER");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));

        panelMoving.setOpaque(false);
        panelMoving.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMovingMouseDragged(evt);
            }
        });
        panelMoving.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMovingMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(menu1Layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(931, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(bottom1, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bottom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelMovingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMovingMousePressed
        //        x = evt.getX();
        //        y = evt.getY();
    }//GEN-LAST:event_panelMovingMousePressed

    private void panelMovingMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMovingMouseDragged
        //        setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_panelMovingMouseDragged

    private void list2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list2MousePressed
        list1.clearSelection();
    }//GEN-LAST:event_list2MousePressed

    private void list1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MousePressed
        list2.clearSelection();
        int index = list1.getSelectedIndex();
        if(index == 0){
            menuClicked(artists);
        }
        if(index == 1){
            menuClicked(albums);
        }
        if(index == 2){
            menuClicked(search);
        }

    }//GEN-LAST:event_list1MousePressed
    private int x;
    private int y;
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    class PanelButtonManager extends MouseAdapter{
        JPanel panel;

        public PanelButtonManager(JPanel panel) {
            this.panel = panel;
        }
        
//        @Override 
//        public void mouseEntered(MouseEvent evt){
//            panel.setBackground(Color.RED);
//        }
//         @Override 
//        public void mouseExited(MouseEvent evt){
//            panel.setBackground(new Color(203, 240, 240));
//        }
//         @Override 
//        public void mousePressed(MouseEvent evt){
//            panel.setBackground(Color.BLACK);
//        }
//         @Override 
//        public void mouseReleased(MouseEvent evt){
//            panel.setBackground(Color.RED);
//        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.raven.component.ListMenu<String> list1;
    private com.raven.component.ListMenu<String> list2;
    private com.raven.component.Menu menu1;
    private com.raven.swing.Panel panel1;
    private javax.swing.JPanel panelMoving;
    private com.raven.component.Bottom bottom1;
    // End of variables declaration//GEN-END:variables
}
