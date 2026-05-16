


public class Alphabet {
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private final String characters;

    public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded) {
        StringBuilder builder = new StringBuilder();
        if (uppercaseIncluded) {
            builder.append(UPPERCASE_LETTERS);
        }
        if (lowercaseIncluded) {
            builder.append(LOWERCASE_LETTERS);
        }
        if (numbersIncluded) {
            builder.append(NUMBERS);
        }
        if (specialCharactersIncluded) {
            builder.append(SYMBOLS);
        }
        characters = builder.toString();
    }

    public String getAlphabet() {
        return characters;
    }

    public boolean isEmpty() {
        return characters.isEmpty();
    }
}
