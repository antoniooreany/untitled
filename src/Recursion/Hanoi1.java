package Recursion;

import java.util.Stack;

/**
 * Created by oreany on 04.08.15.
 */
public class Hanoi1 {
    public static void main(String[] args) {
        Stack<Integer> from = new Stack<>();
        Stack<Integer> help = new Stack<>();
        Stack<Integer> to = new Stack<>();
        int length = 5;
        for (int index = length; index > 0 ; index--) {
            from.push(index);
        }
        Stack<Integer> fromCopy = (Stack<Integer>) from.clone();

        exchange(from, help, to, from.size());
        Stack<Integer> toCopy = (Stack<Integer>) to.clone();
        int toCopySize = toCopy.size();
        System.out.println("FROM(before)   TO(after)");
        for (int index = 0; index < toCopySize; index++) {
            System.out.printf("   %d            %d%n", fromCopy.pop(), toCopy.pop());
        }
    }

    private static void exchange(Stack<Integer> from,
                                 Stack<Integer> help,
                                 Stack<Integer> to,
                                 int count) {
        if (count < 2) {
            to.push(from.pop());
        } else {
            exchange(from, to, help, count - 1);
            to.push(from.pop());
            exchange(help, from, to, count - 1);
        }
    }
}
