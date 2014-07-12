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
