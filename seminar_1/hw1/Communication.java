package seminar_1.hw1;

/**
 * связи членов семьи
 */

import java.util.Objects;

public class Communication {
    private FamilyMember fm1;
    private FamilyMember fm2;
    private Kinship kin;

    public Communication(FamilyMember fm1, FamilyMember fm2, Kinship kin) {
        this.fm1 = fm1;
        this.fm2 = fm2;
        this.kin = kin;
    }

    public FamilyMember fm1() {
        return fm1;
    }

    public FamilyMember fm2() {
        return fm2;
    }

    public Kinship kin() {
        return kin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Communication communication = (Communication) o;
        return Objects.equals(fm1, communication.fm1) && Objects.equals(fm2, communication.fm2) && 
        kin == communication.kin;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", fm1, kin, fm2);
    }
}
