import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    @Test
    public void queDesGoutieresDonne0Points() {
        rollMany(20, 0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void uneSeuleQuille(){
        game.roll(1);
        rollMany(19, 0);
        assertEquals(1, game.getScore());
    }

    @Test
    public void bonusDuSpare(){
        game.roll(8);
        game.roll(2);
        game.roll(1);
        game.roll(9);
        game.roll(5);
        game.roll(4);
        game.roll(3);
        game.roll(5);
        rollMany(12, 0);
        assertEquals(43, game.getScore());
    }
    
    @Test
    public void bonusDuStrike(){
        game.roll(10);
        game.roll(0);
        game.roll(1);
        game.roll(5);
        rollMany(16, 0);
        assertEquals(22, game.getScore());
    }
    
    @Test
    public void jeuComplet(){
        game.roll(8);
        game.roll(2);        
        game.roll(5);
        game.roll(3);
        game.roll(2);
        game.roll(8);
        game.roll(3);
        game.roll(7);
        game.roll(0);
        game.roll(1);
        game.roll(5);
        game.roll(4);
        game.roll(1);
        game.roll(9);
        game.roll(3);
        game.roll(7);
        game.roll(1);
        game.roll(1);
        game.roll(8);
        game.roll(1);
        assertEquals(91, game.getScore());
    }

    private void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            game.roll(numberPins);
        }
    }
}
