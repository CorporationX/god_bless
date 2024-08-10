package faang.school.godbless.LRU;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

//@todo
public class Main {
    private static final String FILE_PATH = "src/main/java/faang/school/godbless/LRU/dataFile.ser";
    private static final Integer CACHE_SIZE = 10;
    private Map<Long, Data> cache;//поменял на лонг для правдоподобности

    public Main() {
        cache = new HashMap<>();
    }

    public void save() {//сохранение данных из кэша в файл
        try(FileOutputStream outputStream = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            for (Map.Entry<Long, Data> pair : cache.entrySet()){
                objectOutputStream.writeObject(pair.getValue());
            }
        }catch (IOException e){
            System.err.println("Error!" + Arrays.toString(e.getStackTrace()));
            throw new RuntimeException();
        }
    }

    public void addData(Data data) {
        if (cache.size() == CACHE_SIZE){
            try{
                cache.remove(cache.
                        values().
                        stream().
                        min((k1, k2) -> Math.toIntExact((k1.getTimestamp().getTime() - k2.getTimestamp().getTime()))).
                        get().getId()
                );
            }catch (NoSuchElementException e){
                System.err.println("Error" + Arrays.toString(e.getStackTrace()));
                throw new RuntimeException();
            }
        }
        cache.put(data.getId(), data);
    }

    public Data getData(Long id) {
        if (cache.containsKey(id)) {
            cache.get(id).setTimestamp(new Date());
            addData(cache.get(id));
            return cache.get(id);
        }else {
            return getDataFromFile(id);
        }
    }

    private Data getDataFromFile(Long id) {
        try (FileInputStream inputStream = new FileInputStream(FILE_PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
            while (true) {
                Data data = (Data) objectInputStream.readObject();
                if (data.getId().equals(id)) {
                    data.setTimestamp(new Date());
                    addData(data);
                    return data;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error :" + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    public void printCacheCondition() {
        for (Map.Entry<Long, Data> pair : cache.entrySet()) {
            System.out.println(pair.getValue());
        }
    }


}
