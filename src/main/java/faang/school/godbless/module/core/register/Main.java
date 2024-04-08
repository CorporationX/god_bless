package faang.school.godbless.module.core.register;

public class Main {
    private static final String JOB_GOOGLE = "Google";
    private static final String JOB_UBER = "Uber";
    private static final String JOB_AMAZON = "Amazon";
    private static final String ADDRESS_LONDON = "London";
    private static final String ADDRESS_NEW_YORK = "New York";
    private static final String ADDRESS_AMSTERDAM = "Amsterdam";
    
    public static void main(String[] args) {
        registerUser("", 20, JOB_GOOGLE, ADDRESS_LONDON);
        registerUser(" ", 20, JOB_UBER, ADDRESS_NEW_YORK);
        registerUser(null, 20, JOB_AMAZON, ADDRESS_AMSTERDAM);
        registerUser("Vlad", 17, JOB_UBER, ADDRESS_LONDON);
        registerUser("Лилия", 31, JOB_UBER, "Улица Пушкина");
        registerUser("Володька", 31, "Фрезировщик", ADDRESS_LONDON);
        registerUser("Димка", 31, JOB_AMAZON, ADDRESS_LONDON);
    }
    
    public static void registerUser(String name, int year, String job, String address) {
        try {
            System.out.printf("Пользовать успешно создан: %s", new User(name, year, job, address));
        } catch (Exception e) {
            System.out.printf("Ошибка валидации создания пользователя: %s \n", e.getMessage());
        }
    }
}
