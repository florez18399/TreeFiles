package models;

import java.util.LinkedList;

public class Node<T> {
	private T info;
	private LinkedList<Node<T>> children;

	public Node(T info) {
		this.info = info;
		children = new LinkedList<Node<T>>();
	}

	/**
	 * @return the info
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * @return the children
	 */
	public LinkedList<Node<T>> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(LinkedList<Node<T>> children) {
		this.children = children;
	}

}
