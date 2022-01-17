import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    HashMap<Integer, MonthData> data = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    int goalSteps = 10000;
            StepTracker () {
                for (int i = 0; i < 12; i++) {
                    data.put((i + 1), new MonthData()); // заполняем хеш-таблицу ключами (номер месяца) и значениями (пустые)
                }
            }
            void saveStepsPerDay() {
                System.out.println("Введите номер месяца:");
                int month = scanner.nextInt();
                MonthData monthData = data.get(month); //из хеш-таблицы вытащили массив для конкретного месяца
                System.out.println("Введите номер дня:");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int stepsInput = scanner.nextInt();
                while (stepsInput < 0) {
                    System.out.println("Количество шагов должно быть неотрицательным! \n Введите количество шагов:");
                    stepsInput = scanner.nextInt();
                }
                monthData.steps[(day - 1)] = stepsInput; //в массив days добвляем шаги
                data.put(month,monthData);
                /*Если за какой-то день статистика не сохранялась, то считаем количество шагов в этот день равным 0.*/
            }

        class MonthData {
            int[] steps = new int[30];
        }

    void printStatisticForMonth() {
        System.out.println("Введите номер месяца, за который хотите посмотреть статистику:");
        int month = scanner.nextInt();
        MonthData thisMonthData = data.get(month);
        System.out.print("Количество пройденных шагов: ");
        for (int i = 0; i < 30; i++) {
            System.out.print((i + 1) + " день: " + thisMonthData.steps[i] + ", ");
        }

        int totalStepsPerMonth = 0;
        for (int i = 0; i < 30; i++) {
            totalStepsPerMonth = totalStepsPerMonth + thisMonthData.steps[i];
        }
        System.out.println("\nОбщее количество шагов за месяц: " + totalStepsPerMonth);

        int maxStepInMonth = 0;
        for (int i = 0; i < 30; i++) {
            if (thisMonthData.steps[i] > maxStepInMonth) {
                maxStepInMonth = thisMonthData.steps[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepInMonth);

        double averageSteps = totalStepsPerMonth / 30;
        System.out.println("Среднее количество шагов: " + averageSteps);

        Converter cnv = new Converter();
        cnv.printDistance(totalStepsPerMonth);

        int currentSeries = 0;
        int maxSeries = 0;
        for (int i = 0; i < 30; i++) {
            if (thisMonthData.steps[i] > goalSteps) {
                currentSeries = currentSeries + 1;
            } else {
                currentSeries = 0;
            }
            if (currentSeries > maxSeries) {
                    maxSeries = currentSeries;
                }
        }
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней - " + maxSeries);
    }




    void changeStepsGoal() {

        System.out.print("Введите целевое количество шагов за день?");
        int NewGoalSteps = scanner.nextInt();
        while (NewGoalSteps < 0) {
            System.out.print("Количество шагов не может быть меньше нуля! Введите значение больше нуля.");
            NewGoalSteps = scanner.nextInt();
        }
        goalSteps = NewGoalSteps;
        System.out.println("Целевое количество шагов за день = " + goalSteps);
    }

}
