package de.mke.ecc.one;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Solution.java
 * My solution of Q1 of the Evernote Coding Challenge (https://evernote.com/careers/challenge.php)
 * dev@michaelkessel.de, 2014
 */
public class Solution {
	
	private int size;
	private int count;
	
	private BufferObject firstBO = null;
	private BufferObject lastBO = null;
	
	public Solution(int n) {
		this.size = n;
		this.count = 0;
	}
	
	public void append(String s) {
		BufferObject bo = new BufferObject(s);
		
		if( lastBO != null) {
			lastBO.nextBO = bo;
		}
		
		this.firstBO = this.firstBO == null ? bo : this.firstBO;
		this.lastBO = bo;
		this.count++;
		
		if(count > size) {
			this.remove();
		}
	}
	
	public void remove() {
		this.firstBO = this.firstBO.nextBO;
		this.count--;
	}
	
	public String list() {
		String ret = new String();
		BufferObject bo = this.firstBO;
		
		while( bo != null) {
			ret = ret.concat(bo.string + "\n");
			bo = bo.nextBO;
		}
		
		return ret;
	}

	/*
	 * STDIN/STDOUT Handling
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
        int n = Integer.parseInt(line);
        Solution sol = new Solution(n);
        
        while(true) {
        	line = br.readLine();
        	n = line.length() > 2 ? Integer.parseInt(line.substring(2)) : 0;
        	
        	switch(line.toUpperCase().charAt(0)) {
        		case 'A':
        			for(int i=1; i<= n; i++) {
        				line = br.readLine();
        				sol.append(line);
        			}
        			break;
        		case 'R':        			
        			for(int i=1; i<= n; i++) {
        				sol.remove();
        			}
        			break;
        		case 'L':        			
        			System.out.println(sol.list());
        			break;
        		case 'Q':
        			System.exit(0);
        			break;
        	}
        }
	}
	
	/*
	 * Inner class BufferObject
	 */
	public class BufferObject {
		protected BufferObject nextBO = null;
		protected String string;
		
		public BufferObject(String s) {
			this.string = s;
		}
	}
}
