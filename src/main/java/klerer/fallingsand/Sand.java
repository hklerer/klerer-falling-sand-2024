package klerer.fallingsand;

public class Sand {

    private int[][] field = new int[3][3];
    private int x;
    private int y;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
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
        if (get(x, y) == field[1][2]) {
            field[y + 1][x + 1] = 1;
        }
        else if (get(x, y) == field[1][0]) {
            field[y][x] = 0;
            field[y][x + 1] = 1;
        }
        else {
            field[y][x] = 0;
            field[y][x + 1] = 1;
        }

    }

}
