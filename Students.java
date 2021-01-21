// Bu�ra ATE�  /  B1705.090046  / Software Engineering
// |Student Register System|

package studentinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;   // import all the libraries that i used
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Students {
	
	private static Scanner input;  // declaring the scanner classes as a private
	private static Scanner input2;
	private static Scanner x ;
	private static Scanner yeniBilgi;
	private static Scanner Silme;

	public static void Silme (String Silinecek , String DosyaYolu) { // deleting process
		
		String tempFile = "temp.txt";  //temporary file
		File oldFile = new File(DosyaYolu); // connecting tempfile to new file
		File newFile = new File(tempFile);
		String xadsoyad = ""; // informations declared as  a null
		String xnumara  = "";
		String xgpa     = "";
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(DosyaYolu));// declaring scanner for reading from file
			x.useDelimiter("[\t\n]"); // this is a way for searching in between the words
			 // it can be , or - to, depens on the programmers. ( like xy,ij = [,\n])
			
			while(x.hasNext())
			{
				xadsoyad = x.next(); // reading infos from file
				xnumara  = x.next();
				xgpa     = x.next();
				if(!xnumara.equals(Silinecek)) // if the info that you entered is not matched
				{
				pw.println(xadsoyad +"\t"+xnumara +"\t"+xgpa);  //write same infos
				}
				else // else delete the informations
				{
				System.out.println(Silinecek + " Student Information Has Been Deleted.");
				}
			}
			x.close(); // close the file scanner
			pw.flush();
			pw.close(); // close the printwritter
			oldFile.delete(); // deleting old file 
			File dump = new File(DosyaYolu); // and rename the new file as 'student.txt'
			newFile.renameTo(dump);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"ERROR");
		}
	}
	public static void Update (String xadsoyad3 ,Double xgpa3,String Aranan ,String DosyaYolu,String xnumara3 ){ //update i�lemi
	
		String tempFile = "temp.txt"; // same things like other functions for reading from file
		// and searching.
		File oldFile = new File(DosyaYolu);
		File newFile = new File(tempFile);
		String xadsoyad = "";
		String xnumara  = "";
		String xgpa     = "";
		try
		{
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			x = new Scanner(new File(DosyaYolu));
			x.useDelimiter("[\t\n]");
			
		while(x.hasNext())
		{
			xadsoyad = x.next();
			xnumara  = x.next();
			xgpa     = x.next();
			
			if(xnumara.equals(Aranan)){ // if the school id is matched
			pw.println(xadsoyad3+"\t"+xnumara3+"\t"+xgpa3 ); // write new infos in the file
			System.out.println(Aranan +" Student Information Has Been Updated.");
			}	
			else {
			pw.println(xadsoyad +"\t"+xnumara +"\t"+xgpa ); // if its not matched write old ones.
			}
		}
		x.close();
		pw.flush();  // closing the files and rename as 'student.txt'
		pw.close();
		oldFile.delete();
		File dump = new File(DosyaYolu);
		newFile.renameTo(dump);
		}
		catch(Exception e){
		}
	}
	
	public static void bilgioku (String Aranan ,String DosyaYolu ) throws IOException { 
		//searching and reading from the file
		
		boolean Bulundu = false ; // declaring bulundu as a boolean (T/F)
		String xadsoyad = "" ;
		String xnumara  = "" ;
		String xgpa = "" ;
		
		try {
		x = new Scanner(new File(DosyaYolu)) ; // declaring X as reader(scanner) from file
		x.useDelimiter("[\t\n]");
		
		while (x.hasNext() && !Bulundu) {
				
		xadsoyad = x.next();
     	xnumara  = x.next();
		xgpa     = x.next();
			
	    if(xnumara.equals(Aranan)) {// the xnumara is the ID that user entered
	    	// and according to that i created a condition with boolean function.
		Bulundu = true ; } // if the boolean is true 
		}
		if(Bulundu){ // Print the certain line on the screen
			// This certain line includes the user informations that user wanted to see.
		System.out.println(xnumara +" Student Informations  : \n " +"Name Surname : " +xadsoyad +" \n GPA          : "+ xgpa);
		}
		else {
	    System.out.println("No Student Number Found !");
		}
		}
		catch(Exception e){
		}
		}
	   
	public static void bilgial () throws Exception {
			
		input2 = new Scanner(System.in);
		input2.useLocale(Locale.US);
		// taking ID - NAME SURNAME - GPA informations
		System.out.println("Enter Student's Name and Surname :");
		String xadsoyad = input2.nextLine() ;
		System.out.println("Enter Student's School ID :");
		String xnumara = input2.next() ;
		System.out.println("Enter Student's GPA :");
		Double xgpa = input2.nextDouble() ;
		
		File dosya = new File("students.txt");
        FileWriter yazici = new FileWriter(dosya,true);
        BufferedWriter yaz = new BufferedWriter(yazici);
        yaz.write(xadsoyad+"\t"+xnumara+"\t"+xgpa + "\r\n");
		yaz.close();	
	}
	
	public static ArrayList DosyadanOku(String DosyaAdi) { //sorting as alphabetically
		 ArrayList<String> Listem = new ArrayList<String>(); // creating Listem as arraylist
		 try {
			Scanner sc = new Scanner(new File(DosyaAdi));
			while(sc.hasNextLine())// it is looped until end of the file
			{
				Listem.add(sc.nextLine()); // used add function for add the line in Listem(arraylist)
			}
			sc.close(); // close the file scanner
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Listem; // Return Listem as a ArrayList

	 }
	public static void DosyayaKaydet(String DosyaAdi , ArrayList Liste)
	{
		// Finally we write the new shape of file in the file.
		Path DosyaYolu = Paths.get(DosyaAdi);
		try {
			Files.write(DosyaYolu, Liste, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void AllInfos() {
		// reading the all informations from file and print on the screen

		String FILENAME = "students.txt"; // declaring FILENAME
		// our file is 'students.txt'
		BufferedReader br = null;
		FileReader fr = null;

		try {

	  // we can also use like br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
		    br = new BufferedReader(fr);
	  // declared filereader in buffered one

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				// Until last line of file , this loop will be looping
				// Until the last, it prints the all lines from the file.
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) { 
			e.printStackTrace(); // using try catch functions with IOException e
		} finally { //in the end , i closed the files
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main (String[] args) throws Exception{
		
		input = new Scanner(System.in);
		// user can use 6 different functions
		// for registering user has to enter a number > 0
		System.out.println(" Enter the number of students you want to register : ");
		System.out.println(" -------------------------------------------------- ");
		System.out.println("(Enter ' 0 ' For SEARCH Student Informations) ");
		System.out.println("(Enter '-1 ' For UPDATE Student Informations) ");
		System.out.println("(Enter '-2 ' For DELETE Student Informations)");
		System.out.println("(Enter '-3 ' For SORT   Student Informations Alphabetically)");
		System.out.println("(Enter '-4 ' For SHOW   Student Informations All)");
		System.out.println(" ------------------------------------------------------- ");
		int x = input.nextInt(); // taking a number from user for choosing function
		int sayac = 1 ;
		
		if(x<-1 && x!=-2 && x!=-3 && x!=-4)
		{
	    System.out.println("The Number You Entered is Invalid !"); // if the number 
	    // smaller than -5 , it is invalid
		}
		else {
		
		if (x>0){ // user can register only when the number greater than 0
		for ( int i=0 ; i<x ; i++) {		
		System.out.println(sayac +". Student Informations : ");
		bilgial() ;	 // the registering function
		sayac++ ; // this counter is for showing the number of student
		}
		}
		else{
		if(x==0) {
		String DosyaYolu = "students.txt";
		String NumaraArama ;
		System.out.println("Enter the School ID of Student That You Want to SEARCH :");
		NumaraArama = input.next();
		bilgioku(NumaraArama,DosyaYolu);	
		}
		else {
		if(x==-1) { //update
		
		String DosyaYolu = "students.txt";
		String NumaraArama;
		String xadsoyad3 , xnumara3 ;
		Double xgpa3 ;
		
		yeniBilgi = new Scanner(System.in); // declaring scanner for taking input from user
		yeniBilgi.useLocale(Locale.US);
		// taking ID - NAME SURNAME - GPA informations
		System.out.println("Enter the School ID of Student That You Want to UPDATE ");
		NumaraArama = input.next(); 
		System.out.println("Enter Student's New Name and Surname :");
		xadsoyad3 = yeniBilgi.nextLine();
		System.out.println("Enter Student's New School ID  :");
		xnumara3 = yeniBilgi.next();
		System.out.println("Enter Student's New GPA  :");
		xgpa3 = yeniBilgi.nextDouble();
		
		Update(xadsoyad3,xgpa3,NumaraArama,DosyaYolu,xnumara3); // calling the Update function
		// with the parameters that user entered and certain info like path of file.(students.txt)
			
		}
		}
		}
		}
		if (x>0){
		System.out.println("Student Informations Has Been Saved to 'students.txt'");
		}
		if(x==-2) {
			Silme = new Scanner(System.in);
			System.out.println("Enter the School ID of Student That You Want to DELETE :");
			String DosyaYolu = "students.txt" ;
			String Silinecek = Silme.next();
			Silme(Silinecek,DosyaYolu);
		}
		if(x==-3){
		String DosyaAdi = "students.txt";
		ArrayList<String> Kelimeler = DosyadanOku(DosyaAdi); // Kelimeler equaled to ArrayList Listem
		Collections.sort(Kelimeler); //Sorting functions
		DosyayaKaydet(DosyaAdi,Kelimeler);// Finally we use this functions to change the lines
		// in the file as alphabetically.
		System.out.println("Students List Has Been Sorted Alphabetically.");
		}
		if(x==-4){
			System.out.println("All Student Informations ");
			System.out.println("------------------------------------");
			System.out.println("NAME SURNAME    SCHOOL ID       GPA");
			AllInfos();// Function that ensures the show all the informations on the screen
			// from the 'students.txt' file.
		}
	}
}
