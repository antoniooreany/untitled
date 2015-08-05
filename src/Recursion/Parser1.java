package Recursion;

/**
 * Created by oreany on 04.08.15.
 */
public class Parser1 {
    public static void main(String[] args) {
//        System.out.println(eval("2"));
//        System.out.println(eval("23+3"));
//        System.out.println(eval("4*(25+3)"));        //It doesn't work
//        System.out.println(eval("1+(14*(2+37))"));   //It doesn't work
        System.out.println(eval("(4+5)*7"));       //It does work
//        System.out.println(eval("((4+5)*7)+33"));  //It doesn't work
    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == '(') {
            int open = 1;
            for (int index = from + 1; index < to; index++) {
                switch (expr.charAt(index)) {
                    case '(':
                        open++;
                    case ')':
                        open--;
                }
                if (open == 0) {
                    int leftOperand = eval(expr, from + 1, index);
                    char operation = expr.charAt(index + 1);
                    int rightOperand = eval(expr, index + 2, to);
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
        } else {
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr, pos + 1, to);
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
        }
        return Integer.valueOf(expr.substring(from, to));
    }
}
