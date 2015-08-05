package Recursion;

/**
 * Created by oreany on 04.08.15.
 */
public class Parser2 {
    public static void main(String[] args) {
        try {
//        System.out.println(eval("2"));
//        System.out.println(eval("23+3"));
//        System.out.println(eval("4*(25+3)"));
            System.out.println(eval("0+(34*(7+9))"));
//        System.out.println(eval("(4+5)+7"));
        } catch (Exception e) {         //catch another Exception, that thrown
//            System.out.println(e.getMessage());
            System.out.println("Hi!!! It's caught Exception!");
        }
    }

    private static int eval(String expr) throws Exception {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) throws Exception {
        if (expr.charAt(from) == '(') {
            int brBalance = 1;
            for (int pos = from + 1; pos < to; pos++) {
                brBalance = brCounter(expr, pos, brBalance);
                if (brBalance == 0) {
                    int leftOperand = eval(expr, pos + 1, to);     //leftOperand
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr, from + 1, pos);   //rightOperand
                    return makeArithmeticOperation(leftOperand, operation, rightOperand);
                }
            }
//            throw new Exception("Incorrect expression");        //Throw another Exception
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
            return Integer.valueOf(expr.substring(from, pos));
        }
        throw new Exception("Incorrect expression");
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
