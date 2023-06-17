package checkBracket;

public class CheckBracket {
    public boolean parsing(String string) {
        int checkBracket = 0;
        for (int i = 0; i < string.length(); i++) {
            if (checkBracket < 0) {
                return false;
            }
            String oneSymbol = string.substring(i, i + 1);
            if (oneSymbol.contains("(")) {
                checkBracket++;
            } else if (oneSymbol.contains(")")) {
                checkBracket--;
            }
        }
        return checkBracket == 0;
    }
}