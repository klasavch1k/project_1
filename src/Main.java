import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int startChoice;
        GameLogicManager gameManager;

        System.out.println("Добро пожаловать в игру Висилица!");
        System.out.println("Выберите действие:");
        System.out.println("1. Начать игру");
        System.out.println("2. выйти");

        while (true){
            Scanner scanner = new Scanner(System.in);
            try {
                startChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка: введите число 1 или 2");
                scanner.next();
                continue;
            }
            if(startChoice == 1){
                gameManager = new GameLogicManager();
                gameManager.startGame();
            } else if (startChoice == 2) {
                System.out.println("Выход из игры. До свидания!");
                break;
            } else {
                System.out.println("Ошибка: введите число 1 или 2");
            }
            System.out.println("хотите сыграть еще раз? (1 - да, 2 - нет)");
        }
    }
}