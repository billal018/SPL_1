import java.util.Scanner;
class Buy
 {
     Scanner sc=new Scanner(System.in);

    public void buy(Player player){  //

         Clear.clearScreen(); 
         System.out.println("\nDo you want to Buy health??");
         System.out.println("\ntype yes or no");
         String st=sc.next();
         System.out.println(st);
       if(st.equalsIgnoreCase("YES"))
         {
             if(player.health>15){
                Clear.clearScreen(); 
                //
                  System.out.println("Reamaining enough health");
                  try {
                    Thread.sleep(2000);
                  } catch (InterruptedException e) {
                       e.printStackTrace(); 
                     }
                      Clear.clearScreen(); 
               }
             else if(player.coins<20 && player.health<15){
                Clear.clearScreen(); 

                 System.out.println("insufficient coins");
             }
             else {
                 Clear.clearScreen(); 
                 player.health+=10;
                 player.coins-=20;
                 System.out.println("\nSuccesfully");
              }
        }
       else if(st.equalsIgnoreCase("NO")) 
      {

        Clear.clearScreen(); 
        System.out.println("\nback to the field");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
                  e.printStackTrace(); 
                }
          Clear.clearScreen(); 
      }
      else 
      {
          Clear.clearScreen(); 
        System.out.println("\nType mistake");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
             e.printStackTrace(); 
            }
          Clear.clearScreen(); 
      }

    }
}