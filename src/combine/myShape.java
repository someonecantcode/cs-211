package combine;


public class myShape {
	
    public static void main(String[] args) {
    	
    	int screenWidth = 1200;
    	int screenHeight= 800;
    	int howManyShapes = 10;
    	int shapeMaxSize = 100;
  
        // AllShapes SR = new AllShapes(screenWidth, screenHeight, howManyShapes, shapeMaxSize); // none recurcive
        
    	Shape_Recursion SR = new Shape_Recursion(screenWidth, screenHeight, howManyShapes, shapeMaxSize);
       
        SR.start(); 
    }

}
