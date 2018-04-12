package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.Node;

public class JFrameMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelMain panelMain;

	public JFrameMain(Node<String> rootTree) {
		init(rootTree);
	}
	

	private void init(Node<String> rootTree) {
		setTitle("Árbol de archivos");
		setIconImage(new ImageIcon(getClass().getResource("/images/iconTree.png")).getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		panelMain = new JPanelMain(rootTree);
		add(panelMain, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void repaintTree(Node<String> rootTree) {
		panelMain.setRootTree(rootTree);
	}
	
	public int getSizeFile() {
		return panelMain.getSizeFile();
	}

}
