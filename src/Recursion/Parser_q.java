package Recursion;

/**
 * Created by oreany on 04.08.15.
 */
public class Parser_q {
    public static void main(String[] args) {
//        System.out.println(eval("2"));
//        System.out.println(eval("23+3"));
//        System.out.println(eval("4*(25+3)"));
        System.out.println(eval("1+(14*(2+37))"));
//        System.out.println(eval("(4+5)+7"));
    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == '(') {
            return eval(expr, from + 1, to - 1);
        } else {
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand  = eval(expr, pos + 1, to);
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(from, to));
        }
    }
}
