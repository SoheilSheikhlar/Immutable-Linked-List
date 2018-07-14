import java.util.Scanner;

public class Queue<T extends Comparable<T>> {
	final ImmutableLinkedList myList;
	Scanner input = new Scanner(System.in);
	Queue(ImmutableLinkedList input){
		this.myList=input;
	}
	public Queue enQueue(T input){
		return new Queue(myList.addToEnd(input));
	}
	public Queue deQueue(){
		return new Queue(myList.removeFirst());
	}
	public T atIndex(int i){
		T[] result=myList.toArray(myList);
		while( i >= result.length || i<0) {
			System.out.println("invalid index, type valid index");
			i= input.nextInt();
		}
		return result[i];
	}
	
	
	public int size(){
		return myList.size;
	}
	
	public boolean isEmpty(){
		if(myList.getFirst() != null) {
			return false;
		}
		else return true;
		
	}
	public Queue Empty(){
		return new Queue(new ImmutableLinkedList());
}
}
