package Recursion;

import java.util.Stack;

/**
 * Created by oreany on 04.08.15.
 */
public class Hanoi {
    public static void main(String[] args) {
        Stack<Integer> from = new Stack<>();
        Stack<Integer> help = new Stack<>();
        Stack<Integer> to = new Stack<>();
        int maxIndex = 3;
        for (int index = 0; index < maxIndex; index++) {
            from.push(index);
        }
        exchange(from, help, to, from.size());
        Stack<Integer> toCopy = (Stack<Integer>) to.clone();
        int toCopySize = toCopy.size();
        for (int index = 0; index < toCopySize; index++) {
            System.out.println(" "+toCopy);
        }
    }

    private static void exchange(Stack<Integer> from,
                                 Stack<Integer> help,
                                 Stack<Integer> to,
                                 int count) {
        while (count > 1) {
            exchange(from, to, help, count - 1);
            to.push(from.pop());
            exchange(help, from, to, count - 1);
        }
    }
}
