package seminar_1.hw1;

/**
 * связи членов семьи
 */

import java.util.Objects;

public abstract class Communication implements Comparable<Communication>{
    private int firstId;
    private int secondId;
    private Kinship kin;

    public Communication(int firstId, int secondId, Kinship kin) {
        this.firstId = firstId;
        this.secondId = secondId;
        this.kin = kin;
    }

    public int firstId() {
        return firstId;
    }

    public int secondId() {
        return secondId;
    }

    public Kinship kin() {
        return kin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Communication communication = (Communication) o;
        return Objects.equals(firstId, communication.firstId) && Objects.equals(secondId, communication.secondId) && 
        kin == communication.kin;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstId, kin, secondId);
    }
}
