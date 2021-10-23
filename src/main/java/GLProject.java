

public class GLProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("It works");
		GenericQueue<Integer> q = new GenericQueue<Integer>(25);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.print();
		for(Integer x : q){
			System.out.println(x);
		}
	}
}
