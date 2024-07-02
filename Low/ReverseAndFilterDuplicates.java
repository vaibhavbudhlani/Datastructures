public class ReverseAndFilterDuplicates {
    public static void main(String[] args) {
        String s = "Vaibhav";
        String ans = "";

        s= s.toLowerCase();

        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) == i){
                ans += s.charAt(i);
            }
        }

        System.out.println(ans);

        StringBuilder sb = new StringBuilder(ans);
        System.out.println(sb.reverse().toString());
    }
}
