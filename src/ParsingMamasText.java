import java.sql.Array;

/**
 * Created by oreany on 04.08.15.
 */
public class ParsingMamasText {
    private static int index = 0;

    public static void main(String[] args) {
        String source = "1) abc 2) def 3) ijk 4) lmn.";
        String[] elements = new String[40];
        int prevPos = 1;
        for (int pos = 0; pos < source.length(); pos++) {
            if (source.charAt(pos) == ')') {
                elements[index] = source.substring(prevPos - 1, pos - 1);
                prevPos = pos;
                index++;
            }
        }
        for (int index = 0; index < 40; index++) {
            System.out.println(elements[index]);
        }
    }
}
