import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 10;
    private static final String COLOR_PURPLE = "\u001B[35m";
    private static final String COLOR_ORANGE = "\u001B[38;5;208m";
    private static final String COLOR_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen beim Geheimcode-Spiel!");
        System.out.println("Errate den vierstelligen Geheimcode.");
        System.out.println("Der Code besteht aus den Ziffern 1 bis 9, jede Ziffer kommt nur einmal vor.");
        System.out.println("Du hast pro Runde 10 Versuche. Nach jedem Versuch erfährst du,");
        System.out.println("wie viele Ziffern an der richtigen und an einer falschen Position stehen.");
        System.out.println("Lila bedeutet: Ziffer und Position stimmen. Orange bedeutet: Ziffer stimmt, Position nicht.");

        boolean playAgain = true;
        while (playAgain) {
            playGame(scanner);

            System.out.print("Möchtest du noch einmal spielen? (j/n): ");
            if (!scanner.hasNextLine()) {
                break;
            }

            String answer = scanner.nextLine().trim();
            while (!answer.equalsIgnoreCase("j") && !answer.equalsIgnoreCase("ja")
                    && !answer.equalsIgnoreCase("n") && !answer.equalsIgnoreCase("nein")) {
                System.out.print("Bitte antworte mit j (ja) oder n (nein): ");
                if (!scanner.hasNextLine()) {
                    return;
                }
                answer = scanner.nextLine().trim();
            }
            playAgain = answer.equalsIgnoreCase("j") || answer.equalsIgnoreCase("ja");
        }

        System.out.println("Danke fürs Spielen. Auf Wiedersehen!");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        String secretCode = createSecretCode();
        int attempts = 0;
        boolean codeGuessed = false;

        while (attempts < MAX_ATTEMPTS && !codeGuessed) {
            System.out.print("Dein Tipp (vier verschiedene Ziffern von 1 bis 9): ");
            if (!scanner.hasNextLine()) {
                return;
            }

            String guess = scanner.nextLine().trim();
            if (!isValidGuess(guess)) {
                System.out.println("Ungültige Eingabe. Bitte gib genau vier verschiedene Ziffern von 1 bis 9 ein.");
                continue;
            }

            attempts++;
            int correctPositions = countCorrectPositions(secretCode, guess);
            int correctDigitsWrongPosition = countCorrectDigitsWrongPosition(secretCode, guess);

            printPositionFeedback(secretCode, guess);
            System.out.println("Richtige Ziffern an der richtigen Position: " + correctPositions);
            System.out.println("Richtige Ziffern an der falschen Position: " + correctDigitsWrongPosition);
            System.out.println("Noch übrige Versuche: " + (MAX_ATTEMPTS - attempts));

            if (correctPositions == CODE_LENGTH) {
                System.out.println("Glückwunsch! Du hast den Geheimcode " + COLOR_PURPLE + secretCode
                        + COLOR_RESET + " erraten.");
                codeGuessed = true;
            }
        }

        if (!codeGuessed && attempts == MAX_ATTEMPTS) {
            System.out.println("Leider verloren. Der Geheimcode war " + COLOR_PURPLE + secretCode
                    + COLOR_RESET + ".");
        }
    }

    private static void printPositionFeedback(String secretCode, String guess) {
        System.out.print("Dein Tipp: ");
        for (int position = 0; position < CODE_LENGTH; position++) {
            char digit = guess.charAt(position);
            if (secretCode.charAt(position) == digit) {
                System.out.print(COLOR_PURPLE + digit + COLOR_RESET);
            } else if (secretCode.indexOf(digit) >= 0) {
                System.out.print(COLOR_ORANGE + digit + COLOR_RESET);
            } else {
                System.out.print(digit);
            }
        }
        System.out.println();

        for (int position = 0; position < CODE_LENGTH; position++) {
            char digit = guess.charAt(position);
            if (secretCode.charAt(position) == digit) {
                System.out.println(COLOR_PURPLE + "Stelle " + (position + 1) + ": Ziffer "
                        + digit + " passt." + COLOR_RESET);
            } else if (secretCode.indexOf(digit) >= 0) {
                System.out.println(COLOR_ORANGE + "Stelle " + (position + 1) + ": Ziffer "
                        + digit + " ist im Code, steht aber an der falschen Stelle." + COLOR_RESET);
            } else {
                System.out.println("Stelle " + (position + 1) + ": Ziffer " + digit
                        + " kommt nicht im Code vor.");
            }
        }
    }

    private static String createSecretCode() {
        Random random = new Random();
        boolean[] usedDigits = new boolean[10];
        char[] code = new char[CODE_LENGTH];

        for (int position = 0; position < CODE_LENGTH; position++) {
            int digit = random.nextInt(9) + 1;
            while (usedDigits[digit]) {
                digit = random.nextInt(9) + 1;
            }
            usedDigits[digit] = true;
            code[position] = (char) ('0' + digit);
        }

        return new String(code);
    }

    private static boolean isValidGuess(String guess) {
        if (guess.length() != CODE_LENGTH) {
            return false;
        }

        boolean[] usedDigits = new boolean[10];
        for (int position = 0; position < CODE_LENGTH; position++) {
            char character = guess.charAt(position);
            if (character < '1' || character > '9') {
                return false;
            }

            int digit = character - '0';
            if (usedDigits[digit]) {
                return false;
            }
            usedDigits[digit] = true;
        }

        return true;
    }

    private static int countCorrectPositions(String secretCode, String guess) {
        int count = 0;
        for (int position = 0; position < CODE_LENGTH; position++) {
            if (secretCode.charAt(position) == guess.charAt(position)) {
                count++;
            }
        }
        return count;
    }

    private static int countCorrectDigitsWrongPosition(String secretCode, String guess) {
        int count = 0;
        for (int guessPosition = 0; guessPosition < CODE_LENGTH; guessPosition++) {
            if (secretCode.charAt(guessPosition) != guess.charAt(guessPosition)) {
                for (int secretPosition = 0; secretPosition < CODE_LENGTH; secretPosition++) {
                    if (guess.charAt(guessPosition) == secretCode.charAt(secretPosition)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
