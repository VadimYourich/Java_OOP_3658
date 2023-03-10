package seminar_1.hw1;

import java.time.LocalDate;

public class FamilyMember extends Human{
    public FamilyMember(int id, String firstName, String lastName, Sex sex, LocalDate birthday) {
        super(id, firstName, lastName, sex, birthday);
    }
    @Override
    public int compareTo(Human o) {
        if (this.id() == o.id()){
            return 0;
        }else if (this.id() < o.id()){
            return -1;
        }
        return 1;
    }
}
