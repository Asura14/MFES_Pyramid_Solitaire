package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Deck {
  public VDMSeq cards;
  public Card newCard;

  public void cg_init_Deck_1() {

    cards = SeqUtil.seq();
    long toVar_4 = 13L;

    for (Long nvalue = 1L; nvalue <= toVar_4; nvalue++) {
      newCard = new Card(nvalue, 'S', nvalue);
      cards = SeqUtil.conc(Utils.copy(cards), SeqUtil.seq(newCard));
      newCard = new Card(nvalue.longValue() + 13L, 'C', nvalue);
      cards = SeqUtil.conc(Utils.copy(cards), SeqUtil.seq(newCard));
      newCard = new Card(nvalue.longValue() + 26L, 'H', nvalue);
      cards = SeqUtil.conc(Utils.copy(cards), SeqUtil.seq(newCard));
      newCard = new Card(nvalue.longValue() + 39L, 'D', nvalue);
      cards = SeqUtil.conc(Utils.copy(cards), SeqUtil.seq(newCard));
    }
    return;
  }

  public Deck() {

    cg_init_Deck_1();
  }

  public void shuffleDeck() {

    Number newIndex = 1L;
    Card tempCard = null;
    long toVar_5 = 52L;

    for (Long index = 1L; index <= toVar_5; index++) {
      tempCard = ((Card) Utils.get(cards, index));
      newIndex = MATH.rand(52L).longValue() + 1L;
      Utils.mapSeqUpdate(cards, index, ((Card) Utils.get(cards, newIndex)));
      Utils.mapSeqUpdate(cards, newIndex, tempCard);
    }
  }

  public String toString() {

    return "Deck{"
        + "cards := "
        + Utils.toString(cards)
        + ", newCard := "
        + Utils.toString(newCard)
        + "}";
  }
}
