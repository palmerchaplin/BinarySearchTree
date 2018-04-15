package csc.pkg220;

import java.util.Stack;//is this the right import?

public class BSTR<K extends Comparable<K>, V>
{
//	public class TreeNode
//	{
//		K key;
//		V value;
//		TreeNode left;
//		TreeNode right;
//
//		public TreeNode(K key, V value)
//		{
//			this.key = key;
//			this.value = value;
//			this.left = null;
//			this.right = null;
//		}
//	}

	public TreeNode<K, V> root;

	public BSTR()
	{
		this.root = null;
	}

	public void put(K key, V value)
	{
		//should I have check for root being null here or in recursion?
		if(root == null)
		{
			root = new TreeNode<>(key, value);
		}
		else
		{
			putR(key, value, root);
		}
	}
	//should I create the node in the put method then pass that in instead of 3 parameters??
	private void putR(K key, V value, TreeNode<K, V> current)
	{
			int c = key.compareTo(current.key);
			//if key == current.key
			if(c == 0)
			{
				current.value = value;
			}
			else if(c < 0)
			{
				if(current.left == null)
				{
					current.left = new TreeNode<>(key, value);
				}
				else
				{
					putR(key, value, current.left);
				}
			}
			else if(c > 0)
			{
				if(current.right == null)
				{
					current.right = new TreeNode<>(key, value);
				}
				else
				{
					putR(key, value, current.right);
				}
			}
	}

	public V get(K key)
	{
		return getR(key, root);
	}

	private V getR(K key, TreeNode<K, V> current)
	{
		if (current == null)
		{
			return null;
		}
		else
		{
			int c = key.compareTo(current.key);
			//	key == current.key
			if (c == 0)
			{
				return current.value;
			}
			//	key < current.key
			else if (c < 0)
			{
				return getR(key, current.left);
			}
			//c > 0, i.e. key > current.key
			else
			{
				return getR(key, current.right);
			}
		}
	}

	public int size()
	{
		return sizeR(root);
	}

	public int sizeR(TreeNode<K, V> current)
	{
		if (current == null)
		{
			return 0;
		}
		else
		{
			return 1 + sizeR(current.left) + sizeR(current.right);
		}
	}
	
	public int depth()
	{
		return depthR(root);
	}
	
	private int depthR(TreeNode<K, V> current)
	{
		if(current == null)
		{
			return -1; //empty tree has depth -1, tree of 1 has 0 depth.
		}
		else
		{
			//depth of left sub tree
			int left = depthR(current.left);
			//depth of right sub tree
			int right = depthR(current.right);
			//chooses to use the subtree with larger depth
			return Math.max(left, right) + 1;
		}
	}
	
	public int Xdepth()
	{
		return XdepthR(root, 0);
	}
	
	private int XdepthR(TreeNode<K, V> current, int d)
	{
		if(current == null)
		{
			return d-1;
		}
		else
		{
			int l = XdepthR(current.left, d+1);
			int r = XdepthR(current.right, d+1);
			return Math.max(l, r);
		}
	}
	
	public int depthS()
	{
		int depth = 0;
		int max = -1;
		Stack <Pairs<TreeNode<K, V>, Integer>> stack = new Stack<>();
		Pairs<TreeNode<K, V>, Integer> start = new Pairs<>(root, 0);
		stack.push(start);
		while(!stack.isEmpty())
		{
			Pairs<TreeNode<K, V>, Integer> current = stack.pop();
			max = Math.max(max, current.snd);
			depth = current.snd;
			if(current.fst.left != null)
			{
				stack.push(new Pairs<>(current.fst.left, depth + 1));
			}
			if(current.fst.right != null)
			{
				stack.push(new Pairs<>(current.fst.right, depth + 1));
			}
		}
		return max;
	}
}