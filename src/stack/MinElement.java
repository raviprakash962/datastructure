package stack;

public class MinElement {
	public static void main(String[] args) {
		
		SpecialStack s = new SpecialStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.getMin());
         System.out.println("----");
        s.push(5);
        s.push(5);
        s.push(10);
        System.out.println(s.getMin());
        
        System.out.println("---------");
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.getMin());
        
       int poped= s.pop();
       System.out.println(" poped value"+ poped);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        
	}

}
