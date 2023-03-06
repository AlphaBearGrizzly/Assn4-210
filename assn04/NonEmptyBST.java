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
		T.compareTo
		if (_element < _left) {     // insert on right
				if (_right == null) {
					_right = insert(T);
				} else {
					insert(T);
				}
			}
			else {                // insert on left
				if (_left == null) {
					_left = insert(T);
				} else {
					insert(T);
				}
			}
		return BST<T>;
		}



	// TODO: remove
	@Override
	public BST<T> remove(T element) {
// deleting function below
		deleteGivenNode(T element);         // helper fun. Deletes specific node.
	}

	void deleteGivenNode(T element) {            // helper fun. Deletes specific node
		if ((_left == null) && (_right == null)) {  // case 1. leaf
			changeChild(element, null);
		} else if ((_left == null)) {  // case 2a. node to delete only has a right child
			changeChild(element, _right);
		} else if ((_right == null)) {  // case 2b. node to delete only has a left child
			changeChild(node, node._leftChild);
		} else {   // case 3. node has 2 children. Lets use successor from right.
			Node successor = findMinNode(node._rightChild);
			node._value = successor._value;
			deleteGivenNode(successor);
		}
	}

	void changeChild(Node currentChild, Node newChild){    // changes parent to point at new child
		if (currentChild._parent == null) {
			_root = newChild;
			if (newChild != null) {
				newChild._parent = null;
			}
		}
		else if (currentChild._parent._leftChild == currentChild) {
			currentChild._parent._leftChild = newChild;
			if (newChild != null) {
				newChild._parent = currentChild._parent;
			}
		}
		else if (currentChild._parent._rightChild == currentChild) {
			currentChild._parent._rightChild = newChild;
			if (newChild != null) {
				newChild._parent = currentChild._parent;
			}
		}
		else {
			System.out.println("Exception error in method 'changeParent'");
		}
	}

	Node findMinNode(Node node){    // returns smallest node in tree starting at node
		if (node._leftChild == null)  {
			return (node);
		}
		else {
			return (findMinNode(node._leftChild));
		}
	}


		// Deleting function above






	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		traversingMethod();
		public void traversingMethod(){
			//
		System.out(_element);
			if(_left != null){
				_element =  _left;
				System.out(_element);
				traversingMethod;
			}
			//now we are at the bottom
			if(_left == null){
				System.out()
			}
			System.out()
		}



	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {



	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {




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
