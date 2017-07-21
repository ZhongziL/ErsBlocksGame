import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomizeSize extends JFrame {
	public static final long serialVersionUID = 2L;
	
	private TipPanel tipPanel = new TipPanel();
	private JPanel custom = new JPanel(new FlowLayout());
	
	private JLabel name1 = new JLabel("width"),
			name2 = new JLabel("height");
	
	private JTextField input1 = new JTextField(4),
			input2 = new JTextField(4);
	
	private JButton button = new JButton("confirm");
	
	public CustomizeSize(String title) {
		super(title);
		tipPanel.setSize(400, 400);
		setSize(400,430);
		custom.add(name1);
		custom.add(input1);
		custom.add(name2);
		custom.add(input2);
		custom.add(button);
		input1.setText("100");
		input2.setText("100");
		setLayout(new BorderLayout());
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrSize.width-getSize().width)/2,(scrSize.height-getSize().height)/2);
		add("North", custom);
		add("Center", tipPanel);
		tipPanel.setStyle(0x0660);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int wide = Integer.parseInt(input1.getText());
				int height = Integer.parseInt(input2.getText());
				tipPanel.setSize(4*wide, 4*height);
				setSize(4*wide, 4*height+30);
				repaint();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent ce) {
				tipPanel.fanning();
			}
		});
		
		this.setVisible(true);
		tipPanel.fanning();
	}
	
	public static void main(String[] args) {
		new CustomizeSize("customize the size of block");
	}
	
}
