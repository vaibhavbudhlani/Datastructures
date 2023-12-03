import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Instructions to candidate.
 * Implement the "put" and "contains" methods.
 * Fix the "inOrderTraversal" method.
*/

public class SearchTree {

  static class BST  {

    private Node root;

    public BST() {
      this.root = new Node();
    }

	private void putInTree(Node node, int value) {
		if(node.val == null) {
			node.val = value;
			return;
		}
		if(node.val < value) {
			if(node.right == null) {
				Node p = new Node();
				node.right = p; 
				p.val = value;
				return;		
			}
			else {
				putInTree(node.right, value);
			}
		}
		else {
			if(node.left == null) {
				Node p = new Node();
				node.left = p;
				p.val = value;
				return;		
			}
			else {
				putInTree(node.left, value);
			}
		}
	}

    public void put(int value) {
      	putInTree(root, value);
    }

	private boolean findVal(Node node, int value) {
		if(node == null) {
			return false;
		}
		if(node.val == value) {
			return true;
		}
		return (findVal(node.left, value) || findVal(node.right, value));
	}

    public boolean contains(int value) {
      // your code
	return findVal(root, value);
      
    }

    public List<Integer> inOrderTraversal() {
      final ArrayList<Integer> acc = new ArrayList<>();
      inOrderTraversal(root, acc);
      return acc;
    }

    private void inOrderTraversal(Node node, List<Integer> acc) {
      if (node == null) {
        return;
      }
      inOrderTraversal(node.left, acc);
      acc.add(node.val);
	inOrderTraversal(node.right, acc);
      
    }

    private static class Node {
      Integer val;
      Node left;
      Node right;
    }
  }


   public static void main(String[] args) {
    
	  final BST searchTree = new BST();

	    searchTree.put(3);
	    searchTree.put(1);
	    searchTree.put(2);
	    searchTree.put(5);
	    if(Arrays.asList(1,2,3,5).equals(searchTree.inOrderTraversal())
	    		&& !searchTree.contains(0) 
	    		&& searchTree.contains(1)
	    		&& searchTree.contains(2)
	    		&& searchTree.contains(3)
	    		&& !searchTree.contains(4)
	    		&& searchTree.contains(5)
	    		&& !searchTree.contains(6)){
	    	System.out.println("Pass");
	    }else {
	    	System.out.println("Fail");
	    }
	    		
  }

}