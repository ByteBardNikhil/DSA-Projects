/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author USER
 */
public class SudokuSolver {

    public static void main(String[] args) {
        int[][] sudokoBoard = {
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
        if(new Sudoku().solve(sudokoBoard))
            System.out.println("Class working well");
        if (solve(sudokoBoard)) {
            System.out.println("Sudoko solved correctly");
            print(sudokoBoard);
        } else {
            System.out.println("No solution exist for sudoko");
        }

    }

    public static boolean solve(int[][] Board) {
        int[] emptyCell = findEmptyCell(Board);
        if (emptyCell == null) {
            return true;
        }
        int row = emptyCell[0];
        int col = emptyCell[1];
        for (int num = 1; num <= 9; num++) {
                if(isValidMove(Board,row,col,num))
                {
                    Board[row][col]=num;
                    if(solve(Board))
                        return true;
                }
                Board[row][col]=0;
        }
        return false;
    }
    private static boolean isValidMove(int [][] Board,int row,int col,int num)
    {
        for(int i=0;i<9;i++)
        {
            if(Board[row][i]==num ||Board[i][col]==num )
                return false;
        }
        
        int startRow=row-row%3;
        int startCol=col-col%3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(Board[i+startRow][j+startCol]==num)
                   return false;
            }
        }
        return true;
    }
    
    public static void print(int[][] a)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int[] findEmptyCell(int[][] Board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

class Sudoku
{
    public boolean solve(int [][] board)
    {
        int[] emptyCell=findEmptyCell(board);
        
        if(emptyCell==null)
            return true;
        int row=emptyCell[0];
        int col=emptyCell[1];
        
        for(int num=1;num<=9;num++)
        {
            if(isValid(board,row,col,num))
            {
               board[row][col]=num;
               if(solve(board))
                   return true;
               board[row][col]=0;
            }
        }
        return false;
    }
    public boolean isValid(int[][] a,int row,int col,int num)
    {
        for(int i=0;i<9;i++)
        {
            if(a[row][i]==num || a[col][i]==num)
                return true;
        }
        int startRow=row-row%3;
        int startCol=col-col%3;
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(a[i+startRow][j+startCol]==num)
                    return true;
            }
        }
        
        return false;
    }
    public int[] findEmptyCell(int[][] a)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a[i][j]==0)
                    return new int[]{i,j};
            }
        }
        return null;
    }
}
