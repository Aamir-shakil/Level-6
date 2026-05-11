# Dungeon Battle Arena

Dungeon Battle Arena is a turn-based Java console game developed to demonstrate object-oriented programming principles and recognised software design patterns.

The game allows players to battle through multiple combat rounds against different enemy types while using attacks, defensive stances, and combat buffs to survive increasingly difficult encounters.

---

# Features

- Turn-based combat system
- Multiple enemy types (`Goblin`, `Orc`, `OrcBoss`)
- Attack, defend, and power attack mechanics
- Runtime combat buffs
- Round progression system
- Battle logs and live stat updates
- Menu and instruction system
- Object-oriented architecture using multiple design patterns

---

# Design Patterns Used

## State Pattern

Used to manage:

- Gameplay flow (`MenuState`, `BattleState`, `VictoryState`, etc.)
- Combat stance behaviour (`NormalCombatState`, `DefendingCombatState`)

## Observer Pattern

Used to update:

- Battle logs
- Player and enemy statistics

Observers react automatically whenever the shared `GameModel` changes.

## Decorator Pattern

Used to apply runtime combat buffs:

- `StrengthBoostDecorator`
- `ShieldBoostDecorator`

Decorators wrap the player object dynamically without modifying the original `Player` class.

---

# Object-Oriented Principles

The project demonstrates:

- Inheritance
- Polymorphism
- Abstraction
- Composition
- Encapsulation
- Delegation

---

# Technologies Used

- Java 21
- Maven
- VS Code
- Git & GitHub

---

# Project Structure


src
├── main
│   └── java
│       └── com.aamir.dungeonarena
│           ├── battle
│           ├── characters
│           ├── combatstate
│           ├── decorator
│           ├── observer
│           ├── state
│           └── main

# How to Run
Clone the repository
git clone https://github.com/Aamir-shakil/Dungeon-Arena.git
Navigate into the project
cd dungeon-arena
Compile the project
mvn compile
Run the application
java -cp target/classes com.aamir.dungeonarena.main.Main
## Author

Mohammed Aamir Shakil

