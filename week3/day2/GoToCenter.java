/**
 * Created by Gabor on 28/03/2017.
 */
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GoToCenter {

  public static void mainDraw(Graphics graphics) {

    centre(25, 25, graphics);
    centre(100, 50, graphics);
    centre(210, 200, graphics);


  }

  private static void centre(int x, int y, Graphics g) {

    g.setColor(Color.BLACK);
    g.drawLine(x, y, 150, 150);

  }

  // create a line drawing function that takes 2 parameters:
  // the x and y coordinates of the line's starting point
  // and draws a line from that point to the center of the canvas.
  // draw 3 lines with that function.


  //    Don't touch the code below
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(300, 300));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);

    }
  }
}



