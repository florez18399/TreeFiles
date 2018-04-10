package models;

import java.io.File;

public class ManagerFiles {
	private File fileFather;

	public ManagerFiles(String pathFather) {
		fileFather = new File(pathFather);
		System.out.println("Es un directorio: " + fileFather.isDirectory());
	}

	public void showInfoFile() {
		showInfoFile(fileFather, " ");
	}

	private void showInfoFile(File actualFile, String separator) {
		System.out.println(separator + actualFile.getName()); 
		if (actualFile.isDirectory()) {
			for (File file : actualFile.listFiles()) {
				showInfoFile(file, separator + "  ");
			}
		}
	}

	/**
	 * @return the fileFather
	 */
	public File getFileFather() {
		return fileFather;
	}

	/**
	 * @param fileFather the fileFather to set
	 */
	public void setFileFather(File fileFather) {
		this.fileFather = fileFather;
	}
	
	
}
