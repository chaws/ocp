class OperatorsPrecedence {
  public static void main(String args[]) {
    int a1 = 2, a2 = 4;
    int b = ++a1 * a2++ % 2 - 2 + 2 >> 1 << 2 | 0xFF & 0b1010101 ^ 0317;
    System.out.println("b = " + b);
    boolean c = true;
  }
}
