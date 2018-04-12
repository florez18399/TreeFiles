package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import gui.JFrameMain;
import models.ManagerFiles;

public class Controller implements ActionListener {

	private static Controller controller;
	private JFrameMain frameMain;
	private ManagerFiles managerFiles;
	private File fileFather;

	private Controller() {

	}

	public static Controller getInstance() {
		if (controller == null)
			controller = new Controller();
		return controller;
	}

	public void initComponents() {
		managerFiles = new ManagerFiles();
		frameMain = new JFrameMain(managerFiles.getRootTree());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case CHOOSE_DIR_FATHER:
			chooseDirFather();
			break;

		case PAINT_TREE:
			paintTree();
			break;

		default:
			break;
		}

	}

	private void paintTree() {
		managerFiles.setFileFather(fileFather);
		try{
			managerFiles.setSizeFile(frameMain.getSizeFile());
			managerFiles.showTree();
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frameMain, "Tamaño de archivo incorrecto", "Número incorrecto", JOptionPane.ERROR_MESSAGE);
		}
		frameMain.repaintTree(managerFiles.getRootTree());
	}

	private void chooseDirFather() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.showOpenDialog(frameMain);
		fileFather = fileChooser.getSelectedFile();
	}

}
