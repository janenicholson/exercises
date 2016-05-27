import lombok.Getter;

public class Member {

    @Getter int priorityPoints = 0;

    public void awardPoints(int i) {
        priorityPoints += i;
    }

}
