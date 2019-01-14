/**
 * Class to generate a mRNA Target sequence 
 * @author christin
 * 
 */

public class MRNA{


	private int length;
	private String sequence;
	
	
	/**
	 * Constructor of mRNA 
	 * @param seq String with target sequence
	 */
	public MRNA(String seq){
		this.sequence = seq;
		this.length = seq.length();
	}
	
	
	public String getSeq(){
		return this.sequence;
	}
	
	
	
	public int getLength(){
		return this.length;
	}

	public void setLength(){
		this.length = this.sequence.length();
	}
	
	public String getSeqAt(int i){
		return this.sequence.substring(i,i+8);
	}
}
