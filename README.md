# miRNA Seed Tool

This tool is still in development.

## Background

MicroRNAs (miRNAs) are small 22 nt non-coding RNA molecules with diverse effects on gene expression and protein translation.

MiRNAs recognize their target genes by binding of a 6-7 nt seed sequence.

---



## Tool 

A Java based tool to get binding prediction information of a miRNA to a specific target mRNA.
Input as java "miRNA Seq" "Seed position #" "mRNA sequence"
like

````shell
java LocateSeed "GCUUAGUGGCUUA" "2" "GTAAACAGATAGACCATTGACAGTAGCGTAGCAGTAGGACCAGTAGAGACAA"
````

. Needs to be compiled prior use. 

