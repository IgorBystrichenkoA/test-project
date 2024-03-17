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
        System.out.println("������� ����� ������");
        int month = readInt();

        if (month < 1 || month > 12) {
            System.out.println("����� ��������� ������ ������ ���� �� 1 �� 12 ������������");
            return;
        }

        System.out.println("������� ���� �� 1 �� 30 (������������)");
        int day = readInt();
        if (day < 1 || day > 30) {
            System.out.println("����� ��������� ��� ������ ���� �� 1 �� 30 ������������");
            return;
        }

        System.out.println("������� ���������� �����");
        int numberOfSteps = readInt();
        if (numberOfSteps < 1) {
            System.out.println("���������� ����� ������ ���� ������������� ������");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.setSteps(day, numberOfSteps);
    }

    public void changeStepGoal() {
        System.out.println("������� ����� ���� ����� �� ����");
        int newGoal = readInt();

        if (newGoal < 1) {
            System.out.println("���� ����� �� ����� ���� ������ ���� ����� ����");
            return;
        }

        goalByStepsPerDay = newGoal;
    }

    public void printStatistic() {
        System.out.println("������� ����� ������");
        int month = readInt();
        if (month < 1 || month > 12) {
            System.out.println("����� ��������� ������ ������ ���� �� 1 �� 12 ������������");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();

        monthData.printDaysAndStepsFromMonth();
        System.out.println("����� ����� �� �����: " + sumSteps);
        System.out.println("������������� ���������� ���������� ����� �� �����: " + monthData.maxSteps());
        System.out.println("������� ���������� ���������� ����� �� �����: " + (sumSteps / 30));
        System.out.println("���������� �� ����� ��������� � ����������: " + Converter.convertToKm(sumSteps));
        System.out.println("���������� �������� ����������� �� �����: "
                + Converter.convertStepsToKilocalories(sumSteps));
        System.out.println("������ �����: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }

    private int readInt() {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
