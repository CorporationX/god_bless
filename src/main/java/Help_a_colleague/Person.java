package Help_a_colleague;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(int index){
        this.name = Integer.toString(index);
        this.surname = Integer.toString(index);
        this.workplace = Integer.toString(index);
        this.age = index;
    }
}
