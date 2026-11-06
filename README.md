# Week 11 — DSA Practice Problems (Java)

SRM SEM-3 · CodInClub — Category C assignment: DSA introduction, arrays,
searching, hashing, two-pointer and sliding-window techniques.

## Structure

```
src/
  Problem01_LibraryCatalogLookup.java    Binary search on sorted catalog
  Problem02_WarehouseBinGridScan.java    Grid scan: total + max coordinate
  Problem03_TransactionDuplicateCheck.java  HashSet duplicate detection
  Problem04_EmployeeIdLookup.java        HashMap lookup table (build + query)
  Problem05_PairWithTargetSum.java       Hash-based pair sum (unsorted)
  Problem06_BestSingleTradeProfit.java   Single-pass max profit
  Problem07_InsertPosition.java          Binary-search insert position
  Problem08_SpiralOrderTraversal.java    Spiral traversal with 4 boundaries
  Problem09_PairSumSorted.java           Two-pointer pair sum (sorted)
  Problem10_RemoveDuplicates.java        In-place dedup of sorted array

PartB-Quiz.md              Quiz answers with reasons
PartC-ConceptQuestions.md  Written answers to concept questions
```

Each file documents its approach, time/space complexity, and required
trade-off discussions in the header comment, and includes a `main`
method that runs the sample inputs from the assignment.

## Compile & run

```sh
cd src
javac Problem01_LibraryCatalogLookup.java
java Problem01_LibraryCatalogLookup
```

Or compile everything at once:

```sh
javac -d out src/*.java
java -cp out Problem01_LibraryCatalogLookup
```
