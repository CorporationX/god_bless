package school.faang.google.docs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

@AllArgsConstructor
@Slf4j
public class DocumentSection {
    private static final String DOC_IS_NOT_AVAILABLE_FOR_UPD = "Документ ожидает завершение обновления данных. " +
            "Попробуйте повторить операцию позже";
    public static final int UPDATE_TIMEOUT = 5;

    @Getter
    private String id;

    private CollaborativeDocument document;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    public String read() {
        rwLock.readLock().lock();
        try {
            return document.getData(id);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void write(String data) {
        rwLock.writeLock().lock();
        try {
            document.addData(id, data);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void update(Function<String, String> process) {
        try {
            TimeUnit.SECONDS.sleep(UPDATE_TIMEOUT);
            boolean isLocked = rwLock.writeLock().tryLock(10, TimeUnit.SECONDS);
            if (isLocked) {
                try {
                    System.out.println(Thread.currentThread().getName() + " читаем и обрабатываем данные: " + id);
                    String currData = document.getData(id);
                    String updatedData = process.apply(currData);

                    System.out.println(Thread.currentThread().getName() + " записываем обновленные данные: " + id);
                    write(updatedData);
                } finally {
                    rwLock.writeLock().unlock();
                }
            } else {
                System.out.println(DOC_IS_NOT_AVAILABLE_FOR_UPD + ": " + id);
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        return id;
    }
}
