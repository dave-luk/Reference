package reference.stack;

import reference.node.Node;

public class Stack<E>
{
	private Node<E>	top;
	private int		size;

	public Stack()
	{
		top = null;
		size = 0;
	}

	public E peek()
	{
		if (top == null) throw new RuntimeException("ERROR: Empty Stack!");
		else return top.getElement();
	}

	public E pop()
	{
		if (top == null) throw new RuntimeException("ERROR: Empty Stack!");
		else
		{
			E element = top.getElement();
			top = top.getNextNode();
			size--;
			return element;
		}
	}

	public void push(E element)
	{
		Node<E> newNode = new Node<E>(element, top);
		top = newNode;
		size++;
	}

	public boolean isEmpty()
	{
		return (size == 0);
	}

	public int size()
	{
		return size;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[<TOP>: ");
		Node<E> cursor = top;
		while (cursor != null)
		{
			sb.append(cursor.getElement());
			if (cursor.getNextNode() != null)
			{
				sb.append(" -> ");
			}
			cursor = cursor.getNextNode();
		}
		sb.append(" :<BTM>]");
		return sb.toString();
	}
}
