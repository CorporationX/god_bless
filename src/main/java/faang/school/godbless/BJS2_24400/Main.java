package faang.school.godbless.BJS2_24400;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = getUsers();
        ChatManager chatManager = new ChatManager();
        Thread initTread = new Thread(chatManager::start);
        initTread.start();
        users.forEach(chatManager::startChat);
    }

    private static List<User> getUsers() {
        return List.of(
                new User("Robert"),
                new User("Sultan"),
                new User("Denis"),
                new User("Andrey"),
                new User("Mikhail"),
                new User("Vladislav"),
                new User("Ivan"),
                new User("Dmitry"),
                new User("Nikolay"),
                new User("Oleg"),
                new User("Alexey"),
                new User("Sergey"),
                new User("Victor"),
                new User("Konstantin"),
                new User("Roman"),
                new User("Yuri"),
                new User("Maxim"),
                new User("Artem"),
                new User("Evgeny"),
                new User("Pavel"),
                new User("Igor"),
                new User("Kirill"),
                new User("Vadim"),
                new User("Anton"),
                new User("Gleb"),
                new User("Boris"),
                new User("Anatoly"),
                new User("Vyacheslav"),
                new User("Alexander"),
                new User("Stepan"),
                new User("Timur"),
                new User("Eduard"),
                new User("Leonid"),
                new User("Fedor"),
                new User("Stanislav"),
                new User("Rostislav"),
                new User("Matvey"),
                new User("Vladimir"),
                new User("Grigory"),
                new User("Alexandr"),
                new User("Vasiliy"),
                new User("Daniil"),
                new User("Georgiy"),
                new User("Ilya"),
                new User("Yaroslav"),
                new User("Bogdan"),
                new User("Semyon"),
                new User("Maksim"),
                new User("Timofey"),
                new User("Gennady"),
                new User("Albert"),
                new User("Artur"),
                new User("Denis"),
                new User("Nikita"),
                new User("Ruslan"),
                new User("Valentin"),
                new User("Oleg"),
                new User("Svyatoslav"),
                new User("Platon"),
                new User("Mark"),
                new User("Adam"),
                new User("Vladlen"),
                new User("Rodion"),
                new User("Veniamin"),
                new User("Aleksey"),
                new User("Boris"),
                new User("Valery"),
                new User("Gavriil"),
                new User("Saveliy"),
                new User("Arseniy"),
                new User("German"),
                new User("Demid"),
                new User("Efim"),
                new User("Kuzma"),
                new User("Lev"),
                new User("Makar"),
                new User("Miron"),
                new User("Nazar"),
                new User("Rinat"),
                new User("Tikhon"),
                new User("Filipp"),
                new User("Zahar"),
                new User("Vadik"),
                new User("Stepan"),
                new User("Konstantin"),
                new User("Anton"),
                new User("Oleg"),
                new User("Gleb"),
                new User("Alexandr"),
                new User("Denis"),
                new User("Mark"),
                new User("Nikita"),
                new User("Fedor"),
                new User("Timur"),
                new User("Boris"),
                new User("Ilya"),
                new User("Arseniy"),
                new User("Gennady"),
                new User("Platon"),
                new User("Maxim"),
                new User("Leonid")
        );
    }
}
