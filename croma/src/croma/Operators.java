package croma;

public class Operators {

	public static void main(String[] args) {
		int a=10;
		System.out.println(a++);// postfix
		System.out.println(--a); //prefix
		System.out.println(a++);
		System.out.println(a--);
		System.out.println("a= "+a);
		int f;
		f=a+10*3;
		System.out.println(f);
        if(f<40) {
        	f=f*5;
        	System.out.println("I am right "+f);
        	System.out.println(f);
        }
        
        else if(f>20) {
        	f=f/2;
        	System.out.println(f+"=k");
        }
        else {
        	System.out.println("m wrong");
        }
	}

}
