package pit;

public class sudoku_solver {
	    public static boolean isValid(int[][] board, int row, int col, int num) {
	        for (int i = 0; i < 9; i++) {
	            if (board[row][i] == num || board[i][col] == num) {
	                return false;
	            }
	        }

	        int startRow = row - row % 3;
	        int startCol = col - col % 3;
	        for (int i = startRow; i < startRow + 3; i++) {
	            for (int j = startCol; j < startCol + 3; j++) {
	                if (board[i][j] == num) {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }

	    public static boolean solveSudoku(int[][] board) {
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                if (board[row][col] == 0) {
	                    for (int num = 1; num <= 9; num++) {
	                        if (isValid(board, row, col, num)) {
	                            board[row][col] = num;

	                            if (solveSudoku(board)) {
	                                return true; // Solution found
	                            }

	                            board[row][col] = 0;
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true; 
	    }

	    public static void printBoard(int[][] board) {
	        for (int r = 0; r < 9; r++) {
	            for (int d = 0; d < 9; d++) {
	                System.out.print(board[r][d]);
	                System.out.print(" ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int[][] board = new int[][] {
	            {5, 3, 0, 0, 7, 0, 0, 0, 0},
	            {6, 0, 0, 1, 9, 5, 0, 0, 0},
	            {0, 9, 8, 0, 0, 0, 0, 6, 0},
	            {8, 0, 0, 0, 6, 0, 0, 0, 3},
	            {4, 0, 0, 8, 0, 3, 0, 0, 1},
	            {7, 0, 0, 0, 2, 0, 0, 0, 6},
	            {0, 6, 0, 0, 0, 0, 2, 8, 0},
	            {0, 0, 0, 4, 1, 9, 0, 0, 5},
	            {0, 0, 0, 0, 8, 0, 0, 7, 9}
	        };

	        if (solveSudoku(board)) {
	            printBoard(board);
	        } else {
	            System.out.println("No solution exists");
	        }
	    }
	    
}