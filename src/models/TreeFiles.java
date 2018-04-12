package models;

import java.io.File;

public class TreeFiles {
	private Node<String> root;
	private int sizeFiles;

	public TreeFiles(File fileFather, int sizeFiles) {
		this.sizeFiles = sizeFiles;
		root = new Node<String>(fileFather.getName());
	}

	public TreeFiles() {
	}

	public TreeFiles(File fileFather) {
		root = new Node<String>(fileFather.getName());
	}

	public void addToTree(File file) {
		if (!file.isDirectory()) {
			String extension = "";
			try {
				extension = file.getName().substring(file.getName().lastIndexOf("."));
			} catch (StringIndexOutOfBoundsException e) {
				extension = "other";
			}
			Node<String> nodeExtension = searhcExtension(extension);
			if (nodeExtension == null) {
				createExtension(extension);
				nodeExtension = searhcExtension(extension);
			}
			addFileToExtension(nodeExtension, file);
		}
	}

	public void addFileToExtension(Node<String> nodeExtension, File file) {
		Node<String> nodeSize;
		if (file.length() < sizeFiles) {
			nodeSize = nodeExtension.getChildren().get(0);
		} else {
			nodeSize = nodeExtension.getChildren().get(1);
		}
		nodeSize.getChildren().add(new Node<String>(file.getName()));
	}

	private void createExtension(String nameExtension) {
		Node<String> newExtension = new Node<String>(nameExtension);
		newExtension.getChildren().add(new Node<String>("Menores al tamaño"));
		newExtension.getChildren().add(new Node<String>("Mayores al tamaño"));
		root.getChildren().add(newExtension);
	}

	private Node<String> searhcExtension(String nameExtension) {
		for (Node<String> extension : root.getChildren()) {
			if (extension.getInfo().equals(nameExtension))
				return extension;
		}
		return null;
	}

	public void showTree() {
		showTree(root, " ");
	}

	private void showTree(Node<String> actual, String separator) {
		System.out.println(separator + actual.getInfo());
		for (Node<String> node : actual.getChildren()) {
			showTree(node, separator + "                 |");
		}
	}

	/**
	 * @return the root
	 */
	public Node<String> getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Node<String> root) {
		this.root = root;
	}

	/**
	 * @return the sizeFiles
	 */
	public int getSizeFiles() {
		return sizeFiles;
	}

	/**
	 * @param sizeFiles
	 *            the sizeFiles to set
	 */
	public void setSizeFiles(int sizeFiles) {
		this.sizeFiles = sizeFiles;
	}

	public void reInit() {
		root.getChildren().clear();
	}

}
