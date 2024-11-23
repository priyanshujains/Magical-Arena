public class Battle {
    private Player player1;
    private Player player2;

    public Battle(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startBattle() {
        System.out.println("Battle begins between " + player1.getName() + " and " + player2.getName());
        Player attacker = determineFirstAttacker();
        Player defender = (attacker == player1) ? player2 : player1;//other one is defender

        while (attacker.isAlive() && defender.isAlive()) {
            takeTurn(attacker, defender);

            // Swap roles every turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        //we got our winner
        Player winner = attacker.isAlive() ? attacker : defender;
        System.out.println("Battle over! Winner is " + winner.getName());
    }

    private Player determineFirstAttacker() {
        if (player1.getHealth() < player2.getHealth()) {
            return player1;
        } else if (player2.getHealth() < player1.getHealth()) {
            return player2;
        } else {
            return Math.random() < 0.5 ? player1 : player2; // Random if health is equal
        }
    }

    //core logic of a game
    private void takeTurn(Player attacker, Player defender) {
        System.out.println(attacker.getName() + " attacks " + defender.getName());
        int attackRoll = attacker.rollDice();
        int defendRoll = defender.rollDice();

        int damage = attackRoll * attacker.getAttack();
        int defendStrength = defendRoll * defender.getStrength();
        int netDamage = Math.max(0, damage - defendStrength);
        // max with 0 because sometime attack value is less than defend value

        defender.takeDamage(netDamage);//reduce the health of defender if any
        System.out.println(attacker.getName() + " rolled " + attackRoll + " (Damaging Power=" + damage + ")");
        System.out.println(defender.getName() + " rolled " + defendRoll + " (Defending Strength=" + defendStrength + ")");
        System.out.println(defender.getName() + " takes " + netDamage + " damage. Health is now " + defender.getHealth());
    }


}
