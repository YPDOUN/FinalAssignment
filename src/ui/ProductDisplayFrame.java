package ui;

import main.Fruit;
import main.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductDisplayFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public ProductDisplayFrame(List<Product> fruitList) {
        setTitle("水果商品展示界面");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {
                "ID", "名称", "类型", "价格", "描述",
                "颜色", "重量", "单位", "产地", "成熟度"
        };

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // 填充数据
//        for (Fruit f : fruitList) {
//            Object[] rowData = {
//                    f.getId(),
//                    f.getName(),
//                    f.getType(),
//                    f.getPrice(),
//                    f.getDescription(),
//                    f.getColor(),
//                    f.getWeight(),
//                    f.getPackageUnit(),
//                    f.getOrigin(),
//                    f.getRipeness()
//            };
//            tableModel.addRow(rowData);
//        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // 模拟数据测试
        List<Fruit> fruits = List.of(
                new Fruit("F001", "苹果", "水果", 3.5, "红富士苹果", "红色", 0.25, "个", "山东", "全熟"),
                new Fruit("F002", "香蕉", "水果", 2.0, "菲律宾香蕉", "黄色", 0.3, "斤", "广东", "半熟")
        );

        //SwingUtilities.invokeLater(() -> new ProductDisplayFrame(fruits).setVisible(true));
    }
}