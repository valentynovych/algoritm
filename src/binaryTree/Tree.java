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
        //System.out.print(tree.value);
        if (tree.left != null) {
            sumChars += sumCharRecursive(tree.left);
        }
        //System.out.println(tree.value);

        if (tree.right != null) {
            sumChars += sumCharRecursive(tree.right);
        }
        return sumChars;
    }

    public static String traverseWith(Tree tree) {
        Queue<Tree> treeDeque = new ArrayDeque<>();
        String sumChars = tree.value + ", ";
        treeDeque.add(tree);

        while (!treeDeque.isEmpty()) {
            Tree node = treeDeque.poll();

            if (node.left != null) {
                treeDeque.add(node.left);
                sumChars += node.left.value + ", ";
            }
            if (node.right != null) {
                treeDeque.add(node.right);
                sumChars += node.right.value + ", ";
            }
        }
        return sumChars;
    }
}
