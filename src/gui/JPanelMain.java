package gui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import controller.Commands;
import controller.Controller;
import models.Node;

public class JPanelMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fieldSizeFile;
	private JTreeFiles treeFiles;

	public JPanelMain(Node<String> rootTree) {
		this.treeFiles = new JTreeFiles(rootTree);
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		setOpaque(false);
		createJPanelHead();
		JPanel panelTree = new JPanel();
		panelTree.setSize(new Dimension(600, 600));
		treeFiles.setIconNode("/images/dirIcon2.png");
		panelTree.add(treeFiles);
		panelTree.setOpaque(false);
		JScrollPane pane = new JScrollPane(panelTree);
		pane.setOpaque(false);
		add(pane, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	private void createJPanelHead() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(400, 100));
		panel.setOpaque(false);
		panel.add(createJButton(Commands.CHOOSE_DIR_FATHER));
		fieldSizeFile = new JTextField();
		fieldSizeFile.setBorder(BorderFactory.createTitledBorder("Tamaño de los archivos(KB):"));
		fieldSizeFile.setPreferredSize(new Dimension(250, 40));
		panel.add(fieldSizeFile);
		panel.add(createJButton(Commands.PAINT_TREE));
		add(panel, BorderLayout.NORTH);
	}

	private JButton createJButton(Commands command) {
		JButton button = new JButton(command.getTitle());
		button.setIcon(new ImageIcon(getClass().getResource(command.getPathIcon())));
		button.setActionCommand(command.getCommand());
		button.setToolTipText(command.getDescription());
		button.setPreferredSize(new Dimension(250, 40));
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 15));
		button.addActionListener(Controller.getInstance());
		return button;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/backImage.jpg")), 0, 0,
				getWidth(), getHeight(), this);
		// Graphics2D g2 = (Graphics2D) g;
		// g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		// RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		// AlphaComposite old = (AlphaComposite) g2.getComposite();
		// g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));
		super.paint(g);
		// g2.setComposite(old);
	}

	public void setRootTree(Node<String> rootTree) {
		treeFiles.setRoot(rootTree);
		repaint();
		revalidate();
	}

	public int getSizeFile() {
		return Integer.parseInt(fieldSizeFile.getText());
	}

}
