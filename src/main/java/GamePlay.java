import java.util.Random;
import java.util.Scanner;

public class GamePlay {
    Randomizer chooseIndex = new Randomizer();
    Scanner playerPick = new Scanner(System.in);

    int player1;
    private int player2;
    private int player3;
    int EnemyPlayer1;
    private int EnemyPlayer2;
    int EnemyPlayer3;
    int userSpeed;
    int enemySpeed;
    String userPlayerName;
    int userPlayerAttack;
    int enemyDefense;
    int dieSide1;
    int AttackBonus;
    int AttackDifference;
    int enemyHealth;
    int enemyAttack;
    int enemyAttackBonus;
    int userDefense;
    int enemyAttackDifference;
    int userHealth;
    String enemyName;
    int enemyDefenseBonus;
    int userDefenseBonus;
    int dieSide2;
    int userPlayerAttackBonus;
    Characters UserplayerFirstRound;
    Characters EnemyplayerFirstRound;
    int EnemyHealthLoss;

    // System.out.println("Your Team \n _______________________________");

    public void playerChoice() {

        System.out.println("Your Team");
        for (int i = 0; i < 3; i++) {
            chooseIndex.randomPick();
        }
        System.out.println("\n _______________________________");
        System.out.println("Enemy Team ");
        for (int i = 0; i < 3; i++) {
            chooseIndex.randomEnemyPick();
        }
        System.out.println("\n _______________________________");


        System.out.println(" Choose which rapper to attack with (1-3):");
        int player = playerPick.nextInt();
        System.out.println(" Choose which opp to attack (1-3): \n _______________________________  ");
        player1 = player;
        EnemyPlayer1 = playerPick.nextInt();
        int index = player - 1;
        if (player == 1) {
            System.out.println(" \n Attack with: " + chooseIndex.userTeam.get(0).getName());
            UserplayerFirstRound = chooseIndex.userTeam.get(0);

        } else if (player == 2) {
            System.out.println(" \n Attack with: " + chooseIndex.userTeam.get(1).getName());
            UserplayerFirstRound = chooseIndex.userTeam.get(1);

        } else if (player == 3) {
            System.out.println(" \n Attack with: " + chooseIndex.userTeam.get(2).getName());
            UserplayerFirstRound = chooseIndex.userTeam.get(2);
        } else {
            System.out.println("\n Enter a number 1-3: ");
            System.out.println(" Choose which player to attack with: ");
            player1 = player;
        }

        if (EnemyPlayer1 == 1) {
            System.out.println("\n Attack opp: " + chooseIndex.EnemyTeam.get(0).getName());
            EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(0);
        } else if (EnemyPlayer1 == 2) {
            System.out.println("\n Attack opp: " + chooseIndex.EnemyTeam.get(1).getName());
            EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(1);
        } else if (EnemyPlayer1 == 3) {
            System.out.println("\n Attack opp: " + chooseIndex.EnemyTeam.get(2).getName());
            EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(2);
        }
    }

    public void rollDie() {
        Random DieSide = new Random();
        Scanner dieChoice = new Scanner(System.in);
        dieSide1 = DieSide.nextInt(6);
        dieSide2 = DieSide.nextInt(6);
        String yes = "Y";
        String no = "N";
        if (dieSide1 == 0) {
            dieSide1 += 1;
        } else if (dieSide2 == 0) {
            dieSide2 += 1;
        }
        int rollCounter = 0;
        while (rollCounter == 0) {
            System.out.println(" \n _______________________________ \n Roll the die! Y/N");
            String rollInput = dieChoice.nextLine();
            if (yes.equalsIgnoreCase(rollInput)) {
                rollCounter += 1;
                System.out.println("You rolled a " + dieSide1);
                System.out.println("Your opp rolled a " + dieSide2 + "\n _______________________________ ");

            } else if (no.equalsIgnoreCase(rollInput)) {
                System.out.println("Your opp rolled a " + dieSide2 + "\n _______________________________");
                rollCounter += 1;
                dieSide1 = 0;
                break;
            }

        }


    }

