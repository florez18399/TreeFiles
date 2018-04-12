package models;

import java.io.File;

public class ManagerFiles {
	private File fileFather;
	private TreeFiles treeFiles;

	public ManagerFiles(String pathFather, int sizeFile) {
		fileFather = new File(pathFather);
		treeFiles = new TreeFiles(fileFather, sizeFile);
		fillTree();
	}

	public ManagerFiles() {
		treeFiles = new TreeFiles();
	}

	/**
	 * Llena el árbol
	 */
	public void fillTree() {
		fillTree(fileFather);
	}

	private void fillTree(File actual) {
		treeFiles.addToTree(actual);
		if (actual.isDirectory()) {
			for (File fileSon : actual.listFiles()) {
				fillTree(fileSon);
			}
		}
	}
	
	/**
	 * Muestra en consola la totalidad de los archivos que se encuentran en el directorio padre
	 */
	public void showInfoFile() {
		showInfoFile(fileFather, " ");
	}

	private void showInfoFile(File actualFile, String separator) {
		System.out.println(separator + actualFile.getName());
		if (actualFile.isDirectory()) {
			for (File file : actualFile.listFiles()) {
				showInfoFile(file, separator + "            		|");
			}
		}
	}

	public void showTree() {
		treeFiles.showTree();
	}

	/**
	 * @return the fileFather
	 */
	public File getFileFather() {
		return fileFather;
	}

	/**
	 * @param fileFather
	 *            the fileFather to set
	 */
	public void setFileFather(File fileFather) {
		this.fileFather = fileFather;
		treeFiles = new TreeFiles(fileFather);
		fillTree();
	}
	
	public void setSizeFile(int sizeFile) {
		treeFiles.reInit();
		treeFiles.setSizeFiles(sizeFile);
		fillTree();
	}
	
	public Node<String> getRootTree() {
		return treeFiles.getRoot();
	}
}
