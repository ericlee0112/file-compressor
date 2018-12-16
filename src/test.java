
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String newstr = duplicates("aabe");
		System.out.println(newstr);
	}
	
    public static String duplicates(String haystack) {
    	String counts = "";
    	String [] strarray = {"a","b","c","d","e","f"};
    	int [] intarray = new int[6];
    	for(int i = 0; i < strarray.length -1; i++) {
    		char character = haystack.charAt(i);
    		String chr = Character.toString(character);
    		if(chr == strarray[i]) {
    			intarray[i]++;
    		}
    	}
    	
    	for(int j = 0; j < strarray.length - 1; j++) {
    		if(intarray[j] > 1) {
    			counts += (strarray[j] + " " + intarray[j]); 
    		}
    	}
    	return counts;
    }

}
