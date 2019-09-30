package a5;

import java.util.Iterator;


public class TernaryTester
{
	public static void main(String[] args)
	{
		test1();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		test2();

	}
	
	public static void test1()
	{	
		//TODO causes error when using TernaryTreeInterface
		//TernaryTreeInterface<String> tree = new TernaryTree<>();
		TernaryTree<String> tree = new TernaryTree<>();
			
		System.out.println("Tree 1 should be empty: " + tree.isEmpty() + ", Height should == 0: " + tree.getHeight());
		
		tree = new TernaryTree<String>("Root");
		TernaryTree<String> leftChild = new TernaryTree<String>("LeftChild");
		TernaryTree<String> middleChild = new TernaryTree<String>("MiddleChild");
		TernaryTree<String> rightChild = new TernaryTree<String>("RightChild");
		tree.setTree(tree.getRootData(), leftChild, middleChild, rightChild);
		System.out.println(tree.getRootData());
		System.out.println(tree.getLeftChild().getData());
		System.out.println(tree.getMiddleChild().getData());
		System.out.println(tree.getRightChild().getData());
		System.out.println("Tree 1 should not be empty: " + tree.isEmpty() + ", Height should == 2: " + tree.getHeight());
		System.out.println("Number of nodes == " + tree.getNumberOfNodes());
		System.out.println();
		TernaryTree<String> leftLeft = new TernaryTree<String>("LeftLeft");
		TernaryTree<String> leftMiddle = new TernaryTree<String>("LeftMiddle");
		TernaryTree<String> leftRight = new TernaryTree<String> ("LeftRight");
		leftChild.setTree(leftChild.getRootData(), leftLeft, leftMiddle, leftRight);
	/*	System.out.println(leftChild.getRootData());
		System.out.println(leftChild.getLeftChild().getData());
		System.out.println(leftChild.getMiddleChild().getData());
		System.out.println(leftChild.getRightChild().getData());
	*/	System.out.println();
		
		TernaryTree<String> leftLeftLeft = new TernaryTree<String>("LeftLeftLeft");
		TernaryTree<String> leftLeftMiddle = new TernaryTree<String>("LeftLeftMiddle");
		TernaryTree<String> leftLeftRight = new TernaryTree<String>("LeftLeftRight");
		leftLeft.setTree(leftLeft.getRootData(), leftLeftLeft, leftLeftMiddle, leftLeftRight);
	/*	System.out.println(leftLeft.getRootData());
		System.out.println(leftLeft.getLeftChild().getData());
		System.out.println(leftLeft.getMiddleChild().getData());
	*/	System.out.println();
	
		tree.setTree(tree.getRootData(), leftChild, middleChild, rightChild);	//Need to be reupdated???
		System.out.println("Tree 1 should not be empty: " + tree.isEmpty() + ", Height should == 9: " + tree.getHeight());
		System.out.println("Number of nodes == " + tree.getNumberOfNodes());
			
		
		Iterator<String> preOrder = tree.getPreorderIterator();
		Iterator<String> postOrder = tree.getPostorderIterator();
		Iterator<String> levelOrder = tree.getLevelOrderIterator();
		
		System.out.println("Preorder Iterator Test");
		while (preOrder.hasNext())
			System.out.println(preOrder.next());
		
		System.out.println();
		
		System.out.println("Postorder Iterator Test");
		while (postOrder.hasNext())						
			System.out.println(postOrder.next());
		
		System.out.println();
		
		System.out.println("LevelOrder Iterator Test");
		while (levelOrder.hasNext())
			System.out.println(levelOrder.next());
	}
	
	public static void test2()
	{
		TernaryTree<String> tree = new TernaryTree<String>("A");
		TernaryTree<String> b = new TernaryTree<String>("B");
		TernaryTree<String> c = new TernaryTree<String>("C");
		TernaryTree<String> d = new TernaryTree<String>("D");
		TernaryTree<String> e = new TernaryTree<String>("E");
		TernaryTree<String> f = new TernaryTree<String>("F");
		TernaryTree<String> g = new TernaryTree<String>("G");
		TernaryTree<String> h = new TernaryTree<String>("H");
		System.out.println(tree.getRootData());
		b.setTree(b.getRootData(),d,e,f);
		g.setTree(g.getRootData(),null,null,h);
		c.setTree(c.getRootData(),null,g,null);
		tree.setTree(tree.getRootData(),b,null,c);
		System.out.println(tree.getRootData());
		Iterator<String> it = tree.getLevelOrderIterator();
		System.out.println("Tree1: ");
		while(it.hasNext())
		{
			System.out.print(it.next()+", ");
		}

		System.out.println();

		System.out.println("Depth: "+tree.getHeight());
		System.out.println("Num Nodes: "+tree.getNumberOfNodes());

		tree.setTree(tree.getRootData());
		it = tree.getLevelOrderIterator();
		System.out.println("Tree1: ");
		while(it.hasNext())
		{
			System.out.print(it.next()+", ");
		}

		System.out.println();

		System.out.println("Depth: "+tree.getHeight());
		System.out.println("Num Nodes: "+tree.getNumberOfNodes());
	}
}
