package seminar_1.hw1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyFamilyTree implements FamilyTree{
    public List<Communication> communications = new ArrayList<>();
    public Set<Human> humans = new HashSet<>();

    public MyFamilyTree(List<Communication> communications, Set<Human> humans) {
        this.communications = communications;
        this.humans = humans;
    }

    public MyFamilyTree() {
    }

    public MyFamilyTree appendMarried(Human fm1, Human fm2) {
        communications.add(new MyCommunication(fm1.id(), fm2.id(), Kinship.MARRIED));
        communications.add(new MyCommunication(fm2.id(), fm1.id(), Kinship.MARRIED));
        humans.add(fm1);
        humans.add(fm2);
        return this;
    }
    public MyFamilyTree appendChild(Human parent, Human child) {
        MyCommunication temp;
        List<Communication> children = communications.stream().filter(communication ->
                (communication.firstId() == parent.id()) && (communication.kin() == Kinship.CHILD)
        ).toList();

        communications.add(new MyCommunication(parent.id(), child.id(), Kinship.CHILD));
        communications.add(new MyCommunication(child.id(), parent.id(), Kinship.PARENT));
        for (Communication communication : children) {
            temp = new MyCommunication(child.id(), communication.secondId(), Kinship.SIBLING);
            if(!communications.contains(temp))
                communications.add(temp);
        }

        humans.add(parent);
        humans.add(child);

        return this;
    }

    public List<Communication> communications(Human fm) {

        return communications.stream().filter(communication -> (communication.firstId() == fm.id())).toList();
    }

    public List<Communication> communications() {
        return communications;
    }

    @Override
    public Set<Human> getHumans() {
        return humans;
    }

    @Override
    public Human getHumanById(int id) {
        for (Human h: humans) {
            if (h.id() == id){
                return h;
            }
        }
        return null;
    }

    @Override
    public Set<Human> find(HumanFilter filter) {
        return humans.stream().filter(
                filter::check).collect(Collectors.toSet()
        );
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Communication communication: communications)
            sb.append(communication).append("\n");
        return sb.toString();
    }
}
