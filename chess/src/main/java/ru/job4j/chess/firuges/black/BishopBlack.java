package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;


public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position(), dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
            int size = Math.abs(position().getX() - dest.getX());
            Cell[] steps = new Cell[size];
            int deltaX = (dest.getX() - position().getX()) / size;
            int deltaY = (dest.getY() - position().getY()) / size;
            steps[0] = position;
            int index2 = 0;
            for (int index = 0; index < size; index++) {
                index2 = index == 0 ? 0 : index - 1;
                steps[index] = Cell.findBy((steps[index2].getX() + deltaX), (steps[index2].getY() + deltaY));

        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int zero = (Math.abs(source.getX() - dest.getX())) - (Math.abs(source.getY() - dest.getY()));
        boolean result = zero == 0 ? true : false;
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
