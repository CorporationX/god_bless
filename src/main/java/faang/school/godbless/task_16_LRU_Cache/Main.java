package faang.school.godbless.task_16_LRU_Cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final int CACHE_SIZE = 5;
    private static final Map<Integer, Data> dataMap = new HashMap<>();
    private static final Random rand = new Random();
    private static int countData = 0;

    public static void main(String[] args) throws InterruptedException {
        // Заполнение хэша данными
        addData(createData(++countData)); // 1
        addData(createData(++countData)); // 2
        addData(createData(++countData)); // 3
        addData(createData(++countData)); // 4
        addData(createData(++countData)); // 5

        // Обращение к данными, для обновление их timestamp
        getData(1);
        getData(2);
        getData(3);

        // Получаем не существующие данные, которые сгенерирует струтура и которые заменят данные с id: 4, 5.
        getData(6); // 6
        getData(40); // 40
        // Сгенерирует данные с id: 7, которые заменят id: 1.
        addData(createData(++countData));  // 7

//        // Выводим хэш в консоль
        showAllData(); // id: 2, 3, 6, 7, 40
    }

    /**
     * Выводид данные в консоль
     */
    private static void showAllData() {
        for (Data data : dataMap.values()) {
            System.out.printf("id: %d, value: %d, timestamp: %s\n", data.getId(), data.getValue(), data.getTimestamp());
        }
    }

    /**
     * Возвращает данные из хэша по id или генерирует новые данные.
     *
     * @param id
     * @return
     */
    private static Data getData(int id) throws InterruptedException {
        // Если в хэш есть данные с таким id, то обновляю им timestamp и возвращаю
        if (dataMap.containsKey(id)) {
            updateTimestamp(id);
            return dataMap.get(id);
        }

        // Создание и добавление в хэш данных, которых там ранее не было
        // id произвольные. Со счётчиком данных не пересекается.
        Data newData = createData(id);
        addData(newData);
        return newData;
    }

    /**
     * Обновление времени при повторном обращении к данным,
     * хранящимся в хэше
     *
     * @param id
     */
    private static void updateTimestamp(int id) {
        dataMap.get(id).setTimestamp(LocalDateTime.now());
    }

    /**
     * Добавление данных в хэш.
     *
     * @param data
     */
    private static Data addData(Data data) throws InterruptedException {
        // Для проверки timastamp во время вывода в консоль
        Thread.sleep(1000);

        // Если данные с таким id уже существуют (из-за метода getData(someId) -> createData(int someId))
        if (dataMap.containsKey(data.getId())) {
            // увеличиваем счётчик данных, пока не получим не занятый id
            while (dataMap.containsKey(countData)) {
                countData++;
            }
            data.setId(countData);
        }

        // Проверка заполненности хэша
        if (dataMap.size() + 1 > CACHE_SIZE) {
            deleteOldDataFromHash();
        }
        dataMap.put(data.getId(), data);

        // На случай изменения id, возвращаем данные с актуальным полем
        return data;
    }

    /**
     * Удаляет самые старые данные из хэша
     */
    private static void deleteOldDataFromHash() {
        LocalDateTime oldTimeStamp = LocalDateTime.now();
        Data oldData = null;

        for (Data data : dataMap.values()) {
            LocalDateTime dataTimeStamp = data.getTimestamp();

            if (dataTimeStamp.isBefore(oldTimeStamp)) {
                oldTimeStamp = dataTimeStamp;
                oldData = data;
            }
        }
        // Метод вызывается в случаи если хэш переполнен,
        // поэтому null не вернёт, ведь в хэше есть данные старше LocalDateTime.now()
        dataMap.remove(oldData.getId());
    }

    /**
     * Имитация получения Data из структуры данных.
     *
     * @param id
     * @return
     */
    private static Data createData(int id) {
        return new Data(id, rand.nextInt(100), LocalDateTime.now());
    }
}
