package main;

import java.util.Scanner;

public class InputHelper {
    private InputHelper(){}

    public static String inputString(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();

            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("输入不能为空！请重新输入");
            }
        }
    }

    public static int inputInt(String prompt, Scanner sc) {
        while (true) {
            System.out.println(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("请输入合法数字！");
            }
        }
    }

    public static double inputDouble(String prompt, Scanner sc) {
        while (true) {
            System.out.println(prompt);
            String input = sc.nextLine().trim();
            try{
                return Double.parseDouble(input);
            } catch (NumberFormatException e){
                System.out.println("请输入合法数字！");
            }
        }
    }
}
