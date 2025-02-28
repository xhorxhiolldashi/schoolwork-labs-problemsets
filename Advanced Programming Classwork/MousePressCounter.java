import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Swing program to demonstrate mouse action
 * listeners.
 *
 *  Click anywhere in the window to increment
 * the counter. Press the reset to reset the
 * count.
 * 
 * @author Xhorxhi Olldashi
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {
    private Integer count;
    String toDisplay;
    JButton reset;
    JPanel panel;
	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
        this.count = 0;
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				toDisplay = "MousePressCounter: " + count;
				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};
		frame.add(panel);
		panel.addMouseListener(this);

        reset = new JButton("Reset");
        reset.addActionListener(this);
        panel.add(reset);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 this.count++;
         panel.repaint();
	}

    @Override
	// mouse clicker action listener
   public void actionPerformed(ActionEvent e){
    if(e.getSource() == reset){
        count = 0;
        panel.repaint();
    }
   }


	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
