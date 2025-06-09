package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductEntryFrame extends JFrame {

    private JTextField nameField, typeField, priceField;
    private JTextArea descriptionArea;

    public ProductEntryFrame() {
        setTitle("商品录入界面");
        setSize(400, 350);
        setLocationRelativeTo(null); // 居中
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 中间表单部分
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        formPanel.add(new JLabel("商品名称："));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("商品类型："));
        typeField = new JTextField();
        formPanel.add(typeField);

        formPanel.add(new JLabel("商品价格："));
        priceField = new JTextField();
        formPanel.add(priceField);

        formPanel.add(new JLabel("商品描述："));
        descriptionArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        formPanel.add(scrollPane);

        // 下方按钮部分
        JPanel buttonPanel = new JPanel();
        JButton submitBtn = new JButton("提交");
        buttonPanel.add(submitBtn);

        // 按钮事件监听
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String type = typeField.getText();
                String price = priceField.getText();
                String description = descriptionArea.getText();

                // 这里你可以调用数据库方法保存数据
                JOptionPane.showMessageDialog(ProductEntryFrame.this,
                        "商品录入成功：\n名称：" + name + "\n类型：" + type +
                                "\n价格：" + price + "\n描述：" + description);
            }
        });

        // 加入组件
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
