package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SolitaireTest extends MyTestCase {
  private Pyramid_Solitaire pyramid = new Pyramid_Solitaire();

  private void testInitPyramid() {

    assertEqual(false, pyramid.getGameOver());
    assertEqual(false, pyramid.getBoardOver());
  }

  private void testRemoveFromBoard() {

    Number index = pyramid.getBoard().getCardIndex(1L, 1L);
    assertTrue(((Card) Utils.get(pyramid.getBoard().cards, index)).getValue().longValue() > 0L);
    pyramid.getBoard().removeCard(1L, 1L);
    assertTrue(Utils.equals(((Card) Utils.get(pyramid.getBoard().cards, index)).getValue(), 0L));
  }

  private void testRemoveFromHand() {

    Card tempCard = pyramid.getHand().getTopCard();
    assertTrue(tempCard.getValue().longValue() > 0L);
    pyramid.getHand().removeCard();
    Boolean orResult_7 = false;

    if (!(Utils.equals(pyramid.getHand().getTopCard().getValue(), tempCard.getValue()))) {
      orResult_7 = true;
    } else {
      orResult_7 = !(Utils.equals(pyramid.getHand().getTopCard().getSuit(), tempCard.getSuit()));
    }

    assertTrue(orResult_7);
  }

  private void testNextCardFromHand() {

    Card tempCard = pyramid.getHand().getTopCard();
    assertTrue(tempCard.getValue().longValue() > 0L);
    pyramid.getHand().nextCard();
    Boolean orResult_8 = false;

    if (!(Utils.equals(pyramid.getHand().getTopCard().getValue(), tempCard.getValue()))) {
      orResult_8 = true;
    } else {
      orResult_8 = !(Utils.equals(pyramid.getHand().getTopCard().getSuit(), tempCard.getSuit()));
    }

    assertTrue(orResult_8);
  }

  public void runTests() {

    testInitPyramid();
    testRemoveFromBoard();
    testRemoveFromHand();
    testNextCardFromHand();
  }

  public SolitaireTest() {}

  public String toString() {

    return "SolitaireTest{" + "pyramid := " + Utils.toString(pyramid) + "}";
  }
}
