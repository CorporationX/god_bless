package BJS218427;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String work;
    private String adress;

    static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static Set<String> VALID_ADDRESSES = Set.of("London","New York","Amsterdam");

    public User(String name, int age, String work, String adress) {
            if(name == null || name.isEmpty()) {
                throw new java.lang.IllegalArgumentException("name is empty");
            }
        if(age < 18){
            throw new java.lang.IllegalArgumentException("age < 18");
        }
        if(!VALID_JOBS.contains(work) || work.isEmpty()){
            throw new java.lang.IllegalArgumentException("work does not contains in list of valid jobs");
        }
        if(!VALID_ADDRESSES.contains(adress) || adress.isEmpty()){
            throw new java.lang.IllegalArgumentException("adress does not contains in list of valid adresses");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;

    }

}
