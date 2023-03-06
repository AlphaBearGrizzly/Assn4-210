package assn04;
//credit to dr ghani's code

import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}


	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		// one traverses i suppose through the Getters?
		//element here works as a cur basically
		int result = _element.compareTo(element);
		if (result <= 0) {     // insert on right, or if they are equal
			if (_right.isEmpty()) {
				_right = new NonEmptyBST<T>(element);
			} else {
				_right = _right.insert(element);
			}
		} else if (result > 0) {            // insert on left
			if (_left.isEmpty()) {
				_left = new NonEmptyBST<T>(element);
			} else {
				_left = _left.insert(element);
			}

		}

		// if result = 0,inserting with euivalence to root
		return this;
	}


	// TODO: remove
	@Override
	public BST<T> remove(T element) {
// deleting function below
		deleteGivenNode(element);         // helper fun. Deletes specific node.
	}

	void deleteGivenNode(T element) {            // helper fun. Deletes specific node. Does this give us a memory location?
		if ((_left == null) && (_right == null)) {  // case 1. leaf
			_element = null;
		} else if ((_left == null)) {  // case 2a. node to delete only has a right child
			_element = _right;
		} else if ((_right == null)) {  // case 2b. node to delete only has a left child
			_element = _left; //This is reassigns so that _element disappears!
		} else {   // case 3. node has 2 children. Lets use successor from right.
			BST<T> successor = findMinNode(_right);
			element = successor;
			deleteGivenNode(successor); //here our recursion
		}
	}



	BST<T> findMinNode(successorFinder) {    // returns smallest node in tree starting at node
		if (_left == null) {
			return (node);
		} else {
			return (findMinNode(_left));
		}
		return this;
	}


// recalling the function ONTHATBST enables us to move along
		// Deleting function above






	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {

		// Needs to go from root (_element), and print each left, then start from the nearest split, and work down the right side,
		// until exhausted (ie equals null)
		}





	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {



	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {

		// goes all the way downtheleft side, then starting with leaf ends, does each _left and _right


	}

	// GetHeight of A Tree

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}


	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}
