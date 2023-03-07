package seminar_1.hw1;

import java.util.ArrayList;
import java.util.List;

public class MyFamilyTree implements FamilyTree{
    private List<Communication> communications = new ArrayList<>();

    public MyFamilyTree appendMarried(Human fm1, Human fm2) {
        communications.add(new MyCommunication(fm1, fm2, Kinship.MARRIED));
        communications.add(new MyCommunication(fm2, fm1, Kinship.MARRIED));
        return this;
    }
    public MyFamilyTree appendChild(Human parent, Human child) {
        MyCommunication temp;
        List<Communication> children = communications.stream().filter(communication ->
                (communication.fm1().equals(parent)) && (communication.kin() == Kinship.CHILD)
        ).toList();

        communications.add(new MyCommunication(parent, child, Kinship.CHILD));
        communications.add(new MyCommunication(child, parent, Kinship.PARENT));
        for (Communication communication : children) {
            temp = new MyCommunication(child, communication.fm2(), Kinship.SIBLING);
            if(!communications.contains(temp))
                communications.add(temp);
        }
        return this;
    }

    public List<Communication> communications(Human fm) {

        return communications.stream().filter(communication -> ((communication.fm1().equals(fm)))).toList();
    }

    public List<Communication> communications() {
        return communications;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Communication communication: communications)
            sb.append(communication).append("\n");
        return sb.toString();
    }
}
