package school.faang.sprint1.task_BJS2_56941;

import lombok.NonNull;

public interface Library {
    void addBook(String title, String author, int year, String location);

    void removeBook(String title, String author, int year);

    void findBook(String title, String author, int year);

    void printAllBooks();
}
