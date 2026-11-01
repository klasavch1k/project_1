import java.util.ArrayList;
import java.util.HashSet;

public class FieldManager {

    public static void printField(ArrayList<Character> guessedLetters, int attempts, HashSet<Character> enteredLetters) {
        printHangman(attempts);
        for (char c : guessedLetters) {
            System.out.print(c + " ");
        }
        System.out.println("Использованные буквы: " + enteredLetters);
    }

    private static void printHangman(int attempts) {
        switch (attempts) {
            case 6:
                System.out.println("""
                        +---+
                        |
                        |
                        |
                        |
                        |
                        =======
                        """);
                break;
            case 5:
                System.out.println("""
                        +---+
                        |   |
                        |   O
                        |
                        |
                        |
                        =======
                        """);
                break;
            case 4:
                System.out.println("""
                        +---+
                        |   |
                        |   O
                        |   |
                        |
                        |
                        =======
                        """);
                break;
            case 3:
            System.out.println("""
                        +---+
                        |   |
                        |   O
                        |  /|
                        |
                        |
                        =======
                        """);
                break;
            case 2:
                System.out.println("""
                        +---+
                        |   |
                        |   O
                        |  /|\\
                        |
                        |
                        =======""");
                break;
            case 1:
                System.out.println("""
                        +---+
                        |   |
                        |   O
                        |  /|\\
                        |  /
                        |
                        =======""");
                break;
            case 0:
                System.out.println("""
                        +---+
                        |   |
                        |   O
                        |  /|\\
                        |  / \\
                        |
                        =======""");
        }
    }
}
