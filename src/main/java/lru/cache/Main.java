package lru.cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static int ID = 1;
    private static final Scanner SCANNER = new Scanner(System.in);
    private final static Map<Integer, Data> dataBase = new HashMap<>();
    private final static int CACHE_SIZE = 3;
    private final static String START_MESSAGE = "Список доступных команд: \n" +
            "'print base' - вывод базы данных\n" +
            "'get data' - получить данные запроса по ID\n" +
            "'stop' - остановить работу программы.";

    private final static Map<Integer, Data> cache = new LinkedHashMap<>(CACHE_SIZE) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            if (cache.size() > CACHE_SIZE) {
                System.out.println("Удален старый элемент");
                return true;
            }
            return false;
        }
    };

    public static void main(String[] args) {

        System.out.println(START_MESSAGE);

        while (true) {
            System.out.println("Введите свой запрос: ");
            String input = SCANNER.nextLine();

            if (input.equals("print cache")) {
                printCache(cache);
                continue;
            }
            if (input.equals("get data")) {
                System.out.println("Введите ID");
                int id = Integer.parseInt(SCANNER.nextLine());
                getData(id);
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

    public static void getData(int id) {
        if (cache.containsKey(id)) {
            cache.get(id).setTimestamp(LocalDateTime.now());
            System.out.println(cache.get(id));
            System.out.println("Данные полученны кэша.");
        } else {
            if (dataBase.containsKey(id)) {
                dataBase.get(id).setTimestamp(LocalDateTime.now());
                System.out.println("Данные полученны из базы и добавлены в кэш.");
                cache.put(id, dataBase.get(id));
                System.out.println(cache.get(id));
                System.out.println("Данные полученны из кэша.");
            } else {
                throw new IllegalArgumentException("Данных нет");
            }
        }
    }

    public static void printCache(Map<Integer, Data> cache) {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static Data createData(String value) {
        return new Data(ID++, value);
    }

}
