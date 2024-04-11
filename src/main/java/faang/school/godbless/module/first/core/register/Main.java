package faang.school.godbless.module.first.core.register;

public class Main {
    private static final String CORRECT_NAME = "Vova";
    private static final int CORRECT_YEAR = 30;
    private static final String CORRECT_JOB = "Google";
    private static final String CORRECT_ADDRESS = "London";
    
    public static void main(String[] args) {
        validateUserRegistration("", CORRECT_YEAR, CORRECT_JOB, CORRECT_ADDRESS);
        validateUserRegistration(" ", CORRECT_YEAR, CORRECT_JOB, CORRECT_ADDRESS);
        validateUserRegistration(null, CORRECT_YEAR, CORRECT_JOB, CORRECT_ADDRESS);
        validateUserRegistration(CORRECT_NAME, 17, CORRECT_JOB, CORRECT_ADDRESS);
        validateUserRegistration(CORRECT_NAME, CORRECT_YEAR, "Фрезировщик", CORRECT_ADDRESS);
        validateUserRegistration(CORRECT_NAME, CORRECT_YEAR, CORRECT_JOB, "Улица Пушкина");
        validateUserRegistration(CORRECT_NAME, CORRECT_YEAR, CORRECT_JOB, CORRECT_ADDRESS);
    }
    
    public static void validateUserRegistration(String name, int year, String job, String address) {
        try {
            System.out.printf("Пользовать успешно создан: %s", new User(name, year, job, address));
        } catch (Exception e) {
            System.out.printf("Ошибка валидации создания пользователя: %s \n", e.getMessage());
        }
    }
}
