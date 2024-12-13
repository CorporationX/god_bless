package school.faang.task_43777;

public record User(String name, int age, String job, String address) {
    public User(String name, int age, String job, String address) {
        this.name = UserValidator.validateName(name);
        this.age = UserValidator.validateAge(age);
        this.job = UserValidator.validateJob(job);
        this.address = UserValidator.validateAddress(address);
    }
}