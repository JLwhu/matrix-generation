package taxonomy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tree.Tree;
import tree.TreeNode;

public class TaxonHierarchy {

    private Tree<ITaxon> hierarchy;

    public TaxonHierarchy() {
        this.hierarchy = new Tree<ITaxon>();
    }

    public TaxonHierarchy(ITaxon root) {
        TreeNode<ITaxon> rootNode = new TreeNode<ITaxon>(root);
        this.hierarchy = new Tree<ITaxon>(rootNode);
    }

    /**
     * @return the hierarchy
     */
    public Tree<ITaxon> getHierarchy() {
        return hierarchy;
    }

    /**
     * Add a sub-taxon as one of the children of the root of this hierarchy. If
     * the root is null, sub becomes the root.
     *
     * @param sub
     * @throws SubTaxonException
     */
    public void addSubTaxon(ITaxon sub) throws SubTaxonException {
        if (this.hierarchy.isEmpty()) {
            this.hierarchy.setRoot(new TreeNode<ITaxon>(sub));
        } else {
            TreeNode<ITaxon> root = this.hierarchy.getRoot();
            if (root.getElement().getTaxonRank().compareTo(sub.getTaxonRank()) > 0) {
                root.addChild(new TreeNode<ITaxon>(sub));
            } else {
                throw new SubTaxonException(sub, root.getElement());
            }
        }

    }

    /**
     * added by Jing Liu Add a sub-taxon as one of the children of the root of
     * this hierarchy. If the root is null, sub becomes the root.
     *
     * @param sub
     * @throws SubTaxonException
     */
    public void addSubTaxon(List<TaxonRank> ranklist,
            List<String> ranknamelist, ITaxon sub) throws SubTaxonException {
        if (this.hierarchy.isEmpty()) {
            this.hierarchy.setRoot(new TreeNode<ITaxon>(sub));
        } else {
            TreeNode<ITaxon> parent = getTaxonParentInTree(ranklist, ranknamelist, sub);
            if (parent != null) {
      //          TreeNode<ITaxon> exist_taxon = findTaxonByName(sub.getName(), sub.getTaxonRank());  //check if there is already node in the tree, ignor the files if it is not the first on encountered.
      //          if (exist_taxon == null) {
                    parent.addChild(new TreeNode<ITaxon>(sub));
      //          }
            }else {
            	parent = this.hierarchy.getRoot();
            	if (parent.getElement().getName().equals("PseudoROOT"))
            		parent.addChild(new TreeNode<ITaxon>(sub));
            		
            }
            //		throw new SubTaxonException(sub, parent.getElement());
        }

    }

    /**
     * added by Jing Liu Get a taxon as the parent of sub in this hierarchy. If
     * the root is null, sub becomes the root.
     *
     * @param sub
     * @throws SubTaxonException
     */
    public TreeNode getTaxonParentInTree(List<TaxonRank> ranklist,
            List<String> ranknamelist, ITaxon sub) throws SubTaxonException {
        TreeNode<ITaxon> taxonNode = this.hierarchy.getRoot();
        if (ranklist != null && ranklist.size() > 0) {
            if (taxonNode.getElement().getName().equals("PseudoROOT")) {
                List<TreeNode<ITaxon>> children = taxonNode.getChildren();
                for (TreeNode<ITaxon> node : children) {
                    if (node.getElement().getTaxonRank().compareTo(ranklist.get(0)) == 0
                            && node.getElement().getName().toLowerCase()
                            .equals(ranknamelist.get(0).toLowerCase())) {
                        taxonNode = node;
                        break;
                    }
                }
            }
        }

        int j = 0;
        for (int i = 0; i < ranklist.size(); i++) {
            if (j == 0) {  //for root node
                while ((i < ranklist.size()) && (taxonNode.getElement().getTaxonRank().compareTo(ranklist.get(i)) < 0)) {
                    i++;
                }
                if (i == ranklist.size()) {
                    return null;
                }
                if (taxonNode.getElement().getTaxonRank().compareTo(ranklist.get(i)) != 0 || !taxonNode.getElement().getName().toLowerCase().equals(ranknamelist.get(i).toLowerCase())) {
                    return null;
                } else {
                    j++;
                }
            } else {
                List<TreeNode<ITaxon>> children = taxonNode.getChildren();
                for (TreeNode<ITaxon> node : children) {
                    if (node.getElement().getTaxonRank().compareTo(ranklist.get(i)) == 0
                            && node.getElement().getName().toLowerCase()
                            .equals(ranknamelist.get(i).toLowerCase())) {
                        taxonNode = node;
                        break;
                    }
                }
                j++;
            }
        }
        return taxonNode;
    }

