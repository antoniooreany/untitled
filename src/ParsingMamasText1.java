/**
 * Created by oreany on 04.08.15.
 */
public class ParsingMamasText1 {
    private static int index = 0;

    public static void main(String[] args) {
        String source = "1) abc 2) def 3) ghi 4) jkl.";
        String[] elements = new String[4];
        int prevPos = source.length() - 1;
        for (int pos = source.length() - 1; pos >= 0; pos--) {
            if (source.charAt(pos) == ')') {
                elements[index] = source.substring(pos - 1, prevPos);
                prevPos = pos - 1;
                index++;
            }
        }
        for (int index = 3; index >= 0; index--) {
            System.out.println(elements[index]);
        }
    }
}
