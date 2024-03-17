import java.util.Scanner;

public class Main {
    private final static String NEW_NUMBER_OF_STEPS = "1";
    private final static String NEW_STEP_GOAL = "2";
    private final static String PRINT_STATISTIC = "3";
    private final static String EXIT = "0";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case NEW_NUMBER_OF_STEPS:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case NEW_STEP_GOAL:
                    stepTracker.changeStepGoal();
                    break;
                case PRINT_STATISTIC:
                    stepTracker.printStatistic();
                    break;
                case EXIT:
                    System.out.println("Выход");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("0 - Выйти из приложения");
    }
}