    /**
     * Add a sub-taxon as one of the children of the parent taxon specified.
     *
     * @param parentName The name of the parent taxon to add sub as a child of.
     * @param sub The sub-taxon.
     * @throws Exception If no taxon with parentName exists in the hierarchy.
     * @throws SubTaxonException
     */
    public void addSubTaxon(String parentName, TaxonRank parentRank, ITaxon sub) throws Exception, SubTaxonException {
        TreeNode<ITaxon> exist_taxon = findTaxonByName(sub.getName(), sub.getTaxonRank());
  //      if (exist_taxon == null) {  ////check if there is already node in the tree, ignor the files if it is not the first on encountered.
            TreeNode<ITaxon> parent = findTaxonByName(parentName, parentRank);
            if (parent == null) {
                throw new Exception("Parent: " + parentName + " does not exist in hierarchy!");
            } else {
                if (parent.getElement().getTaxonRank().compareTo(sub.getTaxonRank()) > 0) {
                    parent.addChild(new TreeNode<ITaxon>(sub));
                } else {
                    throw new SubTaxonException(sub, parent.getElement());
                }
            }
  //      }
    }

    /**
     * Perform a BFS to find the TreeNode with a Taxon element matching the
     * specified name.
     *
     * @param name
     * @param rank The rank of the taxon we're looking for.
     * @return Matching node, if found, null otherwise.
     */
    public TreeNode<ITaxon> findTaxonByName(String name, TaxonRank rank) {
        Deque<TreeNode<ITaxon>> queue = new LinkedList<TreeNode<ITaxon>>();
        queue.add(hierarchy.getRoot());
        while (!queue.isEmpty()) {
            TreeNode<ITaxon> node = queue.poll();
            if (node.getElement().getName().equals(name)
                    && node.getElement().getTaxonRank().equals(rank)) {
                return node;
            }
            for (TreeNode<ITaxon> child : node.getChildren()) {
                queue.add(child);
            }
        }
        return null;
    }

    /**
     * Returns an iterator of nodes only at taxonomic rank specified by
     * rankName.
     *
     * @param rankName
     * @return
     */
    public Iterator<TreeNode<ITaxon>> rankIterator(String rankName) {
        List<TreeNode<ITaxon>> nodeList = new ArrayList<TreeNode<ITaxon>>();
        Iterator<TreeNode<ITaxon>> iter = this.hierarchy.iterator();
        while (iter.hasNext()) {
            TreeNode<ITaxon> node = iter.next();
            if (node.getElement().getTaxonRank().toString().equals(rankName)) {
                nodeList.add(node);
            }
        }
        return nodeList.iterator();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((hierarchy == null) ? 0 : hierarchy.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TaxonHierarchy)) {
            return false;
        }
        TaxonHierarchy other = (TaxonHierarchy) obj;
        if (hierarchy == null) {
            if (other.hierarchy != null) {
                return false;
            }
        } else if (!hierarchy.equals(other.hierarchy)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TaxonHierarchy [hierarchy=" + hierarchy + "]";
    }

    public void printSimple() {
        Iterator<TreeNode<ITaxon>> iter = hierarchy.iterator();
        while (iter.hasNext()) {
            ITaxon element = iter.next().getElement();
            System.out.println(element.getName() + " " + element.getTaxonRank().toString());
        }
    }
}
