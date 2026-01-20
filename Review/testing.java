
public class testing {

    public static void main(String[] args) {
       // recursivetest(5);
        System.out.print(factorial(9));
    }

    public static void recursivetest(int n) {
        System.out.println("*");
        if (n > 0) {
            recursivetest(n - 1);
        }
    }

    public static long factorial(int n) {
        for (int i = n-1; i >= 2; i--) {
            n *= i;
        }
        return n;
    }

    public static long factorialr(int n) {
        if(n==2){
            return 2;
        }

        return factorial(n-1)*n;
    }

    
}