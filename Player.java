import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
class Player
{
    public int health;
    public int coins;
    public  boolean PlayerIsAlive;
    public int count=0;
    Scanner sc=new Scanner(System.in);
    ResumeManager  resumeManager = new ResumeManager();

    public  Player()
    {

        if(resumeManager.resumeStatus()){
          int itemPos[] = resumeManager.getResumeData();
          health=itemPos[4];
          coins=itemPos[6];
        }else{
          health=100;
          coins=0;
        }



        PlayerIsAlive=true;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }
    //
    public void Run(GameBoard game)
    {
        boolean run=true;

            while(run){
                  System.out.println("1. Move Up");
                  System.out.println("2. Move Down");
                  System.out.println("3. Move left");
                  System.out.println("4. Move Right");
                  System.out.println("5. Exit");
                  System.out.print("Enter your choice: ");
                try{

                    int Choice = sc.nextInt();
                    switch (Choice) {
                              case 1: 
                                    game.MoveUp();
                                    game.PrintBoard();
                                    break;
                              case 2:
                   
                                    game.MoveDown();
                                    game.PrintBoard();
                                    break;
                              case 3:
                                    game.MoveLeft();
                                    game.PrintBoard();  
                                    break;
                               case 4:

                                    game.MoveRight();
                                     game.PrintBoard();
                                     break;  
                               case 5:
                                     Clear.clearScreen(); 
                                     run=false;
                                     break;
                              default:
                                      System.out.println("Invalid choice.");
                                       break;
                            }
                }
                catch(InputMismatchException e)
                  {
                    Clear.clearScreen(); 
                     System.out.println("Invalid input. Please enter a valid number.");
                     game.PrintBoard();
                     sc.next();

                }
         }
    }


    public int getHealth()
    {
        return health;
    }

    public int getCoin()
    {
        return coins;
    }

    public boolean PlayerIsAlive()
    {
        return PlayerIsAlive;
    }

    public void collectCoin(int collect)
    {
        coins+=collect;
    }
    
    public void attack(Enemy enemy,GameBoard game)
    { 

        Random random=new Random();
        int damage=random.nextInt(1,25)+5;
       System.out.println(" "); 
       if(enemy.health<damage)
       {
       System.out.println("**  Player attacked enemy for " +enemy.health + " damage.");
       }
       else {
        System.out.println("**  Player attacked enemy for " + damage + " damage.");
       }
        enemy.takedamage(damage);
        
      }
      public void tokedamage(int damage) {
        if(health<damage)
        {
            health-=health;
        }
        else
        {
             health -= damage;
        }   
        if (health == 0) {
            PlayerIsAlive=false;
            System.out.println("Player has been defeated! ):");
          
        }
    }

    public void Penalty()
    {
        health-=5;
    }
 }

