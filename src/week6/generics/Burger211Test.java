package week6.generics;

public class Burger211Test {

    public static void main(String args[]) {

        Burger211<Object> burgerObject = new Burger211<>();
        burgerObject.setPrice("two dollars");
        System.out.println(burgerObject.getPrice());

        burgerObject.setPrice(2);
        System.out.println(burgerObject.getPrice());

        burgerObject.setPrice(2.5);
        System.out.println(burgerObject.getPrice());

    }

}
