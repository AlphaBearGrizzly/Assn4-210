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
		if(!element.equals(_element)) {
			if(_element.compareTo(element) > 0 ){
				_right.remove(element);
			}
			else-if (this.getElement() < element ){
				this.getRight().remove(T element);
			})
			else-if (this.getElement() > element){
				this = this.getLeft().remove(T element);
			}
			else-if (this.getElement() < element ){
				this.getRight().remove(T element);
			}
		}
		if ((this.getLeft().isEmpty()) && (this.getRight().isEmpty())) {  // case 1. leaf
			return new EmptyBST<T>();
		} else if ((this.getLeft().isEmpty()) || (this.getRight().isEmpty())) {  // case 2a. node to delete only has a right child
			if(_left.isEmpty()){
				return _right;
			}
			if(_right.isEmpty()){
				return _left;
			}
		} else {   // case 3. node has 2 children. Lets use successor from right.
			BST<T> successor = findMinNode(this.getRight());
			this.getElement() = successor.getElement();
		}
	}
}



	BST<T> findMinNode(BST<T> thing) {    // returns smallest node in tree starting at node
		if (thing.getLeft().getElement() == null) {
			return (thing);
		} else {
			return (findMinNode(thing.getLeft()));
		}
	}




	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(this.getElement() + " ");
		if(!this.getLeft().isEmpty()){
			this.getLeft().printPreOrderTraversal();
		}
		if (!this.getRight().isEmpty()){
			this.getRight().printPreOrderTraversal();
		}
	} //yeet ligma





	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {



	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {

		// goes like a wave over each line, from left to right

		Queue<BST<T>> myQueue = new LinkedList<BST<T>>();
		BST<T> myCur;
		myQueue.add(this);
		while (myQueue.isEmpty() == false){
			myCur = myQueue.poll();
			if(myCur.getLeft().isEmpty() == false){
				myQueue.add(myCur.getLeft());
			}
			if(myCur.getRight().isEmpty() == false){
				myQueue.add(myCur.getRight());
			}

			System.out.print(myCur.getElement() + " ");
		}

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
