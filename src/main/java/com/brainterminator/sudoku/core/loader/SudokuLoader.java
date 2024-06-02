package com.brainterminator.sudoku.core.loader;

import com.brainterminator.sudoku.core.entities.Sudoku;

/**
 * Loads values into a Sudoku
 */
public abstract class SudokuLoader {
    /**
     * Loads values to the given Sudoku in a certain way
     *
     * @param sudoku Sudoku
     */
    public abstract void loadSudoku(Sudoku sudoku);
}
