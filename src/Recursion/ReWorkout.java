package Recursion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oreany on 04.08.15.
 */
public class ReWorkout {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("x.");
//        Matcher matcher = pattern.matcher("xy");
//        Pattern pattern = Pattern.compile(".*(\\d+\\).*)(\\d+\\).*)");
//        Pattern pattern = Pattern.compile(".*\\s(\\d+\\)\\s.*)\\s.*");
        Pattern pattern = Pattern.compile("\\d+\\)");
        Matcher matcher = pattern.matcher("xyz 1) abc 2) def 3) ghi 4) jkl 5) mno. ");
        String[] split = pattern.split("xyz 1) abc 2) def 3) ghi 4) jkl 5) mno. ");
        for (String s: split) {
            System.out.print(s+"   ");
        }
//        boolean b = matcher.matches();
//        System.out.println(b);
//        String group1 = matcher.group(1);
//        String group2 = matcher.group(2);
//        System.out.println(group1);
//        System.out.println(group2);
    }
}
