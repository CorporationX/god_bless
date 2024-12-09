package CendalJoe_BJS2_43754;

import static CendalJoe_BJS2_43754.Main.VALID_ADDRESSES;
import static CendalJoe_BJS2_43754.Main.VALID_JOBS;

public class Users {
    private String name;
    private int age;
    private String job;
    private String address;



    public Users( String name, int age, String job, String address ) {
        if ( this.name.contains("") || this.name.isBlank() ){

        }
        this.name = name;

        if( this.age >= 18 ) {
            this.age = age;
        }else{

        }
        if(VALID_JOBS.contains(job)) {
            this.job = job;
        } else {

        }
        if(VALID_ADDRESSES.contains(address)) {
            this.address = address;
        }else {

        }
        }
    }

