package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;
    private Set<String> hobbiesSet;
    private List<User> users;
    private User vasya;
    private User petya;
    private User kolya;
    private User slava;
    private User sasha;

    @BeforeEach
    public void setUp() {

        //Инициализируем пользователя
        user = new User();

        //Заполняем множество увлечений
        hobbiesSet = Set.of("Футбол", "Сумерки", "Дом 2", "Звёздные войны", "Пацаны");

        //Заполняем список пользователей
        vasya = new User(1, "Вася", 15, Set.of("Баскетбол", "CS:GO", "Футбол"));
        petya = new User(2, "Петя", 16, Set.of("Футбол", "Звёздные войны", "Пацаны"));
        kolya = new User(3, "Коля", 15, Set.of("DOTA", "Звёздные войны", "Робокоп"));
        slava = new User(4, "Слава", 17, Set.of("CS:GO", "Программирование", "Физика"));
        sasha = new User(5, "Саша", 14, Set.of("DOTA", "PUBG", "CS:GO"));

        users = List.of(vasya, vasya, petya, kolya, slava, sasha);
    }

    @Test
    public void testFindHobbyLovers() {
        // TODO: 16.06.2023   
    }
}
