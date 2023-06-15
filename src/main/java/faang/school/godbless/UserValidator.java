package faang.school.godbless;

public class UserValidator {
    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name is null or empty!");
        }
    }
    public void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18");
        }
    }
    public void validateCompany(String company) {
        if (!User.VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Invalid company");
        }
    }
    public void validateAddress(String address) {
        if (!User.VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
