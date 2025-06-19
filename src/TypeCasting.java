public class TypeCasting {
    public static void main(String[] args) {

        //String to int
        String s1 = "10";
        int n1 = Integer.parseInt(s1);
        System.out.println(n1 + 10);

        //String to Integer
        Integer n2 = Integer.valueOf(s1);
        System.out.println(n2 * 10);
    }
}
