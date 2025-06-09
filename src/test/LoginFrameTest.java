package test;

import ui.LoginFrame;

import javax.swing.*;

class LoginFrameTest {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
        new LoginFrame();
    }
}