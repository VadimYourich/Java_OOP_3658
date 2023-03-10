package seminar_1.hw1;

import java.time.LocalDate;

public class HumanFilter implements Filter<Human> {
    private String firstName;
    private String lastName;
    private Human.Sex sex;
    private LocalDate startDate;
    private LocalDate endDate;

    private HumanFilter() {
        this.firstName = null;
        this.lastName = null;
        this.sex = null;
        this.startDate = null;
        this.endDate = null;
    }

    public static HumanFilter create() {
        return new HumanFilter();
    }

    @Override
    public boolean check(Human h) {
        if (this.firstName != null && !h.firstName().equalsIgnoreCase(firstName))
            return false;
        if (this.lastName != null && !h.lastName().equalsIgnoreCase(lastName))
            return false;
        if (this.sex != null && h.sex() != this.sex)
            return false;
        if (this.startDate != null && h.birthday().isBefore(this.startDate))
            return false;
        if (this.endDate != null && h.birthday().isAfter(this.endDate))
            return false;
        return true;
    }

    public HumanFilter setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public HumanFilter setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public HumanFilter setSex(Human.Sex sex) {
        this.sex = sex;
        return this;
    }

    public HumanFilter setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public HumanFilter setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
}
