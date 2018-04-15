package csc.pkg220;


public class BSTRTest {

	public static void main(String[] args) {
		
		BSTR<String, Integer> tree = new BSTR<String, Integer>();
		tree.put("John", 805);
		tree.put("Quinn", 806);
		tree.put("Berry", 807);
		tree.put("Adam", 808);
		tree.put("Corey", 808);
		tree.put("Zelda", 809);
		tree.put("Dan", 768);
		tree.put("Zo", 567);
		tree.put("Zi", 568);
		tree.put("Dorey", 678);
		tree.put("Depp", 679);
		
		
		System.out.println(tree.depth());
		System.out.println(tree.Xdepth());
		System.out.println(tree.depthS());
	}

}
