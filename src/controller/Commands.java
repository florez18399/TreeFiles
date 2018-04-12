package controller;

public enum Commands {
	CHOOSE_DIR_FATHER("CHOOSE_DIR_FATHER", "Escoger partición", "Escoge el directorio raíz",
			"/images/dirIcon.png"), PAINT_TREE("PAINT_TREE", "Llenar JTREE", "Llenar el árbol",
					"/images/paintIcon.png");

	private String command;
	private String title;
	private String description;
	private String pathIcon;

	private Commands(String command, String title, String description, String pathIcon) {
		this.command = command;
		this.title = title;
		this.description = description;
		this.pathIcon = pathIcon;
	}

	/**
	 * @return the command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the pathIcon
	 */
	public String getPathIcon() {
		return pathIcon;
	}

	/**
	 * @param pathIcon
	 *            the pathIcon to set
	 */
	public void setPathIcon(String pathIcon) {
		this.pathIcon = pathIcon;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
