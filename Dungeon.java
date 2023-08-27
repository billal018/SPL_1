import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Dungeon {
    //static 
    int count = 0;

    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        Dungeon dungeon = new Dungeon();
        Buy by = new Buy();
        game.CreateBoard();
        Player player = new Player();

        Enemy enemy = new Enemy();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        PauseMenu pauseMenu = new PauseMenu();
        int count = 0;

while (running) {

    if (!pauseMenu.isPaused()) {

            game.PrintBoard();
            System.out.println("Player Health: " + player.getHealth());
            System.out.println("Enemy Health:  " + enemy.getHealth()+"\n");
            System.out.println("press 1 to attack:\t\t\t\t\tEnemy Killed:  " + count);
            System.out.println("press 2 to run:\t\t\t\t\t\tcollect coins: " + player.getCoin());
            System.out.println("press 3 to buy: \t\t\t\t\tScore = " + (count * 10));
            System.out.println("press 4 to pasue:");
            System.out.println("press 5 to Exit:");
            System.out.print("Enter your choice: ");
        
             int choice;
                 try {
                     choice = sc.nextInt();
                    } catch (InputMismatchException e) {
                          System.out.println("Invalid input. Please enter a valid number.");
                          sc.nextLine();
                          continue;
                       }

            switch (choice) {

                case 1:
                    Clear.clearScreen(); 
                    if ((game.prow) == (game.erow)||game.pcol==game.ecol) {

                            if((game.ecol!=game.pcol)&&game.pcol<game.ecol ){
                                  for(int j=(game.pcol)+1;j<game.ecol;j++){                             
                                     game.board[game.prow][j] = '-';
                                    }
                              
                                    game.PrintBoard();
                            
                                 try {
                                     Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                          e.printStackTrace(); 
                                        }
                                     Clear.clearScreen();
                                    for(int j=(game.pcol)+1;j<game.ecol;j++){
                                     
                                      game.board[game.prow][j] = ' ';
                                    }

                            }  
                            else if((game.ecol!=game.pcol)&&game.pcol>game.ecol){
                                  for(int j=(game.pcol)-1;j>game.ecol;j--){                             
                                     game.board[game.prow][j] = '-';
                                    }

                               game.PrintBoard();
                            
                                try {
                                     Thread.sleep(2000);
                                   }catch (InterruptedException e) {
                                      e.printStackTrace(); 
                                    }
                                    Clear.clearScreen();
                                         for(int j=(game.pcol)-1;j>game.ecol;j--){                             
                                          game.board[game.prow][j] = ' ';
                                        }
                            }
                            else if((game.erow!=game.prow)&&game.prow>game.erow){
                                  for(int j=(game.prow)-1;j>game.erow;j--){                             
                                     game.board[j][game.pcol] = '|';
                                     }

                                 game.PrintBoard();
                            
                                  try {
                                     Thread.sleep(2000);
                                   }catch (InterruptedException e) {
                                      e.printStackTrace(); 
                                    }
                                    Clear.clearScreen();
                                    for(int j=(game.prow)-1;j>game.erow;j--){                             
                                     game.board[j][game.pcol] = ' ';
                                     }           
                                }

                                else{ 
                                  for(int j=(game.prow)+1;j<game.erow;j++){                             
                                     game.board[j][game.pcol] = '|';
                                    }

                                    game.PrintBoard();
                            
                                  try {
                                     Thread.sleep(2000);
                                   }catch (InterruptedException e) {
                                      e.printStackTrace(); 
                                    }
                                    Clear.clearScreen();
                                    for(int j=(game.prow)+1;j<game.erow;j++){                             
                                     game.board[j][game.pcol] = ' ';
                                     }           
                                }
                        
                        enemy.attack(player);
                        player.attack(enemy, game);
                       try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                              e.printStackTrace(); 
                            }
                        Clear.clearScreen();
                        

                       game.board[game.erow][game.ecol] = ' ';
                       game.AddEnemy();

                        if (!enemy.isAlive()) {
                            System.out.println(" ");
                            //
                            Clear.clearScreen();                        
                            System.out.println("**Enemy defeated! :(");
                            System.out.println("** HORRY :(");
                            count++;                           
                            Random random = new Random();
                            player.collectCoin(random.nextInt(1, 15));
                            System.out.println("**New Enemy Appeared ");
                            enemy = new Enemy();
                            game.board[game.erow][game.ecol] = ' ';
                         try {
                             Thread.sleep(2000);
                           } catch (InterruptedException e) {
                                  e.printStackTrace(); 
                                }
                         Clear.clearScreen(); 
                         game.AddEnemy();      
                        }
                        break;
                    } 
                    
                    else 
                    {
                      if(game.pcol<game.ecol && Math.abs(game.pcol-game.ecol)>Math.abs(game.prow-game.erow))
                       {
                          for(int j=(game.pcol)+1;j<game.Col-1;j++){
                                game.board[game.prow][j] = '-';                               
                            } 
                       game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                            for(int j=(game.pcol)+1;j<game.Col-1;j++)
                               {
                                game.board[game.prow][j] = ' ';
                            }

                    }
                     else if(game.ecol<game.pcol && Math.abs(game.pcol-game.ecol)>Math.abs(game.prow-game.erow))
                       {
                          for(int j=(game.pcol)-1;j>0;j--){
                                game.board[game.prow][j] = '-';                               
                            } 
                       game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                            for(int j=(game.pcol)-1;j>0;j--)
                               {
                                game.board[game.prow][j] = ' ';
                            }

                    }    

                    else if((Math.abs(game.pcol-game.ecol))<(Math.abs(game.prow-game.erow))&&game.erow<game.prow)
                       {
                          for(int j=(game.prow)-1;j>0;j--){
                                game.board[j][game.pcol] = '|';                               
                            } 
                       game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                        Clear.clearScreen();
                            for(int j=(game.prow)-1;j>0;j--)
                               {
                                game.board[j][game.pcol]= ' ';
                            }

                    }       
                   else if((Math.abs(game.pcol-game.ecol))<(Math.abs(game.prow-game.erow))&&game.erow>game.prow)
                       {
                          for(int j=(game.prow)+1;j<game.Row-1;j++){
                                game.board[j][game.pcol] = '|';                               
                            } 
                       game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                        Clear.clearScreen();
                            for(int j=(game.prow)+1;j<game.Row-1;j++)
                               {
                                game.board[j][game.pcol]= ' ';
                            }

                    }       

                         player.Penalty();
                       ///
                         Clear.clearScreen(); 
                         System.out.println("Player loss his 5 health for penalty ):\n");
                          System.out.println("OOh sad!! ):");
                         try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                         e.printStackTrace(); 
                         }
                        Clear.clearScreen();
                        game.board[game.erow][game.ecol] = ' ';
                        game.AddEnemy();


                   
                    }
                    break;

                case 2:

                    Clear.clearScreen(); 
                    game.PrintBoard();
                    player.Run(game);
                    break;

                case 3:
                    by.buy(player);
                    break;

                case 5:
                    running = false;
                    break;
                case 4:
                      pauseMenu.Pause();
                        break;  

                default:
                    System.out.println("Invalid choice.");
                    break;
            }//
    
            if (!player.PlayerIsAlive()) {
                break;
            }
    } 
          else 
          {  
            Clear.clearScreen();
             System.out.println("Game Paused. Press 4 to resume.");
             
                int choice;
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                     Clear.clearScreen();
                    System.out.println("Invalid input. Please enter a number.");
                   
                    sc.nextLine();
                    continue;
                }
                if (choice== 4) {
                    Clear.clearScreen();
                    pauseMenu.Pause();
                    
                }
          }
}

        System.out.println("The Game is Over (:");
         Clear.clearScreen(); 
        System.out.println("\t\t\t\t\t\t\t Final Score = " + count * 10);
    }
}