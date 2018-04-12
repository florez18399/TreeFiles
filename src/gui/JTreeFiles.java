package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import models.Node;

public class JTreeFiles extends JTree {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode mutableTreeNode;
	private DefaultTreeModel defaultTreeModel;
	private Node<String> root;

	public JTreeFiles(Node<String> root) {
		mutableTreeNode = new DefaultMutableTreeNode();
		defaultTreeModel = new DefaultTreeModel(mutableTreeNode);
		setModel(defaultTreeModel);
		this.root = root;
		init();
	}

	public void init() {
		setSize(500, 500);
		setLayout(new BorderLayout());
		setOpaque(false);
		paintTree();
		repaint();
	}

	public void paintTree() {
		if (root != null) {
			mutableTreeNode = createNodeJtree(root);
			defaultTreeModel = new DefaultTreeModel(mutableTreeNode);
			setModel(defaultTreeModel);
			for (Node<String> actualNode : root.getChildren()) {
				paintTree(actualNode, mutableTreeNode);
			}
		}
	}

	public void setIconNode(String pathIcon) {
		DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) getCellRenderer();
		ImageIcon imageIcon = getScaleIconImage(pathIcon);
		render.setLeafIcon(imageIcon);
		render.setOpenIcon(imageIcon);
		render.setClosedIcon(imageIcon);
		paintTree();
	}

	private void paintTree(Node<String> root, DefaultMutableTreeNode jroot) {
		if (root != null) {
			DefaultMutableTreeNode jNode = createNodeJtree(root);
			jroot.add(jNode);
			for (Node<String> actualNode : root.getChildren()) {
				paintTree(actualNode, jNode);
			}
		}
	}

	public DefaultMutableTreeNode createNodeJtree(Node<String> node) {
		return new DefaultMutableTreeNode(node.getInfo());
	}

	public ImageIcon getScaleIconImage(String imageURL) {
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageURL));
		Image image = imageIcon.getImage();
		imageIcon = new ImageIcon(image.getScaledInstance(20, 20, java.awt.Image.SCALE_REPLICATE));
		return imageIcon;
	}

	public void repaintTree() {
		removeAll();
		paintTree();
		revalidate();
		repaint();
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
		removeAll();
		paintTree();
	}

}
