package reference.graph;

import reference.node.Node;

public class Edge<E>
{
	public Node<E> from, to;
	
	public Edge(Node<E> f, Node<E> t)
	{
		from = f;
		to = t;
	}
}
