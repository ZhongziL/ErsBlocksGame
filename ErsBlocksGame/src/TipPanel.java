import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class TipPanel extends JPanel {
	public static final long serialVersionUID = 1L;
	
	private Color frontColor = Color.lightGray;
	private Color backColor = Color.darkGray;
	
	private ErsBox[][] boxes = new ErsBox[4][4];
	private int style, boxWidth, boxHeight;
	
	private boolean isTiled = true;
	
	public TipPanel() {
		for(int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes[i].length; j++) {
				boxes[i][j] = new ErsBox(false);
			}
		}
	}
	
	public TipPanel(Color frontColor, Color backColor) {
		this();
		this.frontColor = frontColor;
		this.backColor = backColor;
	}
	
	public void setStyle(int style) {
		this.style = style;
		repaint();
	}
	
	public void setTiled(boolean tiled) {
		this.isTiled = tiled;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!isTiled) fanning();
		int key = 0x8000;
		for(int i = 0; i < boxes.length; i++) {
			for(int j = 0; j < boxes[i].length; j++) {
				Color color = ((key & style) != 0) ? frontColor : backColor;
				g.setColor(color);
				g.fill3DRect(j*boxWidth, i*boxHeight, boxWidth, boxHeight, true);
				key >>= 1;
			}
		}
	}
	
	public void fanning() {
		boxWidth = getSize().width / 4;
		boxHeight = getSize().height / 4;
		isTiled = true;
	}
}





