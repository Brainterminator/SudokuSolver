package com.brainterminator.sudoku.core.solver;

import com.brainterminator.sudoku.core.entities.FieldGroup;
import com.brainterminator.sudoku.core.entities.Sudoku;
import com.brainterminator.sudoku.core.enums.SudokuState;

import java.util.ArrayList;

public class SaveSolver extends Solver {

    private final Sudoku sudoku;

    public SaveSolver(Sudoku sudoku) {
        super(sudoku);
        this.sudoku = sudoku;
    }

    /**
     * Solves the next Sudoku step safely
     */
    @Override
    public void solve() {
        sudoku.setState(SudokuState.SOLVING);
        for (int y = 0; y < length; y++) {
            for (int x = 0; x < length; x++) {
                solveRecursive(y, x);
            }
        }

        if (sudoku.isSolved())
            sudoku.setState(SudokuState.SOLVED);
        else
            sudoku.setState(SudokuState.LOADED);
    }

    private void solveRecursive(int row, int column) {
        ArrayList<Integer> values = sudoku.getField(column, row).getPossibleValues();
        if (values.size() != 1)
            return;

        sudoku.forceValue(row + 1, column + 1, values.get(0));
        for (int i = 0; i < 9; i++) {
            solveRecursive(row, i);
            solveRecursive(i, column);
            FieldGroup quadrant = sudoku.getQuadrant(row, column);
            solveRecursive(((quadrant.getNr() / 3) * 3) + (i / 3), ((quadrant.getNr() % 3) * 3) + (i % 3));
        }
    }
}
