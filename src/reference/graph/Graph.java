package reference.graph;

import java.util.ArrayList;

import reference.node.Node;

public class Graph<E>
{
	private ArrayList<Node<E>> vertices;
	private ArrayList<Edge<E>> edges;
	
	public Graph()
	{
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	public void addVertice(Node<E> n) {
		if(!vertices.contains(n))
			vertices.add(n);
	}
	
	public void removeVertrice(Node<E> n) {
		vertices.remove(n);
		for(Edge<E> e : edges)
		{
			if(e.from.equals(n) || e.to.equals(n))
				edges.remove(e);
		}
	}
	
	public ArrayList<Node<E>> getVertices()
	{
		return vertices;
	}
	
	public void addEdge(Node<E> a, Node<E> b)
	{	
		for(Edge<E> e : edges)
		{
			if(!e.from.equals(a) || !e.to.equals(b))
				edges.add(new Edge<>(a, b));
		}
	}
	
	public void removeEdge(Node<E> a, Node<E> b)
	{
		for(Edge<E> e : edges)
		{
			if(e.from.equals(a) && e.to.equals(b))
				edges.remove(e);
		}
	}
	
	public E getVertexValue(Node<E> a) {
		if(vertices.contains(a))
			return a.getElement();
		else
			return null;
	}
	
	public void setVertexValue(Node<E> a, E value) {
		if(vertices.contains(a))
			a.setElement(value);
	}
	
	public ArrayList<Node<E>> neighbors(Node<E> a) {
		ArrayList<Node<E>> arr = new ArrayList<>();
		for(Edge<E> e : edges)
		{
			if(e.from.equals(a))
				arr.add(e.to);
		}
		return arr;
	}
	
	public boolean adjacent(Node<E> a, Node<E> b) {
		for(Edge<E> n : edges)
		{
			if(n.from.equals(a) && n.to.equals(b))
				return true;
		}
		return false;
	}
}
