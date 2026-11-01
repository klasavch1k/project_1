import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class WordsManager {
    private final static ArrayList<String> words;

    static {
        words = getWords();
    }


    private  static ArrayList<String> getWords()  {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/resources/words.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        try {
            while ((line = bufferedReader.readLine() )!= null) {
                words.add(line);
            }
        }catch (Exception e){
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return words;
    }

    public static String getRandomWord(){
        String word = "";
        while (word.length() < 5) {
            word = words.get((int) (Math.random() * words.size()));
        }
        return word.toLowerCase();
    }

}
