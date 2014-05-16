public class TestString  {
    public static void main(String[] args) {

        String s = "asdfff";
        char[] ch = s.toCharArray();

        String r = ""+Character.toUpperCase(ch[0]);
        System.out.println(r);
        // System.Out.println(ch.toString());
    }
}
