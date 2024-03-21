package klerer.fallingsand;

import java.util.Random;

public class Sand {

    private final int[][] field;

    private final Random random;

    public Sand(int width, int height) {
        field = new int[height][width];
        this.random = new Random();
    }


    public Sand(int width, int height, Random random) {
        field = new int[height][width];
        this.random = random;
    }

    public int[][] getField() {
        return field;
    }

    /**
     * Adds random sand to our field
     *
     * @param n the amount of sand to add.
     */
    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            int y = random.nextInt(field.length);
            int x = random.nextInt(field[0].length);
            put(x, y);
        }
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

    /**
     * moves the sand from x1, y1 to x2, y2
     *
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return true if the move was successful, otherwise false
     */
    public boolean move(int x1, int y1, int x2, int y2) {
        if (inBounds(x2, y2) && isSand(x1, y1) && !isSand(x2, y2)) {
            field[y1][x1] = 0;
            field[y2][x2] = 1;
            return true;
        }
        return false;
    }

    public boolean inBounds(int x, int y) {
        return x >= 0 && x < field[y].length;
    }


    public int getWidth() {
        return field[0].length;
    }

    public int getHeight() {
        return field.length;
    }

    public void fall() {
        // moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (isSand(x, y)) {
                    moveSandDown(x, y);
                }
            }
        }
    }

    private void moveSandDown(int x, int y) {
        if (!isSand(x, y + 1)) {
            move(x, y, x, y + 1);
            return;
        }

        boolean rightFirst = random.nextBoolean();
        int direction = rightFirst ? +1 : -1;

        if (move(x, y, x + direction, y + 1)) {
            return;
        }

        move(x, y, x - direction, y + 1);
    }

    boolean isSand(int x, int y) {
        return field[y][x] == 1;
    }

    public void resize(int width, int height) {

    }

    public void load(String sandString) {

    }

    // starting at x, y to x+width and y+height set each item in field to
    // be a sand if random.nextDouble() <= probability
    public void put(int x, int y, int width, int height, double probability) {

    }

}
