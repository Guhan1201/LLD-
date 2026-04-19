# Tic-Tac-Toe - Usage Examples & Gameplay Walkthrough

## Starting the Game

### Method 1: Run Main Entry Point
```bash
$ java Main
=== LLD Practice Repository ===

Available Problems:
1. Tic-Tac-Toe Game

========================================
  Welcome to Tic-Tac-Toe Game (LLD)
========================================

Enter Player X name:
Alice
Enter Player O name:
Bob

--- Game Started ---
Board positions (0-indexed):
 0 | 1 | 2
-----------
 3 | 4 | 5
-----------
 6 | 7 | 8
```

## Example Game 1: Alice Wins (Diagonal)

```
   |   |   
-----------
   |   |   
-----------
   |   |   

Current Player: Alice (X)
Game State: IN_PROGRESS

Alice (X), enter your move (0-8) or -1 to quit:
0

   | X |   
-----------
   |   |   
-----------
   |   |   

Current Player: Bob (O)
Game State: IN_PROGRESS

Bob (O), enter your move (0-8) or -1 to quit:
1

   | X | O
-----------
   |   |   
-----------
   |   |   

Current Player: Alice (X)
Game State: IN_PROGRESS

Alice (X), enter your move (0-8) or -1 to quit:
4

   | X | O
-----------
   | X |   
-----------
   |   |   

Current Player: Bob (O)
Game State: IN_PROGRESS

Bob (O), enter your move (0-8) or -1 to quit:
3

   | X | O
-----------
 O | X |   
-----------
   |   |   

Current Player: Alice (X)
Game State: IN_PROGRESS

Alice (X), enter your move (0-8) or -1 to quit:
8

   | X | O
-----------
 O | X |   
-----------
   |   | X

========================================
🎉 Alice (X) WINS! 🎉
========================================

Game State: PLAYER_X_WINS

Do you want to play again? (yes/no):
```

## Example Game 2: Draw (Board Full)

```
Current Board State:

 X | O | X
-----------
 O | X | O
-----------
 O | X | O

Current Player: Bob (O)
Game State: IN_PROGRESS

========================================
🤝 It's a DRAW! 🤝
========================================

Do you want to play again? (yes/no):
```

## Example Game 3: Invalid Moves

```
Current Board State:

 X |   | O
-----------
   | X |   
-----------
   |   |   

Current Player: Bob (O)
Game State: IN_PROGRESS

Bob (O), enter your move (0-8) or -1 to quit:
0
Invalid move! Cell is already occupied or out of bounds.

Bob (O), enter your move (0-8) or -1 to quit:
9
Invalid position! Please enter a number between 0 and 8.

Bob (O), enter your move (0-8) or -1 to quit:
abc
Invalid input! Please enter a number.

Bob (O), enter your move (0-8) or -1 to quit:
3
```

## Example Game 4: Quitting Game

```
Current Board State:

 X |   | O
-----------
   |   |   
-----------
   |   |   

Current Player: Bob (O)
Game State: IN_PROGRESS

Bob (O), enter your move (0-8) or -1 to quit:
-1
Game abandoned!

Do you want to play again? (yes/no):
no

Thank you for playing! Goodbye!
```

## Code Usage Examples

### Creating and Playing a Game Programmatically

```java
import com.lld.problems.tictactoe.*;

public class GameExample {
    public static void main(String[] args) {
        // Initialize game
        TicTacToe game = new TicTacToe("Alice", "Bob");
        
        // Display initial state
        game.displayGameStatus();
        
        // Make moves
        game.makeMove(0, 0); // Alice plays position 0 (0,0)
        game.makeMove(1, 1); // Bob plays position 4 (1,1)
        game.makeMove(0, 1); // Alice plays position 1 (0,1)
        game.makeMove(2, 2); // Bob plays position 8 (2,2)
        game.makeMove(0, 2); // Alice plays position 2 (0,2)
        
        // Check game state
        if (game.isGameOver()) {
            System.out.println("Game Over! State: " + game.getGameState());
            if (game.getGameState() == GameState.PLAYER_X_WINS) {
                System.out.println(game.getPlayerX().getName() + " wins!");
            }
        }
        
        // Display final board
        game.displayGameStatus();
        
        // Reset for new game
        game.resetGame();
    }
}
```

## Testing Different Win Scenarios

### Horizontal Win (Row 0)
```
X | X | X
-----------
   | O | O
-----------
   |   |   
```
Result: Player X Wins

### Vertical Win (Column 1)
```
 O | X |   
-----------
   | X | O
-----------
   | X |   
```
Result: Player X Wins

### Main Diagonal Win
```
X | O |   
-----------
   | X | O
-----------
   |   | X
```
Result: Player X Wins

### Anti-Diagonal Win
```
   | O | X
-----------
   | X | O
-----------
X |   |   
```
Result: Player X Wins

## Board Position Reference

```
   0 | 1 | 2
   ---------
   3 | 4 | 5
   ---------
   6 | 7 | 8
```

## Game Rules Enforced

1. ✅ Players alternate turns (X always goes first)
2. ✅ Moves must be on empty cells
3. ✅ Valid positions: 0-8
4. ✅ Win: 3 in a row/column/diagonal
5. ✅ Draw: Board full with no winner
6. ✅ Game ends immediately after win or draw

## Running Tests

### Test Valid Moves
```java
Board board = new Board();
assert board.isValidMove(0, 0) == true;  // Empty cell
board.placeMove(0, 0, 'X');
assert board.isValidMove(0, 0) == false; // Occupied cell
assert board.isValidMove(5, 5) == false; // Out of bounds
```

### Test Win Detection
```java
Board board = new Board();
board.placeMove(0, 0, 'X');
board.placeMove(0, 1, 'X');
board.placeMove(0, 2, 'X');
assert board.checkWin('X') == true;  // Horizontal win
```

### Test Draw Detection
```java
Board board = new Board();
// Fill entire board without winner
// ... (place all moves)
assert board.isBoardFull() == true;
```

## Performance Notes

- **Time Complexity**: All operations are O(1)
- **Space Complexity**: Fixed 3x3 board = O(1)
- **Move Validation**: Instant (check bounds and cell state)
- **Win Detection**: O(9) = O(1) (fixed board size)
- **Suitable for**: Real-time interactive gameplay

## Tips for Playing

1. **Opening Strategy**: Center position (4) is strong
2. **Blocking**: Watch opponent's moves to block wins
3. **Diagonal Advantage**: Control diagonals early
4. **Corners**: Corners (0,2,6,8) can lead to multiple win paths
5. **Center**: Position 4 (center) is the most powerful square

## Common Game Scenarios

### Scenario 1: Optimal X Strategy
```
Position order: 4 → 0 → 2 → 6
Result: Strong position with multiple win threats
```

### Scenario 2: Defensive O Strategy
```
Watch X's moves and block potential 3-in-a-rows
```

### Scenario 3: Draw Strategy
```
Both players play optimally
Positions: X plays 0, O plays 4, X plays 8, O plays 2...
Result: Draw
```

---

**Enjoy playing Tic-Tac-Toe!** 🎮

