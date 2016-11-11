package reference.list;

public interface List<E>
{

	public void add(E element);

	public void add(int index, E element);

	public void remove(int index);

	public int size();

	public int indexOf(E element);

	public E get(int index);

	public void set(int index, E element);

	public String toString();

	public void clear();

}
