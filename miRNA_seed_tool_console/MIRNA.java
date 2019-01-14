/**
* Class to generate a miRNA Object containing a miRNA core
* @author christin
*/
public class MIRNA{


	private int length;
	private String sequence;
	private String full_seqence;
	private String origSeq;
	
	/**
	 * Constructor of miRNA core
	 * @param seq String containing core miRNA
	 */
	public MIRNA(String seq){
		this.sequence = translateUtoT(seq);
		this.length = this.setLength();
	}
	
	/**
	 * Second constructor for full sequence of miRNA to extract seed which is normally at position 2
	 * @param full_seq String with full miRNA sequence
	 * @param start_seed Int with start of 8 nt seed sequence
	 */
	public MIRNA(String full_seq, int start_seed) {
		this.full_seqence = full_seq;
		String orig = translateUtoT(full_seq.substring(start_seed-2, start_seed+6));
		this.origSeq = orig;
		this.sequence = reverseComplement(origSeq);
		this.length = this.setLength();
	}
	
	private String translateUtoT(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) =='U') {
				result += 'T';
			}
			else {
				result += s.charAt(i);
			}
		}
		return result;
	}
	
	public String reverseComplement(String s) {
		String result = "";
		
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) == 'A') {
				result += 'T';
			}
			if(s.charAt(i) == 'T') {
				result += 'A';
			}
			if(s.charAt(i) == 'G') {
				result += 'C';
			}
			if(s.charAt(i) == 'C') {
				result += 'G';
			}
		}
		
		return result;
	}
	
	public String getSeq(){
		return this.sequence;
	}
	
	public String getFull() {
		return this.full_seqence;
	}
	
	public int getLength(){
		return this.length;
	}

	public int setLength(){

		if(this.sequence.equals("")){
			this.length = 0;
			return 0;
		}

		this.length = this.sequence.length();
		return this.length;
	}
}
