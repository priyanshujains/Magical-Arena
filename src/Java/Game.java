package Java;

public class Game {
    public static void main(String[] args) {

        Player playerA = new Player("Java.Player A", 50, 5, 10);
        Player playerB = new Player("Java.Player B", 100, 10, 5);

        System.out.println(playerA);
        System.out.println(playerB);

        Battle arena = new Battle(playerA, playerB);
        arena.startBattle();
    }
}