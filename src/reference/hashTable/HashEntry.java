package reference.hashTable;

public class HashEntry<K, E>  extends Hashable<K>
{

	private K	key;
	private E	element;

	private HashEntry<K, E> next;

	public HashEntry(K key, E element)
	{
		this.key = key;
		this.element = element;
	}

	public K getKey()
	{
		return key;
	}

	public void setKey(K key)
	{
		this.key = key;
	}

	public E getElement()
	{
		return element;
	}

	public void setElement(E element)
	{
		this.element = element;
	}

	public HashEntry<K, E> getNext()
	{
		return next;
	}

	public void setNext(HashEntry<K, E> next)
	{
		this.next = next;
	}

	@Override
	public int hashCode()
	{
		return element.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return ((Object)this).equals(o);
	}

	public boolean auth(K key)
	{
		return this.key.equals(key);
	}
}
