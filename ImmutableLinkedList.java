import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ImmutableLinkedList<T extends Comparable<T>> implements Iterable<T> {       
	 
	final Node<T> head;
	final int size;
	
	ImmutableLinkedList(T[] input){
		
		this.size = input.length;
		head= new Node(null,helper(input));
	}
	
	private Node<T> helper(T[] input) {
		
		if(input.length==1) { return new Node(input[0] , null); }
		
		else return new Node(input[0] , helper(Arrays.copyOfRange(input, 1, input.length)));
		
	}
	ImmutableLinkedList(T input){
		this.head = new Node(null,new Node(input));
		this.size=1;
		
	}
	ImmutableLinkedList(){
		this.head=new Node();
		this.size=1;
	}
	public T getFirst() {//gives the value of first node after head because head is null
		return this.head.next.value;
	}
	
	public ImmutableLinkedList<T> removeFirst() {
		
		return new ImmutableLinkedList(Arrays.copyOfRange(ImmutableLinkedList.toArray(this), 1, this.size));
	}
	
	public ImmutableLinkedList<T> removeLast() {
		
		return new ImmutableLinkedList(Arrays.copyOfRange(ImmutableLinkedList.toArray(this), 0, this.size-1));
	}
	
	public ImmutableLinkedList addToFront(T input) {												
		
		return concat(new ImmutableLinkedList(input), this);
	}
	public ImmutableLinkedList addToEnd(T input) {
		
		return concat(this , new ImmutableLinkedList(input));
	}
	//toArray
	public static <T extends Comparable<T>> T[] toArray(ImmutableLinkedList mylist) {
		T[] result = (T[]) Array.newInstance(mylist.getFirst().getClass(), mylist.size);
		Node<T> tempNode = mylist.head;
		for(int i=0; i< mylist.size; i++) {
			tempNode= tempNode.next;
			result[i]= tempNode.value;
			
		}
		return result;
		
	}
	@Override
	public Iterator<T> iterator() {
		ArrayList<T> mylist= new ArrayList<>(Arrays.asList((T[]) ImmutableLinkedList.toArray(this)));
		return mylist.iterator();
		
	} 
	private static<T extends Comparable<T>> ImmutableLinkedList concat(ImmutableLinkedList myList1, ImmutableLinkedList myList2) {
		
		T[] result= (T[]) Array.newInstance(myList1.getFirst().getClass(), myList1.size + myList2.size);
		Node<T> tempNode = myList1.head;
		for(int i=0; i<myList1.size ; i++) {
			tempNode=tempNode.next;
			result[i] = tempNode.value;
			
		}
		tempNode= myList2.head;
		for(int i=0; i<myList2.size; i++) {
			tempNode= tempNode.next;
			result[i+myList1.size] = tempNode.value;
			
			
		}
		return new ImmutableLinkedList(result);
	}
	
}
            










