/**
 * Class to find a seed sequence of miRNA in a target mRNA object
 * @author christin
 * @version 1.0
 *
 */

import java.io.*;
import java.util.ArrayList;

public class LocateSeed{
	/**
	 * 7mer-m8: A perfect WC match from nucleotides 2-8 of the miRNA seed.
	 * @param miRNA
	 * @param target
	 * @return
	 */
	public static boolean is7mer_m8(MIRNA miRNA, MRNA target) {
		boolean flag = false;
		
		for(int i = 0; i < target.getLength()-miRNA.getLength(); i++) {
			
			String temp1 = target.getSeq().substring(i,i+miRNA.getLength()-1);
			String temp2 = miRNA.getSeq().substring(0,miRNA.getLength()-1);
			
			if(temp1.equals(temp2)) {	
				if(target.getSeq().charAt(i+miRNA.getLength()-1) != 'A') {
					System.out.println(temp1 + " at position "+i);
					flag = true;
				
				}
			}

		}
		return flag;
	}
	
	/**
	 * 7mer-A1: A perfect WC match from nucleotides 2-7 of the miRNA seed in addition 
	 * to an A across from the miRNA nucleotide 1.
	 * @param miRNA
	 * @param target
	 * @return
	 */
	public static boolean is7mer_A1(MIRNA miRNA, MRNA target) {
		boolean flag = false;
		
		for(int i = 1; i < target.getLength()-miRNA.getLength(); i++) {
			
			String temp1 = target.getSeq().substring(i,i+miRNA.getLength()-2);
			String temp2 = miRNA.getSeq().substring(1,miRNA.getLength()-1);
			
		
			if(temp1.equals(temp2)) {	
			
				if(target.getSeq().charAt(i+miRNA.getLength()-2) == 'A') {
					flag = true;
					System.out.println(temp1 + " at position "+i);
				}
			}

		}
		return flag;
	}
	
	/**
	 * 8mer: A perfect WC match from nucleotides 2-8 of the miRNA seed in addition to an A across from the miRNA nucleotide 1.
	 * @param miRNA
	 * @param target
	 * @return boolean if sequence contains 8mer
	 */
	public static boolean is8mer(MIRNA miRNA, MRNA target) {
		boolean flag = false;
		for(int i = 1; i < target.getLength()-miRNA.getLength(); i++) {
			
			String temp1 = target.getSeq().substring(i,i+miRNA.getLength()-1);
			String temp2 = miRNA.getSeq().substring(0,miRNA.getLength()-1);
			
			if(temp1.equals(temp2)) {
				
				if(target.getSeq().charAt(i+miRNA.getLength()-1) == 'A') {
					System.out.println(temp1 + " at position "+i);
					flag = true;
				}
			} 
		}
		return flag;
	}
	
	/**
	 * 6mer: A perfect WC match between the miRNA seed and mRNA for six nucleotides.
	 * @param miRNA
	 * @param target
	 * @return boolean if sequence contains 6mer
	 */
	public static boolean is6mer(MIRNA miRNA, MRNA target) {
		boolean flag = false;
		
		for(int i = 1; i < target.getLength()-miRNA.getLength(); i++) {
			
			String temp1 = target.getSeq().substring(i,i+miRNA.getLength()-2);
			String temp2 = miRNA.getSeq().substring(1,miRNA.getLength()-1);
			
		
			if(temp1.equals(temp2)) {	
				flag = true;
				System.out.println(temp1 + " at position "+i);
			}
		}
		return flag;
	}

	/**
	 * Main method to start the programm
	 * @param args
	 */
	
