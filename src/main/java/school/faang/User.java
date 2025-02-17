package school.faang;

public class User {
    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};
    private static final int AGE_LIMIT = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < AGE_LIMIT) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (isValidityWord(job, 1)) {
            throw new IllegalArgumentException("Недопустимое место работы");
        }
        if (isValidityWord(address, 2)) {
            throw new IllegalArgumentException("Недопустимое место работы");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public boolean isValidityWord(String word, int list) {
        boolean isValidityWord = true;
        if (list == 1) {
            for (String validWord : VALID_JOBS) {
                if (word.equals(validWord)) {
                    isValidityWord = false;
                    break;
                }
            }
        } else if (list == 2) {
            for (String validWord : VALID_ADDRESSES) {
                if (word.equals(validWord)) {
                    isValidityWord = false;
                    break;
                }
            }
        }
        return isValidityWord;
    }
}
