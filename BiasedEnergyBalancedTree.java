import java.lang.reflect.Array;
import java.util.Comparator;


public class BiasedEnergyBalancedTree <T extends Comparable<T>> 
extends BinarySearchTree<BiasedEnergyBalancedTree.Node<T>,T> {

	protected static class Node<T> extends BinarySearchTree.BSTNode<Node<T>,T> {	
		int p;
		int a;
		int A;
		int size = 1;
	}

	public BiasedEnergyBalancedTree(Comparator<T> c) {
		super(new Node<T>(), c);
	}

	public BiasedEnergyBalancedTree() {
		this(new DefaultComparator<T>());
	}

	public boolean insertTest(T x){
		Node<T> parent = super.findLast(x);
		boolean rebuild = false;
		Node<T> rebuildOn = null;

		if(parent == nil){
			Node<T> newNode = new Node<T>();
			newNode.x = x;
			newNode.parent = parent;
			this.r = newNode;

			//TODO: check these values
			newNode.p = 0;
			newNode.a = 0;
			newNode.A = 0;

			this.n++;


			return true;
		}
		else if(c.compare(parent.x, x) == 0){
			return false;
		}
		else{
			
			Node<T> temp = parent;
			temp.a++;
			while(true){
				//temp.p++;
				temp.size++;
				temp.A++;

				if(temp.p > temp.A/4){
					rebuild = true;
					rebuildOn = temp;
				}

				if(temp.parent == nil)
					break;
				temp = temp.parent;
			}

			Node<T> newNode = new Node<T>();
			newNode.x = x;
			newNode.parent = parent;

			newNode.p = 0;
			newNode.a = 0;
			newNode.A = 0;

			if(c.compare(x, parent.x) < 0)
				parent.left = newNode;
			else if(c.compare(x, parent.x) > 0)
				parent.right = newNode;
			else
				return false;

			this.n++;
			
			if(rebuild)
				rebuildTree(rebuildOn);

			return true;
		}
	}
	
	public boolean insert(T x){
		Node<T> parent = super.findLast(x);
		boolean rebuild = false;
		Node<T> rebuildOn = null;

		if(parent == nil){
			Node<T> newNode = new Node<T>();
			newNode.x = x;
			newNode.parent = parent;
			this.r = newNode;

			//TODO: check these values
			newNode.p = 0;
			newNode.a = 1;
			newNode.A = 1;

			this.n++;


			return true;
		}
		else if(c.compare(parent.x, x) == 0){
			return false;
		}
		else{
			Node<T> temp = parent;
			while(true){
				temp.p++;
				temp.size++;
				temp.A++;

				if(temp.p > temp.A/4){
					rebuild = true;
					rebuildOn = temp;
				}

				if(temp.parent == nil)
					break;
				temp = temp.parent;
			}

			Node<T> newNode = new Node<T>();
			newNode.x = x;
			newNode.parent = parent;

			newNode.p = 0;
			newNode.a = 1;
			newNode.A = 1;

			if(c.compare(x, parent.x) < 0)
				parent.left = newNode;
			else if(c.compare(x, parent.x) > 0)
				parent.right = newNode;
			else
				return false;

			this.n++;

			if(rebuild)
				rebuildTree(rebuildOn);

			return true;
		}
	}

	public boolean removeTest(T x){
		Node<T> u = findLast(x);
		boolean rebuild = false;
		Node<T> rebuildOn = null;

		if (u != nil && c.compare(x,u.x) == 0) {
			int a = u.a;

			Node<T> temp = removeInternal(u);
			if(temp!=nil)
				temp.a++;
			while(temp!=nil){
				temp.p += a;
				temp.size--;
				temp.A++;

				if(temp.p > temp.A/4){
					rebuild = true;
					rebuildOn = temp;
				}

				temp = temp.parent;
			}
			if(rebuild){
				rebuildTree(rebuildOn);
			}
			return true;
		}
		return false;
	}
	
	public boolean remove(T x){
		Node<T> u = findLast(x);
		boolean rebuild = false;
		Node<T> rebuildOn = null;

		if (u != nil && c.compare(x,u.x) == 0) {
			int a = u.a;

			Node<T> temp = removeInternal(u);
			while(temp!=nil){
				temp.p += a;
				temp.size--;

				if(temp.p > temp.A/4){
					rebuild = true;
					rebuildOn = temp;
				}

				temp = temp.parent;
			}
			if(rebuild){
				rebuildTree(rebuildOn);
			}
			return true;
		}
		return false;
	}
	
	protected Node<T> spliceInternal(Node<T> u) {
		Node<T> s, p;
		if (u.left != nil) {
			s = u.left;
		} else {
			s = u.right;
		}
		if (u == r) {
			r = s;
			p = nil;
			return nil;
		} else {
			p = u.parent;
			if (p.left == u) {
				p.left = s;
			} else {
				p.right = s;
			}
		}
		if (s != nil) {
			s.parent = p;
		}
		n--;

		return p;
	}
	
	/**
	 * Remove the node u from the binary search tree
	 * @param u
	 */
	protected Node<T> removeInternal(Node<T> u) {
		if (u.left == nil || u.right == nil) {
			return spliceInternal(u);
		} else {
			Node<T> w = u.right;
			while (w.left != nil) 
				w = w.left;
			u.x = w.x;
			return spliceInternal(w);
		}
	}

	public Node<T> search(T x){
		Node<T> u = super.findLast(x);
		boolean rebuild = false;
		Node<T> rebuildOn = null;

		if(u.x == x){
			u.a++;
			Node<T> temp = u;

			while(true){
				temp.p++;
				temp.A++;

				if(temp.p > temp.A/4){
					rebuild = true;
					rebuildOn = temp;
				}

				if(temp.parent == nil)
					break;
				temp = temp.parent;
			}

			
			if(rebuild){
				rebuildTree(rebuildOn);
			}

			return u;
		}
		return nil;
	}



	void rebuildTree(Node<T> u)
	{
		int ns = u.size;
		Node<T> p = u.parent;
		Node<T>[] a = (Node<T>[])Array.newInstance(Node.class, ns);
		packIntoArray(u, a, 0);

		int[] avArray = getAv(a);
		if (p == nil) {
			r = buildBalanced(a, avArray, 0, a.length-1, ns);
			r.parent = nil;
		} else if (p.right == u) {
			p.right = buildBalanced(a, avArray, 0, a.length-1, ns);
			p.right.parent = p;
		} else {
			p.left = buildBalanced(a, avArray, 0, a.length-1, ns);
			p.left.parent = p;
		}

	}
	int[] getAv(Node<T>[] b)
	{ 

		int[] arrayToReturn = new int[b.length];
		int sum = 0;
		for (int i = 0; i < b.length; i++)
		{

			arrayToReturn[i] = sum + b[i].a;
			sum = arrayToReturn[i];

		}	
		return arrayToReturn;



	}
	int packIntoArray(Node<T> u, Node<T>[] a, int i) {
		if (u == null) {
			return i;
		}
		i = packIntoArray(u.left, a, i);
		a[i++] = u;
		return packIntoArray(u.right, a, i);
	}

	Node<T> buildBalanced(Node<T>[] a, int[] avTotal, int imin, int imax, int ns) {

		Node<T> newNode;

		if(ns==0)
		{
			newNode = null;
			return newNode;
		}
		else
		{
			int s = imin-1;
			int h;
			int Av;
			int x;
			if(s<0)
			{	
				Av = avTotal[imax];
				h = Av/2;
				x = findRoot(avTotal, h, imin, imax, 0);	
			}
			else
			{
				Av = avTotal[imax] - avTotal[s];
				h = Av/2;
				x = findRoot(avTotal, h, imin, imax, avTotal[s]);	
			}

			if (x==imin)
			{
				newNode = a[x];
				newNode.A = Av;
				newNode.p = 0;
				newNode.left = null;
				newNode.size = ns;					

				newNode.right = buildBalanced(a, avTotal, imin + 1, imax, (imax - imin));
				if (newNode.right!=null)
				{
					newNode.right.parent = newNode;
				}

			}
			else if (x>=imax)
			{
				newNode = a[imax];
				newNode.A = Av;
				newNode.p = 0;
				newNode.right = null;
				newNode.size = ns;					

				newNode.left = buildBalanced(a, avTotal, imin, imax - 1, (imax - imin));
				if (newNode.left!=null)
				{
					newNode.left.parent = newNode;
				}
			}
			else
			{

				newNode = a[x];
				newNode.A = Av;
				newNode.p = 0;
				newNode.size = ns;

				newNode.left = buildBalanced(a, avTotal, imin, x - 1, (x - imin));					
				newNode.right = buildBalanced(a, avTotal, x + 1, imax, (imax-x));

				if (newNode.left!=null)
				{
					newNode.left.parent = newNode;
				}
				if(newNode.right!=null)
				{
					newNode.right.parent = newNode;
				}
			}

		}
		return newNode;


	}

	int midpoint(int imin, int imax)
	{
		return (imin + imax)/2;
	}
	int findRoot(int[] A, int key, int imin, int imax, int reduce)
	{

		if (imax < imin)
			return imin;
		else
		{
			int imid = midpoint(imin, imax);

			if ((A[imid] - reduce) > key)
				return findRoot(A, key, imin, imid-1, reduce);
			else if ((A[imid] - reduce) < key)
				return findRoot(A, key, imid+1, imax, reduce);
			else
			{
				if(imid == A.length -1)
				{
					return imid;
				}
				return imid+1;
			}
		}
	}

	Node<T> checkSizes(Node<T> u){
		if(u!=nil){
		if(u.left == nil && u.right == nil){
			if(u.size == 1){
				return null;
			}
			else{
				return u;
			}
		}
		else if(u.left == nil && u.right != nil){
			return checkSizes(u.right);
		}
		else if(u.left != nil && u.right == nil){
			return checkSizes(u.left);
		}
		else{
			Node<T> n = checkSizes(u.left);
			Node<T> n2 = checkSizes(u.right);
			if(n != null)
				return n;
			else
				return n2;
		}
		}
		return null;
	}
	
	public static void main(String [] args){

		BiasedEnergyBalancedTree<Integer> t = new BiasedEnergyBalancedTree<Integer>();
		t.insert(10);
		t.insert(4);
		t.insert(5);
		t.insert(12);
		t.insert(11);
		
		
		t.search(10);
		t.search(10);
		t.search(10);
		t.search(5);
		//System.out.println(t.r.A);

		t.remove(10);
		t.remove(5);
		t.remove(4);
		System.out.println(t.r.size);

		/*Node<Integer> a = new Node<Integer>();
		a.a = 1;

		Node<Integer> b = new Node<Integer>();
		b.a = 3;

		Node<Integer> c = new Node<Integer>();
		c.a = 2;

		Node<Integer> d = new Node<Integer>();
		d.a = 6;

		Node<Integer> e = new Node<Integer>();
		e.a = 4;

		Node<Integer> f = new Node<Integer>();
		f.a = 7;

		Node<Integer> g = new Node<Integer>();
		g.a = 8;

		Node<Integer>[] ray1 = (Node<Integer>[])Array.newInstance(Node.class, 7);

		ray1[0] = a;
		ray1[1] = b;
		ray1[2] = c; 
		ray1[3] = d;
		ray1[4] = e;
		ray1[5] = f;
		ray1[6] = g;


		int[] ray2 = t.getAv(ray1);

		t.buildBalanced(ray1, ray2, 0, 0, 7);*/




	}

}
