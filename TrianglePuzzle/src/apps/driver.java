package apps;

import java.io.FileNotFoundException;
import java.util.Scanner;

import triangle.TriangleSum;


public class driver {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.print("Please enter the triangle file name => ");
		String fileName = sc.nextLine();
		TriangleSum triSum = new TriangleSum(fileName);
		triSum.print();
	}

}
