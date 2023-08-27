import java.util.Random;

class Enemy
{
    public int health;
    public boolean isAlive;
    public Enemy(){
        Random random = new Random();
        health = random.nextInt(50) + 10;
        isAlive = true;      
    }

    public int getHealth()
    {
        return health;
    }
    public boolean isAlive()
    {
        return isAlive;
    }
    public void takedamage(int damage)
    {
        if(health<damage)
        {
            health-=health;
        }
        else
        {
            health-=damage;
        }
        
        if(health==0)
        {
            isAlive=false;
        }
    }
    public void attack(Player player) {
       
        int damage = new Random().nextInt(10);
        if (player.getHealth() < damage) {
            System.out.println("**  Enemy attacked player for " + player.getHealth() + " damage.");
        } else {
            System.out.println("**  Enemy attacked player for " + damage + " damage.");
        }
        player.tokedamage(damage);
    }
}