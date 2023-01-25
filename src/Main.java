import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        System.out.println(calc(input));
    }

    public static String calc (String input){
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String output = null;
        String initialExpression = input;
        String[] splitExpression = initialExpression.split(" ");
        String operand1 = null;
        String operator = null;
        String operand2 = null;

        boolean operand1IsRoman = false;
        boolean operand2IsRoman = false;
        if(splitExpression.length < 3){
            try {

                throw new IOException();
            }
            catch (IOException e){
                output = "throws Exception //т.к. ввод не соответствует условиям задачи(один операнд разделитель \" \" оператор разделитель \" \" второй операнд)";
            }
        } else if (splitExpression.length > 3) {
            try {
                throw new IOException();
            }
            catch (IOException e){
                output = "throws Exception //т.к. ввод не соответствует условиям задачи(один операнд разделитель \" \" оператор разделитель \" \" второй операнд)";
            }
        }else {
            operand1 = splitExpression[0];
            operator = splitExpression[1];
            operand2 = splitExpression[2];

            for (int i = 0; i < roman.length; i++) {
                if (operand1.equals(roman[i])) {
                    operand1IsRoman = true;
                    break;
                } else {
                    operand1IsRoman = false;
                }
            }

            for (int i = 0; i < roman.length; i++) {
                if (operand2.equals(roman[i])) {
                    operand2IsRoman = true;
                    break;
                } else {
                    operand2IsRoman = false;
                }

            }
            if (operand1IsRoman && operand2IsRoman) {
                output = romanExpression(operand1, operand2, operator);
            } else if (operand1IsRoman == false && operand2IsRoman == false) {
                output = arabExpression(operand1, operand2, operator);
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    output = "throws Exception //т.к. Используются разные системы исчислений";
                }
            }
        }
        return output;
    }

    static String romanExpression(String input, String input2, String operator) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < roman.length; i++) {
            if (input.equals(roman[i])) {
                number1 = i + 1;
                break;
            }

        }

        for (int i = 0; i < roman.length; i++) {
            if (input2.equals(roman[i])) {
                number2 = i + 1;
                break;
            }

        }
        String output;
        if ((number1 == 0 || number2 == 0) || (number1 > 10 || number2 > 10)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                output = "throws Exception //т.к. на вход принимаются числа от 1 до 10";
            }
        } else {
            int result = 0;
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
            if (result > 0) {
                output = roman[result - 1];
            } else if (result == 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    output = "throws Exception //т.к. В римской системе нет нуля";
                }
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    output = "throws Exception //т.к. В римской системе нет отрицательных чисел";
                }
            }
        }
        return output;
    }

    static String arabExpression(String input, String input2, String operator) {
        int number1 = Integer.parseInt(input);
        int number2 = Integer.parseInt(input2);
        int result = 0;

        String output;
        if((number1 == 0 || number2 == 0)||(number1 > 10 || number2 > 10)){
            try {
                throw new IOException();
            }catch (IOException e) {
                output = "throws Exception //т.к. на вход принимаются числа от 1 до 10";
            }
        } else {
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
            output = Integer.toString(result);
        }
        return output;
    }
}
