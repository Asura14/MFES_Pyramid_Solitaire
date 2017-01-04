package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestAll extends MyTestCase {
  public static void main() {

    CardTest boardTest = new CardTest();
    SolitaireTest solitaireTest = new SolitaireTest();
    boardTest.runTests();
    solitaireTest.runTests();
  }

  public TestAll() {}

  public String toString() {

    return "TestAll{}";
  }
}
