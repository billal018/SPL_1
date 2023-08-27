public class Bullet {

   public Bullet()
   {
     int screenWidth ; 
        int currentPosition ;
        char character = 'X'; 

   }

    public static void moveCharacter(GameBoard game,int ecol,int pcol) {
       int screenWidth = ecol;
       int currentPosition = pcol;
       char character = 'X'; 

        while (currentPosition < screenWidth) {
            clearLine();
            printCharacter(currentPosition, character);

            try {
                Thread.sleep(25); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            currentPosition++;
        }
        System.out.println(); 

    }

    public static void clearLine() {
        System.out.print("\r"); 
    }

    public static void printCharacter(int position, char character) {
        for (int i = 0; i < position; i++) {
            System.out.print(" ");
        }
        System.out.print(character);
        if (position > 0) {
            System.out.print("\b"); 
        }
    }


       
}