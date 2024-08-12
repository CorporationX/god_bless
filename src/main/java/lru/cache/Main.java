package lru.cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Map<Integer, Data> cache = new HashMap<>();
    private final static int CACHE_SIZE = 3;
    private final static int MAX_RANDOM_ID_FOR_DATA = 150;
    private final static String START_MESSAGE = "Список доступных команд: \n" +
            "'print base' - вывод базы данных\n" +
            "'get data' - получить данные запроса по ID\n" +
            "'stop' - остановить работу программы.";

    private static Map<Integer, Data> dataBase = new LinkedHashMap<>(CACHE_SIZE) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            if (dataBase.size() > CACHE_SIZE) {
                System.out.println("Удален старый элемент");
                return true;
            }
            return false;
        }
    };

    public static void main(String[] args) {
        boolean flagToStop = false;

        System.out.println(START_MESSAGE);

        while (true) {
            System.out.println("Введите свой запрос: ");
            String input = SCANNER.nextLine();

            if (input.equals("print base")) {
                printDataBase(dataBase);
                continue;
            }
            if (input.equals("get data")) {
                System.out.println("Введите ID");
                int id = Integer.parseInt(SCANNER.nextLine());
                getDataFromCache(id);
                continue;
            }
            if (input.equals("stop")) {
                break;
            }

            addDataToDataBase(createData(input));
        }
    }

    public static void addDataToDataBase(Data data) {
        dataBase.put(data.getId(), data);
        System.out.println("Запрос добавлен в базу данных.");
    }

    public static void getDataFromCache(int id) {
        if (cache.containsKey(id)) {
            System.out.println(cache.get(id));
            System.out.println("Данные полученны из базы и добавлены в кэш.");
            dataBase.get(id).setTimestamp(LocalDateTime.now());
        } else {
            if (dataBase.containsKey(id)) {
                System.out.println("Данные полученны из базы и добавлены в кэш.");
                cache.put(id, dataBase.get(id));
                System.out.println(cache.get(id));
                System.out.println("Данные полученны из базы и добавлены в кэш.");
                dataBase.get(id).setTimestamp(LocalDateTime.now());
            }
        }
    }

    public static void printDataBase(Map<Integer, Data> dataMap) {
        for (Map.Entry<Integer, Data> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static int generateDataId() {
        return RANDOM.nextInt(MAX_RANDOM_ID_FOR_DATA) + 1;
    }

    public static Data createData(String value) {
        int id = generateDataId();
        if (dataBase.containsKey(id)) {
            id = +generateDataId();
        }
        return new Data(id, value);
    }

}
