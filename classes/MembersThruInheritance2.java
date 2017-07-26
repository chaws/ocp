package classes;
/*
  This file continues to explore MembersThryInheritance 
*/

class OtherFileNotExtending {
  void m(){
    Super s = new Super();
    s.a = 1; // OK
    s.b = 1; // OK
    s.c = 1; // OK
    s.d = 1; // NOT OK, private in Super
    s.e = 1; // OK
    s.f = 1; // OK
    s.g = 1; // OK
    s.h = 1; // NOT OK, private in Super
  }
}

class OtherFileExtending extends Super {
  void m() {
    a = 1; // OK
    b = 1; // OK
    c = 1; // OK
    d = 1; // NOT OK, private in Super
    e = 1; // OK
    f = 1; // OK
    g = 1; // OK
    h = 1; // NOT OK, private in Super
  }
}
