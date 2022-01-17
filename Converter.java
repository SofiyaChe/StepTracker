public class Converter {
    void printDistance(int stepsInput) {
        StepTracker stTr = new StepTracker();
        double distance = (stepsInput * 75) / 100000; // расчет дистанции в км
        double lostCalories = (stepsInput * 50) / 1000; // расчет сожженных килокалорий
        System.out.println("Пройденная дистанция (в км): " + distance);
        System.out.println("Количество сожжённых килокалорий: " + lostCalories);
    }
}
