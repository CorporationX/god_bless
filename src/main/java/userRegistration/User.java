package userRegistration;
import java.util.HashSet;
public class User {

    String name, work, home;
    int age;

    public static HashSet<String> VALID_JOBS = new HashSet<>();
    public static HashSet<String> VALID_ADDRESSES = new HashSet<>();
    User(String name, String home, String work, int age) {
        try {
            if (age < 18 || name.isEmpty() || VALID_JOBS.contains(work) == false ||
                    VALID_ADDRESSES.contains(home) == false) {
                throw new IllegalArgumentException();
            } else {              //создал условие, с перечислением присваеваемых значний для User
                this.name = name; // если хоть одно из уловий = true
                this.age = age;   // то выбрасывается исключение , а если false
                this.work = work; // то введеные значения присваиваются User-у
                this.home = home;
            }
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("Некорректно введена информация о пользователе");
        }
    }
    public static void main(String[] args) {

        VALID_JOBS.add("Google");           // доваляю значения в Сеты
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");

        User User1 = new User("Bob","London","Uber",5);
        System.out.println(User1.name);    //проверяю присвоенные значения для User
        System.out.println(User1.work);
        System.out.println(User1.home);
        System.out.println(User1.age);

        User User2 = new User("Jack","London","Uber",45); // второй User для проверки
        System.out.println(User2.name);
    }
}
