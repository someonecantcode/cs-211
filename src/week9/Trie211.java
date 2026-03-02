package week9;

import java.util.Scanner;

class tNode {
    public boolean isEnd;
    public tNode[] child = new tNode[26]; // for 26 chars in the alphabet

    public static void addWord(tNode root, String word) {
        for (int j = 0; j < word.length(); j++) { // for each letter of the word
            char c = word.charAt(j); // character at each index

            if (root.child[c - 'a'] != null) { // c-'a' makes it so child[0] is a and child[25] is z.
                if (word.length() - 1 == j) {
                    root.child[c - 'a'].isEnd = true;
                }
                root = root.child[c - 'a'];
            } else {
                tNode trie = new tNode(); // add child node and iteratively repeat the process
                trie.isEnd = (word.length() - 1 == j);
                root.child[c - 'a'] = trie; // add the character for the child node.
                root = root.child[c - 'a'];
            }
        }
    }

    public static boolean searchWord(tNode root, String word) {
        boolean isFound = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (root.child[c - 'a'] != null) { // check through the tree
                if (word.length() - 1 != i) {
                    root = root.child[c - 'a'];
                } else if (!root.child[c - 'a'].isEnd) {
                    isFound = false;
                }
            } else {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    public static void printWord(tNode root, String toPrint) {
        if (root == null) {
            return;
        }

        if (root.isEnd) {
            System.out.println(toPrint);
        }

        for (int i = 0; i < root.child.length; i++) {
            tNode t = root.child[i];
            if (t != null) {
                printWord(t, toPrint + (char) ('a' + i));
            }
        }
    }

    public static void prefixWord(tNode root, String preFix) {
        tNode t = root;
        System.out.println("prefix: " + preFix);

        for (int i = 0; i < preFix.length(); i++) {
            char c = preFix.charAt(i);
            if (t.child[c - 'a'] != null) {
                t = t.child[c - 'a'];
            } else {
                return;
            }
        }
        printWord(t, preFix);
    }
}

public class Trie211 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        tNode root = new tNode();
        String[] words = {"help", "hambuger", "ham", "hem", "huge", "hug", "hen"};
        // add words
        for(String word : words) {
            tNode.addWord(root, word);
        }
        

        // print all the words
        System.out.println("List of words");
        tNode.printWord(root, ""); // every single word since we start at empty root.
        System.out.println();

        //ask user for a prefix
        System.out.print("Input your prefix: ");
        String prefix = scan.next();
        tNode.prefixWord(root, prefix); // print every word starting with "hel".

        // test if the word is in the tree
        System.out.println(tNode.searchWord(root, "has"));
        scan.close();
    }
}