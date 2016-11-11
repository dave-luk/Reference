package reference.list;

import reference.node.Node;

public class LinkedList<E> implements List<E>
{
	public Node<E>	head;
	public Node<E>	tail;
	private int		size;

	public LinkedList()
	{
		size = 0;
	}

	@Override
	public void add(E element)
	{
		Node<E> newNode = new Node<E>(element, null);

		// check if the reference.list is empty
		if (head != null)
		{
			tail.setNextNode(newNode);
		}
		else
		{
			head = newNode;
		}
		tail = newNode;
		size++;
	}

	@Override
	public void add(int index, E element)
	{
		if (index < size())
		{
			// create the new reference.node
			Node<E> newNode = new Node<E>(element, null);

			// check if we want to add it in the beginning
			if (index == 0)
			{
				newNode.setNextNode(head);
				head = newNode;
			}
			else
			{
				Node<E> prev = head;
				for (int i = 0; i < index - 1; i++)
				{
					prev = prev.getNextNode();
				}
				newNode.setNextNode(prev.getNextNode());
				prev.setNextNode(newNode);
			}
			size++;
		}
		else throw new RuntimeException("Index out of bound.");
	}

	@Override
	public void remove(int index)
	{
		if (index < size())
		{
			// check if it is the first element to remove
			if (index == 0)
			{
				head = head.getNextNode();
				if (head == null)
				{
					tail = null;
				}

			}
			else
			{
				Node<E> prev = head;
				for (int i = 0; i < index - 1; i++)
				{
					prev = prev.getNextNode();
				}
				prev.setNextNode(prev.getNextNode().getNextNode());

				if (index == size() - 1)
				{
					tail = prev;
				}

			}

			size--;
		}
		else throw new RuntimeException("Index out of bound.");
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public int indexOf(E element)
	{
		int index = 0;
		Node<E> cursor = head;
		while (cursor != null)
		{
			if (cursor.getElement() == element) { return index; }
			cursor = cursor.getNextNode();
			index++;
		}
		return -1;
	}

	@Override
	public E get(int index)
	{
		if (index < size())
		{
			Node<E> cursor = head;
			for (int i = 0; i < index; i++)
			{
				cursor = cursor.getNextNode();
			}
			return cursor.getElement();
		}
		else
		{
			throw new RuntimeException("Index out of bound.");
		}

	}

	@Override
	public void set(int index, E element)
	{
		if (index < size())
		{
			Node<E> cursor = head;
			for (int i = 0; i < index; i++)
			{
				cursor = cursor.getNextNode();
			}
			cursor.setElement(element);
		}
		else
		{
			throw new RuntimeException("Index out of bound.");
		}
	}

	@Override
	public String toString()
	{
		String res = "[";
		Node<E> cursor = head;
		while (cursor != null)
		{
			res += cursor.getElement();
			cursor = cursor.getNextNode();
			if (cursor != null)
			{
				res += ",";
			}
		}
		res += "]";
		return res;
	}

	@Override
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
	}

}
