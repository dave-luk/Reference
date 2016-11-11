package reference.tree;

import java.util.Arrays;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>
{
	public void add(E element)
	{
		if (root == null)
		{
			root = new BinaryTreeNode<E>(element);
			size++;
			return;
		}

		boolean added = false;
		BinaryTreeNode<E> cursor = root;
		while (!added)
		{
			if (cursor.getElement().compareTo(element) <= 0)
			{
				if (cursor.getRightChild() != null)
				{
					cursor = cursor.getRightChild();
				}
				else
				{
					cursor.setRightChild(new BinaryTreeNode<E>(element));
					added = true;
				}
			}
			else
			{
				if (cursor.getLeftChild() != null)
				{
					cursor = cursor.getLeftChild();
				}
				else
				{
					cursor.setLeftChild(new BinaryTreeNode<E>(element));
					added = true;
				}
			}
		}
		size++;
	}

	@Override
	public boolean add(E element, Integer pos)
	{
		// invalid operation
		return false;
	}

	@Override
	public void remove(int pos)
	{
		// invalid operation
		return;
	}

	public void remove(E element)
	{
		BinaryTreeNode<E> cursor = root;
		while (cursor.getElement().compareTo(element) == 0)
		{
			if (cursor.getElement().compareTo(element) > 0)
			{
				if (cursor.getLeftChild() != null) cursor = cursor.getLeftChild();
				else cursor = null;
			}
			else
			{
				if (cursor.getRightChild() != null) cursor = cursor.getRightChild();
				else cursor = null;
			}
		}
		remove(cursor);
	}

	public void remove(BinaryTreeNode<E> cursor)
	{
		if (cursor != null)
		{
			BinaryTreeNode<E> parent = cursor.getParent();
			if (cursor.isLeaf())
			{
				parent.removeChild(cursor);
				size--;
			}
			else if (cursor.getChildren().size() == 1)
			{
				if (cursor.isLeftChild(parent))
				{
					parent.removeChild(cursor);
					parent.setLeftChild(cursor.getChildren().get(0));
				}
				else if (cursor.isRightChild(parent))
				{
					parent.removeChild(cursor);
					parent.setRightChild(cursor.getChildren().get(0));
				}
				size--;
			}
			else
			{
				if (cursor.getElement().compareTo(root.getElement()) > 0)
				{
					swap(cursor, cursor.getRightChild());
				}
				else
				{
					swap(cursor, cursor.getLeftChild());
				}
				remove(cursor);
			}
		}
	}

	private void traverse(BinaryTreeNode<E> n, String[][] ret, int r, int c)
	{
		if(n == null)
		{
			ret[r][c] = "x";
			return;
		}
		else
		{
			ret[r][c-2] += "|" + n.toString() + "|";
			ret[r][c-1] = "";
			ret[r][c] = "";
		}
		ret[r+1][c-2] = "/";
		traverse(n.getLeftChild(), ret,r+2,c-3);
		ret[r+1][c+2] = "\\";
		traverse(n.getRightChild(), ret,r+2,c+3);
//		ret.msg += " ^ ";
	}

	@Override
	public String toString()
	{
		String[][] tree = new String[4*size+1][4*size+1];
		for(String[] row : tree)
		{
			Arrays.fill(row, "   ");
		}
		System.out.println(tree[0].length);
		traverse(root, tree,0,2*size-1);
		String str ="";
		for(String[] row : tree)
		{
			for(String cell : row)
			{
				str += cell;
			}
			str += "\n";
		}
		return str;
	}
}
