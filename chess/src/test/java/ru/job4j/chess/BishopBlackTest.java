package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.Matchers.is;


import static org.junit.Assert.assertThat;
public class BishopBlackTest {
    @Test
    public void test1() {
        Figure Bishop = new BishopBlack(Cell.C1);
        assertThat(Bishop.position(), is(Cell.C1));
    }
    @Test
    public void test2() {
        Figure Bishop = new BishopBlack(Cell.A1);
        Figure NewBisjop = Bishop.copy(Cell.C1);
        assertThat(NewBisjop.position(), is(Cell.C1));
    }
    @Test
    public void test3() {
        Figure Bishop = new BishopBlack(Cell.A1);
        Cell[] in = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        Cell[] out = Bishop.way(Cell.H8);
        assertThat(in, is(out));
    }
    @Test(expected = OccupiedCellException.class)
    public void test4() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        Figure Bishop1 = new BishopBlack(Cell.C1);
        Figure Bishop2 = new BishopBlack(Cell.D2);
        logic.add(Bishop1);
        logic.add(Bishop2);
        logic.move(Cell.C1, Cell.E3);
    }
}
