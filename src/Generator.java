import java.security.SecureRandom;
import java.util.Scanner;

public class Generator {
    private static final SecureRandom RANDOM = new SecureRandom();
    private final Scanner scanner;

    public Generator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mainLoop() {
        System.out.println("Welcome to Password Generator");
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> handleGeneratePassword();
                case "2" -> handleCheckPassword();
                case "3" -> printUsefulInfo();
                case "4" -> {
                    printQuitMessage();
                    return;
                }
                default -> System.out.println("Please select a valid option (1-4).\n");
            }
        }
    }

    private void handleGeneratePassword() {
        System.out.println();
        System.out.println("Password Generator\nAnswer the questions with Yes or No.");

        Alphabet alphabet;
        while (true) {
            boolean includeLowercase = promptYesNo("Use lowercase letters (abcd...)? ");
            boolean includeUppercase = promptYesNo("Use uppercase letters (ABCD...)? ");
            boolean includeNumbers = promptYesNo("Use numbers (1234...)? ");
            boolean includeSymbols = promptYesNo("Use symbols (!@#$...)? ");

            alphabet = new Alphabet(includeUppercase, includeLowercase, includeNumbers, includeSymbols);
            if (!alphabet.getAlphabet().isEmpty()) {
                break;
            }
            System.out.println("At least one character type must be selected. Please try again.\n");
        }

        int length = promptPasswordLength();
        Password password = generatePassword(alphabet, length);
        System.out.println("\nYour generated password: " + password + "\n");
    }

    private void handleCheckPassword() {
        System.out.println();
        System.out.print("Enter a password to check: ");
        String input = scanner.nextLine();
        if (input.isBlank()) {
            System.out.println("Password cannot be empty.\n");
            return;
        }
        Password password = new Password(input);
        System.out.println(password.calculateScore() + "\n");
    }

    private boolean promptYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("yes")) {
                return true;
            }
            if (input.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Please answer 'Yes' or 'No'.");
        }
    }

    private int promptPasswordLength() {
        while (true) {
            System.out.print("Enter password length (minimum 4): ");
            String line = scanner.nextLine().trim();
            try {
                int length = Integer.parseInt(line);
                if (length >= 4) {
                    return length;
                }
                System.out.println("Password length must be at least 4.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer for password length.");
            }
        }
    }

    private Password generatePassword(Alphabet alphabet, int length) {
        String characters = alphabet.getAlphabet();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return new Password(password.toString());
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Strong passwords are usually: ");
        System.out.println("- At least 8 characters long");
        System.out.println("- A mix of uppercase and lowercase letters");
        System.out.println("- Include numbers and symbols when possible");
        System.out.println("- Not based on dictionary words, names, or personal information");
        System.out.println("- Not repeated across multiple accounts");
        System.out.println("- Free of obvious character sequences or keyboard patterns\n");
    }

    private void printMenu() {
        System.out.println("1 - Generate a password");
        System.out.println("2 - Check password strength");
        System.out.println("3 - Useful information");
        System.out.println("4 - Quit");
        System.out.print("Choice: ");
    }

    private void printQuitMessage() {
        System.out.println("Thank you for using Password Generator. Goodbye!");
    }
}
