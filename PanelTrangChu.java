



import java.util.ArrayList;

public class PanelTrangChu extends javax.swing.JPanel {

    public PanelTrangChu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_all = new javax.swing.JPanel();
        tittle = new javax.swing.JPanel();
        lblTitleTC = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pn_show = new javax.swing.JPanel();
        pnlSoLuongphieunhap = new javax.swing.JPanel();
        lb_phieunhap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlSoLuongsach = new javax.swing.JPanel();
        lb_sach = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlSoLuongnhanvien = new javax.swing.JPanel();
        lb_nhanvien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        pn_all.setBackground(new java.awt.Color(238, 241, 245));

        tittle.setBackground(new java.awt.Color(238, 241, 245));

        lblTitleTC.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitleTC.setForeground(new java.awt.Color(78, 79, 96));
        lblTitleTC.setText("Trang chủ");

        javax.swing.GroupLayout tittleLayout = new javax.swing.GroupLayout(tittle);
        tittle.setLayout(tittleLayout);
        tittleLayout.setHorizontalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tittleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitleTC, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tittleLayout.setVerticalGroup(
            tittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tittleLayout.createSequentialGroup()
                .addComponent(lblTitleTC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pnlSoLuongphieunhap.setBackground(new java.awt.Color(174, 168, 211));
        pnlSoLuongphieunhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongphieunhapMouseClicked(evt);
            }
        });

        lb_phieunhap.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_phieunhap.setForeground(new java.awt.Color(255, 255, 255));
        lb_phieunhap.setText("Danh mục bài hát");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/phieunhaptrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongphieunhapLayout = new javax.swing.GroupLayout(pnlSoLuongphieunhap);
        pnlSoLuongphieunhap.setLayout(pnlSoLuongphieunhapLayout);
        pnlSoLuongphieunhapLayout.setHorizontalGroup(
            pnlSoLuongphieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongphieunhapLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lb_phieunhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuongphieunhapLayout.setVerticalGroup(
            pnlSoLuongphieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongphieunhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongphieunhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSoLuongphieunhapLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_phieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSoLuongsach.setBackground(new java.awt.Color(255, 204, 204));
        pnlSoLuongsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongsachMouseClicked(evt);
            }
        });

        lb_sach.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_sach.setForeground(new java.awt.Color(255, 255, 255));
        lb_sach.setText("Phát nhạc ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sachtrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongsachLayout = new javax.swing.GroupLayout(pnlSoLuongsach);
        pnlSoLuongsach.setLayout(pnlSoLuongsachLayout);
        pnlSoLuongsachLayout.setHorizontalGroup(
            pnlSoLuongsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongsachLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lb_sach, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuongsachLayout.setVerticalGroup(
            pnlSoLuongsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongsachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(lb_sach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlSoLuongnhanvien.setBackground(new java.awt.Color(255, 204, 153));
        pnlSoLuongnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSoLuongnhanvienMouseClicked(evt);
            }
        });

        lb_nhanvien.setBackground(new java.awt.Color(255, 255, 255));
        lb_nhanvien.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lb_nhanvien.setForeground(new java.awt.Color(255, 255, 255));
        lb_nhanvien.setText("Tìm kiếm ");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nhanvientrangchu.png"))); // NOI18N

        javax.swing.GroupLayout pnlSoLuongnhanvienLayout = new javax.swing.GroupLayout(pnlSoLuongnhanvien);
        pnlSoLuongnhanvien.setLayout(pnlSoLuongnhanvienLayout);
        pnlSoLuongnhanvienLayout.setHorizontalGroup(
            pnlSoLuongnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongnhanvienLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(lb_nhanvien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSoLuongnhanvienLayout.setVerticalGroup(
            pnlSoLuongnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSoLuongnhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSoLuongnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSoLuongnhanvienLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_nhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pn_showLayout = new javax.swing.GroupLayout(pn_show);
        pn_show.setLayout(pn_showLayout);
        pn_showLayout.setHorizontalGroup(
            pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_showLayout.createSequentialGroup()
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_showLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlSoLuongsach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(pnlSoLuongphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_showLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(pnlSoLuongnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        pn_showLayout.setVerticalGroup(
            pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_showLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pn_showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSoLuongsach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSoLuongphieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(pnlSoLuongnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pn_allLayout = new javax.swing.GroupLayout(pn_all);
        pn_all.setLayout(pn_allLayout);
        pn_allLayout.setHorizontalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pn_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_allLayout.setVerticalGroup(
            pn_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSoLuongnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongnhanvienMouseClicked
        NhanVienBUS busnv = new NhanVienBUS();
        for(NhanVienDTO nv: busnv.docNv()){
            lb_nhanvien.setText(busnv.docNv().size()+"");}
    }//GEN-LAST:event_pnlSoLuongnhanvienMouseClicked

    private void pnlSoLuongsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongsachMouseClicked
        SachBUS sachbus = new SachBUS();
        for(SachDTO s: sachbus.docSach()){
            lb_sach.setText(sachbus.docSach().size()+"");}
    }//GEN-LAST:event_pnlSoLuongsachMouseClicked

    private void pnlSoLuongphieunhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSoLuongphieunhapMouseClicked
        PhieuNhapBUS buspn = new PhieuNhapBUS();
        for(PhieuNhapDTO pn: buspn.docPn()){
            lb_phieunhap.setText(buspn.docPn().size()+"");}
    }//GEN-LAST:event_pnlSoLuongphieunhapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_nhanvien;
    private javax.swing.JLabel lb_phieunhap;
    private javax.swing.JLabel lb_sach;
    private javax.swing.JLabel lblTitleTC;
    private javax.swing.JPanel pn_all;
    private javax.swing.JPanel pn_show;
    private javax.swing.JPanel pnlSoLuongnhanvien;
    private javax.swing.JPanel pnlSoLuongphieunhap;
    private javax.swing.JPanel pnlSoLuongsach;
    private javax.swing.JPanel tittle;
    // End of variables declaration//GEN-END:variables
}
