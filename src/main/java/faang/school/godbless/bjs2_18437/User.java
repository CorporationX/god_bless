package faang.school.godbless.bjs2_18437;

public class User {
    private String name;
    private Integer age;
    private String jobPlace;
    private String address;

    public User(String name, Integer age, String jobPlace, String address, boolean throwMessage) {
        validateUserCreation(name, age, jobPlace, address, throwMessage);
        this.name = name;
        this.age = age;
        this.jobPlace = jobPlace;
        this.address = address;
    }

    private void validateUserCreation(String name, Integer age, String jobPlace, String address, boolean throwMessage) {
        var userValidator = new UserValidator<User>();
        if (throwMessage) {
            userValidator.validateUserCreationWithThrowingMessages(name, age, jobPlace, address);
        } else {
            userValidator.validateUserCreation(name, age, jobPlace, address);
        }
    }
}
