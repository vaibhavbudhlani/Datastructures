abstract class Bird{
    private String birdName;


    public Bird(String birdName){
        this.birdName= birdName;
        System.out.println("I am Awesome inside parameter");
    }

    public abstract String printVaibhav();

    public Bird(){
        System.out.println("I am inside Bird");
    }
    private String getAnswer(){
        return "Abc";
    }
}

interface Reptiles {
    public String printVaibhav();
}

public class AbstractClassDemo  {
//    public AbstractClassDemo(){
//        super("Vaibhav");
//
//    }
    public static void main(String[] args) {
       AbstractClassDemo demo = new AbstractClassDemo();
        Reptiles rept = ()-> "I am awesome";
        System.out.println(rept.printVaibhav());
    }
}
