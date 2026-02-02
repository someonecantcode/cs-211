import java.util.Stack;


public class q13 {
    public static void recursion(int n) {
        if (n > 0) {
            System.out.println(n);
            recursion(n-1);
            System.err.println(n);
        }
    }

    public static void testing(int i){
        if (i >= 0){
            System.out.print(i);
            testing(--i);
        }
    }
    public static void main(String[] args) {


        Stack<String> s = new Stack<>();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s.search("C"));
    }
}