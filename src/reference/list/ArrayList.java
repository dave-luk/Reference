package reference.list;

public class ArrayList<E> implements List<E>
{
	private Object[]	data;
	private int			size;

	public ArrayList()
	{
		data = new Object[10];
		size = 0;
	}

	public ArrayList(int capacity)
	{
		data = new Object[capacity];
		size = 0;
	}

	/**
	 * Double the capacity of the array.
	 *
	 * Note: this method is private, because we do not want the users to know
	 * the internal details on how we scale and increase the capacity.
	 */
	private void increaseDataCapacity()
	{
		Object[] newData = new Object[data.length * 2];
		for (int i = 0; i < data.length; i++)
		{
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * Appends value at end of reference.list
	 */
	@Override
	public void add(E element)
	{
		// if the array is full, we need to
		// increase the capacity
		if (size == data.length)
		{
			increaseDataCapacity();
		}
		data[size] = element;
		size++;
	}

	/**
	 * Inserts given value just before the given index, shifting subsequent
	 * values to the right
	 */
	@Override
	public void add(int index, E element)
	{
		if (index < size)
		{
			// if the array is full, we need to
			// increase the capacity
			if (size == data.length)
			{
				increaseDataCapacity();
			}
			// shift all the elements to the right by 1,
			// so that we can add the
			for (int i = size; i > index; i--)
			{
				data[i] = data[i - 1];
			}
			data[index] = element;
			size++;
		}
		else
		{
			throw new RuntimeException("Out of the reference.list boundary.");
		}
	}

	/**
	 * Removes all elements of the reference.list
	 */
	public void clear()
	{
		size = 0;
	}

	/**
	 * Returns first index where given value is found in reference.list (-1 if not found)
	 */
	@Override
	public int indexOf(E element)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] == element) { return i; }
		}
		return -1;
	}

	/**
	 * Returns the value at given index
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E get(int index)
	{
		if (index < size)
		{
			return (E) data[index];
		}
		else
		{
			throw new RuntimeException("Out of the reference.list boundary.");
		}
	}

	/**
	 * Removes/returns value at given index, shifting subsequent values to the
	 * left
	 */
	@Override
	public void remove(int index)
	{
		if (index < size)
		{
			// shift all the element to the left by 1
			// so that we can remove the element at the index
			for (int i = index; i < size - 1; i++)
			{
				data[i] = data[i + 1];
			}
			size--;
		}
		else
		{
			throw new RuntimeException("Out of the reference.list boundary.");
		}
	}

	/**
	 * Replaces value at given index with given value
	 */
	@Override
	public void set(int index, E element)
	{
		if (index < size)
		{
			data[index] = element;
		}
		else
		{
			throw new RuntimeException("Out of the reference.list boundary.");
		}
	}

	/**
	 * Returns the number of elements in reference.list
	 */
	@Override
	public int size()
	{
		return size;
	}

	/**
	 * Returns a string representation of the reference.list, such as "[3, 42, -7, 15]"
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i = 0; i < size; i++)
		{
			sb.append(data[i]);
			if (i < size - 1)
			{
				sb.append(", ");
			}
		}
		sb.append(']').toString();
		return sb.toString();
	}

}
