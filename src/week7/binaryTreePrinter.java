package week7;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePrinter {

    private static String SPACER = "_";
    private static String SPACER_ALTERNATE = " ";
    public int scalingfactor;

    /**
     *
     * _______X______ depth 2
     *
     * _ _X_ _ _ _X__ depth 1
     *
     * _X_ _X _X_ _X_ depth 0
     */
    public binaryTreePrinter(int scalingfactor) {
        this.scalingfactor = scalingfactor;
        SPACER = SPACER.repeat(scalingfactor);
        SPACER_ALTERNATE = SPACER_ALTERNATE.repeat(scalingfactor);
    }

    public <T> void printBinaryTree(List<T> binaryArrayList) {
        System.out.println(binaryArrayList);
        if (binaryArrayList.isEmpty()) {
            return;
        }

        if (binaryArrayList.size() == 1) {
            System.out.println(" " + binaryArrayList.get(0) + " ");
            return;
        }

        int indexnumber = 0;
        int totalDepth = calculateDepth(binaryArrayList.size());

        // all depths except last. follows block pattern 
        // block = SPACER item SPACER 
        // block |scaled space| (do it for n items per each depth level)
        for (int depth = totalDepth; depth > 0; depth--) {
            String spaces = SPACER.repeat(spacesFormula(depth));
            int items = itemsperDepth(totalDepth, depth);
            
            for (int i = 0; i < items; i++) {
                printBlock(spaces, binaryArrayList.get(indexnumber));
                indexnumber++;
            }
            System.out.println();
        }

        // last layer X_X_X_X_ 
        System.out.print(binaryArrayList.get(indexnumber));
        indexnumber++;
        for (; indexnumber < binaryArrayList.size(); indexnumber++) {
            System.out.print(SPACER + binaryArrayList.get(indexnumber));
        }
    }

    private <T> void printBlock(String spaces, T value) {
        String formatString = "%s%" + this.scalingfactor + "s%s";
        System.out.printf(formatString, spaces, value, spaces);
        System.out.print(SPACER_ALTERNATE);
    }

    private int itemsperDepth(int totalDepth, int depth) {
        int reversedDepth = (totalDepth - depth);
        return (int) Math.pow(2, reversedDepth);
    }

    private int spacesFormula(int depth) {
        // closed form a_n = 2^{n} -1. depth 3-> (2*3 - 1)
        // recursive form a_n = 2(a_{n-1}) + 1
        return (int) Math.pow(2, depth) - 1;
    }

    private <T> int calculateDepth(int index) { // floor(log2 index)
        return (int) (logbase2(index));
    }

    private double logbase2(double input) {
        return Math.log(input) / Math.log(2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(List.of(1, 10, 7, 23, 27, 22, 15, 31, 23, 44, 31, 27, 40, 26));
        // System.out.println(al.get(al.size()-1));
        binaryTreePrinter printer = new binaryTreePrinter(2);
        printer.printBinaryTree(al);
    }
}
