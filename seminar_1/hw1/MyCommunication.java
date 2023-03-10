package seminar_1.hw1;

public class MyCommunication extends Communication {
    public MyCommunication(int firstId, int secondId, Kinship kin) {
        super(firstId, secondId, kin);
    }

    @Override
    public int compareTo(Communication o) {
        if (this.firstId() == o.firstId()) {
            if (this.secondId() < o.secondId()) {
                return -1;
            } else if (this.secondId() > o.secondId()) {
                return 1;
            }
        } else {
            if (this.firstId() < o.firstId()) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}