package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CardTest extends MyTestCase {
  private Deck deck = new Deck();
  private Board board = new Board(deck);
  private Hand hand = new Hand(deck);

  private void testBoard() {

    assertEqual(28L, board.cards.size());
    long toVar_7 = board.cards.size();

    for (Long index = 1L; index <= toVar_7; index++) {
      Card tempCard = ((Card) Utils.get(deck.cards, index));
      assertTrue(tempCard.getValue().longValue() > 0L);
      Boolean orResult_1 = false;

      if (Utils.equals(tempCard.getSuit(), 'S')) {
        orResult_1 = true;
      } else {
        Boolean orResult_2 = false;

        if (Utils.equals(tempCard.getSuit(), 'C')) {
          orResult_2 = true;
        } else {
          Boolean orResult_3 = false;

          if (Utils.equals(tempCard.getSuit(), 'D')) {
            orResult_3 = true;
          } else {
            orResult_3 = Utils.equals(tempCard.getSuit(), 'H');
          }

          orResult_2 = orResult_3;
        }

        orResult_1 = orResult_2;
      }

      assertTrue(orResult_1);
    }
  }

  private void testDeck() {

    assertEqual(52L, deck.cards.size());
  }

  private void testHand() {

    assertEqual(24L, hand.cards.size());
    long toVar_8 = hand.cards.size();

    for (Long index = 1L; index <= toVar_8; index++) {
      Card tempCard = ((Card) Utils.get(hand.cards, index));
      assertTrue(tempCard.getValue().longValue() > 0L);
      Boolean orResult_4 = false;

      if (Utils.equals(tempCard.getSuit(), 'S')) {
        orResult_4 = true;
      } else {
        Boolean orResult_5 = false;

        if (Utils.equals(tempCard.getSuit(), 'C')) {
          orResult_5 = true;
        } else {
          Boolean orResult_6 = false;

          if (Utils.equals(tempCard.getSuit(), 'D')) {
            orResult_6 = true;
          } else {
            orResult_6 = Utils.equals(tempCard.getSuit(), 'H');
          }

          orResult_5 = orResult_6;
        }

        orResult_4 = orResult_5;
      }

      assertTrue(orResult_4);
    }
  }

  public void runTests() {

    testBoard();
    testDeck();
    testHand();
  }

  public CardTest() {}

  public String toString() {

    return "CardTest{"
        + "deck := "
        + Utils.toString(deck)
        + ", board := "
        + Utils.toString(board)
        + ", hand := "
        + Utils.toString(hand)
        + "}";
  }
}
