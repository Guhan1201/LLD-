# Tic-Tac-Toe Game - Low Level Design (LLD)

## Overview
A complete low-level design and implementation of the classic Tic-Tac-Toe game with all required features including game initialization, move validation, win/draw detection, and player management.

## Architecture & Design

### Class Structure

#### 1. **Player.java**
Represents a player in the game.
- **Attributes:**
  - `name`: Player's name
  - `symbol`: Player's symbol ('X' or 'O')
- **Methods:**
  - `getName()`: Get player name
  - `getSymbol()`: Get player symbol

#### 2. **Board.java**
Manages the 3x3 game board and game rules.
- **Attributes:**
  - `grid`: 3x3 character array representing the board
  - `BOARD_SIZE`: Constant (3)
- **Key Methods:**
  - `initializeBoard()`: Initialize empty board
  - `isValidMove(row, col)`: Validate if a move is possible
  - `placeMove(row, col, symbol)`: Place a move on the board
  - `isBoardFull()`: Check for draw condition
  - `checkWin(symbol)`: Check if player has won
  - `displayBoard()`: Display formatted board
  - `reset()`: Reset board for new game

#### 3. **GameState.java**
Enum to represent different game states.
- **States:**
  - `IN_PROGRESS`: Game is ongoing
  - `PLAYER_X_WINS`: Player X has won
  - `PLAYER_O_WINS`: Player O has won
  - `DRAW`: Game ended in a draw

#### 4. **TicTacToe.java**
Main game controller that manages game logic and state.
- **Attributes:**
  - `board`: Game board instance
  - `playerX`: Player X
  - `playerO`: Player O
  - `currentPlayer`: Current turn player
  - `gameState`: Current game state
- **Key Methods:**
  - `TicTacToe(playerXName, playerOName)`: Initialize new game
  - `makeMove(row, col)`: Execute a player's move
  - `switchPlayer()`: Switch between players
  - `getGameState()`: Get current game state
  - `isGameOver()`: Check if game has ended
  - `displayGameStatus()`: Show board and game status
  - `resetGame()`: Reset for new game

#### 5. **TicTacToeDemo.java**
Interactive console interface for playing the game.
- Handles user input
- Manages game flow
- Displays results

## Features Implemented

### ✅ Initialization
```java
TicTacToe game = new TicTacToe("Alice", "Bob");
```
Creates a new game with player names and initializes an empty 3x3 board.

### ✅ Move Validation
```java
if (board.isValidMove(row, col))
```
- Checks if cell is within bounds (0-2)
- Verifies cell is empty (not already occupied)

### ✅ Board Update
```java
board.placeMove(row, col, symbol);
```
Places player's symbol on the board at specified position.

### ✅ Win Condition
```java
if (board.checkWin(symbol))
```
Checks all winning scenarios:
- **Rows**: All 3 cells in a row match
- **Columns**: All 3 cells in a column match
- **Diagonal**: All cells in main diagonal match
- **Anti-Diagonal**: All cells in anti-diagonal match

### ✅ Draw Condition
```java
if (board.isBoardFull())
```
Detects when board is completely filled without a winner.

### ✅ Player Switching
```java
private void switchPlayer()
```
Alternates between Player X and Player O after each valid move.
Player X always starts first.

## How to Play

### Run the Game
```bash
java Main
```

### Game Instructions
1. Enter names for Player X and Player O
2. Board positions are numbered 0-8:
   ```
   0 | 1 | 2
   ---------
   3 | 4 | 5
   ---------
   6 | 7 | 8
   ```
3. Enter a position (0-8) for your move
4. Game continues until:
   - One player wins (gets 3 in a row/column/diagonal)
   - Board is full (draw)
   - Player enters -1 to quit
5. Option to play again after game ends

## Design Patterns Used

### 1. **Separation of Concerns**
- `Board`: Handles board logic
- `Player`: Represents player data
- `TicTacToe`: Manages game flow
- `TicTacToeDemo`: Handles UI/Input

### 2. **State Pattern**
- `GameState` enum represents different game states
- Clear state transitions

### 3. **Encapsulation**
- Board logic is encapsulated in Board class
- Game logic encapsulated in TicTacToe class

## Time Complexity Analysis

| Operation | Time Complexity |
|-----------|-----------------|
| isValidMove() | O(1) |
| placeMove() | O(1) |
| isBoardFull() | O(9) = O(1) |
| checkWin() | O(9) = O(1) |
| makeMove() | O(1) |

## Space Complexity
- **Board**: O(1) - Fixed 3x3 grid = 9 cells
- **Game**: O(1) - Constant space for players and state

## Example Game Flow

```
Player X (Alice) makes move at position 4 (center)
 0 | 1 | 2
-----------
 3 | X | 5
-----------
 6 | 7 | 8

Player O (Bob) makes move at position 0
 O | 1 | 2
-----------
 3 | X | 5
-----------
 6 | 7 | 8

... game continues until win or draw
```

## Testing Scenarios

### Win Scenarios
- Horizontal win (any row)
- Vertical win (any column)
- Diagonal win (main or anti-diagonal)

### Draw Scenario
- Board fills without three in a row

### Move Validation
- Valid moves on empty cells
- Invalid moves on occupied cells
- Out of bounds moves

## Future Enhancements
- AI opponent with difficulty levels
- Game history/statistics
- Network multiplayer support
- GUI implementation
- Undo/Redo moves
- Save game state

