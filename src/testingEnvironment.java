import java.util.*;
import java.io.*;
public class testingEnvironment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		 Map<Character, Integer> counts = new TreeMap<Character, Integer>();
	        counts.put('a', 4);
	        counts.put('v', 5);
	        counts.put('b', 8);
	        counts.put('h', 90);
	        counts.put('k', 45);
	        counts.put('p', 12);
	        counts.put('i', 3);
	        counts.put('y', 89);
	        counts.put('r', 149);
	        
	    
	        
	        HuffmanTree tree = new HuffmanTree(counts);
	        toString(tree.node);
	        
	        Map<Character, String> mapped = tree.createEncodings();
	        
	        for(Character character: mapped.keySet()) {
				String binary = mapped.get(character);
				System.out.println(character + " " + binary);
			}
	        
	      /*  
	        System.out.println("enter name of file you want to read from");
	        String filename = input.nextLine();
	        File file = new File("src\example.txt");
	        InputStream read = new FileInputStream(file);
	        
	  */
	        
	        /*
	      //we are given a map of characters to the number of occurences of that character (int)
			//build the huffman tree by using priority queue
			PriorityQueue<HuffmanNode> pr = new PriorityQueue<HuffmanNode>();
			
			for(Character letter: counts.keySet()) {
				int value = counts.get(letter);
			HuffmanNode node = new HuffmanNode(value, letter);
			pr.add(node);
			}//add the huffmannodes into the priortyqueue in sorted order
			
			//now create the huffmantree
			while(pr.size() > 1) {
				HuffmanNode smaller = pr.remove();//smaller
				HuffmanNode bigger = pr.remove();//bigger
				
				HuffmanNode newnode = new HuffmanNode(smaller.data + bigger.data, '\0', smaller, bigger);//set char to null
				//place the smaller huffman node on left, larger huffman node on right
				pr.add(newnode);
			}//pr now contains the huffman tree
			
			HuffmanTree tree = new HuffmanTree();
			
			tree.node = pr.remove();//we have created the tree
			print(tree.node);
			
			
			
			Map<Character, String> codeMap = new TreeMap<Character, String>();
			
			if(tree.node != null) {
				traverse(tree.node.left, codeMap, "0");
				traverse(tree.node.right, codeMap, "1");
			}
			
			for(Character character: codeMap.keySet()) {
				String binary = codeMap.get(character);
				System.out.println(character + " " + binary);
			}
	  
	        
	   */
		     
	}//end of main method
	
	private static void toString(HuffmanNode node) {
		// TODO Auto-generated method stub
		
	}

	public static void print(HuffmanNode main) {
		if(main != null) {
			System.out.println(main.character + " " + main.data);
			print(main.left);
			print(main.right);
		}
	}
	
	
	public static void traverse(HuffmanNode node, Map<Character, String> codeMap, String binaryCode) {
		if(node != null && node.character != '\0') {//base case
			codeMap.put(node.character, binaryCode);
		}
		else {//recursion
			traverse(node.right, codeMap, binaryCode + "1");
			traverse(node.left, codeMap, binaryCode + "0");
		}
	
		
	}
	/*
	public static Map<Character, String> createEncodings(){
		//traverse through your huffman tree and produce a mapping from each character in the tree to its encoded binary represenation as a string 
		//eg. {' '=00, 'a'=11, 'b'=10, 'c'=010, EOF=011}
		Map<Character, String> codeMap = new TreeMap<Character, String>();
		if(node != null) {
			traverse(node.left, "0");
			traverse(node.right, "1");
		}
		
		return codeMap;//after traversing, return the filled codeMap
	}
	*/
	
	
	/*
	public static void traverse(HuffmanNode node, String code) {
		
		if(node.left != null) {
			code += "0";
			traverse(node.left, code);
			//code = code.substring(0,code.length()-1);
		}
		System.out.println(node.character);
		System.out.println(code);
		code = code.substring(0,code.length()-1);
		//code = "";
		if(node.right != null) {
			code += "1";
			traverse(node.right, code);
			//code = code.substring(0,code.length()-1);
		}
	}
	*/
	


}
