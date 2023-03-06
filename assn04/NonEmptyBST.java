package assn04;


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
		while(_right != null  && _left != null){
			if (T >= _element){
				_element = getRight();
			}
			if (T < _element){
				_left = T;
				_element = getLeft();
			}
		}
		if(_right == null && _left != null){

		}
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {

	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {


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
