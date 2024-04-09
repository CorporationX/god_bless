package faang.school.godbless.lambdas.task_5.util;

import faang.school.godbless.lambdas.task_5.model.Email;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailProcessor {
    public <T> void processEmails(List<Email> emails, Predicate<Email> filter, Consumer<Email> handler, Function<Email, T> converter) {
        for (Email email : emails) {
            if (filter.test(email)) {
                T convertedLetter = converter.apply(email);
                createBackup(email);
                handler.accept(email);
                System.out.println("В письме " + email + " произошли преобразования. Преобразованная часть " + convertedLetter);
            }
        }
    }

    private void createBackup(Email email) {
        Consumer<Email> backupHandler = (mail) -> System.out.println("Создана копия старой версии объекта " + mail);
        backupHandler.accept(email);
    }
}