package binaryTree;

public class TreeDemo {
    public static void main(String[] args) {
        Tree charsTree = new Tree('M',
                new Tree('I',
                        new Tree('F',
                                new Tree('D',
                                        new Tree('A'), null),
                                new Tree('H')),
                        new Tree('L')),
                new Tree('T',
                        new Tree('S',
                                new Tree('P',
                                        new Tree('Q'),
                                        new Tree('O')), null),
                        new Tree('V',
                                null,
                                new Tree('Y',
                                        new Tree('X'),
                                        new Tree('Z')))));


        System.out.println("Traverse in depth");
        System.out.println("Expected result: \nM, I, F, D, A, H, L, T, S, P, Q, O, V, Y, X, Z");
        System.out.println("Actual result");
        System.out.println(Tree.sumCharRecursive(charsTree));

        System.out.println();
        System.out.println("Traverse in width");
        System.out.println("Expected result: \nM, I, T, F, L, S, V, D, H, P, Y, A, Q, O, X, Z");
        System.out.println("Actual result");
        System.out.println(Tree.traverseWith(charsTree));
    }
}
