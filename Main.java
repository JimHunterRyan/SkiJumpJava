
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Competition comp = new Competition();
        start(sc, comp);
        while (true) {
            comp.sort();
            if (!play(sc, comp)) {
                break;
            }

        }
        comp.sort();
        gameEnd(comp);

    }

    public static void start(Scanner sc, Competition comp) {
        System.out.println("Kumpula ski jumping week\n" + "\n"
                + "Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String ans = sc.nextLine();
            if (ans.equals("")) {
                break;
            }
            Participant participant = new Participant(ans);
            comp.add(participant);
        }
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");

    }

    public static boolean play(Scanner sc, Competition comp) {

        System.out.print("Write \"jump\" to jump; otherwise you quit: ");
        String ans = sc.nextLine();
        if (!ans.equals("jump")) {
            return false;
        }
        comp.incrementRound();
        System.out.println("");
        System.out.println("Round " + comp.getRound());
        System.out.println("");

        comp.jumpingOrder();
        comp.roundResults();
        return true;
    }

    public static void gameEnd(Competition comp) {

        System.out.println("Thanks!");
        System.out.println("");
        comp.finalResults();
    }

}