    public void UserAttacker(Characters rapper, Characters enemy) {
        System.out.println(rapper.getName() + " spun the block faster, your turn! \n");
        rollDie();
        enemyDefenseBonus = enemyDefense + dieSide2;
        userPlayerAttackBonus = userPlayerAttack + dieSide1;
        System.out.println(rapper.getName() + " attacks first! \n " + rapper.getName() + " attack: Base of " + rapper.getAttack() + " + Roll of " + dieSide1 + " = " + userPlayerAttackBonus);
        System.out.println(enemy.getName() + " defense: Base of " + enemy.getDefense() + " + Roll of " + dieSide2 + " = " + enemyDefenseBonus);
        System.out.println(rapper.getName() + " deals " + (enemyDefenseBonus - userPlayerAttackBonus) + " damage to the Opp!");
        if (userPlayerAttackBonus > enemyDefenseBonus) {
            EnemyHealthLoss = enemy.getMaxHealth() - (userPlayerAttackBonus - enemyDefenseBonus);
            enemy.setMaxHealth(EnemyHealthLoss);
            System.out.println(enemy.getName() + " remaining health: " + enemy.getMaxHealth());
            enemy.setDefense(0);
            if (enemy.getMaxHealth() <= 0) {
                System.out.println(enemy.getName() + "is out!");
                chooseIndex.EnemyTeam.remove(enemy);
            }
        } else if (userPlayerAttackBonus < enemyDefenseBonus) {
            int enemyleftoverDefense = enemyDefenseBonus - userPlayerAttackBonus;
            enemy.setDefense(enemyleftoverDefense);
            System.out.println(enemy.getName() + " remaining defense: " + enemy.getDefense());
        } else {
            enemy.setDefense(0);
        }
    }

    public void CounterAttack(Characters FirstAttacker, Characters CounterAttacker) {
        if (FirstAttacker.getSpeed() > CounterAttacker.getSpeed()) {
            System.out.println("\n _______________________________ \n" + CounterAttacker.getName() + " counterattacks!");
            rollDie();
            int CounterAttackBonus = CounterAttacker.getAttack() + dieSide1;
            int DefenderDefenseBonus = FirstAttacker.getDefense() + dieSide2;
            int damage = CounterAttackBonus - DefenderDefenseBonus;

            int DefenderHealthLoss = FirstAttacker.getMaxHealth() - (damage);

            System.out.println(CounterAttacker.getName() + " attack: Base of " + CounterAttacker.getAttack() + " + roll of " + dieSide1 + " = " + CounterAttackBonus);
            System.out.println(FirstAttacker.getName() + " defense: Base of " + FirstAttacker.getDefense() + " + roll of " + dieSide2 + " = " + DefenderDefenseBonus);
            System.out.println(CounterAttacker.getName() + " deals " + (CounterAttackBonus - DefenderDefenseBonus) + " damage to " + FirstAttacker.getName() + "!");
            if (damage > 0) {
                FirstAttacker.setMaxHealth(DefenderHealthLoss);
                if (FirstAttacker.getMaxHealth() <= 0) {
                    chooseIndex.userTeam.remove(FirstAttacker);
                    System.out.println(FirstAttacker.getName() + " is out of the game!");
                }
                System.out.println(FirstAttacker.getName() + " remaining health: " + FirstAttacker.getMaxHealth());
            } else if (damage < 0) {
                int remainingDefense = DefenderDefenseBonus - CounterAttackBonus;
                FirstAttacker.setDefense(remainingDefense);
                System.out.println(FirstAttacker.getName() + " remaining defense: " + FirstAttacker.getDefense());
            }

        } else if (FirstAttacker.getSpeed() < CounterAttacker.getSpeed()) {
            System.out.println("\n" + FirstAttacker.getName() + " counterattacks!");
            rollDie();
            int CounterDefenseBonus = CounterAttacker.getDefense() + dieSide1;
            int FirstAttackerBonus = FirstAttacker.getAttack() + dieSide2;
            int damage = CounterDefenseBonus - FirstAttackerBonus;
            int CounterHealthLoss = CounterAttacker.getMaxHealth() - damage;

            System.out.println(FirstAttacker.getName() + " attack: Base of " + FirstAttacker.getAttack() + " + roll of " + dieSide1 + " = " + CounterDefenseBonus);
            System.out.println(CounterAttacker.getName() + " defense: Base of " + CounterAttacker.getDefense() + " + roll of " + dieSide2 + " = " + FirstAttackerBonus);
            System.out.println(FirstAttacker.getName() + " deals " + (FirstAttackerBonus - CounterDefenseBonus) + " damage to " + CounterAttacker.getName() + "!");

            if (damage > 0) {
                CounterAttacker.setMaxHealth(CounterHealthLoss);
                System.out.println(CounterAttacker.getName() + " remaining health: " + CounterAttacker.getMaxHealth());
                if (CounterAttacker.getMaxHealth() <= 0) {
                    chooseIndex.EnemyTeam.remove(CounterAttacker);
                    System.out.println(CounterAttacker.getName() + " is out of the game!");
                }
            } else if (damage < 0) {
                int remainingDefense = CounterDefenseBonus - FirstAttackerBonus;
                CounterAttacker.setDefense(remainingDefense);
                System.out.println(FirstAttacker.getName() + " deals " + (FirstAttackerBonus - CounterDefenseBonus) + " damage to " + CounterAttacker.getName() + "!");
                System.out.println(CounterAttacker.getName() + " remaining defense: " + remainingDefense);
            }

        }
    }

