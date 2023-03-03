package seminar_1.hw1;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private ArrayList<Communication> communications = new ArrayList<>();

    public FamilyTree appendMarried(FamilyMember fm1, FamilyMember fm2) {
        communications.add(new Communication(fm1, fm2, Kinship.married));
        communications.add(new Communication(fm2, fm1, Kinship.married));
        return this;
    }

    public FamilyTree appendChild(FamilyMember parent, FamilyMember child) {
        Communication temp;
        List<Communication> children = communications.stream().filter(communication ->
                (communication.fm1().equals(parent)) && (communication.kin() == Kinship.child)
        ).toList();

        communications.add(new Communication(parent, child, Kinship.child));
        communications.add(new Communication(child, parent, Kinship.parent));
        for (Communication communication : children) {
            temp = new Communication(child, communication.fm2(), Kinship.sibling);
            if(!communications.contains(temp))
                communications.add(temp);
        }
        return this;
    }

    public List<Communication> communications(FamilyMember fm) {

        return communications.stream().filter(communication -> ((communication.fm1().equals(fm)))).toList();
    }

    public ArrayList<Communication> communications() {
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
