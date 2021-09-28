import java.text.MessageFormat;
import java.util.ArrayList;

public class Characters {
   private  int MaxHealth;
   private  int Attack;
   private  int Defense;
   private int Speed;
   private  String name;

   public static void toString(Characters rapper){
       System.out.println(rapper.getName()+ "\n - Health: " + rapper.getMaxHealth() + " / " + rapper.getMaxHealth() + "\n - Attack: " +  rapper.getAttack() + "\n - Defense: " + rapper.getDefense() + "\n - Speed: " + rapper.getSpeed());
   }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void setMaxHealth(int health) {
        MaxHealth = health;
    }

    public  void setAttack(int attack) {
        this.Attack = attack;
    }

    public  void setDefense(int defense) {
        this.Defense = defense;
    }

    public void setSpeed(int speed) {
        this.Speed = speed;
    }

    public int getMaxHealth() {
        return this.MaxHealth;
    }

    public  int getAttack() {
        return this.Attack;
    }

    public int getDefense() {
        return Defense;
    }

    public int getSpeed() {
        return this.Speed;
    }

    }
