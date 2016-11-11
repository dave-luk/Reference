package reference.tree;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T>>
{
	public enum Mode
	{
		MAX_HEAP, MIN_HEAP;
	}

	private int					size;
	private BinaryTreeNode<T>	root;
	private Mode				mode;

	public Heap(Mode m)
	{
		size = 0;
		mode = m;
	}

	public Heap(Mode m, BinaryTreeNode<T> r)
	{
		root = r;
		size = 1;
		mode = m;
	}

	public int getSize()
	{
		return size;
	}

	public BinaryTreeNode<T> getRoot()
	{
		return root;
	}

	public Mode getMode()
	{
		return mode;
	}

	public void setMode(Mode mode)
	{
		this.mode = mode;
		for(int i = size/2; i > 0; i--)
		{
			siftDown(seek(i));
		}
	}

	public void add(T value)
	{
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);
		if (root == null)
		{
			root = newNode;
			size++;
			return;
		}

		BinaryTreeNode<T> cursor = seek((size + 1) / 2); // the parent node of
		                                                 // the
		// desired location
		if ((size + 1) % 2 == 0) cursor.setLeftChild(newNode);
		else cursor.setRightChild(newNode);
		size++; // important

		siftUp(newNode);
	}

	@SuppressWarnings("unchecked")
	public T[] toArray(T[] array)
	{
		T[] arr = (T[]) Array.newInstance(array.getClass().getComponentType(), size);

		for (int i = 1; i <= size; i++)
		{
			arr[i - 1] = seek(i).getElement();
		}
		return arr;
	}

	public T remove()
	{
		// Ambiguous... referring to removing the root? no specific
		// index/element is provided
		// Proceeding with removing the root.
		BinaryTreeNode<T> lastNode = seek(size);
		T temp = root.getElement();
		if (lastNode != root)
		{
			temp = swap(root, lastNode);
			// delete the last node;
			lastNode.getParent().removeChild(lastNode);
			siftDown(root);
		}
		else
		{
			root = null;
		}
		size--;

		return temp;
	}

	public void fromArray(T[] array)
	{
		for (T val : array)
		{
			add(val);
		}
	}

	@SuppressWarnings("unchecked")
	public T[] getSortedContents(T[] array)
	{
		T[] arr = (T[]) Array.newInstance(array.getClass().getComponentType(), size);
		Heap<T> copy = deepCopy();
		for (int i = 0; i < size; i++)
			arr[i] = copy.remove();
		return arr;
	}

	/**
	 * Observe that the location of the node is the index in binary with the
	 * MSD(first digit) discarded, a path is shown. (0 is left, 1 is right).
	 * 
	 * @param pos
	 *            position of node wanted.
	 * @return the node of that position.
	 * 
	 * 
	 */
	private BinaryTreeNode<T> seek(int pos)
	{
		BinaryTreeNode<T> cursor = root;
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
	private T swap(BinaryTreeNode<T> a, BinaryTreeNode<T> b)
	{
		T temp = a.getElement();
		a.setElement(b.getElement());
		b.setElement(temp);
		return temp;
	}

	private void siftUp(BinaryTreeNode<T> n)
	{
		while (n.getParent() != null && compare(n, n.getParent()) > 0)
		{
			swap(n, n.getParent());
			n = n.getParent();
		}
	}

	private void siftDown(BinaryTreeNode<T> n)
	{
		while (n.hasChildren())
		{
			int swapPos = -1;
			int candidate = 0;
			for (int i = 0; i < n.getChildren().size(); i++)
			{
				if (compare(n,n.getChildren().get(i)) < 0)
				{
					swapPos = i;
					candidate++;
				}
			}

			if(candidate > 1)
			{
				swapPos = (compare(n.getLeftChild(), n.getRightChild()) > 0) ? 0 : 1;
			}
			
			switch (swapPos)
			{
				case 0:
					swap(n, n.getLeftChild());
					n = n.getLeftChild();
					break;
				case 1:
					swap(n, n.getRightChild());
					n = n.getRightChild();
					break;
				default:
					return;
			}
		}
	}

	/**
	 * This method compares 2 nodes by the heap structure and returns appropiate comparision.
	 * 
	 * @param a node to compare for
	 * @param b node to compare to
	 * @return a compare to b or b compare to a;
	 */
	private int compare(BinaryTreeNode<T> a, BinaryTreeNode<T> b)
	{
		switch (mode)
		{
			case MAX_HEAP:
				return (a.getElement().compareTo(b.getElement()));
			case MIN_HEAP:
				return (b.getElement().compareTo(a.getElement()));
			default:
				return -1;//never should happen
		}
	}

	/**
	 * @return String representation of the heap
	 */
	@Override
	public String toString()
	{
		String str = "";
		for (int i = 0; i < size; i++)
		{
			BinaryTreeNode<T> curr = seek(i + 1);
			for (int t = 0; t < Math.floor((Math.log(i + 1) / Math.log(2))); t++)
				str += "\t";
			str += curr.toString();
			str += "\n";
		}
		return str;
	}
	
	public Heap<T> deepCopy(Mode m)
	{
		Heap<T> cpy = new Heap<T>(m);
		for (int i = 1; i <= size; i++)
			cpy.add(seek(i).getElement());
		return cpy;
	}

	public Heap<T> deepCopy()
	{
		Heap<T> cpy = new Heap<T>(mode);
		for (int i = 1; i <= size; i++)
			cpy.add(seek(i).getElement());
		return cpy;
	}
}
