package com.prac.treesAndGraphs;

public class BinaryTree<E> {
	
	public static class Node<E>{
		E data;
		Node<E> left;
		Node<E> right;
		
		Node(E data, Node<E> left,Node<E> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	Node<E> root;
	
	public void add(E data){
		if(root == null){
			root = new Node<E>(data, null, null);
		}else{
			if(root.left == null){
				root.left = new Node<E>(data, null, null);
			}else if(root.right == null){
				root.right = new Node<E>(data, null, null);
			}else{
				insert(data,root.left);
			}
		}
	}
	
	public void insert(E data, Node<E> node){
		if(node == null){
			node = new Node<E>(data,null,null);
		}else{
			if(node.right == null){
				insert(data,node.right);
			}else{
				insert(data,node.left);
			}
		}
	}
	
	/*public void add(E data){
		if(data == null){
			System.out.println("Data you've entered is NULL. Please add legit data.");
			return;
		}
		Node<E> current = new Node<E>(data, null, null);
		if(root == null){
			root = current;
		}else{
			if(root.left == null){
				root.left = current;
			}else if(root.right == null){
				root.right = current;
			}else{
				
			}
		}
	}
	
	private boolean addNode(Node<E> current , Node<E> parent){
		if(!isCompleteNode(parent)){
			if(parent.left == null){
				parent.left = current;
				return true;
			}else{
				parent.right = current;
				return true;
			}
		}else{
			boolean isAdded = addNode(current , parent.left);
			if(!isAdded){
				isAdded = addNode(current , parent.left);
			}
			return isAdded;
		}
	}
	
	public void insert(){
		
	}
	
	private boolean isCompleteNode(Node<E> root){
		if((root.left != null && root.right != null) || (root.left== null && root.right == null))
			return true;
		else
			return false;
	}
*/
}
