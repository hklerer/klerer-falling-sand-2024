package klerer.fallingsand;

import java.util.Random;

public class Sand {

    private final int[][] field;

    private final Random random = new Random();

    public Sand(int width, int height) {
        field = new int[height][width];
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                builder.append(field[y][x]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * @return the value in field
     */
    public int get(int x, int y) {
        return field[y][x];
    }

    /**
     * sets the value in field to 1
     */
    public void put(int x, int y) {
        field[y][x] = 1;
    }

    public void fall() {
        // moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    // does the sand fall straight down?
                    if (field[y + 1][x] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x] = 1;
                    }

                    // does the sand fall to the right?
                    else if (field[y + 1][x + 1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + 1] = 1;
                    }

                    // does the sand fall to the left?
                    else if (field[y + 1][x - 1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x - 1] = 1;
                    }
                }
            }
        }
    }
}
