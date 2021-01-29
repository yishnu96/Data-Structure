// ! Largest Piece

// It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
// Input Format :
// The first line of input contains an integer, that denotes the value of N. 
// Each of the following N lines contain N space separated integers.
// Output Format :
// Print the count of '1's in the biggest piece of '1's, according to the description in the task.
//? Constraints :
// 1 <= N <= 1000
// Time Limit: 1 sec
//? Sample Input 1:
// 2
// 1 1
// 0 1
//? Sample Output 1:
// 3



public class LargestPiece {

    public static int solve(int n, String[] cake) {
		char[][] matrix = new char[n][n];
		for (int i = 0; i < n; i++) {
			matrix[i]= cake[i].toCharArray();
		}
		
		int max=0,temp;
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
				if (matrix[i][j] == '1'){
					temp = largest_piece(matrix,i,j,n);
					if(max < temp)
						max = temp;
				}
		
		return max;
	}
	private static int largest_piece(char[][] matrix, int i, int j, int n) {
		
        if(i<0 || i>=n || j<0 || j>=n || matrix[i][j] != '1')
            return 0;

        matrix[i][j] = '0';
        int a = largest_piece(matrix, i-1, j, n);

        int b = largest_piece(matrix, i+1, j, n);

        int c = largest_piece(matrix, i, j-1, n);

        int d = largest_piece(matrix, i, j+1, n);

        return 1 + a + b + c + d;
	}
}
