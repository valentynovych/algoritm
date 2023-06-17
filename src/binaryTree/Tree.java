package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {
    Character value;
    Tree left;
    Tree right;

    public Tree(char value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(char value) {
        this.value = value;
    }

    public static String sumCharRecursive(Tree tree) {

        String sumChars = tree.value + ", ";

        if (tree.left != null) {
            sumChars += sumCharRecursive(tree.left);
        }

        if (tree.right != null) {
            sumChars += sumCharRecursive(tree.right);
        }
        return sumChars;
    }

    public static String traverseWith(Tree tree) {
        Queue<Tree> treeDeque = new ArrayDeque<>();
        StringBuilder sumChars = new StringBuilder();

        treeDeque.add(tree);

        while (!treeDeque.isEmpty()) {
            Tree stock = treeDeque.poll();

            sumChars.append(stock.value).append(", ");

            if (stock.left != null) {
                treeDeque.add(stock.left);
            }

            if (stock.right != null) {
                treeDeque.add(stock.right);
            }
        }
        return sumChars.toString();
    }
}
