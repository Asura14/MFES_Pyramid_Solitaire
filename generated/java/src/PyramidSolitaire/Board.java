package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Board {
  public VDMSeq cards;

  public void cg_init_Board_1(final Deck deck) {

    cards = SeqUtil.seq();
    long toVar_1 = 28L;

    for (Long i = 1L; i <= toVar_1; i++) {
      cards = SeqUtil.conc(Utils.copy(cards), SeqUtil.seq(((Card) Utils.get(deck.cards, i))));
    }
    return;
  }

  public Board(final Deck deck) {

    cg_init_Board_1(deck);
  }

  public Card selectCard(final Number row, final Number col) {

    if (Utils.equals(checkCardAtCoor(row, col), true)) {
      if (Utils.equals(checkFree(row, col), true)) {
        Number cardIndex = getCardIndex(row, col);
        return ((Card) Utils.get(cards, cardIndex));
      }
    }

    return new Card(0L, 'N', 0L);
  }

  public void removeCard(final Number row, final Number col) {

    Number index = getCardIndex(row, col);
    Utils.mapSeqUpdate(cards, index, new Card(0L, 'N', 0L));
  }

  public Boolean checkCardAtCoor(final Number row, final Number col) {

    Number index = getCardIndex(row, col);
    if (((Card) Utils.get(cards, index)).getValue().longValue() > 0L) {
      return true;

    } else {
      return false;
    }
  }

  public Boolean checkFree(final Number row, final Number col) {
	if(row.longValue() != 7) {
		if (Utils.equals(checkCardAtCoor(row.longValue() + 1L, col), false)) {
			if (Utils.equals(checkCardAtCoor(row.longValue() + 1L, col.longValue() + 1L), false)) {
				return true;
			  } 
		    }
		} else {
			return true;
			}
    return false;
  }

  public Number getCardIndex(final Number row, final Number col) {

    Number index = 0L;
    long toVar_3 = row.longValue();

    for (Long i = 1L; i <= toVar_3; i++) {
      long toVar_2 = i.longValue();

      for (Long j = 1L; j <= toVar_2; j++) {
        index = index.longValue() + 1L;
        Boolean andResult_13 = false;

        if (Utils.equals(i, row)) {
          if (Utils.equals(j, col)) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          return index;
        }
      }
    }
    return index;
  }

  public Board() {}

  public String toString() {

    return "Board{" + "cards := " + Utils.toString(cards) + "}";
  }
}
