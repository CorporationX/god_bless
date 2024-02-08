package group_users_by_age;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public String getName(){return name;}
    public int getAge(){return age;}
    public String getWorkPlace() {return workPlace;}
    public String getAddress() {return address;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public User(String name, int age, String workPlace, String address){
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

}
