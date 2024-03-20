package klerer.fallingsand;

import javax.swing.*;
import java.awt.*;

public class SandComponent extends JComponent {

    private final Sand sand;

    public SandComponent(Sand sand) {
        this.sand = sand;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the sand
        int cellSize = 20; // Size of each cell in pixels

        // Iterate over the sand field and draw sand particles
        for (int y = 0; y < sand.getHeight(); y++) {
            for (int x = 0; x < sand.getWidth(); x++) {
                if (sand.get(x, y) == 1) {
                    g.setColor(Color.YELLOW); // Color of sand particles
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize); // Draw sand particle
                }
            }
        }
    }
}