    public void EnemyAttacker(Characters enemy, Characters user) {
        System.out.println(enemy.getName() + " spun the block faster, opps turn!");
        rollDie();
        int enemyAttackBonus = enemy.getAttack() + dieSide2;
        int userDefenseBonus = user.getDefense() + dieSide1;
        int damage = enemyAttackBonus - userDefenseBonus;
        System.out.println(enemy.getName() + " attacks first! \n" + enemy.getName() + "'s attack: Base of " + enemy.getAttack() + " + Roll of " + dieSide2 + " = " + enemyAttackBonus);
        System.out.println(user.getName() + " defense: Base of " + user.getDefense() + " roll of " + dieSide1 + " = " + userDefenseBonus);
        System.out.println(enemy.getName() + " deals " + damage + " damage to " + user.getName() + "!");
        if (damage > 0) {
            user.setDefense(0);
            int afflicted = user.getMaxHealth() - damage;
            if (afflicted <= 0) {
                afflicted = 0;
                chooseIndex.userTeam.remove(user);
                System.out.println(user.getName() + " is out!");
                //remove player from game
            } else {
                user.setMaxHealth(afflicted);
                System.out.println(user.getName() + " remaining health: " + user.getMaxHealth());
            }
        } else if (damage < 0) {
            int newDefense = userDefenseBonus - enemyAttackBonus;
            user.setDefense(newDefense);
            System.out.println(user.getName() + " remaining defense: " + user.getDefense());

        }


    }


