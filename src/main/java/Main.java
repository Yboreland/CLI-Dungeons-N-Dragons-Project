public class Main {


    public static void main(String[] args) {
        GamePlay gametime = new GamePlay();
        System.out.println("\n");
        System.out.println("|Welcome to DEF JAM: Spin the Block on Ya Opps! |");
        System.out.println("-------------------------------------------------");

        Randomizer chooseIndex = new Randomizer();
        gametime.playerChoice();
        gametime.firstRound();

        gametime.teamEliminated();
        while (!gametime.teamEliminated()) {
            gametime.teamChoiceRnd2();
        }




    }
}


