package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class combinationsTest {
    static Map<String, String> phone = new HashMap<String, String>() {{
        put("0", "0");
        put("1", "1");
        put("2", "ABC");
        put("3", "DEF");
        put("4", "GHI");
        put("5", "JKL");
        put("6", "MNO");
        put("7", "PQRS");
        put("8", "TUV");
        put("9", "WXYZ");
    }};

    static List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

}
