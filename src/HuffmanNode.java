// Class for storing a single node of a binary tree of ints

public class HuffmanNode implements Comparable{
    public int data;
    public char character;
    public HuffmanNode left;
    public HuffmanNode right;
                
    // constructs a leaf node with given data
    public HuffmanNode(int data, char character) {
        this(data, character, null, null);
    }
                        
    // constructs a branch node with given data, left subtree,
    // right subtree
    public HuffmanNode(int data, char character, HuffmanNode left, HuffmanNode right) { 
        this.data = data;
        this.character = character;
        this.left = left;
        this.right = right;
    }
    //implement comparable
    public int compareTo(Object o) {
    	HuffmanNode node = (HuffmanNode) o;
    	if(this.data > node.data) {
    		return 1;
    	}
    	else if(this.data < node.data) {
    		return -1;
    	}else {
    		return 0;
    	}
    }
    //prints out huffman node 
    public void toString(HuffmanNode node) {
    	if(node != null) {
    	System.out.println(node.character);
    	System.out.println(node.data);
    		toString(node.left);
    		toString(node.right);
    	}
    }
    
    
  

}