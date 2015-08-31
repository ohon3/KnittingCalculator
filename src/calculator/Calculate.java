package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import stitchmath.StitchMath;

public class Calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StitchMath s = new StitchMath();
		
		try {
			System.out.print("How many stitches are on your needles?: ");
			String line = br.readLine();
			
			while (line != null) {
				s.setStitches(Integer.parseInt(line));
				//System.out.println("Okay. How many partitions do you want in your hat? (Default is 8)"); 
				s.printInstructions();
				System.out.print("How many stitches are on your needles?: ");
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			
		}
		
		

	}

}
