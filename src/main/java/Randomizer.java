import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Randomizer extends Characters {
    ArrayList<Characters> userTeam = new ArrayList<Characters>();
    ArrayList<Characters> EnemyTeam = new ArrayList<Characters>();



    public void randomPick() {

        Random randcharacter = new Random();
        switch (randcharacter.nextInt(6) + 1) {
            case 1:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1:  //wutang
                        WuTangClan RZA = new WuTangClan("RZA (WuTang)", 20, 9, 4, 5);
                        toString(RZA);
                        userTeam.add(RZA);
                        break;


                    case 2:
                        WuTangClan MethodMan = new WuTangClan("Method Man (WuTang)", 15, 6, 7, 6);
                        toString(MethodMan);
                        userTeam.add(MethodMan);
                        break;


                    case 3:
                        WuTangClan Raekwon = new WuTangClan("Raekwon (WuTang)", 10, 8, 6, 8);
                        toString(Raekwon);
                        userTeam.add(Raekwon);
                        break;
                }

                break;


            case 2:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1: //lox
                        Lox Jadakiss = new Lox("Jadakiss (Lox)", 12, 7, 4, 8);
                        toString(Jadakiss);
                        userTeam.add(Jadakiss);
                        break;
                    case 2:
                        Lox SheekLouch = new Lox("Sheek Louch (Lox)", 14, 5, 5, 5);
                        toString(SheekLouch);
                        userTeam.add(SheekLouch);
                        break;
                    case 3:
                        Lox StylesP = new Lox("Styles P (Lox)", 13, 3, 8, 4);
                        toString(StylesP);
                        userTeam.add(StylesP);
                        break;
                }
                break;


            case 3:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1://dipset
                        Dipset JimJones = new Dipset("Jim Jones (Dipset)", 9, 6, 3, 2);
                        toString(JimJones);
                        userTeam.add(JimJones);
                        break;
                    case 2:
                        Dipset Camron = new Dipset("Camron (Dipset)", 8, 4, 3, 4);
                        toString(Camron);
                        userTeam.add(Camron);
                        break;


                    case 3:
                        Dipset JuelzSantana = new Dipset("Juelz Santana (Dipset)", 6, 10, 4, 3);
                        toString(JuelzSantana);
                        userTeam.add(JuelzSantana);
                        break;


                }
                break;


            case 4:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1:
                        BoneThugsNHarmony BizzyBone = new BoneThugsNHarmony("Bizzy Bone (Bone Thugs)", 10, 6, 10, 3);
                        toString(BizzyBone);
                        userTeam.add(BizzyBone);
                        break;

                    case 2:
                        BoneThugsNHarmony WishBone = new BoneThugsNHarmony("Wish Bone (Bone Thugs)", 9, 6, 3, 2);
                        toString(WishBone);
                        userTeam.add(WishBone);
                        break;

                    case 3:
                        BoneThugsNHarmony LayzieBone = new BoneThugsNHarmony("Layzie Bone (Bone Thugs)", 9, 5, 12, 2);
                        toString(LayzieBone);
                        userTeam.add(LayzieBone);
                        break;

                }
                break;


            case 5:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1 -> {
                        NaughtyByNature Treach = new NaughtyByNature("Treach (NaughtyByNature)", 10, 8, 3, 5);
                        toString(Treach);
                        userTeam.add(Treach);
                    }
                    case 2 -> {
                        NaughtyByNature VinRock = new NaughtyByNature("Vin Rock (NaughtyByNature)", 13, 4, 5, 6);
                        toString(VinRock);
                        userTeam.add(VinRock);
                    }
                    case 3 -> {
                        NaughtyByNature DJKayGee = new NaughtyByNature("DJ Kay Gee (NaughtyByNature)", 11, 7, 6, 4);
                        toString(DJKayGee);
                        userTeam.add(DJKayGee);
                    }
                }
                break;


            case 6:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1 :
                        Three6Mafia JuicyJ = new Three6Mafia("Juicy J (Three6Mafia)", 15, 8, 6, 7);
                        toString(JuicyJ);
                        userTeam.add(JuicyJ);
                        break;

                    case 2:
                        Three6Mafia DJPaul = new Three6Mafia("DJ Paul (Three6Mafia)", 10, 7, 8, 6);
                        toString(DJPaul);
                        userTeam.add(DJPaul);
                        break;

                    case 3:
                        Three6Mafia LordInfamous = new Three6Mafia("Lord Infamous (Three6Mafia)", 18, 6, 5, 7);
                        toString(LordInfamous);
                        userTeam.add(LordInfamous);
                        break;

                }
                break;

        }

        }




    public void randomEnemyPick() {
        Random randcharacter = new Random();
        switch (randcharacter.nextInt(6) + 1) {
            case 1:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1://wutang
                        WuTangClan RZA = new WuTangClan("RZA (WuTang)", 20, 9, 4, 5);
                        EnemyTeam.add(RZA);
                        toString(RZA);
                        break;

                    case 2:
                        WuTangClan MethodMan = new WuTangClan("Method Man (WuTang)", 15, 6, 7, 6);
                        EnemyTeam.add(MethodMan);
                        toString(MethodMan);
                        break;


                    case 3:
                        WuTangClan Raekwon = new WuTangClan("Raekwon (WuTang)", 10, 8, 6, 8);
                        EnemyTeam.add(Raekwon);
                        toString(Raekwon);
                        break;
                    }
                    break;



            case 2:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1: //lox
                        Lox Jadakiss = new Lox("Jadakiss (Lox)", 12, 7, 4, 8);
                        toString(Jadakiss);
                        EnemyTeam.add(Jadakiss);
                        break;

                    case 2:
                        Lox SheekLouch = new Lox("Sheek Louch (Lox)", 14, 5, 5, 5);
                        toString(SheekLouch);
                        EnemyTeam.add(SheekLouch);
                        break;
                    case 3:
                        Lox StylesP = new Lox("Styles P (Lox)", 13, 3, 8, 4);
                        toString(StylesP);
                        EnemyTeam.add(StylesP);
                        break;
                }
                break;


            case 3:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1: //dipset
                        Dipset JimJones = new Dipset("Jim Jones (Dipset)", 9, 6, 3, 2);
                        toString(JimJones);
                        EnemyTeam.add(JimJones);
                        break;

                    case 2:
                        Dipset Camron = new Dipset("Camron (Dipset)", 8, 4, 3, 4);
                        toString(Camron);
                        EnemyTeam.add(Camron);
                        break;

                    case 3:
                        Dipset JuelzSantana = new Dipset("Juelz Santana (Dipset)", 6, 10, 4, 3);
                        toString(JuelzSantana);
                        EnemyTeam.add(JuelzSantana);
                        break;

                }
                break;


            case 4:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1:
                        BoneThugsNHarmony BizzyBone = new BoneThugsNHarmony("Bizzy Bone (Bone Thugs)", 10, 6, 10, 3);
                        toString(BizzyBone);
                        EnemyTeam.add(BizzyBone);
                        break;

                    case 2:
                        BoneThugsNHarmony WishBone = new BoneThugsNHarmony("Wish Bone (Bone Thugs)", 9, 6, 3, 2);
                        toString(WishBone);
                        EnemyTeam.add(WishBone);
                        break;

                    case 3:
                        BoneThugsNHarmony LayzieBone = new BoneThugsNHarmony("Layzie Bone (Bone Thugs)", 9, 5, 12, 2);
                        toString(LayzieBone);
                        EnemyTeam.add(LayzieBone);
                        break;

                }
                break;


            case 5:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1:
                        NaughtyByNature Treach = new NaughtyByNature("Treach (NaughtyByNature)", 10, 8, 3, 5);
                        toString(Treach);
                        EnemyTeam.add(Treach);
                        break;

                    case 2:
                        NaughtyByNature VinRock = new NaughtyByNature("Vin Rock (NaughtyByNature)", 13, 4, 5, 6);
                        toString(VinRock);
                        EnemyTeam.add(VinRock);
                        break;

                    case 3:
                        NaughtyByNature DJKayGee = new NaughtyByNature("DJ Kay Gee (NaughtyByNature)", 11, 7, 6, 4);
                        toString(DJKayGee);
                        EnemyTeam.add(DJKayGee);
                        break;
                    }
                    break;



            case 6:
                switch (randcharacter.nextInt(3) + 1) {
                    case 1:
                        Three6Mafia JuicyJ = new Three6Mafia("Juicy J (Three6Mafia)", 15, 8, 6, 7);
                        toString(JuicyJ);
                        EnemyTeam.add(JuicyJ);
                        break;

                    case 2:
                        Three6Mafia DJPaul = new Three6Mafia("DJ Paul (Three6Mafia)", 10, 7, 8, 6);
                        toString(DJPaul);
                        EnemyTeam.add(DJPaul);
                        break;

                    case 3:
                        Three6Mafia LordInfamous = new Three6Mafia("Lord Infamous (Three6Mafia)", 18, 6, 5, 5);
                        toString(LordInfamous);
                        EnemyTeam.add(LordInfamous);
                        break;

                }
                break;
            }

        }
    }





