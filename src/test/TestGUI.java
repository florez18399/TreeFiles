package test;

import gui.JFrameMain;
import models.Node;

public class TestGUI {
	public static void main(String[] args) {
		JFrameMain window = new JFrameMain(new Node<String>("Hola"));
	}
}	
