package GroupingUsersByAge;

public class User {
    private final String name;
    private final String work;
    private final String home;
    private final int age;

    public String getName(){
        return name;
    }
    public String getWork(){
        return work;
    }
    public String getHome(){
        return home;
    }
    public int getAge(){
        return age;
    }
    public User(String setName, String setWork, String setHome, int setAge) {
        this.name = setName;
        this.work = setWork;
        this.home = setHome;
        this.age = setAge;
    }
    public String toString() {
        String text = "";
        text += this.name + " : name, ";
        text += this.work + " : work, ";
        text += this.home + " : home, ";
        text += this.age + " : age ";
        return text;
    }

}


