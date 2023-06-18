package CryptoString;

public class CryptoString {
/**
 * Gronsfeld's method
 */

    private static char shiftChar(char c, int i) {
        if (c < 'A' || c > 'z') {
            return c;
        }
        c = (char) (c + i);
        if (c < 'A') {
            c = (char) (c + 'z' - 'A' + 1);
        }
        if (c > 'z') {
            c = (char) (c - 'z' + 'A' - 1);
        }
        return c;
    }

    private static int[] getKeyArray(String keyStr) {
        return keyStr.chars().map(ch -> ch - '0').toArray();
    }

    public String crypt(String text, String key) {
        return shiftWithKey(text, key, true);
    }

    public String decrypt(String text, String key) {
        return shiftWithKey(text, key, false);
    }

    private static String shiftWithKey(String text, String key, boolean forward) {
        int[] keyArray = getKeyArray(key);
        char[] result = new char[text.length()];
        char[] textChars = text.toCharArray();
        int sign = forward ? 1 : -1;
        for (int i = 0; i < textChars.length; i++) {
            result[i] = shiftChar(textChars[i], sign * keyArray[i % keyArray.length]);
        }
        return String.valueOf(result);
    }
}
