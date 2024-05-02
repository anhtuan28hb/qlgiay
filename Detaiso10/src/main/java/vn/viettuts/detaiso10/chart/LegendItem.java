package vn.viettuts.detaiso10.chart;

public class LegendItem extends javax.swing.JPanel {

    public LegendItem(ModelLegend data) {
        initComponents();
        setOpaque(false);
        labelColor.setBackground(data.getColor());
        namelabel.setText(data.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namelabel = new javax.swing.JLabel();
        labelColor = new vn.viettuts.detaiso10.chart.LabelColor();

        namelabel.setForeground(new java.awt.Color(100, 100, 100));
        namelabel.setText("Name");

        labelColor.setBackground(new java.awt.Color(255, 51, 51));
        labelColor.setText("labelColor1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namelabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(namelabel)
                .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vn.viettuts.detaiso10.chart.LabelColor labelColor;
    private javax.swing.JLabel namelabel;
    // End of variables declaration//GEN-END:variables
}
