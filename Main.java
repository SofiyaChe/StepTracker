import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.saveStepsPerDay();
            } else if (command == 2) {
                stepTracker.printStatisticForMonth();
            } else if (command == 3) {
                stepTracker.changeStepsGoal();
            } else if (command == 0) {
                System.out.println("Программа завершена!");
                break;
            } else {
                System.out.println("Такой команды нет. Выберите команду с номером от 0 до 3)");
            }
            }
        }


    public static void printMenu() {
        System.out.println("Пожалуйста, введи команду, которую нужно выполнить: \n 1 - ввести количество " +
                         "шагов за определённый день \n 2 - напечатать статистику за определённый месяц\n" +
                        " 3 - изменить цель по количеству шагов в день \n 0 - выйти из приложения.");
    }
}

