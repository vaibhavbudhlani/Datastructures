interface A { void show();}

interface B { void show();}

public class Indus implements A,B{

    public static void main(String[] args) {
       A a = new Indus();
       B b = new Indus();

       Indus indus = new Indus();
       a.show();
       b.show();
       indus.show();
       while(true){
           System.out.println("Stack Overflow");
       }


    }

    @Override
    public void show() {
        show();
        System.out.println("Inside C");
    }
}