    public void firstRound() {
        userSpeed = UserplayerFirstRound.getSpeed();
        enemySpeed = EnemyplayerFirstRound.getSpeed();
        userPlayerName = UserplayerFirstRound.getName();
        enemyName = EnemyplayerFirstRound.getName();
        userPlayerAttack = UserplayerFirstRound.getAttack();
        enemyAttack = EnemyplayerFirstRound.getAttack();
        AttackBonus = dieSide1 + UserplayerFirstRound.getAttack();
        userHealth = UserplayerFirstRound.getMaxHealth();
        enemyHealth = EnemyplayerFirstRound.getMaxHealth();
        userDefense = UserplayerFirstRound.getDefense();
        enemyDefense = EnemyplayerFirstRound.getDefense();
        if (userSpeed > enemySpeed) {
            UserAttacker(UserplayerFirstRound, EnemyplayerFirstRound);
            CounterAttack(UserplayerFirstRound, EnemyplayerFirstRound);

        } else if (userSpeed == enemySpeed) {
            System.out.println("Both rappers spin the block at the same speed!");
            System.out.println("Roll the die to break the tie!");
            rollDie();
            if (dieSide1 > dieSide2) {
                UserAttacker(UserplayerFirstRound, EnemyplayerFirstRound);
                CounterAttack(UserplayerFirstRound, EnemyplayerFirstRound);
            } else {
                EnemyAttacker(EnemyplayerFirstRound, UserplayerFirstRound);
                CounterAttack(EnemyplayerFirstRound, UserplayerFirstRound);
            }
        } else {
            EnemyAttacker(EnemyplayerFirstRound, UserplayerFirstRound);
            CounterAttack(EnemyplayerFirstRound, UserplayerFirstRound);
        }

        System.out.println("\n _______________________________ \n Your team: \n  _______________________________ ");
        for (int i = 0; i < chooseIndex.userTeam.size(); i++) {
            userTeamDisplay(i);
        }
        System.out.println("\n _______________________________ \n Opp team \n _______________________________ ");
        for (int i = 0; i < chooseIndex.EnemyTeam.size(); i++) {

            enemyTeamDisplay(i);
        }

    }

    public Boolean teamEliminated() {
        boolean teamEliminated = false;
        if (chooseIndex.userTeam.isEmpty()) {
            teamEliminated = true;
            System.out.println("When all is said and done.....The OG Rap Group is your Opposition, they knocked off all your rappers \n YOU LOSE!");

        } else if(chooseIndex.EnemyTeam.isEmpty()) {
            teamEliminated = true;
            System.out.println("When all is said and done.....The OG Rap Group is Your team, you knocked off all the opposition \n YOU WIN!");
        }
        return teamEliminated;
    }




    public void userTeamDisplay(int g) {
        System.out.println(chooseIndex.userTeam.get(g).getName());
        System.out.println("Health: " + chooseIndex.userTeam.get(g).getMaxHealth());
        System.out.println("Attack: " + chooseIndex.userTeam.get(g).getAttack());
        System.out.println("Defense: " + chooseIndex.userTeam.get(g).getDefense());
        System.out.println("Speed: " + chooseIndex.userTeam.get(g).getSpeed());
    }

