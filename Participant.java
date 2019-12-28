
import java.util.ArrayList;

public class Participant implements Comparable<Participant> {
    private int points;
    private String name;
    private ArrayList<Integer> jumpLengths;

    public Participant(String name) {
        jumpLengths = new ArrayList<Integer>();

        this.name = name;

    }

    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    public int jump() {
        return (int) (Math.random() * 61 + 60);
    }

    public void addJumpLength(int len) {
        jumpLengths.add(len);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> votes() {
        ArrayList<Integer> roundVotes = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            roundVotes.add((int) (Math.random() * 11 + 10));
        }
        return roundVotes;
    }

    public void addPoints(ArrayList<Integer> nums, int jumpLength) {
        int max = nums.get(0);
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        nums.remove(nums.indexOf(max));
        int min = nums.get(0);
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        nums.remove(nums.indexOf(min));
        for (int num : nums) {
            this.points += num;
        }
        this.points += jumpLength;
    }

    public String jumpLengths() {
        String ret = "";
        for (int i = 0; i < jumpLengths.size() - 1; i++) {
            ret += jumpLengths.get(i) + " m,";
        }
        int last = jumpLengths.size() - 1;
        ret += jumpLengths.get(last) + " m";
        return ret;
    }

    @Override
    public int compareTo(Participant o) {
        return this.points - o.points;
    }
}