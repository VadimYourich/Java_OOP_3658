package seminar_1.hw1;

import java.time.LocalDate;

public abstract class Human {
    enum Sex {
        MAN,
        WOMAN
    }
    
    private String firstName;
    private String lastName;
    private Sex sex;
    private LocalDate birthday;

    public Human(String firstName, String lastName, Sex sex, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public Sex sex() {
        return sex;
    }

    public LocalDate birthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s) %s", firstName, lastName, birthday, sex);
    }
}
