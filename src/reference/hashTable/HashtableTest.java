package reference.hashTable;

public class HashtableTest
{

	public static void main(String[] args)
	{
		HashTable<String, Integer> tbl = new HashTable<String, Integer>();
		tbl.put("Dave", new Integer(19));
		tbl.put("Foo", 3);
		tbl.put("Bar", 4);
		
		System.out.println(tbl.toString());
		System.out.println(tbl.get("Foo"));
		tbl.remove("Bar");
		System.out.println(tbl.toString());
		tbl.put("Bbr", 23);
		System.out.println(tbl.toString());
	}

}