    public void enemyTeamDisplay(int g) {

        System.out.println(chooseIndex.EnemyTeam.get(g).getName());
        System.out.println("Health: " + chooseIndex.EnemyTeam.get(g).getMaxHealth());
        System.out.println("Attack: " + chooseIndex.EnemyTeam.get(g).getAttack());
        System.out.println("Defense: " + chooseIndex.EnemyTeam.get(g).getDefense());
        System.out.println("Speed: " + chooseIndex.EnemyTeam.get(g).getSpeed());
    }
int index;
    int enemyIndex;

public void teamChoiceRnd2() {
    System.out.println("\n _______________________________ \n Your team: \n  _______________________________ ");
    for ( int i = 0; i < chooseIndex.userTeam.size(); i++) {
        userTeamDisplay(i);
    }
    System.out.println("\n _______________________________ \n Opp team: \n  _______________________________ ");
    for (int i = 0; i < chooseIndex.EnemyTeam.size(); i++) {
        enemyTeamDisplay(i);
    }
    System.out.println(" Choose the next rapper to attack with: ");
    player1 = playerPick.nextInt();
     index = player1 - 1;
    if (player1 == 1 && chooseIndex.userTeam.get(0) != null) {
        System.out.println("\n Attack with: " + chooseIndex.userTeam.get(0).getName());
        UserplayerFirstRound = chooseIndex.userTeam.get(0);
        if (chooseIndex.userTeam.get(0) == null) {
            System.out.println("Choose 2 or 3");
        }

    } else if (player1 == 2 && chooseIndex.userTeam.get(1) != null) {
        System.out.println("\n Attack with: " + chooseIndex.userTeam.get(1).getName());
        UserplayerFirstRound = chooseIndex.userTeam.get(1);
        if (chooseIndex.userTeam.get(1) == null) {
            System.out.println("Choose 1 or 3");
        }

    } else if (player1 == 3 && chooseIndex.userTeam.get(2) != null) {
        System.out.println("\n Attack with: " + chooseIndex.userTeam.get(2).getName());
        UserplayerFirstRound = chooseIndex.userTeam.get(2);
        if (chooseIndex.userTeam.get(2) == null) {
            System.out.println("Choose 1 or 2");
        }
    }
    System.out.println(" Opp choose next rapper to attack with:  \n _______________________________  ");
     enemyIndex = EnemyPlayer1 - 1;
    Random enemyPlayer = new Random();
    EnemyPlayer1 = enemyPlayer.nextInt(chooseIndex.EnemyTeam.size());

    if (EnemyPlayer1 == 1) {
        System.out.println("\n Attacking opp: " + chooseIndex.EnemyTeam.get(0).getName());
        EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(0);
        if (chooseIndex.EnemyTeam.get(0) == null) {
            System.out.println("Choose 2 or 3");
        }
    } else if (EnemyPlayer1 == 2) {
        System.out.println("\n Attacking opp: " + chooseIndex.EnemyTeam.get(1).getName());
        EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(1);
        if (chooseIndex.EnemyTeam.get(1) == null) {
            System.out.println("Choose 1 or 3");
        }
    } else if (EnemyPlayer1 == 3) {
        System.out.println("\n Attacking opp: " + chooseIndex.EnemyTeam.get(2).getName());
        EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(2);
        if (chooseIndex.EnemyTeam.get(2) == null) {
            System.out.println("Choose 1 or 2");
        }
    }
    Rnd2();
}

    public void Rnd2() {
        enemyIndex = EnemyPlayer1 - 1;
        index = player1 - 1;
            this.UserplayerFirstRound = chooseIndex.userTeam.get(index);
            this.EnemyplayerFirstRound = chooseIndex.EnemyTeam.get(enemyIndex);
            this.userSpeed = UserplayerFirstRound.getSpeed();
            this.enemySpeed = EnemyplayerFirstRound.getSpeed();
            userPlayerName = UserplayerFirstRound.getName();
            enemyName = EnemyplayerFirstRound.getName();
            userPlayerAttack = UserplayerFirstRound.getAttack();
            enemyAttack = EnemyplayerFirstRound.getAttack();
            AttackBonus = dieSide1 + UserplayerFirstRound.getAttack();
            userHealth = UserplayerFirstRound.getMaxHealth();
            enemyHealth = EnemyplayerFirstRound.getMaxHealth();
            userDefense = UserplayerFirstRound.getDefense();
            enemyDefense = EnemyplayerFirstRound.getDefense();

            if (userSpeed > enemySpeed) {

                UserAttacker(UserplayerFirstRound, EnemyplayerFirstRound);
                CounterAttack(UserplayerFirstRound, EnemyplayerFirstRound);

            } else if (userSpeed == enemySpeed) {
                System.out.println("Both rappers spin the block at the same speed!");
                System.out.println("Roll the die to break the tie!");
                rollDie();
                if (dieSide1 > dieSide2) {
                    UserAttacker(UserplayerFirstRound, EnemyplayerFirstRound);
                    CounterAttack(UserplayerFirstRound, EnemyplayerFirstRound);
                } else {
                    EnemyAttacker(EnemyplayerFirstRound, UserplayerFirstRound);
                    CounterAttack(EnemyplayerFirstRound, UserplayerFirstRound);
                }
            } else {
                EnemyAttacker(EnemyplayerFirstRound, UserplayerFirstRound);
                CounterAttack(EnemyplayerFirstRound, UserplayerFirstRound);
            }
        }
    }






























