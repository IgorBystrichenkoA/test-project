public class Converter {
    private final static int STEP_LENGTH = 75; // В сантиметрах
    private final static int STEP_CALORIES = 50;

    /** Переводит количество шагов в километры. Возвращаемый тип int выбран по ТЗ */
    public static int convertToKm(int steps) {
        return steps * STEP_LENGTH / 100000;
    }

    /** Переводит количество шагов в килокалории. Возвращаемый тип int выбран по ТЗ */
    public static int convertStepsToKilocalories(int steps) {
        return steps * STEP_CALORIES / 1000;
    }
}
