import java.util.List;

public class BowlingGame {

    private Integer score= 0;
    private Integer round = 1;
    private Integer tableauCoups[] = new Integer[25];

    public int getScore() {
        return score;
    }

    public void roll(int numberPins) {
    	this.score += numberPins;
        this.tableauCoups[round] = numberPins;    
        
        if (round % 2 == 0 && round > 3) {
        	this.strike();
        }
        
        else if (round % 2 == 1 && round > 2) {
        	this.spare(numberPins);
        }
        
        this.round++;
    }
    
    public void spare(int numberPins) {    	
		if (tableauCoups[round-1] + tableauCoups[round-2] == 10  && tableauCoups[round-2] != 10) {
			score+=numberPins;
		}    	
    }
    	
    public void strike() {
		if (tableauCoups[round-3] == 10 ) {
			score+= tableauCoups[round];
			score+= tableauCoups[round-1];    			
		}    	
    }
}
