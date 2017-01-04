package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Hand {
  public VDMSeq cards = SeqUtil.seq();

  public void cg_init_Hand_1(final Deck deck) {

    cards = SeqUtil.seq();
    long toVar_6 = 52L;

    for (Long i = 29L; i <= toVar_6; i++) {
      cards = SeqUtil.conc(Utils.copy(cards), SeqUtil.seq(((Card) Utils.get(deck.cards, i))));
    }
    return;
  }

  public Hand(final Deck deck) {

    cg_init_Hand_1(deck);
  }

  public Card getTopCard() {

    return ((Card) cards.get(0));
  }

  public void nextCard() {

    cards = SeqUtil.conc(SeqUtil.tail(Utils.copy(cards)), SeqUtil.seq(((Card) cards.get(0))));
  }

  public void removeCard() {

    cards = SeqUtil.tail(Utils.copy(cards));
  }

  public Card selectCard() {

    return ((Card) cards.get(0));
  }

  public Hand() {}

  public String toString() {

    return "Hand{" + "cards := " + Utils.toString(cards) + "}";
  }
}
