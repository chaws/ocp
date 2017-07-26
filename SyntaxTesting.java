import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;
import static java.lang.System.out;

public class SyntaxTesting {
  static int var1;

  public static void main(String args[]) {
  
    // Labels are allowed anywhere, which is cool 
    PrimitiveVars: {
      final long[] var1 = {0};
      final long var2[] = {0};
      int var3, var4;
      // var3 = 1, var4 = 1; // DOES NOT COMPILE, one statement per line only

      // char var5 = 300; DOES NOT COMPILE: need to be from -128 to 127
      // short var6 = 70000; DOES NOT COMPILE: need to be less than 65546, idk the correct value
      // long var7 = 3000000000; DOES NOT COMPILE: need to add the character 'L' to the end of the number
      // float var7_1 = 1.2; // DOES NOT COMPILE: need to  be literal float, add character 'F' to the end of the number
      long var7 = 3000000000L;
      long var7_2 = 300;

      int var8 = 017;
      char var9 = 0xF;
      short var10 = 0b10;

      double var11 = 1_0_0_0_0.0_0_0_0;
      
      // int []var12 = new int[-1]; DOES NOT COMPILE: -1 is negative array size
      // THERE IS NOT UNSIGNED INTEGERS IN JAVA =/
      // int var13 = 1U; DOES NOT COMPILE: because there's no unsigned primitive integers in java
    }

    PrimitiveWrappers: {
      out.println("PrimitiveWrappers:");
      int var1 = Integer.parseInt("+1"); out.println("var1 = " + var1);
      int var2 = Integer.parseInt("-1"); out.println("var2 = " + var2);
      // int var3 = Integer.parseInt("108D"); out.println("var3 = " + var3); THROWS NUMBERFORMATEXCEPTION
      int var4 = Integer.parseInt("108D", 14); out.println("var4 = " + var4);

      double var5 = Double.parseDouble("108D"); out.println("var5 = " + var5);
      double var6 = Double.parseDouble("108"); out.println("var6 = " + var6);
      double var7 = Double.parseDouble("NaN"); out.println("var7 = " + var7);
      double var8 = Double.parseDouble("Infinity"); out.println("var8 = " + var8);
      // double var9 = Double.parseDouble("10lalala"); out.println("var9 = " + var9); THROWS NUMBERFORMATEXCEPTION
      double var10 = Double.parseDouble(".10"); out.println("var10 = " + var10);
      out.println("var11 = " + Double.parseDouble(".10"));
      out.println("var12 = " + Double.parseDouble(".10E10"));
      // out.println("var13 = " + Double.parseDouble("10e2.10E10")); THROWS NUMBERFORMATEXCEPTION due to 'e' appear twice
      out.println("var13 = " + Double.parseDouble("0X3.p3"));
    }
    
    GenericsAndDiamond: {
      Map<Map<String, String>, List<String>> var1 = new HashMap<>();
      // Map<Map<String, String>, List<String>> var2 = new HashMap<Map<>, List<>>(); // DOES NOT COMPILE
      // Map<  Map<?, ?>, List<?> > > var3 = new HashMap<HashMap<String, String>, List<String>>(); // DOES NOT COMPILE
      Map<?,?> var4 = new HashMap<HashMap<String, String>, List<String>>();
      List<?> var5 = new ArrayList<String>();
    }

    Labels: {
      // break; // DOES NOT COMPILE
      int var1;
      OneStatementLabel: var1 = 1;
      //MultilineStatementLabel: { int var1; }

      ForLoopBreak:
      {
        out.println("ForLoopBreak:");
        for(int i = 0; i < 2; i++)
        {
          out.println("\tin-ForLoopBreak: " + i);
          ForLoopBreak1: {
            out.println("\tForLoopBreak1");

            ForLoopBreak2: {
              out.println("\t\tForLoopBreak2");
              break ForLoopBreak1;
            }
            // out.println("\tForLoopBreak1_end"); // DOES NOT COMPILE: unreachable statement
          }
          break ForLoopBreak;
        }
        out.println("end-ForLoopBreak:");
      }

      out.println("ForLoopContinue:");
      ForLoopContinue:
      for(int i = 0; i < 2; i++)
      {
        out.println("\tin-ForLoopContinue: " + i);
        continue ForLoopContinue; // Will jumb to line of ForLoopContinue, but NOT reset constructor
      }
      out.println("end-ForLoopContinue:");
    }
 
    Switch: {
      String var1 = "myStr";
      String var2 = "Str";
      switch(var1)
      {
        case "value1":
	  out.println("reached 1");
	  break;
	case "myStr":
	  out.println("yay, found it!");
	case "value2":
	  out.println("reached 2");
	// case 3: DOES NOT COMPILE: datatypes must be the same
	//   out.println("wow, this shouldn't happen");
	default:
	  out.println("default");
      }

      // long var3 = 3; DOES NOT COMPILE: char, short, and int allowed here
      // switch(var3){}
      // float var4 = 1.2f;
      // switch(var4){ default:; }
    }

    TernaryIf: {
      int a = 10;
      int b = a > 10 ? -1 : a < 10 ? 1 : 0;
      out.println("TernaryIf: b = " + b);
    }

    Loops: {
      
      for(int i : Arrays.asList(1,2,3));
    }

    Formats: {
      out.println("Formats");
      double var1 = 1234567.437;
      out.println(new DecimalFormat("###,###,###.###").format(var1));
      out.println(new DecimalFormat("#-#lala#.###").format(var1));
      out.println(new DecimalFormat("-###.###").format(var1));
      out.println(new DecimalFormat("R$###.##").format(var1));
      out.println(new DecimalFormat("R$-###.##").format(var1));
      // out.println(new DecimalFormat("R$-###.##.###.####.##").format(var1)); THROWS IligalArgumentException cuz of multiple decimal points
      out.println(new DecimalFormat("R$-#,#,#.##").format(var1));
      // out.println(new DecimalFormat("R$-#,0#,#.##").format(var1)); THROWS IllegalArgumentException cuz it's mixing 0 and #
      out.println(new DecimalFormat("lalaa-#,#,#.##").format(var1));
    }
  }

  public static void supportMethod() {
    OtherMethodLabel: ;
  }
}

abstract class AbstractClass {
}
