package faang.school.godbless.BJS2_8924;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.BJS2_8924.Main.database;

public class LRUChache {
    public final int CACHE_SIZE;
    private final Map<Integer, DataCell> cache = new HashMap<>();
    // В голове будет хранится недавний использованный (recently used)
    private DataCell headCell;
    // В хвосте будет хранится самый давний использованный (least recently used)
    private DataCell tailCell;

    public LRUChache(int CACHE_SIZE) {
        this.CACHE_SIZE = CACHE_SIZE;
    }

    public String getData(Integer key) {
        String data;

        if (cache.containsKey(key)) {
            // если есть в кэше, то возвращаем из значение из него
            DataCell dataCell = cache.get(key);
            putToHead(dataCell);
            data = dataCell.getValue();
        } else {
            // если нет, то запрашиваем значение из базы и обновляем кэш
            data = database.getDataFromDatabase(key);
            cache.put(key, new DataCell(key, data));
            putToHead(cache.get(key));
        }

        return data;
    }

    public void putData(Integer key, String data) {
        if (cache.containsKey(key)) {
            DataCell dataCell = cache.get(key);
            dataCell.setValue(data);

            putToHead(dataCell);
        } else {
            DataCell dataCell = new DataCell(key, data);

            if (cache.size() != CACHE_SIZE) {
                addToHead(dataCell);
            } else {
                cache.remove(headCell.getId());
                removeCellFromTail();
                addToHead(dataCell);
            }

            // обновляем кэш и базу
            cache.put(key, dataCell);
            database.addDataToDatabase(key, dataCell.getValue());
        }
    }


    // метод перемещает ячейку в голову (recently used)
    private void putToHead(DataCell dataCell) {
        if (dataCell != headCell) {
            // если dataCell это хвост, то все по другому
            if (dataCell != tailCell) {
                // вычленяем dataCell
                dataCell.previousCell.nextCell = dataCell.nextCell;
                dataCell.nextCell.previousCell = dataCell.previousCell;

                // вставляем в headCell
                dataCell.nextCell = headCell;
                headCell.previousCell = dataCell;
                dataCell.previousCell = null;
            } else {
                dataCell.previousCell.nextCell = null;
                dataCell.previousCell = null;
                dataCell.nextCell = headCell;
                headCell.previousCell = dataCell;
            }
        }
    }

    // метод добавляет ячейку в голову (recently used)
    private void addToHead(DataCell dataCell) {
        // если у нас есть элементы в списке
        if (headCell != null) {
            headCell.previousCell = dataCell;
            dataCell.nextCell = headCell;
            dataCell.previousCell = null;
        } else {
            // если headCell == null то и tailCell == null - пустой список
            tailCell = dataCell;
        }

        headCell = dataCell;
    }

    // удаляет последний элемент из хвоста (least recently used)
    private void removeCellFromTail() {
        // когда хвост это голова
        if (headCell == tailCell) {
            // теперь у нас и хвост и голова null
            tailCell = null;
        } else {
            tailCell.previousCell.nextCell = null;
            tailCell = tailCell.previousCell;
        }
    }

    @Getter
    @Setter
    private class DataCell {
        private Integer id;
        private String value;
        private DataCell nextCell;
        private DataCell previousCell;

        public DataCell(Integer id, String value) {
            this.id = id;
            this.value = value;
        }
    }
}
