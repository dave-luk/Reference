package reference.queue;

import reference.node.Node;

public class Queue<E>
{
	private Node<E>	head;
	private int		size;

	public Queue()
	{
		head = null;
		size = 0;
	}

	public E peek()
	{
		if (head == null) throw new RuntimeException("ERROR: Empty Queue!");
		else return head.getElement();
	}

	public E pop()
	{
		if (head == null) throw new RuntimeException("ERROR: Empty Queue!");
		else
		{
			E element = head.getElement();
			head = head.getNextNode();
			size--;
			return element;
		}
	}

	public void push(E element)
	{
		Node<E> cursor = head;
		
		while(cursor.hasNext())
		{
			cursor = cursor.getNextNode();
		}
		cursor.setNextNode(new Node<E>(element));
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
		sb.append("[<BTM>: ");
		Node<E> cursor = head;
		while (cursor != null)
		{
			sb.append(cursor.getElement());
			if (cursor.getNextNode() != null)
			{
				sb.append(" <- ");
			}
			cursor = cursor.getNextNode();
		}
		sb.append(" :<TOP>]");
		return sb.toString();
	}
}
