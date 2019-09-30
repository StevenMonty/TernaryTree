package a5;

import java.util.*;

public class TreeClient {

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws NullPointerException {

        TernaryTree<Integer> tree1 = new TernaryTree(1);
        TernaryTree<Integer> tree2 = new TernaryTree(2);
        TernaryTree<Integer> tree3 = new TernaryTree(3);
        TernaryTree<Integer> tree4 = new TernaryTree(4, tree1, tree2, tree3);
        // figure out if you had to make a copy
        TernaryTree<Integer> tree5 = new TernaryTree(5);
        TernaryTree<Integer> tree6 = new TernaryTree(6);
        TernaryTree<Integer> tree7 = new TernaryTree(7);
        TernaryTree<Integer> tree8 = new TernaryTree(8, tree5, tree6, tree7);
        TernaryTree<Integer> tree11 = new TernaryTree(11);
        TernaryTree<Integer> tree12 = new TernaryTree(12);
        TernaryTree<Integer> tree13 = new TernaryTree(13);
        TernaryTree<Integer> tree10 = new TernaryTree(10, tree11, tree12, tree13);
        TernaryTree<Integer> largeTree = new TernaryTree(0, tree4, tree8, tree10);
        System.out.println("Tree has been made");

        TernaryTree<Integer> newT = new TernaryTree(12);

        newT.setTree(10, newT, newT, newT);
        System.out.println("New Tree created, newt is a tree that is just a copy of itself as children");
        System.out.println("Num Nodes newt: " + newT.getNumberOfNodes());
        System.out.println("Height of newt tree: " + newT.getHeight());

        System.out.println("Let's test level order of newt");
        Iterator<Integer> testIter = newT.getLevelOrderIterator();
        while (testIter.hasNext()) {
            System.out.println(testIter.next() + " ");
        }
        System.out.println("Height of newt tree: " + newT.getHeight());

        System.out.println("Nodes of complex tree: " + largeTree.getNumberOfNodes());
        System.out.println("Height of complex tree: " + largeTree.getHeight());

        System.out.println("a pre order iterator");

        Iterator<Integer> newPRIter = largeTree.getPreorderIterator();
        while (newPRIter.hasNext()) {
            System.out.print(newPRIter.next() + " ");
        }

        System.out.println();

        System.out.println("Follows is post order iterator of complex: ");

        Iterator<Integer> newPIter = largeTree.getPostorderIterator();
        while (newPIter.hasNext()) {
            System.out.print(newPIter.next() + " ");
        }
        System.out.println();
        System.out.println("Now is a level order iterator");

        Iterator<Integer> newLIter = largeTree.getLevelOrderIterator();
        while (newLIter.hasNext()) {
            System.out.print(newLIter.next() + " ");
        }
        System.out.println();

        TernaryTree<Integer> bigBoy = new TernaryTree(100);
        bigBoy.setTree(bigBoy.getRootData(), largeTree, largeTree, largeTree);
        System.out.println("Height of big boy: " + bigBoy.getHeight());
        System.out.println("Number of nodes in big boy: " + bigBoy.getNumberOfNodes());
        System.out.println("Alright heres the big boy, level order of a large tree using large trees as copy");
        System.out.println();
        Iterator<Integer> levelBig = bigBoy.getLevelOrderIterator();
        while (levelBig.hasNext()) {
            System.out.print(levelBig.next() + " ");
        }
        System.out.println();
        System.out.println("A tree with only left children");
        TernaryTree<Integer> tree9 = new TernaryTree(12);
        tree9.setTree(9, null, null, null);
        tree6.setTree(6, tree9, null, null);
        tree3.setTree(3, tree6, null, null);
        System.out.println("Height of all left tree, should be 3: " + tree3.getHeight());
        System.out.println("Number of nodes in tree, should also be 3: " + tree3.getNumberOfNodes());
        System.out.println("Post iterator of leftie, should read 9 6 3: ");
        Iterator leftie = tree3.getPostorderIterator();
        while (leftie.hasNext()) {
            System.out.print(leftie.next());
        }

        System.out.println();
        System.out.println("A tree with only middle children");
        tree4.setTree(4, null, null, null);
        tree2.setTree(2, null, tree4, null);
        tree8.setTree(8, null, tree2, null);

        System.out.println("Height of all middle tree, should be 3: " + tree8.getHeight());
        System.out.println("Number of nodes in tree, should also be 3: " + tree8.getNumberOfNodes());
        System.out.println("level iterator of middie, should read 8 2 4: ");
        Iterator middie = tree8.getLevelOrderIterator();
        while (middie.hasNext()) {
            System.out.print(middie.next());
        }

        System.out.println();
        System.out.println("A tree with only right children");
        tree2.setTree(2, null, null, null);
        tree7.setTree(7, null, null, tree2);
        tree1.setTree(1, null, null, tree7);

        System.out.println("Height of all right tree, should be 3: " + tree1.getHeight()); // not working
        System.out.println("Number of nodes in tree, should also be 3: " + tree1.getNumberOfNodes());
        System.out.println("pre iterator of rightie, should read 1 7 2: ");
        Iterator rightie = tree1.getPreorderIterator();
        while (rightie.hasNext()) {
            System.out.print(rightie.next());
        }
        System.out.println();

        TernaryTree<Integer> aTree = new TernaryTree();
        System.out.println("Height of tree that had no root data: " + aTree.getHeight());
        System.out.println("Number of nodes of tree in tree with no root data: " + aTree.getNumberOfNodes());

        System.out.println("Making the biggest boy...");
        System.out.println();

        TernaryTree baseLeft = new TernaryTree(16);
        baseLeft.setTree(baseLeft.getRootData(), new TernaryTree(23), new TernaryTree(24), new TernaryTree(25));
        TernaryTree baseRight = new TernaryTree(19);
        baseRight.setTree(baseRight.getRootData(), new TernaryTree(20), new TernaryTree(21), new TernaryTree(22));

        tree13.setTree(13, baseLeft, new TernaryTree(17), null);

        TernaryTree tree14 = new TernaryTree(14);
        tree14.setTree(tree14.getRootData(), null, null, new TernaryTree(18));

        TernaryTree tree15 = new TernaryTree(15);
        tree15.setTree(tree15.getRootData(), null, null, baseRight);

        tree12 = new TernaryTree(12);
        tree12.setTree(tree12.getRootData(), tree13, tree14, tree15);

        tree10.setTree(10, null, tree12, null);

        tree8.setTree(8, null, tree10, new TernaryTree(11));

        TernaryTree tree25 = new TernaryTree(25);
        tree25.setTree(tree25.getRootData(), new TernaryTree(26), new TernaryTree(27), new TernaryTree(28));

        TernaryTree tree23 = new TernaryTree(23);
        tree23.setTree(23, new TernaryTree(24), null, tree25);

        tree6.setTree(6, tree8, tree23, null);

        // left side of the biggest boy done

        TernaryTree tree47 = new TernaryTree();
        tree47.setTree(47, new TernaryTree(48), new TernaryTree(49), new TernaryTree(50));

        tree7.setTree(7, new TernaryTree(45), new TernaryTree(46), tree47);
        // middle of tree done

        TernaryTree tree54 = new TernaryTree();
        tree54.setTree(54, new TernaryTree(55), new TernaryTree(56), new TernaryTree(57));

        TernaryTree tree52 = new TernaryTree();
        tree52.setTree(52, tree54, new TernaryTree(), new TernaryTree());

        tree1.setTree(1, new TernaryTree(51), tree52, new TernaryTree(53));

        tree5.setTree(5, tree6, tree7, tree1);
        // tree is done being made

        System.out.println("Height of the biggest boy, should be 8: " + tree5.getHeight());
        System.out.println("Number of nodes in biggest boy, should be 40: " + tree5.getNumberOfNodes());

        System.out.println();
        System.out.println("Now the pre order iterator: ");
        System.out.println();
        Iterator<Integer> pre = tree5.getPreorderIterator();
        while (pre.hasNext()) {
            System.out.print(pre.next() + " ");
        }

        System.out.println();
        System.out.println("Now the post order iterator: ");
        System.out.println();
        Iterator<Integer> post = tree5.getPostorderIterator();
        while (post.hasNext()) {
            System.out.print(post.next() + " ");
        }

        System.out.println();
        System.out.println("Now the level order iterator: ");
        System.out.println();
        Iterator<Integer> lev = tree5.getLevelOrderIterator();
        while (lev.hasNext()) {
            System.out.print(lev.next() + " ");
        }

        System.out.println("Ok let's test some errors");
        // System.out.println("Calling pre without checking if it has next : ");
        // System.out.println(pre.next());

        // System.out.println(lev.next());

        // System.out.println(post.next());

        // Iterator<Integer> test = tree5.getInorderIterator();

        // TernaryTree tree69 = new TernaryTree();
        // System.out.println(tree69.getRootData());

    }

}