package school.faang.task51248;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class Department implements Runnable {

    @Setter
    private Department departmentAnalyze;
    private final Set<String> files;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void run() {
        Objects.requireNonNull(departmentAnalyze);

        try {
            if (departmentAnalyze.files.isEmpty()) {
                throw new IllegalArgumentException(String.format("files у %s пуст", departmentAnalyze));
            }

            writeFile(departmentAnalyze.files);
        } catch (IllegalArgumentException e) {
            log.error("Произошла ошибка при записи файла", e);
        }
    }

    public void readFiles() {
        lock.readLock().lock();

        try {
            log.info(files.toString());
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeFile(Set<String> newFiles) {
        lock.writeLock().lock();

        try {
            Objects.requireNonNull(newFiles);

            if (departmentAnalyze.equals(this)) {
                throw new IllegalArgumentException("Невозможно записать в 1 и тот же department");
            }

            Set<String> oldFiles = newFiles.stream()
                    .filter(file -> !files.contains(file))
                    .collect(Collectors.toSet());

            files.addAll(oldFiles);

            log.info("Файлы добавлены {} в {}", oldFiles, this);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
