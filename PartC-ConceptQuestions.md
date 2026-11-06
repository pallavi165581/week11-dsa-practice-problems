# Part C — Concept Questions

## Question 1

Primitive data structures are the basic, built-in types a language provides directly; each holds a single, indivisible value and has a fixed size defined by the language. Non-primitive data structures are constructed by the programmer (or standard library) out of primitive types and other structures, and they store collections of related values. As a less-common example: Java's `byte` is primitive (a single 8-bit value), while an `enum` like `DayOfWeek` is non-primitive because it is a user-defined type composed of named constants — even though a single enum variable references just one value, the type itself is a defined structure rather than a machine-level scalar.

## Question 2

"Linear" vs "non-linear" describes the **logical arrangement** of elements — how each element relates to the next — not the physical placement of bytes in memory. In a linked list every element has at most one predecessor and one successor, so the elements form a single sequence you traverse in order: that is the definition of a linear structure. A structure is non-linear when an element can connect to multiple others (trees, graphs), producing branching rather than a sequence. The developer confused storage layout (non-contiguous nodes) with access topology (strictly sequential); arrays and linked lists are both linear even though only arrays store elements contiguously.

## Question 3

Two **independent** loops run one after the other, so their costs add: O(m) + O(n) = O(m + n). When the m-iteration loop is **nested inside** the n-iteration loop, the inner loop's full m iterations execute once for every one of the n outer iterations, so the costs multiply: O(m × n). The rule: sequential statements contribute the sum of their complexities (dominated by the largest term), while nested repetition contributes the product of the iteration counts. This is the same reason Q5 (sequential → O(m + n)) differs from Q4 (nested → O(n²)) in the quiz.

## Question 4

A web application's **response cache** is a good example. When thousands of users request the same product page, re-running the database queries and template rendering for every request is O(query + render) per hit. Caching the rendered page in memory (e.g., Redis or an in-process map) makes each repeat request O(1) — a lookup by URL. The trade-off: we spend RAM holding copies of rendered pages (and accept the invalidation work when data changes) in exchange for dramatically lower latency and CPU load on a very frequent operation. Trading space for time like this is the same principle behind memoization and hash indexes.

## Question 5

Choose a **hash map** when the dominant operations are exact-match lookups and frequent inserts/deletes: average O(1) search, insert, and delete beat a sorted array's O(log n) search, O(n) insert, and O(n) delete (shifting to preserve order). Choose a **sorted array** when you need ordering semantics — iterating employees by ID, prefix searches, or range queries ("all IDs between E100 and E200") — or when memory overhead matters, since a hash map spends extra space on buckets and load-factor headroom. So for an HR system queried mostly by exact employee ID with regular hiring/departures, the hash map wins; for a mostly-static directory that must stay ordered, the sorted array is simpler and cheaper in space.
