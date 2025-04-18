package school.faang.bjs268455;

import java.util.Set;

public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String address) {
        // add validation for VALID_JOBS and VALID_ADDRESSES
        //if (VALID_JOBS) {
        //}
        //if (VALID_ADDRESSES) {
        //}

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}



/*
Создать класс пользователя с конструктором, который выполняет валидацию входных данных
на основе заранее определённых критериев. Программа должна демонстрировать использование
статических констант, множеств (Set), проверки условий и обработки исключений.

Требования:
Создайте класс User, который представляет пользователя и содержит следующие поля:

name — имя пользователя.
age — возраст пользователя.
job — место работы.
address — адрес.

Объявите и инициализируйте статические константы:
VALID_JOBS — набор допустимых мест работы, содержащий строки: "Google", "Uber", "Amazon".
VALID_ADDRESSES — набор допустимых адресов, содержащий строки: "London", "New York", "Amsterdam".
Создайте конструктор в классе User, который принимает значения для всех полей и выполняет валидацию входных данных:
Имя не может быть пустым.
Возраст не может быть меньше 18.
Место работы должно содержаться в наборе VALID_JOBS.
Адрес должен содержаться в наборе VALID_ADDRESSES.
Если хотя бы одно из условий не выполняется, конструктор должен выбросить IllegalArgumentException с описанием ошибки.
Если все условия выполняются, конструктор должен сохранять значения в соответствующих полях.
 */