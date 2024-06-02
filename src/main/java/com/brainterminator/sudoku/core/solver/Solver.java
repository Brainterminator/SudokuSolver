package com.brainterminator.sudoku.core.solver;

import com.brainterminator.sudoku.core.entities.Sudoku;

public abstract class Solver {

    public static final int length = 9;

    public Solver(Sudoku sudoku) {
    }

    public abstract void solve();
}
