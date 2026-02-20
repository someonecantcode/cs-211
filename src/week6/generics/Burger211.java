package week6.generics;

public class Burger211<T> {

    private T burgerPrice;

    public void setPrice(T burgerPrice) {
        this.burgerPrice = burgerPrice;
    }

    public T getPrice() {
        return this.burgerPrice;
    }

}
