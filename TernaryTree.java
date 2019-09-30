package a5;	//TODO

import java.util.Iterator;
import java.util.NoSuchElementException;
import a5.StackAndQueuePackage.*;	//TODO


//Your TernaryTree class must include the following in- ner classes 
//that implement these iterators: PreorderIterator, PostorderIterator, and LevelOrderIterator.

//TODO add javadoc

public class TernaryTree<T> implements TernaryTreeInterface<T>, TernaryTreeBonus<T>
{
	private TernaryNode<T> root;
		
	public TernaryTree()
	{
		root = null;
	}
	
	public TernaryTree(T rootData)
	{
		root = new TernaryNode<>(rootData);
	}
	
	public TernaryTree (T rootData, TernaryTree<T> leftChild, TernaryTree<T> middleChild, TernaryTree<T> rightChild )
	{
		privateSetTree(rootData, leftChild, middleChild, rightChild);
	}
	
	@Override
	public void setTree(T rootData)
	{
		privateSetTree(rootData, null, null, null);
	}
	
	@Override
	public void setTree(T rootData, TernaryTreeInterface<T> leftTree, TernaryTreeInterface<T> middleTree, TernaryTreeInterface<T> rightTree)
	{
		privateSetTree(rootData,(TernaryTree<T>) leftTree, (TernaryTree<T>) middleTree, (TernaryTree<T>) rightTree);
	}
	
	private void privateSetTree(T rootData, TernaryTree<T> leftTree, TernaryTree<T> middleTree, TernaryTree<T> rightTree)
	{
		/*
		root = new TernaryNode<T>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty()) 
            root.setLeftChild(leftTree.root);
        
        if ((middleTree != null) && !middleTree.isEmpty())
        	root.setMiddleChild(middleTree.root);

        if ((rightTree != null) && !rightTree.isEmpty()) 
        	root.setRightChild(rightTree.root);
        	*/
		TernaryNode<T> root = new TernaryNode<>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty()) {
            if (leftTree != middleTree && leftTree != rightTree)
                root.setLeftChild(leftTree.root);
            else
                root.setLeftChild(leftTree.root.copy());
        }

        if (middleTree != null && !middleTree.isEmpty()) {
            if (middleTree != leftTree && middleTree != rightTree) {
                root.setMiddleChild(middleTree.root);
            } else {
                root.setMiddleChild(middleTree.root.copy());
            }
        }
        if (rightTree != null && !rightTree.isEmpty()) {
            if (rightTree != leftTree && rightTree != middleTree) {
                root.setRightChild(rightTree.root);
            } else {
                root.setRightChild(rightTree.root.copy());
            }
        }

        this.root = root;

        if ((leftTree != null) && (leftTree != this)) {
            leftTree.clear();
        }

        if ((middleTree != null) && (middleTree != this)) {
            middleTree.clear();
        }

