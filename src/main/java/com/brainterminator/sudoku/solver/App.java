package com.brainterminator.sudoku.solver;

import com.brainterminator.sudoku.core.entities.Sudoku;
import com.brainterminator.sudoku.core.loader.ExampleLoader;
import com.brainterminator.sudoku.core.loader.SudokuLoader;
import com.brainterminator.sudoku.solver.frames.SudokuFrame;

public class App {

    //THE MASTER BRANCH IS STRICTLY PROTECTED - VIEW ONLY
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        SudokuLoader loader = new ExampleLoader();
        loader.loadSudoku(sudoku);
        SudokuFrame sudokuFrame = new SudokuFrame(sudoku);
    }
}
