package reference.tree;

import java.util.ArrayList;

public class TreeNode<E>
{
	private E						element;
	private TreeNode<E>				parent;
	private ArrayList<TreeNode<E>>	children;
	
	public TreeNode(E e)
	{
		element = e;
	}
	
	/**
	 * @return the element
	 */
	public E getElement()
	{
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(E element)
	{
		this.element = element;
	}

	/**
	 * @return the parent
	 */
	public TreeNode<E> getParent()
	{
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(TreeNode<E> parent)
	{
		this.parent = parent;
	}

	public ArrayList<TreeNode<E>> getChildren()
	{
		return children;
	}

	public void addChildren(TreeNode<E> c)
	{
		this.children.add(c);
	}
	
	public void removeChildren(TreeNode<E> c)
	{
		this.children.remove(c);
	}
	
	public void removeChildren(int index)
	{
		children.remove(index);
	}
}
