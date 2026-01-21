package week3;

public class myStar {
	
    public static void main(String[] args) {
    	
    	int screenWidth =1200;
    	int screenHeight= 800;
    	int howManyStars = 10;
    	int starMaxSize = 100;
  
        // Stars SR = new Stars(screenWidth, screenHeight, howManyStars, starMaxSize); // none recurcive
        
    	 Stars_Recursion SR = new Stars_Recursion(screenWidth, screenHeight, howManyStars, starMaxSize);
       
        SR.start(); 
    }

}
