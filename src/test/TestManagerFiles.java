package test;

import java.io.File;

import models.ManagerFiles;
import models.TreeFiles;

public class TestManagerFiles {
	public static void main(String[] args) {
		ManagerFiles manager = new ManagerFiles("C:/Users/lenovo/Documents/Ing Sistemas/Programacion 3");
		manager.showInfoFile();
		
		TreeFiles treeFiles = new TreeFiles(manager.getFileFather());
		treeFiles.addToTree(new File("C:\\Users\\lenovo\\Pictures\\Saved Pictures/unnamed.jpg"));
	}
}
