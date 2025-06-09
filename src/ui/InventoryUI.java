package ui;

import main.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class InventoryUI extends JFrame {

    public InventoryUI(Inventory inventory) {
        setTitle("农产品信息展示");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        //为顶部添加按钮
        tabbedPane.addTab("水果", createTablePanel(inventory.getAllProducts(), "Fruit"));
        tabbedPane.addTab("木材", createTablePanel(inventory.getAllProducts(), "Wood"));
        tabbedPane.addTab("药材",createTablePanel(inventory.getAllProducts(), "Herb"));

        add(tabbedPane);
    }

    private JPanel createTablePanel(ArrayList<Product> products, String className) {
        String[] columnNames;
        DefaultTableModel tableModel;

        switch (className){
            case "Fruit" ->{
                columnNames = new String[]{"ID", "名称", "类型", "价格", "描述", "颜色", "重量", "单位", "产地", "成熟度"};
                tableModel = new DefaultTableModel(columnNames, 0);

                for (Product p : products) {
                    if (p instanceof Fruit f) {
                        Object[] row = {
                                f.getId(), f.getName(), f.getType(), f.getPrice(), f.getDescription(),
                                f.getColor(), f.getWeight(), f.getPackageUnit(), f.getOrigin(), f.getRipeness()
                        };
                        tableModel.addRow(row);
                    }
                }
            }

            case "Wood" ->{
                columnNames = new String[]{"ID", "名称", "类型", "价格", "描述", "树种", "长度", "宽度", "厚度", "含水率"};
                tableModel = new DefaultTableModel(columnNames, 0);

                for (Product p : products) {
                    if (p instanceof Wood w) {
                        Object[] row = {
                                w.getId(), w.getName(), w.getType(), w.getPrice(), w.getDescription(),
                                w.getSpecies(), w.getLength(), w.getWidth(),w.getThickness(),w.getMoistureContent()
                        };
                        tableModel.addRow(row);
                    }
                }
            }

            case "Herb" ->{
                columnNames = new String[]{"ID", "名称", "类型", "价格", "描述", "药材名称", "产地", "采摘季节", "保质期"};
                tableModel = new DefaultTableModel(columnNames, 0);

                for (Product p : products) {
                    if (p instanceof Herb h) {
                        Object[] row = {
                                h.getId(), h.getName(), h.getType(), h.getPrice(), h.getDescription(),
                                h.getHerbName(), h.getHerbOrigin(), h.getSeason(), h.getShelfLife()
                        };
                        tableModel.addRow(row);
                    }
                }
            }

            default -> {return new JPanel();}
        }

        JTable table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 15));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // 让滚轮滑动更快

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
}
