package reference.hashTable;

public abstract class Hashable<K>
{
	public abstract  int hashCode();
	
	public abstract boolean auth(K key);
	
	public abstract boolean equals(Object o);
}
