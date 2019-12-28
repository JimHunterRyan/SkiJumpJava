
import java.util.ArrayList;
import java.util.Collections;

public class Competition {
    private ArrayList<Participant> participants;
    private int round;

    public Competition() {
        participants = new ArrayList<Participant>();
        this.round = 0;
    }

    public void add(Participant participant) {
        participants.add(participant);
    }

    public int getRound() {
        return this.round;
    }

    public void incrementRound() {
        this.round++;
    }

    public void jumpingOrder() {
        int i = 1;
        sort();
        System.out.println("Jumping order:");
        for (Participant participant : participants) {
            System.out.println("  " + i + ". " + participant);
            i++;
        }
        System.out.println("");
    }

    public void roundResults() {
        sort();
        System.out.println("Results of round " + getRound());
        for (Participant participant : participants) {
            System.out.println("  " + participant.getName());
            int len = participant.jump();
            System.out.println("    " + "length:" + len);
            participant.addJumpLength(len);
            ArrayList<Integer> votes = participant.votes();
            System.out.print("    judge votes: [");
            for (int i = 0; i < votes.size() - 1; i++) {
                System.out.print(votes.get(i) + ", ");
            }
            System.out.print(votes.get(4));
            System.out.println("]");
            participant.addPoints(votes, len);

        }
        System.out.println("");
    }

    public void sort() {
        Collections.sort(this.participants);
        // Collections.reverse(this.participants);
    }

    public void finalResults() {

        Collections.reverse(participants);
        System.out.println("Tournament results:\n" + "Position    Name");
        int i = 0;
        for (Participant participant : participants) {
            i++;
            System.out.println(i + "           " + participant);
            System.out.println("            jump lengths: " + participant.jumpLengths());

        }
    }
}