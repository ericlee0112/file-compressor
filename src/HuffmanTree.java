import java.util.*;//import map
import java.io.*;//import inputstream

public class HuffmanTree {
	HuffmanNode node;
	

	
	public HuffmanTree()
	{
		node = null;
	}
	
	public HuffmanTree(Map<Character, Integer> counts) {
		
		//we are given a map of characters to the number of occurences of that character (int)
		//build the huffman tree by using priority queue
		if(counts == null) {
			throw new IllegalArgumentException();
		}
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
		}
		
		node = pr.remove();//set node to the last remaining node in priority queue
		}//end of the creating the huffman tree method 	
	
	
	
	public Map<Character, String> createEncodings(){
		//traverse through your huffman tree and produce a mapping from each character in the tree to its encoded binary represenation as a string 
		//eg. {' '=00, 'a'=11, 'b'=10, 'c'=010, EOF=011}
		if(node == null) {
			throw new IllegalArgumentException();
		}
		Map<Character, String> codeMap = new TreeMap<Character, String>();
		if(node != null) {
			traverse(node.left, codeMap, "0");//go to left subtree
			traverse(node.right, codeMap, "1");//go to right subtree
		}
		
		return codeMap;//after traversing, return the filled codeMap
	}
	
	public void compress(InputStream input, BitOutputStream output) throws IOException{
		//read the text data from the given input file stream and use the huffman encodings created in the method above to write a huffman-compressed version of this data to the given bit output file stream
		//use a bitoutputstream object to help with writing binary output one bit at a time 
		if(input == null || output == null) {
			throw new IllegalArgumentException();
		}
		
		Map<Character,String> codeMap = createEncodings();
		
		int byteValue = 0;
		output.setBitMode(false);
		
		while((byteValue=input.read()) != -1){//while byteValue ranges from 0 to 255
			char c = (char)byteValue;//cast to corresponding char
			output.writeBits(codeMap.get(c));
		}
		output.close();
	}
	
	public void decompress(BitInputStream input, OutputStream output) throws IOException{
		//read the compress)ed binary data from the given bit input file stream and use huffman tree to write a decompressed text version of this data to the given output file stream. 
		//assume that all the characters in the input file were represented in the map of counts passed to your tree's constructor
		//use bitinputstream object to help read the binary input one bit at a time 
		if(input == null || output == null) {
			throw new IllegalArgumentException();
		}
		HuffmanNode newnode = this.node;
		
		input.setBitMode(false);
		
		int bit = input.readBit();
		while(bit != -1) {//while we are still in the middle of the line (havent reached the end of the line)
			if(newnode.character != '\0') {//if character exists at this node
				output.write(newnode.character);
				newnode = this.node;//go back to the root of the tree
			}else if(bit == 0) {
				newnode = newnode.left;
				bit = input.readBit();
			}else if(bit == 1) {
				newnode = newnode.right;
				bit = input.readBit();
			}
			
		}
		
		
		
		
	}
	
	private void traverse(HuffmanNode node, Map<Character, String> codeMap, String binaryCode) {
		if(node.character != '\0') {//base case, if character exists
			codeMap.put(node.character, binaryCode);
		}
		else {//recursion

			traverse(node.right, codeMap, binaryCode+"1");//go right
			
			traverse(node.left, codeMap, binaryCode+"0");//go left
		}
	
		
	}
	

}
