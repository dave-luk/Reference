package reference.tree;

import java.util.ArrayList;

public class BinaryTreeNode<E>
{
	private E					element;
	private BinaryTreeNode<E>	parent, leftChild, rightChild;

	public BinaryTreeNode(E e)
	{
		setElement(e);
	}

	public BinaryTreeNode(E e, BinaryTreeNode<E> parent)
	{
		this.setElement(e);
		this.setParent(parent);
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
	public BinaryTreeNode<E> getParent()
	{
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(BinaryTreeNode<E> parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the leftChild
	 */
	public BinaryTreeNode<E> getLeftChild()
	{
		return leftChild;
	}

	/**
	 * @param leftChild
	 *            the leftChild to set
	 */
	public void setLeftChild(BinaryTreeNode<E> leftChild)
	{
		this.leftChild = leftChild;
		leftChild.setParent(this);
	}

	/**
	 * @return the rightChild
	 */
	public BinaryTreeNode<E> getRightChild()
	{
		return rightChild;
	}

	/**
	 * @param rightChild
	 *            the rightChild to set
	 */
	public void setRightChild(BinaryTreeNode<E> rightChild)
	{
		this.rightChild = rightChild;
		rightChild.setParent(this);
	}

	public void removeChild(BinaryTreeNode<E> c)
	{
		if (leftChild == c) leftChild = null;
		else if (rightChild == c) rightChild = null;
	}

	public ArrayList<BinaryTreeNode<E>> getChildren()
	{
		ArrayList<BinaryTreeNode<E>> c = new ArrayList<>();
		if (leftChild != null) c.add(leftChild);
		if (rightChild != null) c.add(rightChild);
		return c;
	}
	
	public boolean isLeaf()
	{
		return (getParent() != null) && !hasChildren();
	}
	
	public boolean isLeftChild(BinaryTreeNode<E> p)
	{
		return p.getLeftChild() == this;
	}
	
	public boolean isRightChild(BinaryTreeNode<E> p)
	{
		return p.getRightChild() == this;
	}

	/**
	 * @return hasChildren whether the node has children
	 */
	public boolean hasChildren()
	{
		return (leftChild != null || rightChild != null);
	}

	/**
	 * 
	 * @return isFull is true when the node have 2 children
	 */
	public boolean isFull()
	{
		return (leftChild != null && rightChild != null);
	}

	public String toString()
	{
		return element.toString();
	}
}
