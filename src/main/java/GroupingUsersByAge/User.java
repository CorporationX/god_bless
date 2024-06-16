package GroupingUsersByAge;

public class User {
    protected String name;
    protected String work;
    protected String home;
    public int age;

    public String toString() {
        String text = "";
        text += this.name + " : name, ";
        text += this.work + " : work, ";
        text += this.home + " : home, ";
        text += this.age + " : age ";
        return text;
    }

    public User(String name, String work, String home, int age) {
        this.name = name;
        this.work = work;
        this.home = home;
        this.age = age;
    }

}


