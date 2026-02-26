
import java.util.ArrayList;
import java.util.List;

public class binaryTreePrinter {
    private static final String SPACER = "_";
    /**
     *
     * _______X______ depth 3
     * _ _X_ _ _ _X__ depth 2
     * _X_ _X _X_ _X_ depth 1
     */

    public static <T> void printBinaryTree(ArrayList<T> binaryArrayList) {
        if (binaryArrayList.isEmpty()) {
            return;
        }

        if (binaryArrayList.size() == 1) {
            System.out.println(" " + binaryArrayList.get(0) + " ");
            return;
        }

        int indexnumber = 0;
        int totalDepth = calculateDepth(binaryArrayList.size());
        for (int depth = totalDepth; depth > 1; depth--) {
            String spaces = SPACER.repeat(spacesFormula(depth));
            int items = itemsperDepth(totalDepth, depth);

           // System.out.printf("depth %d:", depth);
           // System.out.printf("items %d:", items);

            for (int i = 0; i < items; i++) {
                printBlock(spaces, binaryArrayList.get(indexnumber));
                indexnumber++;
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.print(binaryArrayList.get(indexnumber));
        indexnumber++;
        for(; indexnumber < binaryArrayList.size(); indexnumber++){
        //    System.out.printf("size: %d, current_index: %d", binaryArrayList.size(), indexnumber);
            System.out.print(SPACER + binaryArrayList.get(indexnumber));
        }
    }

    private static <T> void printBlock(String spaces, T value) {
        System.out.print(spaces + value + spaces);
    }

    private static int itemsperDepth(int totalDepth, int depth) { 
        // 2^(reversedDepth - 1)
        int reversedDepth = (totalDepth - depth);
        return (int) Math.pow(2, reversedDepth);
    }

    private static int spacesFormula(int depth) { // a_n = 2^{n-1} -1. 3-> (2*3 + 1)
        return (int) Math.pow(2, depth - 1) - 1;
    }

    private static <T> int calculateDepth(int index) {
        return (int) (logbase2(index) + 1);
    }

    private static double logbase2(double input) {
        return Math.log(input) / Math.log(2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11));
       // System.out.println(al.get(al.size()-1));
        printBinaryTree(al);
    }
}
