package reference.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Set<T>
{
	// Set stores the original set.
	private List<T> set;

	/**
	 * Constructor for a set Object
	 * 
	 * @param objects
	 *            the items to be in the list
	 */
	public Set(@SuppressWarnings("unchecked") T... objects)
	{
		set = new ArrayList<>();
		for (T obj : objects)
		{
			set.add(obj);
		}
	}

	/**
	 * 
	 * @return a list of the objects in the set.
	 */
	public List<T> getSet()
	{
		return set;
	}

	/**
	 * Computes all combination of sets
	 * 
	 * @return all combinations of the set
	 */
	public List<ArrayList<T>> powerSet()
	{
		// inSet describes whether element is in the set or not.
		boolean[] inSet = new boolean[set.size()];
		// List of lists to store subsets
		ArrayList<ArrayList<T>> powerSet = new ArrayList<>();
		// recursive calls
		subSet(inSet, powerSet, set.size() - 1);
		return powerSet;
	}

	/**
	 * Computes all the combination of r elements from the set
	 * 
	 * @param r
	 *            the number of elements in the combination
	 * @return a list of all combination
	 */
	public List<ArrayList<T>> combination(int r)
	{
		List<ArrayList<T>> combSet = new ArrayList<>();
		// Loop through all of the subsets, selecting sets with the correct
		// length
		for (ArrayList<T> subset : powerSet())
		{
			if (subset.size() == r)
			{
				combSet.add(subset);
			}
		}
		return combSet;
	}

	/**
	 * Computes the permutations of the set
	 *
	 * @return a list of all permutations.
	 */
	public List<ArrayList<T>> permutation()
	{
		// used describe whether an element is used in the generated permutation
		boolean[] used = new boolean[set.size()];
		// order records the order of the elements to put in.
		int[] order = new int[set.size()];
		// initialize the list to return
		ArrayList<ArrayList<T>> permutations = new ArrayList<>();
		// recursive call
		permute(used, order, permutations, set.size() - 1);
		return permutations;
	}

	/**
	 * 
	 * @param used
	 *            describe whether an element is used in the generated
	 *            permutation
	 * @param order
	 *            records the order of the elements to put in.
	 * @param list
	 *            the list to save the permutations in
	 * @param tier
	 *            the index of elements that we are iterating on. (from last to
	 *            first. For example, "123456" tier starts from index 5 and
	 *            counts down to 0)
	 */
	private void permute(boolean[] used, int[] order, ArrayList<ArrayList<T>> list, int tier)
	{
		// if we we have no more elements left to iterate, generate the full
		// sequence.
		if (tier < 0)
		{
			// adding generated sequence to the list.
			list.add(constructSet(order));
		}
		else
		{
			// loop through all elements in the set
			for (int i = 0; i < set.size(); i++)
			{
				// if that element has not been used
				if (!used[i])
				{
					// set used to true.
					used[i] = true;
					// order at the index(tier)
					order[tier] = i;
					// recursive call
					permute(used, order, list, tier - 1);
					// set used to false, and loop through all other
					// Possibilities.
					used[i] = false;
				}

			}
		}
	}

	/**
	 * generates subsets recursively
	 * 
	 * @param inSet
	 *            describe whether an element is in the set
	 * @param powerset
	 *            the list to save the subsets to.
	 * @param tier
	 *            the index of elements that we are iterating on. (from last to
	 *            first. For example, "123456" tier starts from index 5 and
	 *            counts down to 0)
	 */
	private void subSet(boolean[] inSet, ArrayList<ArrayList<T>> powerset, int tier)
	{
		// if we have computed all possible combination of this, add the set.
		if (tier < 0)
		{
			// adding generated set to the list.
			powerset.add(constructSet(inSet));
		}
		else
		{
			// first we include the element with index of tier
			inSet[tier] = true;
			// recursive call
			subSet(inSet, powerset, tier - 1);
			// then we do not include the element with index of tier
			inSet[tier] = false;
			// recursive call
			subSet(inSet, powerset, tier - 1);
		}
	}

	/**
	 * Generates a set from an array of boolean
	 * 
	 * @param inSet
	 *            boolean array that describe whether an element is in the set
	 * @return a set of elements described by inSet
	 */
	private ArrayList<T> constructSet(boolean[] inSet)
	{
		ArrayList<T> subset = new ArrayList<>();
		for (int i = 0; i < set.size(); i++)
		{
			//if it is in the set, add to the list.
			if (inSet[i])
			{
				subset.add(set.get(i));
			}
		}
		return subset;
	}

	/**
	 * Generates a set from an array of integers dictating order.
	 * 
	 * @param order
	 *            integer array that describes the order of element to be
	 *            arranged in the new set.
	 * @return a list of elements described by order
	 */
	private ArrayList<T> constructSet(int[] order)
	{
		ArrayList<T> perm = new ArrayList<>();
		for (int i : order)
		{
			//add the element of index i described in order.
			perm.add(set.get(i));
		}
		return perm;
	}

	public static void main(String[] args)
	{
		Set<String> set = new Set<>("A", "B", "C");
		for (ArrayList<String> subset : set.powerSet())
		{
			System.out.println(subset.toString());
		}
		System.out.println("COMB: ");
		for (ArrayList<String> combination : set.combination(2))
		{
			System.out.println(combination);
		}
		System.out.println("PERM: ");
		for (ArrayList<String> perm : set.permutation())
		{
			System.out.println(perm);
		}

	}
}
