package models;

import java.io.File;
import java.nio.file.attribute.FileAttribute;

public class TreeFiles {
	private Node<String> root;
	private int smallerSize;
	private int biggerSize;
	
	public TreeFiles(File fileFather) {
		if(fileFather.isDirectory()){
			root = new Node<String>(fileFather.getName());
		}else {
			throw new NullPointerException("La carpeta que eligió no es un directorio");
		}
	}
	
	public void addToTree(File file) {
		String extension = file.getName().substring(file.getName().lastIndexOf("."));
	}
	
}
