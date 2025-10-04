package work;

// Child class B that extends abstract class A
public class ClassB extends ClassA {
    
    // Implementation of abstract method
    @Override
    public void abstractMethod() {
        System.out.println("This is the implementation of abstract method in ClassB");
    }
    
    public static void main(String[] args) {
        // Create object of ClassB
        ClassB obj = new ClassB();
        
        // Call abstract method
        obj.abstractMethod();
        
        // Call regular method from parent class
        obj.regularMethod();
    }
}