	public static void main (String[] args) throws Exception{
		
		// hsa-miR-182-5p
		//MIRNA miRNA = new MIRNA("UUUGGCAAUGGUAGAACUCACACU",2);
		// hsa-let-7e-5p
		//MIRNA miRNA = new MIRNA("UGAGGUAGGAGGUUGUAUAGUU",2);
		// IRS2
		//MRNA target = new MRNA("AGATCTGTCTGGCTTTATCACCAGGATGTCACATGTCAGAGAGTATCATTAAAAGAAGACGCTCAGCACTGTTTCAGCCCGAAGCTGCTTGCAGTTTTCTTTTGGATCTGAGCAATGACTGTGTTTGGAAACATCTGTGGACTCTGTTAGATGAGGCACCAACAAGGCAAGGTCACCTGCCTCTTTCCCTTGTTCCCGGATGGGGCATTCATCATTGTGCTGTTTGCGTTTTGTTTTGTTTTGTTTTAACAAAATTAGCTGAAGAAGTTATTCTCAAGAAAATTGGATGTTTTCATTGGCCTTCTTAAATTGTGGCCAGTGTCTTTTAATTTCTTCTTCTTTTCCTTTTGGCAAAGCAGATATAACCCTCAGCATGCTAGGAGAGTGCACCCGTACCTATGGAAGTGGTAAAATCTGGTATTTACTGGCTTACACTCAAAACGACCACAGTCCTACCTCAGTTCAAGGTAAAGCCGGATTTCCGTGGCGGGGGTCCCACAGGACCTCCTGTAGTAGCCCCTGCGCTGTGTGTCTGGAGCGCGGTCCTCGGCCTTATTGAAATGGTCCAAGTAGACAGCTGCTTGTTGGATTCCAGTGCAGGTACCTGCGATGTTTACGTCCACACCGAGCCCAGTGTGGGACTGACATTTCTCAATGGAAGTGAAATTTGGGATTGGACTTTGAAGACGGATTACTAAATAATAATTATTATATGTAACTGAAGCAACCTACTTTTGAAAATCAACTGTATTGGGTAGTGGGAGGTGGGAGGGAAGGGCTTTGGGAAGGGGATGAATATCTCTTTTTACCTTTAACAGACTTGTTTAATCTTCTCGATGTAGATGTTTATGTAGGTACTTCACATTGCAAACGCCTTTTATTCTATTTACAAGCTCAGATGTCTCTGCTCTCCTGAATCTTGGGCATGCCTTTCTGTAACCAAAAATCCCTGTAGGCGTGCTAGCAATTCCAGGGTGGTCCGGGTTTGGCAGATTTGATTTTTAAAAAACGTATTATCTTTAATAAAATGTTATTATGTCAACCAGTGAGGCTGCCCTGAACAAAAAAAACAAAAAGAAAAAAAAAAAAGGAAAGAAAGAAACTGATAAAAAGAGGCATTCCAGCCCCTATGTTATTGATGGAAAAAGAAAAAGAAGAAAAGCAATCTCGCAGTACATGTTACTTGTCGAAAAAATTCCGGACAAGACTACCCTTGTTTTATGTTTTCAGTATTCTGAAAATACCAGTGTGTGGCAGTTCTCGCAGATGTTACCTAAAACTGCTGAACTTGACCGGCAGAATGTTCTGCCGTTTTCTGCTCCCTCGACACTTGATTGGAGGGCTGTCGACCTCTCCTCCCGTGGGGGCTTCCCCAGTGCCTATCTTCTCTGATAGTCATGGAGAGGTTACACTAATTCATTGGAGATGTAAGTTGTTGGTTTTGTTTTGTTTTGTTTTTAGAAAAATATATATAAATATATAATAGATATCTATCGCTATAGAATAATGCATTAATAAAATGAGGCTTTTTTAGAGGAAGACCAAAAAATTCAATGTCTTAAAAATATATTTAATGGCAATGCAAAAGTCTTCCTGCTTCCGTGCTGAACTTTAGAACAGAGGATTGTATTGCAAGACAAAGTTGAATGTAAAGTGATCTCCCTGAACATTTTTAAGGTTTTACTTTTCTGAAATTATACATCACAGCAGTGCATAGGCCATATAATGTTAGCTGGAAGGTCAATTTCAGTGTATGATATACTTTATTAAGATGTATAAAAATCCTGAAGTTTTTATTTAGTTTTGGGAATAGGCATCAATGGGTGGTATTTGCTTTGTAACTCCCCCCAGGTACGATAGGGACTGAATATGGACCCTGCTGAAAGCAGTGTATTGACGCATATTTAACTCGCCCTCTATCCGTAGAGTAGTCATGACACTATACAGATGGTTCGTGTTCATACTGCAGCTTAAAACAAGCAAAATACACAGATGATAATATGCTAAATTTTCCTCTATCCTGTACATTTCACAAAAAGGCATATGCAATATTTACATTTTTAATTTAGTTTACAGAATGGAACCAAAATGTATAAATGTTATGTTTGCTAAAACTTCACAATGTATATTGGGTCTTTGTACATTTTGCCTGACTTACCTTAAATTTAAAATATTTTTTGCTATATAAACTTTAACAGTTATTAAACAGTGTTTTCTTTTTGGGTACGTATTGTTTCTGGATATCAAGATGTTAAATATATTTCTTGCTATTGTGATATGACAAGAGACTTAACTTATCTTGCTCTGTCTTCCACTGTACACGCTGTATATAGGGGTCAATGTGATGCTGCTGGAGACGAGAATAAACTGGACTAGAATAGTGCATTGTATTTAGTCTGTATTGATCATGGATGCCCTCCTTAATAGCCATATGCAATAAAATAAAGTACATTATTTATGAAATGAA");
		// LRP6
		//MRNA target = new MRNA("CTACAGGCCATATAGCTACCGGCACTTTGCACCCCCCACCACACCCTGCAGCACAGATGTTTGTGACAGTGACTATGCTCCTAGTCGGAGAATGACCTCAGTGGCAACAGCCAAGGGCTATACCAGTGACTTGAACTATGATTCAGAACCTGTGCCCCCACCTCCCACACCCCGAAGCCAATACTTGTCAGCAGAGGAGAACTATGAAAGCTGCCCACCTTCTCCATACACAGAGAGGAGCTATTCTCATCACCTCTACCCACCGCCACCCTCTCCCTGTACAGACTCCTCCTGAGGAGGGGCCCTCCTCCTCTGACTGCCTCCAACGTAAAAATGTAAATATAAATTTGGTTGAGATCTGGAGGGGGGGAGGGAGCTATTAGAGAAGGATGAGGCAGACCATGTACAGTTAAAATTATAAAATGGGGTAGGGAATACTGGAGATATTTGTACAGAAGAAAAGGATATTTATATATTTTCTTAAAACAGCAGATTTGCTGCTTGTGCCATAAAAGTTTGTATAAAAAAAATTTGTACTAAAAGTTTTATTTTTGCAAACTAAATACACAAAGCATGCCTTAAACCCAGTGAAGCAACTGAGTACAAAGGAAACAGGAATAATAAAGGCATCACTGACCAGGAATATCTGGGCTTTATTGATACCAAAAATAAAAAAGAGGAAGAAGAAAAATTAAGTCCATCTCAGAGCAGCAAACCATAGATACATGGATGTAGCCAGATAGCCTTCAGTTAACTAACATTTGAGGGCCAACAAGTAAGAAATGATGAAAGGAAAAAAATGCAATTAATACTAACCTTGGACGAAGGGCTTTGTTTTCTCTAGGAATCCAACAGTGCTAGTGAGGAAAGTAGATATTTCTAAAAACCCATTCTGGGTGTTGCTGTTGTAGGAGAGATCAGCCCTCTGGTAAGATGCCATGAAGCTGTGTGTGTGTGCAAGTCTCTGTCCCTACCTTTAGAATCCATACCTCTGTCAAAATGAATTTTTTTCTCTAGGTATGTTTACCTTGCTGCCTCCTCCAGCAACTTGGTAAGTCATTTTGCTAAGATACCATGATTTTTTTAAGCTGAAGCATTGACTAAATGGAATTTTCTAAATTAAACTTGATTTTAATATTTCTTCTAGCTCCATTCCCCAGTAGGCTTAGCTCTTCAATTTGACTGCTGTTTTTGCATAATGATCAAAAGTTAGACATATTATTTCTCTTCTTCCAAGATTGTTTTAATGCTCATTAAAATGTCTTTTTACAACACATATAGACAATGTTTAAGAATTAAAAATTTAACCATTATGTTTTTGTTGTAAATCTCATATCCTTGCACTACTTTCAGCATATATCACAGTACGAAATCATTTATATATATATATATATATATATATATATATATATATATATATATATATATATTTTGTTTGTTTGTTTGTTTTCTGAGTAAAACATTTAAATATGTTCTGGTTAGAGACAATCTATTTAAAAAGATTTTTTTCTTATTAGGATTTTCCCTATATTAACAGTTTGTGATGTTTTCATGTTCTTTAGACCGGTTTTTCTCAGAATAATGTCTACATACATACCTCTTCTAATGTGTGACATGAATTTAATATCTTTCTGTTACCCACTGTGAATGTTAGGCTGTTTTCAAATTATCCACAAATTATTCTTGTAATCACCCAATATTTTTATGTGGGTCCTCTCTTACCCATTATGGATTAAGATAGTTTAACAAATTTAACAATGAGGATTAAATGAGAAGGCAAACTGTTAACTTCTCAGCTGTCAGAATTTGGGTGGAAGGGAATAATGGAAGCCTCTTTTGTGATCTGCCTGACCTGCTGTCATGTATGGTACTGGGGCTGCTACATCTTGAGCTATCAGGGCTGACCTGTGGAATGATTCTAGCACTTGCTCTGCCACCTTGCCAGAAGTTCGTTTCCTGCTTTTTACACATGTGTAGCACTTCTCTGCTAAAATTGAATGGTTTTAAACTAATGTATTTTTAGCTTAAGAGGTGTTGGTCAGTTAATTATTGAATTTTTTTTTTTTCTTTTTTAATTCTGTCTTGCCAAGGCCTCTCTGGGTTTCAGGGCCCAAGAGAAAACAGTGGAAGAAAGGATTCAGAATTTGGGCAAGGGTGAAGTAACTGTTCATGCAAGTTAAAAATACCTAAGTAAAGTTTTTGAAGATAAAATTGTGGTTTCAGAATAATGCTGATTGTTGGAGACTGTAAGAATCAGGTGCACTTGATTTTGCATATAAGCAAATGGTAAATCTATCAGAATCCTAAAACAGACAAGCATGAACTCTTCCCATTGCTGGAACTAAGTGCCCACAGTGTCAGACAAAATGGACATTGAACTTGGATTCTGTGATACACAGGGCACTTGATGCTTAAATGAAGATGGAAAGGTTAGCAATACCTGGGTGTCAGTTAGAATTTGAGAATTCTATATGTTTACATATTTAAATGTGCATCTTGATCTGGTGGGCTTCCCATGTGGAGACTTGCACTCTAATTAACTAAGAAGAATATTGCCTTGTTGGATCTCAGTCCACGTGCTTGCACTGCGATGGCAATGGCCTCTTCTTCAAAATACTAATTTGTGTGCCAATTTGTTTAAAATTATTTGAAGGCAGTTCAGCCTAATCTCAGTGTTCTCTTTCTGGGGTAGATGAGATGGATTCTTAATATTTCTGGGAGTACTTTTTAATGAGAGAATTGTCAAATTTGGAAAGATTTATTGAGCCTTAGGTTACATGGACAGTTAAGCTTAAGTAAACTGTATATTGATTATCAAACACAAGCTGTAATTGGAAAAGTTGAGAGGAAAAGCATGAGATCACAAATTAGGGGGAAAAAAGAAAAGGGATTTTTAAATTTGGTGTATTAAATTCATTGTCCAAGGGGGAAAATGAATAATGTTTCATTAGATTCCTTATATGCAAAAGTATTTATTTTGAACATGTGTCCTAAAATATATGCACTAACTGATGTGATTAAAATTGTCCAAGAAATAAACTTGAGCATAACATACTTTGTGTGCACCACAGTAAGCTATTCTGCATTGAAGTGGTCTTTTATAACTAAGGCCTGGACTTTGCTCCAACAGAGTCGTGGTCTTCTGAATAGTGACTTAAGGAGTTTTGTTTGCTTAAGTCAGATAATAGCACATTCACAGGGAAACAAAGAGAGTTGGTGGATAGAATTTTCTGACTATTAATTTTTCTTCCATGAAATTTTATTATGCCTTTGGCACTTTCTGCCACTCTTACAGCATATCACAAGATATCTGTTTAGCAGAAGATTATGTAGTTACTTTAATTTTAATATAAAAGTAGCTTGTGATACATTACCAAGAGATCTCTGATTCTTTAGTAAGTTTGAGAACACCTATTCTACAGAGATGATAGGTACTTAGAAATGAAGACTTTAAAGTACATTTTAATCTAATATAGGCCAGTAATTGGGGGAAGGGGCTTTGAGCAGTACAATTTTAAGATGATTTTGAGGGTTGTATTTCTTTATCATTTAAAAATATCCTAAAGTCAGTAATTTATATGAAGGAAACTCATTCATTATTGAAGGTATTAAAAATAGCCATCATCTGTATTAGGTAGCAGTTTTGGAGGATCATCTTTTTCTTTTGCTATAAAGCCCTATTAATGAAGAATACTTCCAGTAGAGTTAATAGCTGTAGCTTACCTAGTGTGTTAATGAAGTGTGTTTATTTATGTGACTTGATACCAGTAGTCATAATAGAGACTGAAGAGGTATGCGTTAAGCACGCCTACTTCTATGCAGTAAACAGGCTGCAGCTGCCTAGATTAGATTCTTAGAAATGTCATATTTTGAATTGTTTTATTTCTTGTAGGGGAAGCTTTGTCCCACTTCATTCATTTGCATGCCATAGGAATTACATATTGGTTATCATTACGTATCTAACAAGATTCAGAAACAAAAATCTTGGACTTTTCACATCCGAAATATGTCAGCTCTTAATAAATGTGTGGTGCTTAAGTCTACATATGGCATCCATAGTTGATTTAGAGTATGGATATGAGTGTGTTGACCAGTTATCAGTAGGTGGACAAATATTTGGGCATCTACAGATGAGACTATGCACTAAGTGTGGACTGAGTCCTAAAGAAGCTTATAGTCAGGTGTTGTTTAAAACATTATCAGAATTCTTAAACCCAAGGAATTTAATTTTATTTGGTATTTCTTAAGCCTAAAATGAACCAAGAGAAAGATGATTTTAGAAAGTACTTGTAGTGAAAGATGATTTTAGAAAGTACTTGTAGTGCATGTGTGGCTTCTGACTTTTGGGATGGCACCATTTTATAATAGTTTCAAAATTTAGCTTTTGAAATTCTCAACATTTTATGGTAGAAGACTTTGGACCTCAAGTATAAAATTATACGTTTATAATTTTTTTAAAATTTAAATTATAAGTATTGTGAATTCACACTCTCAGGCTATTGTCTGACTTGATCTACGTCTCATAAAGCCTGTACCTGAGTGGAGTGGAAGGTGGAGTCTTAGGTTAATCAGTTACTGACTCTACCCTCACCCTCTTTCAATTGAGGTAAACTTTGCTGTTTTTCTTTTTCATAAAGCATTCTCAAATTGTTGAGTTTATTGCTGAAAAAAATCTCCATGACTTTACAGATAGAATTACAAACTAAATGATGTCTTGTATTTAGAAGCAGAGTACAGACCTAACGAACTGTTAGATTCTCCACCATCACTTAGGGTTTGCCCAGAAGCAACACCAGAGAATTACAGACAACGCGCTTTTGCTGAACTGTCCATTTTGGTGGTTGTGTTTTTCAGTCAAATATAAGCAGGATGGGCGATAGAGATATATTTATATATAGATACATATTCTATATATCTAATGCCTAAATATGGGTATTAAAGGGAAAATTTTTAAAGTCTGATTAAATCCAATATGACATGAAATTAAATATATGGATTAGTAAGGAAAAATGTTAAAAAGTAGAGAGGATACCAAGAAGATTAAACTGGACTAGCCTTATTTGCAAGTGAAGGATCTGGTGCTGCTTTCAGATGTTTATCTTTTATTTTTTTCCCTTAAGCTTTAATCTTCGTCATTGTCTTAAAGTCAACTGGTGTTTCTTGTTCATTGACTTTGGTACGATGGTGCTTTGCAAGGATGTATTTATGTTATAATGGCCAACATTTGGTCAGCCCTTGTCCACTTATTCACTTCCCTCCTTTTGTAAAATAAGTGCTTTAATTATAAACTGTATAAAAATACCTTGTATAAACCCCTTTTTTGATTATTACAATAAATAAGCTGAATTGTAACAAATGAAATTTGATTTTTGTAATAAAACAGTGGAAAAGTAAAA");
		//CDKN1B
		//MRNA target = new MRNA("CAGAATTAAGAATATGTTTCCTTGTTTATCAGATACATCACTGCTTGATGAAGCAAGGAAGATATACATGAAAATTTTAAAAATACATATCGCTGACTTCATGGAATGGACATCCTGTATAAGCACTGAAAAACAACAACACAATAACACTAAAATTTTAGGCACTCTTAAATGATCTGCCTCTAAAAGCGTTGGATGTAGCATTATGCAATTAGGTTTTTCCTTATTTGCTTCATTGTACTACCTGTGTATATAGTTTTTACCTTTTATGTAGCACATAAACTTTGGGGAAGGGAGGGCAGGGTGGGGCTGAGGAACTGACGTGGAGCGGGGTATGAAGAGCTTGCTTTGATTTACAGCAAGTAGATAAATATTTGACTTGCATGAAGAGAAGCAATTTTGGGGAAGGGTTTGAATTGTTTTCTTTAAAGATGTAATGTCCCTTTCAGAGACAGCTGATACTTCATTTAAAAAAATCACAAAAATTTGAACACTGGCTAAAGATAATTGCTATTTATTTTTACAAGAAGTTTATTCTCATTTGGGAGATCTGGTGATCTCCCAAGCTATCTAAAGTTTGTTAGATAGCTGCATGTGGCTTTTTTAAAAAAGCAACAGAAACCTATCCTCACTGCCCTCCCCAGTCTCTCTTAAAGTTGGAATTTACCAGTTAATTACTCAGCAGAATGGTGATCACTCCAGGTAGTTTGGGGCAAAAATCCGAGGTGCTTGGGAGTTTTGAATGTTAAGAATTGACCATCTGCTTTTATTAAATTTGTTGACAAAATTTTCTCATTTTCTTTTCACTTCGGGCTGTGTAAACACAGTCAAAATAATTCTAAATCCCTCGATATTTTTAAAGATCTGTAAGTAACTTCACATTAAAAAATGAAATATTTTTTAATTTAAAGCTTACTCTGTCCATTTATCCACAGGAAAGTGTTATTTTTCAAGGAAGGTTCATGTAGAGAAAAGCACACTTGTAGGATAAGTGAAATGGATACTACATCTTTAAACAGTATTTCATTGCCTGTGTATGGAAAAACCATTTGAAGTGTACCTGTGTACATAACTCTGTAAAAACACTGAAAAATTATACTAACTTATTTATGTTAAAAGATTTTTTTTAATCTAGACAATATACAAGCCAAAGTGGCATGTTTTGTGCATTTGTAAATGCTGTGTTGGGTAGAATAGGTTTTCCCCTCTTTTGTTAAATAATATGGCTATGCTTAAAAGGTTGCATACTGAGCCAAGTATAATTTTTTGTAATGTGTGAAAAAGATGCCAATTATTGTTACACATTAAGTAATCAATAAAGAAAACTTCCATAGCTATTCAT");
		// FOXO1
		//MRNA target = new MRNA("TTTTTTCCTAGGTTACACTTAAAAGTACTTCAGATTGTCTGACAGCAGGAACTGAGAGAAGCAGTCCAAAGATGTCTTTCACCAACTCCCTTTTAGTTTTCTTGGTTAAAAAAAAAAACAAAAAAAAAAACCCTCCTTTTTTCCTTTCGTCAGACTTGGCAGCAAAGACATTTTTCCTGTACAGGATGTTTGCCCAATGTGTGCAGGTTATGTGCTGCTGTAGATAAGGACTGTGCCATTGGAAATTTCATTACAATGAAGTGCCAAACTCACTACACCATATAATTGCAGAAAAGATTTTCAGATCCTGGTGTGCTTTCAAGTTTTGTATATAAGCAGTAGATACAGATTGTATTTGTGTGTGTTTTTGGTTTTTCTAAATATCCAATTGGTCCAAGGAAAGTTTATACTCTTTTTGTAATACTGTGATGGGCCTCATGTCTTGATAAGTTAAACTTTTGTTTGTACTACCTGTTTTCTGCGGAACTGACGGATCACAAAGAACTGAATCTCCATTCTGCATCTCCATTGAACAGCCTTGGACCTGTTCACGTTGCCACAGAATTCACATGAGAACCAAGTAGCCTGTTATCAATCTGCTAAATTAATGGACTTGTTAAACTTTTGGAAAAAAAAAGATTAAATGCCAGCTTTGTACAGGTCTTTTCTATTTTTTTTTGTTTATTTTGTTATTTGCAAATTTGTACAAACATTTAAATGGTTCTAATTTCCAGATAAATGATTTTTGATGTTATTGTTGGGACTTAAGAACATTTTTGGAATAGATATTGAACTGTAATAATGTTTTCTTAAAACTAGAGTCTACTTTGTTACATAGTCAGCTTGTAAATTTTGTGGAACCACAGGTATTTGGGGCAGCATTCATAATTTTCATTTTGTATTCTAACTGGATTAGTACTAATTTTATACATGCTTAACTGGTTTGTACACTTTGGGATGCTACTTAGTGATGTTTCTGACTAATCTTAAATCATTGTAATTAGTACTTGCATATTCAACGTTTCAGGCCCTGGTTGGGCAGGAAAGTGATGTATAGTTATGGACACTTTGCGTTTCTTATTTAGGATAACTTAATATGTTTTTATGTATGTATTTTAAAGAAATTTCATCTGCTTCTACTGAACTATGCGTACTGCATAGCATCAAGTCTTCTCTAGAGACCTCTGTAGTCCTGGGAGGCCTCATAATGTTTGTAGATCAGAAAAGGGAGATCTGCATCTAAAGCAATGGTCCTTTGTCAAACGAGGGATTTTGATCCACTTCACCATTTTGAGTTGAGCTTTAGCAAAAGTTTCCCCTCATAATTCTTTGCTCTTGTTTCAGTCCAGGTGGAGGTTGGTTTTGTAGTTCTGCCTTGAGGAATTATGTCAACACTCATACTTCATCTCATTCTCCCTTCTGCCCTGCAGATTAGATTACTTAGCACACTGTGGAAGTTTAAGTGGAAGGAGGGAATTTAAAAATGGGACTTGAGTGGTTTGTAGAATTTGTGTTCATAAGTTCAGATGGGTAGCAAATGGAATAGAACTTACTTAAAAATTGGGGAGATTTATTTGAAAACCAGCTGTAAGTTGTGCATTGAGATTATGTTAAAAGCCTTGGCTTAAGAATTTGAAAATTTCTTTAGCCTGTAGCAACCTAAACTGTAATTCCTATCATTATGTTTTATTACTTTCCAATTACCTGTAACTGACAGACCAAATTAATTGGCTTTGTGTCCTATTTAGTCCATCAGTATTTTCAAGTCATGTGGAAAGCCCAAAGTCATCACAATGAAGAGAACAGGTGCACAGCACTGTTCCTCTTGTGTTCTTGAGAAGGATCTAATTTTTCTGTATATAGCCCACATCACACTTGCTTTGTCTTGTATGTTAATTGCATCTTCATTGGCTTGGTATTTCCTAAATGTTTAACAAGAACACAAGTGTTCCTGATAAGATTTCCTACAGTAAGCCAGCTCTATTGTAAGCTTCCCACTGTGATGATCATTTTTTTGAAGATTCATTGAACAGCCACCACTCTATCATCCTCATTTTGGGGCAGTCCAAGACATAGCTGGTTTTAGAAACCCAAGTTCCTCTAAGCACAGCCTCCCGGGTATGTAACTGAACTTGGTGCCAAAGTACTTGTGTACTAATTTCTATTACTACGTACTGTCACTTTCCTCCCGTGCCATTACTGCATCATAATACAAGGAACCTCAGAGCCCCCATTTGTTCATTAAAGAGGCAACTACAGCCAAAATCACTGTTAAAATCTTACTACTTCATGGAGTAGCTCTTAGGAAAATATATCTTCCTCCTGAGTCTGGGTAATTATACCTCTCCCAAGCCCCCATTGTGTGTTGAAATCCTGTCATGAATCCTTGGTAGCTCTCTGAGAACAGTGAAGTCCAGGGAAAGGCATCTGGTCTGTCTGGAAAGCAAACATTATGTGGCCTCTGGTAGTTTTTTTCCTGTAAGAATACTGACTTTCTGGAGTAATGAGTATATATCAGTTATTGTACATGATTGCTTTGTGAAATGTGCAAATGATATCACCTATGCAGCCTTGTTTGATTTATTTTCTCTGGTTTGTACTGTTATTAAAAGCATATTGTATTATAGAGCTATTCAGATATTTTAAATATAAAGATGTATTGTTTCCGTAATATAGACGTATGGAATATATTTAGGTAATAGATGTATTACTTGGAAAGTTCTGCTTTGACAAACTGACAAAGTCTAAATGAGCACATGTATCCCAGTGAGCAGTAAATCAATGGAACATCCCAAGAAGAGGATAAGGATGCTTAAAATGGAAATCATTCTCCAACGATATACAAATTGGACTTGTTCAACTGCTGGATATATGCTACCAATAACCCCAGCCCCAACTTAAAATTCTTACATTCAAGCTCCTAAGAGTTCTTAATTTATAACTAATTTTAAAAGAGAAGTTTCTTTTCTGGTTTTAGTTTGGGAATAATCATTCATTAAAAAAAATGTATTGTGGTTTATGCGAACAGACCAACCTGGCATTACAGTTGGCCTCTCCTTGAGGTGGGCACAGCCTGGCAGTGTGGCCAGGGGTGGCCATGTAAGTCCCATCAGGACGTAGTCATGCCTCCTGCATTTCGCTACCCGAGTTTAGTAACAGTGCAGATTCCACGTTCTTGTTCCGATACTCTGAGAAGTGCCTGATGTTGATGTACTTACAGACACAAGAACAATCTTTGCTATAATTGTATAAAGCCATAAATGTACATAAATTATGTTTAAATGGCTTGGTGTCTTTCTTTTCTAATTATGCAGAATAAGCTCTTTATTAGGAATTTTTTGTGAAGCTATTAAATACTTGAGTTAAGTCTTG");
		
		if(args[0].equals("help")) {
			System.out.println(" ");
			System.out.println("miRNA Seed Tool for in silico search for binding sites. \nAuthor Christin Krause @ University of L�beck");
			System.out.println(" ");
			System.out.println("Options:");
			System.out.println(" ");
			System.out.println("single: miR-seq SeedStart mRNA");
			System.out.println(" ");
			System.out.println("mult_miR: miR-seq-file mRNA");
			System.out.println("The file should have the form of: mature Sequence 'tab' name");
			System.out.println(" ");
			System.out.println("mult_mR: miR-seq mRNA-file");
			System.out.println("The file should have the form of: name 'tab' 3'UTR Sequence");
			System.out.println(" ");
		}
		
		if(args[0].equals("single")) {
			MIRNA miRNA = new MIRNA(args[1], Integer.parseInt(args[2]));
			MRNA target = new MRNA(args[3]);
			System.out.println(" ");
			System.out.println("Seed Sequence of miRNA: " + miRNA.getSeq());
			System.out.println(miRNA.getLength());
			
			System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("mRNA contains 8mer: " + is8mer(miRNA, target));
			System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("mRNA contains 6mer: " + is6mer(miRNA, target));
			System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("mRNA contains 7mer_m8: " + is7mer_m8(miRNA, target));
			System.out.println("- - - - - - - - - - - - - - -");
			System.out.println("mRNA contains 7mer_A1: " + is7mer_A1(miRNA, target));
			System.out.println(" ");
		}
		
		if(args[0].equals("mult_miR")) {
			
			File file = new File(args[1]);
			BufferedReader buffReader = new BufferedReader(new FileReader(file));
			
			String str;
			ArrayList<String> divide = new ArrayList<String>();
			ArrayList<String> name = new ArrayList<String>();
			
			while ((str = buffReader.readLine()) != null){
				String[] temp = str.split("\t");
				
				divide.add(temp[0]);
				name.add(temp[1]);
			}
			
			MRNA target = new MRNA(args[2]);
			
			while(divide.size() != 0) {
				MIRNA miRNA = new MIRNA(divide.get(0), 2);
				
					System.out.println(" ");
					System.out.println("> Seed Sequence of miRNA " + name.get(0) +  ": " + miRNA.getSeq());
					System.out.println(miRNA.getLength());
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 8mer: " + is8mer(miRNA, target));
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 6mer: " + is6mer(miRNA, target));
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 7mer_m8: " + is7mer_m8(miRNA, target));
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 7mer_A1: " + is7mer_A1(miRNA, target));
					System.out.println(" ");
				
				divide.remove(0);
				name.remove(0);
			}
		}
			
		if(args[0].equals("mult_mR")) {
				
			File file = new File(args[2]);
			BufferedReader buffReader = new BufferedReader(new FileReader(file));
				
			String str;
			ArrayList<String> divide = new ArrayList<String>();
			ArrayList<String> name = new ArrayList<String>();
				
			while ((str = buffReader.readLine()) != null){
				String[] temp = str.split("\t");
					
				divide.add(temp[1]);
				name.add(temp[0]);
			}
				
			MIRNA miRNA = new MIRNA(args[1], 2);
				
			while(divide.size() != 0) {
					MRNA target = new MRNA(divide.get(0));
					System.out.println(" ");
					System.out.println("Seed Sequence of miRNA for target " + name.get(0) +  ": " + miRNA.getSeq());
					System.out.println(miRNA.getLength());
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 8mer: " + is8mer(miRNA, target));
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 6mer: " + is6mer(miRNA, target));
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 7mer_m8: " + is7mer_m8(miRNA, target));
					System.out.println("- - - - - - - - - - - - - - -");
					System.out.println("mRNA contains 7mer_A1: " + is7mer_A1(miRNA, target));
					System.out.println(" ");
					
					divide.remove(0);
					name.remove(0);
			}
			
		}
		
	}

}
