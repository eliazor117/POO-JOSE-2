import javax.swing.*;
import java.awt.*;

public class FlorDibujo extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFlower(g);
    }

    private void drawFlower(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Dibujar pétalos (óvalos alrededor del centro)
        g.setColor(Color.PINK);
        int petalWidth = 60;
        int petalHeight = 30;

        for (int angle = 0; angle < 360; angle += 45) {
            double rad = Math.toRadians(angle);
            int x = (int) (centerX + 60 * Math.cos(rad)) - petalWidth / 2;
            int y = (int) (centerY + 60 * Math.sin(rad)) - petalHeight / 2;
            g.fillOval(x, y, petalWidth, petalHeight);
        }

        // Centro de la flor
        g.setColor(Color.YELLOW);
        g.fillOval(centerX - 25, centerY - 25, 50, 50);

        // Tallo
        g.setColor(Color.GREEN);
        g.fillRect(centerX - 5, centerY + 25, 10, 100);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Flor en Java");
        FlorDibujo panel = new FlorDibujo();
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
        ventana.setVisible(true);
    }
}
