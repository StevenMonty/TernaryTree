package a5;
import java.util.*;
import a5.StackAndQueuePackage.*;


public class TestTree
{
    public static void main(String[] args)
    {
        
        TernaryTree<String> test = new TernaryTree<String>("hello");

        System.out.println("The following test methods should print 1");
        testnumnodes(test);
        testgetheight(test);

        //create three more trees to add to root node
        TernaryTree<String> left1 = new TernaryTree<String>("bye");
        TernaryTree<String> mid1 = new TernaryTree<String>("hi");
        TernaryTree<String> right1 = new TernaryTree<String>("thankyou");

        //create three more trees to add to left1 node
        TernaryTree<String> left2 = new TernaryTree<String>("1");
        TernaryTree<String> mid2 = new TernaryTree<String>("2");
        TernaryTree<String> right2 = new TernaryTree<String>("3");

        //create three more trees to add to left2 node
        TernaryTreeInterface<String> left3 = new TernaryTree<String>("luisa");
        TernaryTreeInterface<String> mid3 = new TernaryTree<String>("phin");
        TernaryTreeInterface<String> right3 = new TernaryTree<String>("cusick");

        //create three more trees to add to level1 mid node
        TernaryTreeInterface<String> left4 = new TernaryTree<String>("a");
        TernaryTreeInterface<String> mid4 = new TernaryTree<String>("b");
        TernaryTreeInterface<String> right4 = new TernaryTree<String>("c");
        
        //add the "level3mid" set of trees to to the level3mid tree and to the level1mid
        mid3.setTree("phin", left4, mid4, right4);
        mid1.setTree("hi", left4, mid4, right4);
        left2.setTree("1", left3, mid3, right3);
        left1.setTree("bye", left2, mid2, right2);
        
        //set root's children
        test.setTree("hello", left1, mid1, right1);

        System.out.println("The following should print out 16 for number of nodes and 5 for height");
        testnumnodes(test);
        testgetheight(test);

        
        System.out.println("");
        System.out.println("Post Order Iterator Test should print out: ");
        System.out.println("luisa, a, b, c, phin, cusick, 1, 2, 3, bye, a, b, c, hi, thankyou, hello");
        testPostOrder(test);
        
        
        System.out.println("");
        System.out.println("Pre Order Iterator Test should print out: ");
        System.out.println("hello, bye, 1, luisa, phin, a, b, c, cusick, 2, 3, hi, a, b, c, thankyou");
        testPreOrder(test);

        System.out.println();
        System.out.println("Level Order Iterator Test should print out: ");
        System.out.println("hello, bye, hi, thankyou, 1, 2, 3, a, b, c, luisa, phin, cusick, a, b, c");
        testLevelOrder(test);

        System.out.println("Testing bonus contains method: ");
        System.out.println("The following should be true: ");
        testContains(test, "luisa");

        System.out.println("The following should be false: ");
        testContains(test, "cassie");
        

        System.out.println("Testing bonus isBalanced method: ");
        System.out.println("The following should be false: ");
        System.out.println(test.isBalanced());

        test.setTree("hello");
        System.out.println("Testing bonus isBalanced method: ");
        System.out.println("The following should be true: ");
        System.out.println(test.isBalanced());

        test.clear();
        System.out.println("Testing clear method. The following should print 0: ");
        testnumnodes(test);
        testgetheight(test);
 
    }

    public static void testPostOrder(TernaryTree<String> test)
    {
        Iterator testiterator = test.getPostorderIterator();
        System.out.println("Your output: ");
        while(testiterator.hasNext())
        {
            System.out.print(testiterator.next().toString() + ", ");

        }
        System.out.println(" ");

    }

    public static void testPreOrder(TernaryTree<String> test)
    {
        Iterator testiterator = test.getPreorderIterator();
        System.out.println("Your output: ");

        while(testiterator.hasNext())
        {
            System.out.print(testiterator.next().toString() + ", ");
        }
        System.out.println(" ");

    }

    public static void testLevelOrder(TernaryTree<String> test)
    {
        Iterator testiterator = test.getLevelOrderIterator();
        System.out.println("Your output: ");

        while(testiterator.hasNext())
        {
            System.out.print(testiterator.next().toString() + ", ");

        }
        System.out.println(" ");

    }

    public static void testnumnodes(TernaryTree<String> test)
    {
        System.out.println("Number of nodes: " + test.getNumberOfNodes());
    }

    public static void testgetheight(TernaryTree<String> test)
    {
        System.out.println("Height: " + test.getHeight());
    }

    public static void printAll(TernaryTree<String> test)
    {
        System.out.println(test.toString());
    }

    public static void testContains(TernaryTree<String> test, String elem)
    {
        boolean contains = test.contains(elem);
        System.out.println(contains);
    }
}