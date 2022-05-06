import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        Logger logger = Logger.getInstance();

        logger.log("Запуск программы");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.print("Введите размер списка: ");
        int sizeList = scan.nextInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int topTreshold = scan.nextInt();

        List<Integer> allValues = Arrays.asList(new Integer[sizeList]);
        logger.log("Cоздаём и наполняем список");

        StringBuilder logList = new StringBuilder();
        for (int i = 0; i < allValues.size(); i++) {
            int r = random.nextInt(topTreshold);
            allValues.set(i, r);
            logList.append(r).append(" ");
        }
        System.out.println("Вот случайный список: " + logList);

        logger.log("Просим пользователя ввести входные данные для фильтрации");

        System.out.print("Введите порог для фильтра: ");
        int treshold = scan.nextInt();

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(allValues);

        logger.log("Выводим результат на экран");
        StringBuilder resultList = new StringBuilder();
        for (int value : result) {
            resultList.append(value).append(" ");
        }

        System.out.println("Отфильтрованный список: " + resultList);
        logger.log("Завершаем работу");
    }
}
