package pages;

import com.github.javafaker.Faker;

public class DatosFaker {
    static Faker faker = new Faker();

    public static String nombre() {
        return faker.name().firstName();
    }

    public static String apellido() {
        return faker.name().lastName();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String telefono() {
        return faker.phoneNumber().subscriberNumber(10);
    }
}
