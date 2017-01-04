package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Card {
  private Number id;
  private Character suit;
  private Number value;

  public void cg_init_Card_1(final Number cardid, final Character nsuit, final Number nvalue) {

    id = cardid;
    suit = nsuit;
    value = nvalue;
    return;
  }

  public Card(final Number cardid, final Character nsuit, final Number nvalue) {

    cg_init_Card_1(cardid, nsuit, nvalue);
  }

  public Number getID() {

    return id;
  }

  public Character getSuit() {

    return suit;
  }

  public Number getValue() {

    return value;
  }

  public void printCard() {

    Boolean andResult_15 = false;

    if (value.longValue() < 11L) {
      if (value.longValue() > 1L) {
        andResult_15 = true;
      }
    }

    
    if (andResult_15) {
      System.out.print(value);
      System.out.printf("%s", new String(new char[] {suit}));
      return;
    }
    
    if (Utils.equals(value, 0L)) {
        System.out.print("[]");
        return;
      }

    if (Utils.equals(value, 1L)) {
      System.out.printf("%s", new String(new char[] {'A'}));
      System.out.printf("%s", new String(new char[] {suit}));
      return;
    }

    if (Utils.equals(value, 11L)) {
      System.out.printf("%s", new String(new char[] {'J'}));
      System.out.printf("%s", new String(new char[] {suit}));
      return;
    }

    if (Utils.equals(value, 12L)) {
      System.out.printf("%s", new String(new char[] {'Q'}));
      System.out.printf("%s", new String(new char[] {suit}));
      return;
    }

    if (Utils.equals(value, 13L)) {
      System.out.printf("%s", new String(new char[] {'K'}));
      System.out.printf("%s", new String(new char[] {suit}));
      return;
    }
    
    
  }

  public Card() {}

  public String toString() {

    return "Card{"
        + "id := "
        + Utils.toString(id)
        + ", suit := "
        + Utils.toString(suit)
        + ", value := "
        + Utils.toString(value)
        + "}";
  }
}
