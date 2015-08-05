package Recursion;

import java.util.Stack;

/**
 * Created by oreany on 02.08.15.
 */
public class Hanoi_q {
    public static void main(String[] args) {
        Stack<Integer> from = new Stack<>();
        Stack<Integer> help = new Stack<>();
        Stack<Integer> to = new Stack<>();
        from.push(3);
        from.push(2);
        from.push(1);
        Stack<Integer> from1 = (Stack<Integer>) from.clone();
        int from1Size = from1.size();
        for (int i = 0; i < from1Size; i++) {
            System.out.println("from " + from1.pop());
        }
        exchange(from, help, to, from.size());
        Stack<Integer> to1 = (Stack<Integer>) to.clone();
        int to1Size = to1.size();
        for (int j = 0; j < to1Size; j++) {
            System.out.println("to " + to1.pop());
        }
    }

    private static void exchange(
            Stack<Integer> from,
            Stack<Integer> help,
            Stack<Integer> to,
            int count) {
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggest = from.pop();
            to.push(biggest);
            exchange(help, from, to, count - 1);
        }
    }
}
