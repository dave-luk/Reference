package reference.node;

public class Node<E> {
	
	private Node<E> nextNode;
	private E element;
	
	public Node (E element, Node<E> nextNode)
	{
		super();
		this.setNextNode(nextNode);
		this.element = element;
	}	
	
	public Node(E element)
	{
		this.element = element;
	}

	public Node<E> getNextNode() 
	{
		return nextNode;
	}

	public void setNextNode(Node<E> nextNode)
	{
		this.nextNode = nextNode;
	}

	public E getElement() 
	{
		return element;
	}

	public void setElement(E element) 
	{
		this.element = element;
	}

	public boolean hasNext()
	{
		return !(nextNode == null);
	}
	
	@Override
	public String toString()
	{
		return this.element.toString();
	}
}
