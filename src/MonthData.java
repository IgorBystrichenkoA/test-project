import java.util.Arrays;

public class MonthData {
    // �� �� �� ���� ������� � ���� �� 30 ����
    private final int[] days = new int[30];

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " ����: " + days[i]);
        }
        Arrays.stream(days).max();
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int steps : days) {
            sumSteps = sumSteps + steps;
        }
        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = days[0];
        for (int steps : days) {
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int steps : days) {
            if (steps >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (finalSeries < currentSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }

        // ���� � ��������� ���� ���������� ����� ���� ����� ��� ���� ��������, �� ��������� �������
        // � ����� �� �����������, ������� ��������� ��������� ������� ��������
        if (finalSeries < currentSeries) {
            finalSeries = currentSeries;
        }
        return finalSeries;
    }

    public void setSteps(int day, int steps) {
        days[day - 1] = steps;
    }
}
