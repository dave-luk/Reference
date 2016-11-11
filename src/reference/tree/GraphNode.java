package reference.tree;

import java.util.ArrayList;

public class GraphNode<E>
{
	private ArrayList<GraphNode<E>> neighbor;
	private GraphNode<E> parent;
	private E element;
	
	public GraphNode(E element)
	{
		neighbor = new ArrayList<>();
		this.element = element;
	}
	
	public void setElement(E element)
	{
		this.element = element;
	}
	
	public E getElement()
	{
		return element;
	}
	
	public void setParent(GraphNode<E> parent)
	{
		this.parent = parent;
	}
	
	public GraphNode<E> getParent()
	{
		return parent;
	}
	
	public ArrayList<GraphNode<E>> getNeighbor()
	{
		return neighbor;
	}
	
	public GraphNode<E> getNeighbor(int pos)
	{
		return neighbor.get(pos);
	}
	
	public boolean hasNeighbor()
	{
		return (!neighbor.isEmpty());
	}
	
	public String toString() {
		String str = "[" + element + "]";
		if(hasNeighbor())
		{
			str += "\nNeighbor(s): " + getNeighbor().size();
		}
		return str;
	}
}
