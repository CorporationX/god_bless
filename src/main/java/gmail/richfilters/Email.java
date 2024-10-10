package gmail.richfilters;


/*
* Создайте класс Email с полями:
subject — тема письма;
body — текст письма;
isImportant — флаг, указывающий, важное письмо или нет.*/

import lombok.Data;

@Data
public class Email {
    private final String subject;
    private final boolean isImportant;
    private String body;

    public Email(String subject, String body, boolean isImportant) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Задайте тему письма");
        }
        if (body == null) {
            throw new IllegalArgumentException("Тело письма отсутствует");
        }

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
