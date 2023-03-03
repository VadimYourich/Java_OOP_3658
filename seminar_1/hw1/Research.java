package seminar_1.hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Research {
    FamilyTree ft;

    public Research(FamilyTree ft) {
        this.ft = ft;
    }

    public List<FamilyMember> spend(FamilyMember fm, Kinship kin) {
        List<FamilyMember> familyMembers = new ArrayList<>();
        for (Communication communication : ft.communications(fm)) {
            if (communication.kin().equals(kin))
                familyMembers.add(communication.fm2());
        }
        return familyMembers;
    }

    public Map<Kinship, List<FamilyMember>>complexSpend(FamilyMember fm){
        Map<Kinship, List<FamilyMember>> tree = new HashMap<>();
        for (Kinship kin: Kinship.values()){
            tree.put(kin, spend(fm, kin));
        }
        return tree;
    }
}