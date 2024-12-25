package by.ceny.ui.domain;

import com.github.javafaker.Faker;

public class SiteData {
    public User getFullData() {
        User data = new User(new Faker().internet().emailAddress(), new Faker().internet().password(5, 8, true));
        return data;
    }

    public User getEmailData() {
        User data = new User();
        data.setEmail(new Faker().internet().emailAddress());
        return data;
    }

    public User getPasswordlData() {
        User data = new User();
        data.setPassword(new Faker().internet().password(5, 8, true));
        return data;
    }

}