        if ((rightTree != null) && (rightTree != this)) {
            rightTree.clear();
        }

	}
	
	@Override
	public boolean isEmpty()
	{
		return root == null;
	}

	@Override
	public void clear()
	{
		root = null;
	}

	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	}
	
	protected void setRootNode(TernaryNode<T> newRoot)
	{
		root = newRoot;
	}
	
	protected TernaryNode<T> getRootNode()
	{
		return root;
	}
	
	@Override
	public T getRootData()
	{
		if (isEmpty())
			throw new EmptyTreeException();
		
		return root.getData();
	}

	public boolean hasLeftChild()
	{
		return root.hasLeftChild();
	}

	public TernaryNode<T> getLeftChild()
	{
		return root.getLeftChild();
	}
	
	public boolean hasMiddleChild()
	{
		return root.hasMiddleChild();
	}

	public TernaryNode<T> getMiddleChild()
	{
		return root.getMiddleChild();
	}
	
	public boolean hasRightChild()
	{
		return root.hasRightChild();
	}

	public TernaryNode<T> getRightChild()
	{
		return root.getRightChild();
	}
	
	@Override
	public int getHeight()
	{
	   int height = 0;
	   if (!isEmpty()) 
	      height = root.getHeight();
	        
	   return height;
	}

	@Override
	public int getNumberOfNodes()
	{
		int numberOfNodes = 0;
        if (!isEmpty()) {
            numberOfNodes = root.getNumberOfNodes();
        }
        return numberOfNodes;
	}
	
	@Override
	public boolean contains(T elem)		
	{
		Iterator<T> it = this.getPreorderIterator();
		
		while(it.hasNext())
			if (it.next().equals(elem))
				return true;
		
		return false;
	}

	@Override
	public boolean isBalanced()	
	{
        TernaryNode<T> left = root.getLeftChild();
        TernaryNode<T> middle = root.getMiddleChild();
        TernaryNode<T> right = root.getRightChild();

        int leftHeight = 0;
        int middleHeight = 0;
        int rightHeight = 0;
        
        if(left != null)
            leftHeight = left.getHeight();
        
        if(middle != null)
            middleHeight = middle.getHeight();
        
        if(right != null)
            rightHeight = right.getHeight();

        if( (Math.abs(leftHeight - middleHeight) > 1)  || 
        	(Math.abs(middleHeight - rightHeight) > 1) ||
        	(Math.abs(leftHeight - rightHeight) >1) )
            	return false;

        else 
        	return true;

	}
	
	@Override
	public Iterator<T> getPreorderIterator()
	{
		return new PreorderIterator();
	}

	@Override
	public Iterator<T> getPostorderIterator()
	{
	return new PostorderIterator();
	}

	@Override
	public Iterator<T> getInorderIterator()
	{
		/* TernaryTree does not support InorderIterator because in a BinaryTree, the
		 * iterator returns the left child, then the root, and then the right node,
		 * but this is not possible with a TernaryTree because the root would have to 
		 * go inbetween the three nodes and not be in between them properly and there
		 * is not way to determine the priority of the middle node compared to its parent.  
		 */
		
		throw new UnsupportedOperationException("InorderIterator not supported");
	}

	@Override
	public Iterator<T> getLevelOrderIterator()
	{
		return new LevelorderIterator();
	}

	private class PreorderIterator implements Iterator<T>	//Done
	{
		private StackInterface<TernaryNode<T>> nodeStack;
		
		public PreorderIterator()
		{
			nodeStack = new LinkedStack<>();
			
			if (root != null)
				nodeStack.push(root);
		}

		@Override
		public boolean hasNext()	
		{
			return !nodeStack.isEmpty();
		}

		@Override
		public T next()
		{
			TernaryNode<T> nextNode;
			
			if (hasNext())
			{
				nextNode = nodeStack.pop();
				
				TernaryNode<T> left = nextNode.getLeftChild();
				TernaryNode<T> middle = nextNode.getMiddleChild();
				TernaryNode<T> right = nextNode.getRightChild();
				
				//Push onto stack in reverse order
				if (right != null)
					nodeStack.push(right);
				
				if (middle != null)
					nodeStack.push(middle);
				
				if (left != null)
					nodeStack.push(left);
			} else {
				throw new NoSuchElementException();	
			}
			
			return nextNode.getData();
		}
		
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Remove operation not supported");
		}
	}	//End PreOrderIterator class
	
	private class PostorderIterator implements Iterator<T>
	{
		private StackInterface<TernaryNode<T>> nodeStack;
		private TernaryNode<T> currentNode;

		public PostorderIterator() 
		{
            nodeStack = new LinkedStack<>();
            currentNode = root;
        }
		
		@Override
		public boolean hasNext()
		{
			return !nodeStack.isEmpty() || currentNode != null;
		}
		
		@Override
		public T next()
		{		
			TernaryNode<T> left = null;
			TernaryNode<T> middle = null;
			TernaryNode<T> next = null;
			
			while (currentNode != null)
			{
				nodeStack.push(currentNode);
				
				left = currentNode.getLeftChild();
				middle = currentNode.getMiddleChild();

				if (left == null && middle == null) 
                    currentNode = currentNode.getRightChild();
				else if (left == null) 
                    currentNode = middle;
				else 
					currentNode = left;
			}
				
			if (!nodeStack.isEmpty()) 
			{
		        next = nodeStack.pop();
		        
				TernaryNode<T> parent = null;

	                if (!nodeStack.isEmpty()) 
	                {
	                    parent = nodeStack.peek();

	                    if (next == parent.getLeftChild() && parent.getMiddleChild() != null) 
	                   
	                        currentNode = parent.getMiddleChild();
	                  
	                    else if (next == parent.getMiddleChild()) 
	                   
	                        currentNode = parent.getRightChild();
	          
	                    else if (next == parent.getLeftChild()) 
	                   
	                        currentNode = parent.getRightChild();
	                    else 
	                        currentNode = null;
	                 
	                } else 
	                    currentNode = null;
	                
			} else 
				throw new NoSuchElementException();	
			
			return next.getData();
		}
		
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Remove operation not supported");
		}
		
	}	//End PostOrderIterator class
	
	private class LevelorderIterator implements Iterator<T>
	{
		private QueueInterface<TernaryNode<T>> nodeQueue;
		
		public LevelorderIterator()
		{
			nodeQueue = new LinkedQueue<>();
			
			if(root != null)
				nodeQueue.enqueue(root);
		}
		
		@Override
		public boolean hasNext()
		{
			return !nodeQueue.isEmpty();
		}

		@Override
		public T next()
		{
			TernaryNode<T> nextNode;
			
			if (hasNext())
			{
				nextNode = nodeQueue.dequeue();
				
				TernaryNode<T> left = nextNode.getLeftChild();
				TernaryNode<T> middle = nextNode.getMiddleChild();
				TernaryNode<T> right = nextNode.getRightChild();
				
				//Add to queue in order
				if (left != null)
					nodeQueue.enqueue(left);
				
				if (middle != null)
					nodeQueue.enqueue(middle);
				
				if (right != null)
					nodeQueue.enqueue(right);
			} else {
				throw new NoSuchElementException();	
			}
					
			return nextNode.getData();
		}
		
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Remove operation not supported");
		}
		
	}	//End LevelOrderIterator class
} //EOF