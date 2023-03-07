package seminar_1.hw1;

import java.util.ArrayList;
import java.util.List;

public abstract class Research {
    FamilyTree ft;

    public Research(FamilyTree ft) {
        this.ft = ft;
    }

    public List<Human> spend(Human fm, Kinship kin) {
        List<Human> familyMembers = new ArrayList<>();
        for (Communication communication : ft.communications(fm)) {
            if (communication.kin().equals(kin))
                familyMembers.add(communication.fm2());
        }
        return familyMembers;
    }
}