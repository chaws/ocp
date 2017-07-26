class DefaultConstructor {
  public DefaultConstructor(int a) {}

  public static void main(String args[]) {
    // DefaultConstructor d = new DefaultConstructor(); // NOT OK, once there's Constructor implementation, then thedefault one
    // is never created, thus preventing the use  of default constructors
    DefaultConstructor d = new DefaultConstructor(1);
  }
}
