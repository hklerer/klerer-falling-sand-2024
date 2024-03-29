package klerer.fallingsand;

public class Sand {

    private int intX = 3;
    private int intY = 3;
    private int[][] field = new int[intX][intY];

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
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1 && field[y + 1][x] == 0) {
                    field[y][x] = 0;
                    field[y + 1][x] = 1;
                }
            }
        }
    }

}
