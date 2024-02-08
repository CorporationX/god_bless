package group_users_by_age;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    public User(String name, int age, String workPlace, String address){
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }
    public String getName(){return name;}
    public int getAge(){return age;}

    public String getWorkPlace() {return workPlace;}

    public String getAddress() {return address;}


}
