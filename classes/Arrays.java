import static java.lang.System.out;
class Arrays {
  public static void main(String args[]) {
    String var1[][] = new String[3][2]; // requires a dimension
    var1[0] = new String[]{"lala"};
    var1[2] = new String[2];
    out.println("var1 = " + var1);
    out.println("var1.class = " + var1.getClass());

    int var2[] = {1,2};
    out.println("var2.class = " + var2.getClass());
  }
}
