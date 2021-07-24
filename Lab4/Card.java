import java.util.*;

public class Card {
	public static final int VALUE_RANGE = 13;
	public static final int SUIT_RANGE = 4;
	private int value = 0;
	private int suit = 0;
	
	
	public Card(){ //create a card with a random suit and value
		Random gen = new Random();
		this.value = gen.nextInt(VALUE_RANGE);
		this.suit = gen.nextInt(SUIT_RANGE);
	}
	
	public Card(int value, int suit) { //create a card with a specific suit and value
		this.suit = suit;
		this.value = value;
	}
	
	public void setEqual(Card match) { //make the suit and value of this card equal to the input card
		this.value = match.value;
		this.suit = match.suit;
	}
	
	public String toString() {
		String value = " ";
		String suit = " ";
		
		switch (this.suit) { //assign suit the correct suit value corresponding to the Card.suit random int
		case 0: suit = "Hearts"; break;
		case 1: suit = "Clubs"; break;
		case 2: suit = "Spades"; break;
		case 3: suit = "Diamonds"; break;
		}
		
		switch (this.value) { //assign string equivalent of int value
		case 0: value = "Ace"; break;
		case 1: value = "Two"; break;
		case 2: value = "Three"; break;
		case 3: value = "Four"; break;
		case 4: value = "Five"; break;
		case 5: value = "Six"; break;
		case 6: value = "Seven"; break;
		case 7: value = "Eight"; break;
		case 8: value = "Nine"; break;
		case 9: value = "Ten"; break;
		case 10: value = "Jack"; break;
		case 11: value = "Queen"; break;
		case 12: value = "King"; break;
		}
		return (value + " of " + suit); //return the card's suit and value
	}

	public static void main(String[] args) { 
		int handSize = 5;
		int deckSize = 52;
		int userIn = 1;
		
		Scanner scan = new Scanner(System.in); //currently only used so the user can decide when to exit
		
		Card[] hand = new Card[handSize];
		ArrayList<Card> deck = new ArrayList<Card>(deckSize); //created as ArrayList to allow Collections.shuffle()
		
		for (int index = 0; index < handSize; index++) { //initialize hand with random Cards
		hand[index] = new Card();	
		}
		
		for (int index = 0; index < deckSize; index++) {
			deck.add(new Card(index % VALUE_RANGE, index % SUIT_RANGE)); //instantiate an unshuffled 52 Card deck
		}
		
		System.out.println("Welcome to Card!");
		
		while (userIn == 1) { //deal a 5 card hand to the user as long as they input "redraw"
			Collections.shuffle(deck);
			
			for (int index = 0; index < handSize; index++) {
				hand[index].setEqual(deck.get(index)); //sets cards in hand equal to first 5 cards in deck
			}                                          
			//TODO currently the hand is not removed from the deck
			//create this functionality in order to play a game
			
			System.out.print("Your hand is : "); //print the hand
			for (int index = 0; index < handSize; index++) {
				System.out.print(hand[index] + " ");
			}
			
			System.out.println("\nEnter 1 to draw a new hand, or anything else to quit");
			userIn = scan.nextInt();
		}
		
		scan.close();
	}

}
