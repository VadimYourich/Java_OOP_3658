package seminar_1.hw1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyResearch extends Research{
    public MyResearch(FamilyTree ft) {
        super(ft);
    }
    public Map<Kinship, List<Human>> complexSpend(Human fm){
        Map<Kinship, List<Human>> tree = new HashMap<>();
        for (Kinship kin: Kinship.values()){
            tree.put(kin, spend(fm, kin));
        }
        return tree;
    }
}