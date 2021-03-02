package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = ImpossibleMoveException.class)
    public void test5() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure Bishop1 = new BishopBlack(Cell.C1);
        Figure Bishop2 = new BishopBlack(Cell.D2);
        logic.add(Bishop1);
        logic.add(Bishop2);
        logic.move(Cell.C1, Cell.C2);
    }
}