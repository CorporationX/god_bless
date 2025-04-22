package school.faang.stream3.parallelismthread.workformicrosoft;

public class Email {
    private String name;
    private String content;

    public Email() {
        name = RandomStringGenerator.generateRandomString(6);
        content = RandomStringGenerator.generateRandomString(20);
    }
}
