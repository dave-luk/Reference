package reference.tree;

public class Tree<E>
{
	private int numChild;
	private int size;
	private TreeNode<E> root;
	
	public Tree(int child) {
		numChild = child;
	}
	
	public Tree(int child, TreeNode<E> rt)
	{
		numChild = child;
		root = rt;
	}

	public TreeNode<E> getRoot()
	{
		return root;
	}

	public int getNumChild()
	{
		return numChild;
	}

	public int getSize()
	{
		return size;
	}
	
	public void bind(TreeNode<E> node, TreeNode<E> anchor)
	{
		anchor.addChildren(node);
	}
	
	public void remove(TreeNode<E> node, TreeNode<E> anchor)
	{
		anchor.removeChildren(node);
	}
}
