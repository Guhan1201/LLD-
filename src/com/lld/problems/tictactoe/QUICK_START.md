# Quick Start Guide - Tic-Tac-Toe LLD

## ⚡ Get Started in 30 Seconds

### 1. Compile the Project
```bash
javac -d bin src/Main.java src/com/lld/problems/tictactoe/*.java
```

### 2. Run the Game
```bash
java -cp bin Main
```

### 3. Play!
- Enter player names when prompted
- Enter move positions (0-8)
- Try to get 3 in a row to win! 🎮

---

## 🎮 How to Play

### Board Layout
```
0 | 1 | 2
---------
3 | 4 | 5
---------
6 | 7 | 8
```

### Winning Combinations
- **Rows**: 0-1-2, 3-4-5, 6-7-8
- **Columns**: 0-3-6, 1-4-7, 2-5-8
- **Diagonals**: 0-4-8, 2-4-6

---

## 📋 Features

✅ **Initialization**: Start new game with player names
✅ **Move Validation**: Only valid moves accepted
✅ **Board Display**: Clear formatted board
✅ **Win Detection**: Detects all 8 win scenarios
✅ **Draw Detection**: Recognizes tied games
✅ **Player Switching**: Alternates between X and O
✅ **Replay**: Play multiple games in one session

---

## 📂 Project Structure

```
src/
├── Main.java                           (Entry point)
└── com/lld/problems/tictactoe/
    ├── Player.java                     (Player data)
    ├── Board.java                      (Game board)
    ├── GameState.java                  (Game states)
    ├── TicTacToe.java                  (Game logic)
    └── TicTacToeDemo.java              (UI/Demo)
```

---

## 🚀 Run Options

### Option 1: Main Entry Point
```bash
java Main
```

### Option 2: Direct Demo
```bash
java com.lld.problems.tictactoe.TicTacToeDemo
```

---

## 📚 Documentation Files

- **QUICK_START.md** - This file
- **IMPLEMENTATION_SUMMARY.md** - Complete implementation details
- **TIC_TAC_TOE_LLD.md** - Detailed design documentation
- **USAGE_EXAMPLES.md** - Gameplay examples and code samples

---

## ❓ Common Commands

| Action | Input |
|--------|-------|
| Move to position | 0-8 |
| Quit game | -1 |
| New game | yes |
| Exit program | no |

---

## 🏆 Example Game

```
Enter Player X name: Alice
Enter Player O name: Bob

Alice (X) moves to: 4
Bob (O) moves to: 0
Alice (X) moves to: 5
Bob (O) moves to: 1
Alice (X) moves to: 6

Alice wins with diagonal! 🎉
```

---

## 🐛 Troubleshooting

### "Invalid move! Cell is already occupied"
- You tried to place on an occupied square
- Choose an empty position (0-8)

### "Invalid position! Please enter a number between 0 and 8"
- You entered a number outside 0-8 range
- Enter position 0-8 or -1 to quit

### "Invalid input! Please enter a number"
- You entered non-numeric input
- Enter a valid number

---

## 💡 Strategy Tips

1. **Take Center (4)**: Most powerful position
2. **Control Corners**: Positions 0, 2, 6, 8
3. **Block Opponent**: Prevent their 3-in-a-row
4. **Create Threats**: Build two win threats simultaneously
5. **Odd Moves (X)**: Should aim for 3+ win paths

---

## 📊 Game Statistics

| Metric | Value |
|--------|-------|
| Board Size | 3x3 |
| Total Positions | 9 |
| Min Moves to Win | 5 |
| Max Moves in Game | 9 |
| Possible Games | 255,168 |
| Draws (Optimal) | ~138,000 |

---

## 🎯 Learning Objectives

This implementation demonstrates:

1. **Object-Oriented Design**
   - Classes: Player, Board, TicTacToe, GameState
   - Encapsulation and data hiding

2. **Game Logic**
   - Win/Draw detection algorithms
   - Game state management
   - Move validation

3. **Software Design Patterns**
   - State Pattern (GameState enum)
   - Separation of Concerns
   - Single Responsibility Principle

4. **Java Fundamentals**
   - Methods and constructors
   - Arrays and loops
   - Enums
   - User input handling

---

## ✨ Next Features

- AI opponent implementation
- Difficulty levels (Easy/Medium/Hard)
- Game history and statistics
- Network multiplayer support
- GUI version (JavaFX)

---

**Ready to play? Run `java Main` and enjoy! 🎮**

