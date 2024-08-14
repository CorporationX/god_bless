import faang.school.godbless.LRU.Data;
import faang.school.godbless.LRU.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LruTest {
    private static Main main;

    @BeforeAll
    public static void init() {
        main = new Main();
    }

    @BeforeEach
    public void mapInit() {
        for (Long i = 0L; i < 10L; i++) {
            try {
                Thread.sleep(1);//чтобы время создания отличалось
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

            Data data = new Data(i,i);
            main.addData(data);
        }
    }

    @Test
    public void addDataTest() {
        Map<Long, Data>  map = new HashMap<>();
        for (Long i = 0L; i < 100L; i++) {
            try {
                Thread.sleep(1);//чтобы время создания отличалось
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

            Data data = new Data(i,i);
            main.addData(data);
            if (i >= 90l) {
                map.put(data.getId(), data);
            }
        }
        Assertions.assertEquals(map, main.getCache());//проверка на то, что
        // все старые запросы удалились и остальсь только новые
    }

    @Test
    public void saveTest() {
        Set<Data> expectedSet = new HashSet<>();
        Set<Data> requiredSet = new HashSet<>(main.getCache().values());

        main.save();


        try (FileInputStream inputStream = new FileInputStream(Main.getFILE_PATH());
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            while (true){//почему то objectInputStream.available() всегда влзвращает
                // 0 (хотя данные читаются нормально)
                try{
                    expectedSet.add((Data) objectInputStream.readObject());
                } catch (Exception e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(requiredSet, expectedSet);
    }

    @Test
    public void getDataTest() {
        Object[] values = main.getCache().values().toArray();
        Data data;
        if (values.length > 0) {
            data = (Data) values[(int) (values.length * Math.random())];
            Assertions.assertEquals(data, main.getData(data.getId()));
        }
    }

    @Test
    void getDataFromFileTest() {
        Object[] values = main.getCache().values().toArray();
        main.save();
        Data data = (Data) values[(int) (values.length * Math.random())];
        Data dataFromFile = main.getDataFromFile(data.getId());
        data.setTimestamp(dataFromFile.getTimestamp());//потому что при обращении меняется время
        Assertions.assertEquals(data, dataFromFile);
    }

}
