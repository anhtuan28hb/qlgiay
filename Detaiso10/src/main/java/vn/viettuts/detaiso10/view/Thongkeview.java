package vn.viettuts.detaiso10.view;

//import ChartPie.ModelPieChart;
import java.awt.Color;
import vn.viettuts.detaiso10.chart.ModelChart;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import vn.viettuts.detaiso10.chart.ModelPolarAreaChart;

public class Thongkeview extends javax.swing.JPanel {
    
    private HashMap<String,Integer> mapdonhang;
    private HashMap<String,Integer> mapsize;
    private HashMap<String,Integer> map;
    private Document doc;
    List<Color> colors = new ArrayList<>();
    HashMap<String, Color> productColors = new HashMap<>();
    int tong =0;
    
    public Thongkeview() {
        initComponents();
        
        try {
            File xmlFile = new File("donhang.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nldonhang = doc.getElementsByTagName("sanpham");
            HashMap<String,Integer> mapdonhang= new HashMap<>();
            for (int i = 0; i < nldonhang.getLength(); i++) {
                Element element = (Element) nldonhang.item(i);
                String ten = element.getElementsByTagName("ten").item(0).getTextContent();
                int soluong = Integer.parseInt(element.getElementsByTagName("soluong").item(0).getTextContent());
                String[] hanggiay = ten.split("\\s+"); // Tách chuỗi thành mảng các từ
                tong+=soluong;
                if (hanggiay.length > 0) {
                    String keys = hanggiay[0]; // Lấy từ đầu tiên
                    if (mapdonhang.containsKey(keys)) {
                        int count = mapdonhang.get(keys);
                        mapdonhang.put(keys, count + soluong);
                    } else {
                        mapdonhang.put(keys, soluong);
                        }
                }
            }
            for(Map.Entry<String,Integer> entry : mapdonhang.entrySet()){
                String productName = entry.getKey();
                Color color = productColors.get(productName); // Kiểm tra xem tên sản phẩm đã được ánh xạ với một màu hay chưa
                if (color == null) {
                    // Nếu tên sản phẩm chưa có màu, tạo một màu mới và ánh xạ tên sản phẩm với màu đó
                    color = addNewColor();
                    productColors.put(productName, color);
                }
                polarAreaChart.addItem(new ModelPolarAreaChart(color, productName, entry.getValue()));
            }
        }    
        catch (ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex) {
            Logger.getLogger(Thongkeview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            File xmlFile = new File("donhang.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nldonhang = doc.getElementsByTagName("sanpham");
            HashMap<String,Integer> mapsize= new HashMap<>();
            for (int i = 0; i < nldonhang.getLength(); i++) {
                Element element = (Element) nldonhang.item(i);
                String size1 = element.getElementsByTagName("size").item(0).getTextContent();
                int soluong1 = Integer.parseInt(element.getElementsByTagName("soluong").item(0).getTextContent());
                if (size1.length() > 0) {
                    if (mapsize.containsKey(size1)) {
                        int count = mapsize.get(size1);
                        mapsize.put(size1, count + soluong1);
                    } else {
                        mapsize.put(size1, soluong1);
                        }
                }
            }
            for(Map.Entry<String,Integer> entry : mapsize.entrySet()){
                String productName = entry.getKey();
                Color color = productColors.get(productName); // Kiểm tra xem tên sản phẩm đã được ánh xạ với một màu hay chưa
                if (color == null) {
                    // Nếu tên sản phẩm chưa có màu, tạo một màu mới và ánh xạ tên sản phẩm với màu đó
                    color = addNewColor();
                    productColors.put(productName, color);
                }
                polarAreaChart1.addItem(new ModelPolarAreaChart(color, productName, entry.getValue()));
            }
        }    
        catch (ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex) {
            Logger.getLogger(Thongkeview.class.getName()).log(Level.SEVERE, null, ex);
        }
        chart.addLegend("Giày trong kho", new Color(34,139,34));
        try {
            File xmlFile = new File("sanpham.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nlsanpham = doc.getElementsByTagName("sanpham");
            HashMap<String,Integer> map= new HashMap<>();
            for (int i = 0; i < nlsanpham.getLength(); i++) {
                Element element = (Element) nlsanpham.item(i);
                String ten = element.getElementsByTagName("ten").item(0).getTextContent();
                String[] words = ten.split("\\s+"); 
                if (words.length > 0) {
                    String key = words[0]; 
                    if (map.containsKey(key)) {
                        int count = map.get(key);
                        map.put(key, count + 1);
                    } else {
                        map.put(key, 1);
                        }
                }
            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
            chart.addData(new ModelChart(entry.getKey(), new double[]{entry.getValue()}));
            }
        }    
        catch (ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex) {
            Logger.getLogger(Sanphamview.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTextField1.setText(String.valueOf(tong));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        chart = new vn.viettuts.detaiso10.chart.Chart();
        polarAreaChart = new vn.viettuts.detaiso10.chart.PolarAreaChart();
        myButton1 = new Buttonborder.MyButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        polarAreaChart1 = new vn.viettuts.detaiso10.chart.PolarAreaChart();

        setBackground(new java.awt.Color(135, 206, 250));
        setPreferredSize(new java.awt.Dimension(900, 620));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Thống kê cửa hàng");

        myButton1.setText("Biểu đồ");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("TOTAL SOLD");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("PREFERED SIZE");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 375, Short.MAX_VALUE))
                            .addComponent(polarAreaChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141))
                            .addComponent(polarAreaChart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(polarAreaChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                        .addGap(43, 43, 43)
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(polarAreaChart, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        polarAreaChart.start();
        chart.start();
        polarAreaChart1.start();
        
    }//GEN-LAST:event_myButton1ActionPerformed
    private Color addNewColor() {
        Random random = new Random();
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        colors.add(color); // Thêm màu mới vào danh sách
        return color;
    }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

//   public void thongkedoanhthu(){
//       HashMap<String, Donhang> donhangMap = donhang.getMapDonhang();
//       for (Map.Entry<String, Donhang> entry : donhangMap.entrySet()) {
//            Donhang n = entry.getValue();
//            int i = 0;
//            pieChart1.addData(new ModelPieChart(n.getTengiay(),n.getDoanhthu(),getColor(i++)));
//        }
//       
//   }
//   private Color getColor(int i){
//       Color[] color = new Color[]{};
//       return color[i];
//   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vn.viettuts.detaiso10.chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private Buttonborder.MyButton myButton1;
    private vn.viettuts.detaiso10.chart.PolarAreaChart polarAreaChart;
    private vn.viettuts.detaiso10.chart.PolarAreaChart polarAreaChart1;
    // End of variables declaration//GEN-END:variables
}
