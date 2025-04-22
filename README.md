# Minimal Mark Ruler Calculator

This Java program finds the **fewest number of marks** needed on a ruler to measure **all integer distances from 1 to X** using only the **differences between pairs of marks**.

Unlike traditional rulers with marks at every unit, this ruler is optimized to use the **least number of marks** while still being able to measure all necessary distances.

---

## How It Works

The program uses **recursive backtracking** to try combinations of marks starting from `0` up to the target length `X`, checking if the selected set of marks can measure all lengths from `1` to `X`.

---

## Example

For input `X = 6`:

```
Fewest marks needed: 4  
Marks on the ruler: [0, 1, 4, 6]
```

With just 4 marks, this ruler can measure all integer lengths from 1 to 6!

---

## Key Features

- ✅ Finds the minimum number of marks needed
- ✅ Supports any positive integer input
- ✅ Uses backtracking for efficient searching (works well for small X)
- ✅ Clean, readable code in **Allman style**
- ✅ Fully commented for learning and clarity

---

## How to Run

1. Make sure you have Java installed (`java -version`)
2. Compile the program:
   ```bash
   javac Solutions/Solutions.java
   ```
3. Run it:
   ```bash
   java Solutions.Solutions
   ```

---

## 📂 File Structure

```
Solutions/
├── Solutions.java  // Main source file
```

---

## 🙌 Acknowledgments

Inspired by mathematical problems related to **difference covers** and **minimal ruler constructions**.

---
