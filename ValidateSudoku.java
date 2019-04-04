package com.perficient.test;

public class ValidateSudoku {
	public static void main(String[] args) throws Exception {
	    int[][] matrix = {{5,3,4,6,7,8,9,1,2},
	    			 	 {6,7,2,1,9,5,3,4,8},
		    			 {1,9,8,3,4,2,5,6,7},
		                 {8,5,9,7,6,1,4,2,3},
		                 {4,2,6,8,5,3,7,9,1},
		                 {7,1,3,9,2,4,8,5,6}, 
		                 {9,6,1,5,3,7,2,8,4},
		                 {2,8,7,4,1,9,6,3,5},
		                 {3,4,5,2,8,6,1,7,9}};
	
	    if(validate(matrix))
	        System.out.println("The matrix is a solution for Sudoku.");
	    else
	    	System.out.println("The matrix is not a solution for Sudoku.");
	   
	}
	
	public static boolean validate(int[][] matrix)
	  {
		 //Verifies cells contains values between 1 to 9
		for(int row=0;row<9;row++)
		      for(int col=0;col<9;col++)
		    	  if(matrix[row][col]>9 || matrix[row][col]<1) {
		    		  System.out.println("invalid Integer in cells");
		    		  return false;
		    	  }
		 //Verifies rows not contain any duplicate 
	    for(int row=0;row<9;row++)
	      for(int col=0;col<8;col++)
	      if(matrix[row][col]==matrix[row][col+1])
	      return false;
	    
	    //Verifies columns not contain any duplicate 
	    for(int col=0;col<9;col++)
	      for(int row=0;row<8;row++)
	      if (matrix[row][col]==matrix[row+1][col])
	      return false;
	    	    
	    //Verifies 3*3 grid not contain any duplicate 
	    for(int row = 0; row < 9; row += 3)
	       for(int col = 0; col < 9; col += 3)
	          for(int posR = 0; posR < 8; posR++)
	             for(int posC = posR + 1; posC < 9; posC++)
	                if(matrix[row + posR%3][col + posR/3]==matrix[row + posC%3][col + posC/3])
	                   return false;

	    return true;    
	  }
}

