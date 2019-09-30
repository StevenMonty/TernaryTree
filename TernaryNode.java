package a5;	//TODO

@SuppressWarnings("unchecked")
public class TernaryNode<T>
{
	private T data;
	private TernaryNode<T>[] children = (TernaryNode<T>[]) new TernaryNode<?>[3];	
	//Array of refs to children where [0] == left, [1] == middle, [2] == right child 
	
    public TernaryNode() 
    {
        this(null); 
    }
    
    public TernaryNode(T data) 
    {
       this(data, null); 
    }
	
    
	public TernaryNode(T data, TernaryNode<T>[] children) 
    {
		this.data = data;
		
		if (children != null)
		{
			this.children[0] = children[0];
			this.children[1] = children[1];
			this.children[2] = children[2];
		}
	}
	
    public void setData(T data) 
    {
    	this.data = data;
    }

    public T getData()
    {
    	return this.data;
    }
    
	public TernaryNode<T> getLeftChild()
	{
		return this.children[0];	
	}
	
	public void setLeftChild(TernaryNode<T> left)
	{
		children[0] = left;
	}
	
	public boolean hasLeftChild()
	{
		return children[0] != null;
	}
	
	public TernaryNode<T> getMiddleChild()
	{
		return this.children[1];
	}
	
	public void setMiddleChild(TernaryNode<T> middle)
	{
		children[1] = middle;
	}
	
	public boolean hasMiddleChild()
	{
		return children[1] != null;
	}
	
	public TernaryNode<T> getRightChild()
	{
		return this.children[2];
	}
	
	public void setRightChild(TernaryNode<T> right)
	{
		children[2] = right;
	}
	
	public boolean hasRightChild()
	{
		return children[2] != null;
	}
	
	public boolean isLeaf()
	{
		return (children[0] == null) && (children[1] == null) && (children[2] == null);
	}
    
	/** Recursively counts the nodes in the subtree rooted at this node.
	 * 
     *  @return  The number of nodes in the subtree rooted at this node. 
     */
    public int getNumberOfNodes() {
        int leftNumber = 0;
        int middleNumber = 0;
        int rightNumber = 0;

        if (children[0] != null) 
	        {
	            leftNumber = children[0].getNumberOfNodes();
	        }

        if (children[1] != null) 
	        {
	            middleNumber = children[1].getNumberOfNodes();
	        }
        
        if (children[2] != null)
	        {
	        	rightNumber = children[2].getNumberOfNodes();
	        }

        return 1 + leftNumber + middleNumber + rightNumber;
    }
		
    /** 
     * Computes the height of the subtree rooted at this node.
     * Uses private helper method.
     *  
     * @return  The height of the subtree rooted at this node. 
     */
    public int getHeight() 
    {
        return getHeight(this); 
    }

    private int getHeight(TernaryNode<T> node) 
    {
        int height = 0;

        if (node != null)
        {
        	int tmp =  Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
        	 height = 1 + Math.max(tmp, getHeight(node.getMiddleChild()));
        }
        
        	//Adds one to account for this node, returns 1 + the height of whichever child has a higher height

        return height;
    }
	
    /**
     * @return a deep copy of this node
     */
	public TernaryNode<T> copy()
	{
		TernaryNode<T> copy = new TernaryNode<>(data);
	
		if (children[0] != null)
			copy.setLeftChild(children[0].copy());		//copy the left node, if not null
			
		if (children[1] != null)
			copy.setMiddleChild(children[1].copy());	//copy the middle node, if not null
		
		if (children[2] != null)
			copy.setRightChild(children[2].copy());		//copy the right node, if not null
		
		return copy;
	}
} 