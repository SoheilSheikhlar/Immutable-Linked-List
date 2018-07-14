
public class Node<T extends Comparable<T>> implements Comparable <Node<T>> {
	
	final T value;
	final Node<T> next;
	
	
	Node(T input, Node<T> next){
		this.value= input;
		this.next= next;
	}
	
	Node(T input){
		this(input,null);
		
	}
	
	Node(){
		this(null);
	}
	@Override
	public int compareTo(Node<T> input) {
		return this.value.compareTo(input.value);
	}
}
