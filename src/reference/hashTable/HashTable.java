package reference.hashTable;

public class HashTable<K, E>
{

	private static final int TABLE_CAPACITY = 100;

	protected HashEntry<K, E>[]	dataArray;
	protected int				size;

	@SuppressWarnings("unchecked")
	public HashTable()
	{
		dataArray = new HashEntry[TABLE_CAPACITY];
		size = 0;
	}

	protected int hash(K key)
	{
		// System.out.println("Key: " + key + "\tHash: " + key.hashCode() + "\t
		// position: " + (Math.abs(key.hashCode()) % dataArray.length));
		return Math.abs(key.hashCode()) % dataArray.length;
	}

	public void put(K key, E element)
	{
		HashEntry<K, E> entry = new HashEntry<K, E>(key, element);
		int indexToPut = hash(key);
		HashEntry<K, E> cursor = dataArray[indexToPut];
		if (cursor != null)
		{
			HashEntry<K, E> prev = null;
			while (cursor != null && !cursor.auth(key))
			{
				prev = cursor;
				cursor = cursor.getNext();
			}
			if (cursor == null)
			{
				prev.setNext(entry);
			}
			else
			{
				cursor.setElement(element);
			}
		}
		else
		{
			dataArray[indexToPut] = entry;
		}
		size++;
	}

	public E get(K key)
	{
		int indexToGet = hash(key);
		HashEntry<K, E> cursor = dataArray[indexToGet];
		while (cursor != null && !cursor.auth(key))
		{
			cursor = cursor.getNext();
		}
		if (cursor == null) { return null; }
		return cursor.getElement();
	}

	public int size()
	{
		return size;
	}

	public void remove(K key)
	{
		int indexToRemove = hash(key);
		HashEntry<K, E> cursor = dataArray[indexToRemove];
		HashEntry<K, E> prev = null;
		while (cursor != null && !cursor.auth(key))
		{
			prev = cursor;
			cursor = cursor.getNext();
		}
		if (cursor != null)
		{
			if (prev == null)
			{
				dataArray[indexToRemove] = cursor.getNext();
			}
			else
			{
				prev.setNext(cursor.getNext());
			}
			size--;
		}
	}

	public String toString()
	{
		String res = "";
		for (HashEntry<K, E> entry : dataArray)
		{
			if (entry != null)
			{
				HashEntry<K, E> cursor = entry;
				while (cursor != null)
				{
					res += cursor.getKey() + " = " + cursor.getElement() + "\n";
					cursor = cursor.getNext();
				}
			}
		}
		return res;
	}
}
