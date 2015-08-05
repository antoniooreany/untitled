package Recursion;

/**
 * Created by oreany on 04.08.15.
 */
public class Parser4 {
    private static int result;

    public static void main(String[] args) {
        System.out.println(eval("2"));
        System.out.println(eval("23+3"));
        System.out.println(eval("4*(25+3)"));
        System.out.println(eval("(4+5)+7"));
        System.out.println(eval("0+(34*(7+9))"));
        System.out.println(eval("0+(34+6)"));
        System.out.println(eval("(1+3)+((7+9)+12+14)+17"));
    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == '(') {
            int brBalance = 1;
            for (int pos = from + 1; pos < to; pos++) {
                brBalance = brCounter(expr, pos, brBalance);
                if (brBalance == 0) {
                    int leftOperand = eval(expr, from + 1, pos);
                    char operation;
                    int rightOperand;
                    try {
                        operation = expr.charAt(pos + 1);
                        rightOperand = eval(expr, pos + 2, to);
                    } catch (StringIndexOutOfBoundsException e) {      //catch
                        operation = '+';
                        rightOperand = 0;
                    }
                    return makeArithmeticOperation(leftOperand, operation, rightOperand);
                }
            }
        } else {
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr, pos + 1, to);
                    return makeArithmeticOperation(leftOperand, operation, rightOperand);
                }
            }
            result = Integer.valueOf(expr.substring(from, pos));
        }
        return result;
    }

    private static int brCounter(String expr, int pos, int brBalance) {
        switch (expr.charAt(pos)) {
            case '(':
                brBalance++;
                break;
            case ')':
                brBalance--;
                break;
        }
        return brBalance;
    }

    private static Integer makeArithmeticOperation(int leftOperand, char operation, int rightOperand) {
        switch (operation) {
            case '+':
                return leftOperand + rightOperand;
            case '-':
                return leftOperand - rightOperand;
            case '*':
                return leftOperand * rightOperand;
            case '/':
                return leftOperand / rightOperand;
            default:
                return null;
        }
    }
}
