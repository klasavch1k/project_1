import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GameLogicManager {

    private static final Scanner scanner = new Scanner(System.in);
    private String word;
    private int attempts = 6;
    private ArrayList<Character> guessedLetters;
    private final HashSet<Character> enteredLetters = new HashSet<>();

    public void startGame(){
        word = WordsManager.getRandomWord();
        guessedLetters = new ArrayList<>();
        for(int i =0; i<word.length(); i++){
            guessedLetters.add( '_');
        }
        FieldManager.printField(guessedLetters, attempts, enteredLetters);

        while (attempts> 0 && ! isWordGuessed() ){
            if(processGuess()){
                FieldManager.printField(guessedLetters, attempts, enteredLetters);
                System.out.println("\nты угадал букву! Осталось попыток: " + attempts);
            }else {
                attempts--;
                FieldManager.printField(guessedLetters, attempts, enteredLetters);
                System.out.println("\nневерная буква! Осталось попыток: " + attempts);
            }
        }
        endGame();
    }

    private boolean processGuess() {
        boolean correctGuess = false;
        char guess;
        while (true){
            System.out.println();
            System.out.println("Введите букву: ");
            guess = scanner.next().charAt(0);
            if(enteredLetters.contains(guess)){
                System.out.println("Вы уже вводили эту букву. Попробуйте другую.");
            } else {
                enteredLetters.add(guess);
                break;
            }
        }
        for(int i=0; i<guessedLetters.size(); i++){

            if(Character.toLowerCase(word.charAt(i)) == guess){
                guessedLetters.set(i,guess);
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private boolean isWordGuessed() {
        for(char c : guessedLetters){
            if(c == '_'){
                return false;
            }
        }
        return true;
    }

    private void endGame() {
        boolean won = isWordGuessed();
        if (won) {
            System.out.println("Поздравляем! Вы угадали слово: " + word);
        } else {
            System.out.println("Вы проиграли! Загаданное слово было: " + word);
        }
    }
}
