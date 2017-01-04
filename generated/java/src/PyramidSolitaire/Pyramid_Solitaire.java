package PyramidSolitaire;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Pyramid_Solitaire {
  private Deck deck;
  private Board board;
  private Hand hand;
  private Boolean gameOver = false;
  private Boolean boardOver = false;

  public void cg_init_Pyramid_Solitaire_1() {

    deck = new Deck();
    deck.shuffleDeck();
    board = new Board(deck);
    hand = new Hand(deck);
  }

  public Pyramid_Solitaire() {

    cg_init_Pyramid_Solitaire_1();
  }

  public void gameCycle() {
	
    System.out.println("Welcome");
    Boolean whileCond_1 = true;
    while (!gameOver) {
    	
    	while(!boardOver) {
    		printBoard();
    		System.out.println("");
    		System.out.println("");
    		Card firstCard = new Card(0,'N',0);
    		Card secondCard = new Card(0,'N',0);
    		
    		System.out.print("Select the card coordinates to move (ex: \"3,3\"). To select card in hand insert \"0,0\". To get next card in hand type \"1\": ");
    		ArrayList<Integer> numbers = getNumbers();
    		
    		if(numbers.size() == 1) {
    			hand.nextCard();
    		} else {
    			
    			if(numbers.get(0) == -1 && numbers.get(1) == -1) {
        			gameOver = true;
        		} else if(numbers.get(0) == 0 && numbers.get(1) == 0) {
        			firstCard = hand.selectCard();
        		} else if(numbers.get(0) > 0 && numbers.get(0) < 14 && numbers.get(1) > 0 && numbers.get(1) < 14) {
        			firstCard = board.selectCard(numbers.get(0), numbers.get(1));
        		} else {
        			break;
        		}
        		
        		if(firstCard.getValue().intValue() == 13) {
        			if(numbers.get(0) == 0 && numbers.get(1) == 0) {
        				hand.removeCard();
        			} else {
        				board.removeCard(numbers.get(0), numbers.get(1));
        			}

        		} else {
        			System.out.print("Select second card: ");
        			ArrayList<Integer> numbers2 = getNumbers();
            		if(numbers2.get(0) == -1 && numbers2.get(1) == -1) {
            			gameOver = true;
            		} else if(numbers2.get(0) == 0 && numbers2.get(1) == 0) {
            			secondCard = hand.selectCard();
            		} else if(numbers2.get(0) > 0 && numbers2.get(0) < 14 && numbers2.get(1) > 0 && numbers2.get(1) < 14) {
            			secondCard = board.selectCard(numbers2.get(0), numbers2.get(1));
            		} else {
            			break;
            		}
            		
            		if((firstCard.getValue().intValue() + secondCard.getValue().intValue()) == 13) {
            			if(numbers.get(0) == 0 && numbers.get(1) == 0) {
            				hand.removeCard();
                			board.removeCard(numbers2.get(0), numbers2.get(1));
            			} else {
                			board.removeCard(numbers.get(0), numbers.get(1));
                			board.removeCard(numbers2.get(0), numbers2.get(1));
            			}
            			
            			System.out.println("Pair removed");
            		}
        		}
        		boardOver = isBoardOver();
    		}
    	}
    	System.out.println("Victory! Good Job.");
    	return;
        }
    System.out.println("You lose! Try again.");
	return;
  }
  
  public ArrayList<Integer> getNumbers() {
	  
	  
	  ArrayList numbers = new ArrayList<>();
	  Scanner reader = new Scanner(System.in);  // Reading from System.in
	  if(reader.hasNextInt()){
		  numbers.add(reader.nextInt());
		  return numbers;
	  }
	  String input = reader.nextLine();
	  
	  String[] parts = input.split(",");
	  numbers.add(Integer.parseInt(parts[0]));
	  numbers.add(Integer.parseInt(parts[1]));
	  return numbers;
  }

  public Card selectCard(final Number row, final Number col) {

    if (Utils.equals(row, 0L)) {
      return hand.selectCard();
    }

    if (row.longValue() > 0L) {
      return board.selectCard(col, row);
    }

    return new Card(0L, 'N', 0L);
  }

  public Boolean isBoardOver() {

    if ( ((Card) Utils.get(board.cards, 1L)).getValue().intValue() == 0) {
      return true;

    } else {
      return false;
    }
  }
  
  public Boolean isGameOver(final Number row, final Number col) {

    Boolean andResult_16 = false;

    if (Utils.equals(row, -1L)) {
      if (Utils.equals(col, -1L)) {
        andResult_16 = true;
      }
    }

    if (andResult_16) {
      return true;

    } else {
      return false;
    }
  }

  public Deck getDeck() {

    return deck;
  }

  public Board getBoard() {

    return board;
  }

  public Hand getHand() {

    return hand;
  }

  public Boolean getGameOver() {

    return gameOver;
  }

  public Boolean getBoardOver() {

    return boardOver;
  }

  public void printBoard() {

    System.out.println("          PYRAMID               ");
    System.out.print("            ");
    ((Card) Utils.get(board.cards, 1L)).printCard();
    System.out.println();
    System.out.print("          ");
    ((Card) Utils.get(board.cards, 2L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 3L)).printCard();
    System.out.println();
    System.out.print("        ");
    ((Card) Utils.get(board.cards, 4L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 5L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 6L)).printCard();
    System.out.println();
    System.out.print("      ");
    ((Card) Utils.get(board.cards, 7L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 8L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 9L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 10L)).printCard();
    System.out.println();
    System.out.print("    ");
    ((Card) Utils.get(board.cards, 11L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 12L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 13L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 14L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 15L)).printCard();
    System.out.println();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 16L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 17L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 18L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 19L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 20L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 21L)).printCard();
    System.out.println();
    ((Card) Utils.get(board.cards, 22L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 23L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 24L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 25L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 26L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 27L)).printCard();
    System.out.print("  ");
    ((Card) Utils.get(board.cards, 28L)).printCard();
    System.out.println();
    System.out.println();
    hand.getTopCard().printCard();
  }

  public String toString() {

    return "Pyramid_Solitaire{"
        + "deck := "
        + Utils.toString(deck)
        + ", board := "
        + Utils.toString(board)
        + ", hand := "
        + Utils.toString(hand)
        + ", gameOver := "
        + Utils.toString(gameOver)
        + ", boardOver := "
        + Utils.toString(boardOver)
        + "}";
  }
}
