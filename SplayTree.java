import java.util.Comparator;


public class SplayTree<T extends Comparable<T>> 
		extends BinarySearchTree<SplayTree.Node<T>,T> {

	protected static class Node<T> extends BinarySearchTree.BSTNode<Node<T>,T> {	}
	
	public SplayTree(Comparator<T> c) {
		super(new Node<T>(), c);
	}
	
	public SplayTree() {
		this(new DefaultComparator<T>());
	}

	public void splay(Node<T> u) {
		if(u != this.r){
			Node<T> p = u.parent;
			Node<T> g = null;
			if(p.parent != nil)
				g = p.parent;
			
			//Three steps
			//p is the root - Zig
			if(p == this.r && p.left == u){
				this.rotateRight(p);
				this.r = u;
			}
			else if(p == this.r && p.right == u){
				this.rotateLeft(p);
				this.r = u;
			}
			
			//p is not the root and u and p are either both right children or are both left children - Zig Zig
			else if( p != this.r && (g.left == p && p.left == u)){
				this.rotateRight(g);
				this.rotateRight(p);
				this.splay(u);
			}
			else if( p != this.r && (g.right == p && p.right == u)){
				 this.rotateLeft(g);
				 this.rotateLeft(p);
				 this.splay(u);
			}
			
			//p is not the root and u is a right child and p is a left child or vice versa - Zig Zag
			else if( p != this.r && (g.left == p && p.right == u)){
				this.rotateLeft(p);
				this.rotateRight(g);
				this.splay(u);
			}
			else if( p != this.r && (g.right == p && p.left == u)){
				this.rotateRight(p);
				this.rotateLeft(g);
				this.splay(u);
			}
		}
	}

	public boolean remove(T x){
		Node<T> u = super.findLast(x);
		if(c.compare(u.x,x)==0){
			Node<T> toSplay = u.parent;
			super.remove(u);
			
			if(toSplay!=nil){
				splay(toSplay);
			}
			
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean add(T x) {
		Node<T> u = newNode(x);
		if (!super.add(u)) return false;
		splay(u);
		return true;
	}
	
	public T find(T x) {
		Node<T> u = super.findLast(x);
		if (u != null) 
			splay(u);
		return u != null && u.x.equals(x) ? x : null;
	}
	
}