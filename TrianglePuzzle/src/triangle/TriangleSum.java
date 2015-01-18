package triangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TriangleSum {
	
	int maxTotal;
	int rows;
	int[][] triangle;
	
	public TriangleSum(String file) throws FileNotFoundException{

		BufferedReader br = new BufferedReader(new FileReader(file));
	
		maxTotal = 0;
		rows = 0;
		
		try {
			while(br.ready()){ // counting rows
				rows++; 
				br.readLine();
			}
		} catch (IOException e1) {
			System.err.println(e1.getMessage());
		}
		
		
		
		br = new BufferedReader(new FileReader(file));
		triangle = new int[rows][rows]; // 'triangle' is array representation of triangle
		
		try {
			int r = 0;
			while(br.ready()){
				String str = br.readLine();
				String[] splitStr = str.split("\\s+"); // split at spaces
				for (int j = 0; j<splitStr.length; j++){
						triangle[r][j] = Integer.parseInt(splitStr[j]); 
				}
				r++;
			}
			br.close();
			
			/**
			 * Using breadth-first approach from the bottom up works better than starting from the top.
			 * Instead of creating more possible paths working from the top, we eliminate them from 
			 * the bottom up. Calculating total by replacing triangle[i][j] with its previous
			 * value + maximum(nextRow same column, nextRow one column over).
			 * This is essentially its adjacent values. We use the fact that triangle[][]
			 * is no longer needed after we find its path. For further explanation, please email me:
			 * rs1064@scarletmail.rutgers.edu 
			 * 
			 */
			
			for (int i=rows-2; i>= 0; i--){
				for (int j=0; j<=i; j++){
					triangle[i][j] = triangle[i][j] + Math.max(triangle[i+1][j], triangle[i+1][j+1]);
				}
			}
			maxTotal = triangle[0][0];
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void print(){
		System.out.println("The maximum total from top to bottom is: "+maxTotal);
	}

}
