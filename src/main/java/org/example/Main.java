package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validOperation = false;

        while (!validOperation) {
            try {
                // 1番目の数字を入力
                System.out.print("1番目の数字を入力してください: ");
                int number1 = scanner.nextInt();

                // 演算子の入力をループで検証
                String operator = "";
                boolean validOperator = false;
                while (!validOperator) {
                    System.out.print("演算子を入力してください (+, -, *, /): ");
                    operator = scanner.next();

                    if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
                        validOperator = true; // 有効な演算子が入力されたらループを終了
                    } else {
                        System.out.println("無効な演算子が入力されました。もう一度、演算子を入力してください。");
                    }
                }

                int number2 = 0;
                boolean validNumber2 = false;

                // 2番目の数字の入力を検証
                while (!validNumber2) {
                    try {
                        // 2番目の数字を入力
                        System.out.print("2番目の数字を入力してください: ");
                        number2 = scanner.nextInt();

                        // 割り算で0が入力された場合のチェック
                        if (operator.equals("/") && number2 == 0) {
                            System.out.println("0で割ることはできません。もう一度2番目の数字を入力してください。");
                            continue;
                        }
                        validNumber2 = true;

                    } catch (InputMismatchException e) {
                        System.out.println("無効な数字が入力されました。もう一度2番目の数字を入力してください。");
                        scanner.next();
                    }
                }

                int result = 0;

                // 計算の実行
                switch (operator) {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "*":
                        result = number1 * number2;
                        break;
                    case "/":
                        result = number1 / number2;
                        break;
                }

                // 計算結果を表示
                System.out.println("計算結果: " + number1 + " " + operator + " " + number2 + " = " + result);
                validOperation = true;

            } catch (InputMismatchException e) {
                System.out.println("無効な数字が入力されました。最初からやり直してください。");
                scanner.next();
            }
        }

        scanner.close();
    }
}
