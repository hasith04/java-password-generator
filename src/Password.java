
public class Password {
    private final String value;

    public Password(String value) {
        this.value = value == null ? "" : value;
    }

    public String getValue() {
        return value;
    }

    public int length() {
        return value.length();
    }

    public int charType(char c) {
        if (Character.isUpperCase(c)) {
            return 1;
        }
        if (Character.isLowerCase(c)) {
            return 2;
        }
        if (Character.isDigit(c)) {
            return 3;
        }
        return 4;
    }

    public int passwordStrength() {
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNumber = false;
        boolean usedSymbol = false;

        for (char c : value.toCharArray()) {
            int type = charType(c);
            if (type == 1) {
                usedUpper = true;
            } else if (type == 2) {
                usedLower = true;
            } else if (type == 3) {
                usedNumber = true;
            } else if (type == 4) {
                usedSymbol = true;
            }
        }

        int score = 0;
        if (usedUpper) {
            score += 1;
        }
        if (usedLower) {
            score += 1;
        }
        if (usedNumber) {
            score += 1;
        }
        if (usedSymbol) {
            score += 1;
        }
        if (value.length() >= 8) {
            score += 1;
        }
        if (value.length() >= 16) {
            score += 1;
        }
        return score;
    }

    public String calculateScore() {
        int score = passwordStrength();
        if (score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        }
        if (score >= 4) {
            return "This is a good password :) but you can still do better";
        }
        if (score >= 3) {
            return "This is a medium password :/ try making it better";
        }
        return "This is a weak password :( definitely find a new one";
    }

    @Override
    public String toString() {
        return value;
    }
}
