package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Set<String> VALID_OPERATORS = Set.of("+", "-", "*", "/");  // 演算子をSetとして定義

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validFirstNumber = false;
        boolean validSecondNumber = false;
        boolean validOperator = false;

        int number1 = 0;
        int number2 = 0;
        String operator = "";

        // 1番目の数字を入力
        while (!validFirstNumber) {
            try {
                System.out.print("1番目の数字を入力してください: ");
                number1 = scanner.nextInt();
                validFirstNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("無効な数字が入力されました。もう一度入力してください。");
                scanner.next();
            }
        }

        while (!validOperator) {
            System.out.print("演算子を入力してください (+, -, *, /): ");
            operator = scanner.next();

            if (VALID_OPERATORS.contains(operator)) {
                validOperator = true;
            } else {
                System.out.println("無効な演算子が入力されました。もう一度、演算子を入力してください。");
            }
        }

        while (!validSecondNumber) {
            try {
                System.out.print("2番目の数字を入力してください: ");
                number2 = scanner.nextInt();

                if (operator.equals("/") && number2 == 0) {
                    System.out.println("0で割ることはできません。もう一度2番目の数字を入力してください。");
                } else {
                    validSecondNumber = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("無効な数字が入力されました。もう一度2番目の数字を入力してください。");
                scanner.next();
            }
        }

        int result = 0;
        switch (operator) {
            case "+" -> result = number1 + number2;
            case "-" -> result = number1 - number2;
            case "*" -> result = number1 * number2;
            case "/" -> result = number1 / number2;
        }

        System.out.println("計算結果: " + number1 + " " + operator + " " + number2 + " = " + result);

        scanner.close();
    }
}
