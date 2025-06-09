package ui;

import main.Fruit;
import main.Product;
import mapper.FruitDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFruitFrame extends JFrame {
    private JTextField idField, nameField, typeField, priceField, descriptionField;
    private JTextField colorField, weightField, unitField, originField, ripenessField;
    private JButton saveButton;

    public EditFruitFrame(Fruit fruit) {
        setTitle("修改水果信息");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(12, 2, 5, 5));

        add(new JLabel("编号(ID):"));
        idField = new JTextField(fruit.getId());
        idField.setEditable(false); // 主键通常不修改
        add(idField);

        add(new JLabel("名称:"));
        nameField = new JTextField(fruit.getName());
        add(nameField);

        add(new JLabel("类型:"));
        typeField = new JTextField(fruit.getType());
        add(typeField);

        add(new JLabel("价格:"));
        priceField = new JTextField(String.valueOf(fruit.getPrice()));
        add(priceField);

        add(new JLabel("描述:"));
        descriptionField = new JTextField(fruit.getDescription());
        add(descriptionField);

        add(new JLabel("颜色:"));
        colorField = new JTextField(fruit.getColor());
        add(colorField);

        add(new JLabel("重量:"));
        weightField = new JTextField(String.valueOf(fruit.getWeight()));
        add(weightField);

        add(new JLabel("单位:"));
        unitField = new JTextField(fruit.getPackageUnit());
        add(unitField);

        add(new JLabel("产地:"));
        originField = new JTextField(fruit.getOrigin());
        add(originField);

        add(new JLabel("成熟度:"));
        ripenessField = new JTextField(fruit.getRipeness());
        add(ripenessField);

        saveButton = new JButton("保存修改");
        add(saveButton);
        add(new JLabel()); // 占位

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 可以进行合法性校验
                try {
                    fruit.setName(nameField.getText());
                    fruit.setType(typeField.getText());
                    fruit.setPrice(Double.parseDouble(priceField.getText()));
                    fruit.setDescription(descriptionField.getText());
                    fruit.setColor(colorField.getText());
                    fruit.setWeight(Double.parseDouble(weightField.getText()));
                    fruit.setPackageUnit(unitField.getText());
                    fruit.setOrigin(originField.getText());
                    fruit.setRipeness(ripenessField.getText());

                    // 这里调用 DAO 执行更新数据库
                    FruitDAO dao = new FruitDAO();
                    boolean result = dao.update(fruit);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "修改成功！");
                    } else {
                        JOptionPane.showMessageDialog(null, "该商品不存在！");
                    }
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "修改失败：" + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
