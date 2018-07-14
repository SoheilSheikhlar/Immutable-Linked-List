import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;

public class Stack<T extends Comparable<T>> {
	
	final ImmutableLinkedList myList; 
	
	
	Scanner input = new Scanner(System.in);//used in line 31 to control input
	Stack(ImmutableLinkedList input){
		this.myList= input;
		
	}
	
	
	public Stack push(T input){
		return new Stack(myList.addToFront(input));
	}
	public Stack pop(){
		return new Stack(myList.removeFirst());
	}
	public T peek(){
		return  (T) myList.getFirst(); 
	}
	public T atIndex(int i){
																		 
		T[] result= myList.toArray(myList);
		while( i >= result.length || i<0) {
			System.out.println("invalid index, type valid index");
			i= input.nextInt();
		}
		return result[i];
		
	}
	public int size(){
		T[] result=myList.toArray(myList);
		return result.length;
		
	}
	public boolean isEmpty(){
		if(myList.getFirst() != null) {
			return false;
		}
		else return true;
		
		/*T[] result=myList.toArray(myList);
		for(int i=0; i< result.length; i++) {
			if(result[i] != null) {
				return false;
			}
			
		}
		return true;*/
	}
	public Stack empty(){
		
		return new Stack(new ImmutableLinkedList());
		//return new Stack(new ImmutableLinkedList((T[]) Array.newInstance(this.myList.getFirst().getClass(), myList.size)));
		 
	}
}
