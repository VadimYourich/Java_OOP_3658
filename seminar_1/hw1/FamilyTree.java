package seminar_1.hw1;

import java.util.List;
import java.util.Set;

public interface FamilyTree {
    List<Communication> communications (Human fm);
    List<Communication> communications ();
    Set<Human> getHumans();
    Human getHumanById(int id);
    Set<Human> find(HumanFilter filter);
}
