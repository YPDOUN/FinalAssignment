package ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private JCheckBox rememberMeCheckBox;

    public LoginFrame() {
        setTitle("农产品销售系统 - 登录");
        setSize(400, 250);
        setLocationRelativeTo(null); // 居中显示
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //顶部标签
        JLabel titleLabel = new JLabel("广东农产品销售系统", JLabel.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // 中间
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        JLabel userLabel = new JLabel("用户名:");
        usernameField = new JTextField();

        JLabel passLabel = new JLabel("密码:");
        passwordField = new JPasswordField();

        showPasswordCheckBox = new JCheckBox("显示密码");
        rememberMeCheckBox = new JCheckBox("记住我");

        // 显示密码切换
        showPasswordCheckBox.addActionListener(e -> {
            passwordField.setEchoChar(showPasswordCheckBox.isSelected() ? (char) 0 : '•');
        });

        formPanel.add(userLabel);
        formPanel.add(usernameField);
        formPanel.add(passLabel);
        formPanel.add(passwordField);
        formPanel.add(showPasswordCheckBox);
        formPanel.add(rememberMeCheckBox);

        add(formPanel, BorderLayout.CENTER);

        // ======= 底部按钮 =======
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("登录");
        JButton clearButton = new JButton("清空");

        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // 登录逻辑
        loginButton.addActionListener(e -> login());
        clearButton.addActionListener(e -> clearFields());

        // 按回车键登录
        passwordField.addActionListener(e -> login());
        usernameField.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入用户名和密码！", "输入有误", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ("admin".equals(username) && "1234".equals(password)) {
            JOptionPane.showMessageDialog(this, "登录成功，欢迎您，" + username + "！");
            //
        } else {
            JOptionPane.showMessageDialog(this, "用户名或密码错误，请重试！", "登录失败", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        rememberMeCheckBox.setSelected(false);
        showPasswordCheckBox.setSelected(false);
        passwordField.setEchoChar('•');
    }

//    public static void main(String[] args) {
//        // 使用系统外观
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception ignored) {}
//        new LoginFrame();
//    }
}