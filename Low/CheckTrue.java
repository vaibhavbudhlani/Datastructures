public class CheckTrue {

    public static void main(String[] args) {
        boolean a= false; // P
        boolean b = false; // CU
        boolean c= true; // Vc
        System.out.println(giveAnswer(a,b,c));
    }

    enum Persons{
        P,V,M
    }


    public static String giveAnswer(boolean a,boolean b, boolean c) {
//        if(a && b && c){
//            return "Vaibhav";
//        }
//        else return c ?"Garima":"chintu";
//
//    }
        return String.valueOf(Persons.P);
    }
}
