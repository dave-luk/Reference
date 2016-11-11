package reference.tree;

public class BinaryTree<E>
{
	protected int				size;
	protected BinaryTreeNode<E>	root;

	public BinaryTree()
	{
		size = 0;
	}

	public BinaryTree(BinaryTreeNode<E> root)
	{
		this.root = root;
		size = 1;
	}

	public int getSize()
	{
		return size;
	}

	public BinaryTreeNode<E> getRoot()
	{
		return root;
	}

	public boolean add(E element, Integer pos)
	{
		if (pos == null)
		{
			BinaryTreeNode<E> newNode = new BinaryTreeNode<E>(element);
			if (root == null)
			{
				root = newNode;
				size++;
				return true;
			}

			BinaryTreeNode<E> cursor = seek((size + 1) / 2); // the previous
			                                                 // node of the
			// desired location
			if ((size + 1) % 2 == 0) cursor.setLeftChild(newNode);
			else cursor.setRightChild(newNode);
			size++; // important

			try
			{
				BinaryTreeNode<E> b = seek((size + 1) / 2);
				if ((size + 1) % 2 == 0) b.setLeftChild(new BinaryTreeNode<E>(element));
				else b.setRightChild(new BinaryTreeNode<E>(element));
			}
			catch (Exception e)
			{
				return false;
			}
			return true;
		}
		else
		{
			BinaryTreeNode<E> cursor = seek(pos / 2);
			BinaryTreeNode<E> newNode = new BinaryTreeNode<E>(element);

			if (pos % 2 == 0) cursor.setLeftChild(newNode);
			else cursor.setRightChild(newNode);
		}
		return false;
	}

	public void remove(int pos)
	{
		try
		{
			BinaryTreeNode<E> b = seek(pos / 2);
			if (pos % 2 == 0) b.setLeftChild(null);
			else b.setRightChild(null);
		}
		catch (Exception e)
		{

		}
	}

	public void fromArray(E[] arr)
	{
		for (E val : arr)
		{
			add(val, size);
		}
	}

	protected BinaryTreeNode<E> seek(int pos)
	{
		BinaryTreeNode<E> cursor = root;
		String path = Integer.toBinaryString(pos).substring(1);

		for (int i = 0; i < path.length(); i++)
		{
			if (path.charAt(i) == '0') cursor = cursor.getLeftChild();
			else cursor = cursor.getRightChild();
		}
		return cursor;
	}
	
	/**
	 * 
	 * @param a
	 *            node to swap
	 * @param b
	 *            node to swap
	 * @return the value of a
	 */
	protected E swap(BinaryTreeNode<E> a, BinaryTreeNode<E> b)
	{
		E temp = a.getElement();
		a.setElement(b.getElement());
		b.setElement(temp);
		return temp;
	}

	public String toString()
	{
		String str = "";
		for (int i = 0; i < size; i++)
		{
			BinaryTreeNode<E> curr = seek(i + 1);
			for (int t = 0; t < Math.floor((Math.log(i + 1) / Math.log(2))); t++)
				str += "\t";
			str += (curr != null) ? curr.toString() : "-";
			str += "\n";
		}
		return str;
	}
}
