package ru.kraiush.lambda.BJS2_21169;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppWeHandleErrorsBeautifully {

    public static void main(String[] args) {

        SomeService service1 = new SomeService("abra");
        SomeService service2 = new SomeService("cada");
        SomeService service3 = new SomeService("bra");
        List<SomeService> listServices = new ArrayList<>();
        listServices.add(service1);
        listServices.add(service2);
        listServices.add(service3);

        String param = "cada";

        System.out.print(String.join("", Collections.nCopies(80, "-")));

        System.out.println("\n some Service" );
        System.out.println(listServices);

        System.out.println("\nUsing two Functional Interfaces");
        List<Object> result = RemoteService.withErrorHandling(listServices, param);
        System.out.println("result: " + result);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
