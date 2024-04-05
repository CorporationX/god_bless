package faang.school.godbless.javaHashMap.vesterosLibrary;

import lombok.Data;
import lombok.NonNull;

@Data
public class Book {
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private int year;


}
