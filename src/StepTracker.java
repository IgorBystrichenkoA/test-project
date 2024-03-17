import java.util.Scanner;

public class StepTracker {
    private final Scanner scanner;
    private int goalByStepsPerDay = 10000;
    private final MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("¬ведите номер мес€ца");
        int month = readInt();

        if (month < 1 || month > 12) {
            System.out.println("Ќомер вводимого мес€ца должен быть от 1 до 12 включительно");
            return;
        }

        System.out.println("¬ведите день от 1 до 30 (включительно)");
        int day = readInt();
        if (day < 1 || day > 30) {
            System.out.println("Ќомер вводимого дн€ должен быть от 1 до 30 включительно");
            return;
        }

        System.out.println("¬ведите количество шагов");
        int numberOfSteps = readInt();
        if (numberOfSteps < 1) {
            System.out.println(" оличество шагов должно быть положительным числом");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.setSteps(day, numberOfSteps);
    }

    public void changeStepGoal() {
        System.out.println("¬ведите новую цель шагов на день");
        int newGoal = readInt();

        if (newGoal < 1) {
            System.out.println("÷ель шагов не может быть меньше либо равна нулю");
            return;
        }

        goalByStepsPerDay = newGoal;
    }

    public void printStatistic() {
        System.out.println("¬ведите число мес€ца");
        int month = readInt();
        if (month < 1 || month > 12) {
            System.out.println("Ќомер вводимого мес€ца должен быть от 1 до 12 включительно");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();

        monthData.printDaysAndStepsFromMonth();
        System.out.println("—умма шагов за мес€ц: " + sumSteps);
        System.out.println("ћаксимального пройденное количество шагов за мес€ц: " + monthData.maxSteps());
        System.out.println("—реднее пройденное количество шагов за мес€ц: " + (sumSteps / 30));
        System.out.println("ѕройденна€ за мес€ц дистанци€ в километрах: " + Converter.convertToKm(sumSteps));
        System.out.println(" оличество сожжЄнных килокалорий за мес€ц: "
                + Converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Ћучша€ сери€: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    private int readInt() {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
