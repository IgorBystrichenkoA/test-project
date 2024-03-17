public class Converter {
    private final static int STEP_LENGTH = 75; // � �����������
    private final static int STEP_CALORIES = 50;

    /** ��������� ���������� ����� � ���������. ������������ ��� int ������ �� �� */
    public static int convertToKm(int steps) {
        return steps * STEP_LENGTH / 100000;
    }

    /** ��������� ���������� ����� � �����������. ������������ ��� int ������ �� �� */
    public static int convertStepsToKilocalories(int steps) {
        return steps * STEP_CALORIES / 1000;
    }
}
