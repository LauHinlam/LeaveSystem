package GUI;

import Staffs.Director;
import Staffs.Staff;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

/**
 * Created by JerryLau on 12/4/2016.
 */
public class TreeView extends JPanel {
    protected DefaultMutableTreeNode root;
    protected DefaultTreeModel treeModel;
    protected JTree tree;

    public TreeView() {
        this("Director");
    }
    public TreeView(String rootName) {
        super(new GridLayout(1, 0));

        root = new DefaultMutableTreeNode(Director.getInstance());
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    public DefaultMutableTreeNode getSelectedNode() {
        TreePath selectedPath = tree.getSelectionPath();
        DefaultMutableTreeNode selectedNode = this.root;
        if (selectedPath != null) {
            selectedNode = (DefaultMutableTreeNode) (selectedPath.getLastPathComponent());
        }
        return selectedNode;
    }

    public boolean isRoot(DefaultMutableTreeNode node) {
        return (node == this.root);
    }

    public DefaultMutableTreeNode addNode(Staff staffObject) {
        DefaultMutableTreeNode parentNode = getSelectedNode();
        TreePath parentPath = tree.getSelectionPath();

        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(staffObject);
        treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount());
        tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        return childNode;
    }

    public void RemoveCurrentNode() {
        TreePath selectedPath = tree.getSelectionPath();
        if (selectedPath != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) (selectedPath.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (selectedNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(selectedNode);
                return;
            }
        }
    }
}
