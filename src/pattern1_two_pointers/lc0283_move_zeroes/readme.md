# LeetCode 0283: Move Zeroes — Interview Variants

This package contains three high-value Amazon interview variants derived from **LeetCode 283 (Move Zeroes)**. Each variant expands on standard same-direction pointer mechanics, ranging from in-place defragmentation and stable multi-boundary partitioning to mathematical displacement cost modeling.

---

## Pattern Overview: Same-Direction Two Pointers (Read / Write)

Unlike bilateral pointer problems where pointers converge from opposite ends (e.g., Two Sum II), these variants utilize **Fast (Read)** and **Slow (Write)** pointers moving in the same direction:
* **`read` (Fast Pointer):** Scans every element of the input array sequentially.
* **`write` (Slow Pointer):** Marks the boundary where the next valid element must be written.

---

## Variant 1: In-Place Data Defragmentation & De-duplication

### Problem Description
You are optimizing memory management for a cache array. Given an integer array `nums` containing invalid/corrupted marker values (`-1`) alongside valid positive integers, modify the array **in-place** to move all `-1` markers to the end while **removing adjacent duplicates** among valid integers.

The relative order of valid, unique integers must be preserved. Return the count of valid unique integers.

### Real-World Context
Memory cache defragmentation where corrupted/invalid slots (`-1`) are scrubbed and adjacent duplicate valid data blocks are consolidated.

### Key Mechanics & Edge Cases
* A `read` pointer scans the array. Valid non-duplicate elements are written to `nums[write++]`.
* **Edge Case Handling:** To catch duplicates separated by invalid `-1` markers (e.g., `[1, -1, 1]`), elements are compared against the **last written valid element** (`nums[write - 1]`) rather than their immediate neighbor (`nums[read - 1]`).

### Example Test Cases
* **Input:** `nums = [1, 1, -1, 2, 2, -1, 3, 1]`  
  **Expected Array:** `[1, 2, 3, 1, -1, -1, -1, -1]` | **Return Count:** `4`
* **Input:** `nums = [1, -1, 1]`  
  **Expected Array:** `[1, -1, -1]` | **Return Count:** `1`

### Complexity
* **Time Complexity:** $\mathcal{O}(N)$
* **Space Complexity:** $\mathcal{O}(1)$ auxiliary space

---

## Variant 2: Stability-Preserved Dual-Boundary Task Partitioning

### Problem Description
You are working on a process scheduling engine. You are given an array `tasks` containing process priority levels, where `0` represents an **idle thread**, positive values represent **high-priority tasks**, and negative values represent **background tasks**.

Rearrange the array in-place or into an output array such that:
1. All negative tasks appear at the beginning (left).
2. All positive tasks appear in the middle.
3. All `0` idle threads are moved to the end (right).
4. The relative ordering within negative tasks and within positive tasks **must be strictly preserved**.

### Real-World Context
Process scheduling engine grouping background tasks (`< 0`), high-priority tasks (`> 0`), and idle threads (`0`) into distinct execution tiers.

### Key Mechanics & Trade-offs
* Standard 3-pointer partitioning (Dutch National Flag) is **unstable** and destroys relative order.
* To strictly preserve ordering within task tiers in $\mathcal{O}(N)$ time:
    * **Pass 1:** Copy all negative numbers into an auxiliary array `ans`.
    * **Pass 2:** Copy all positive numbers into `ans` immediately following negative tasks.
    * Unfilled trailing indices are automatically initialized to `0`.

### Example Test Cases
* **Input:** `tasks = [3, -1, 0, 2, -4, 0, 1]`  
  **Expected Output:** `[-1, -4, 3, 2, 1, 0, 0]`
* **Input:** `tasks = [5, -2, -3, 8]`  
  **Expected Output:** `[-2, -3, 5, 8]`

### Complexity
* **Time Complexity:** $\mathcal{O}(N)$
* **Space Complexity:** $\mathcal{O}(N)$ auxiliary space *(Acceptable trade-off for Amazon interviews when stability is required in $\mathcal{O}(N)$ time)*.

---

## Variant 3: Minimal Swap Count with Adjacent Distance Overhead

### Problem Description
You are managing a load balancer for a dynamic cluster. You are given a binary array `server_status`, where `0` represents an **offline server** and `1` represents an **active server**.

To consolidate active servers at the front of the cluster, you must move all `0` (offline) servers to the end of the array using adjacent swaps. Every adjacent swap incurs a network latency cost of $1$ unit. Return the **minimum total swap cost** required while strictly preserving the relative order of active servers (`1`s).

### Real-World Context
Server cluster load balancing where offline servers (`0`) are shifted to the back via adjacent node swaps, each incurring a network latency penalty of $1$ unit.

### Key Mechanics & Edge Cases
* Avoid physical $\mathcal{O}(N^2)$ swap operations by tracking displacement mathematically in a single pass.
* Each active server (`1`) must cross all offline servers (`0`) that appear to its left (`total_swaps += zero_count`).
* **Integer Overflow Risk:** Uses a `long` accumulator for total swap cost to prevent 32-bit signed integer overflow when $N \ge 10^5$.

### Example Test Cases
* **Input:** `server_status = [0, 1, 0, 1, 1]`  
  **Expected Cost:** `5`
* **Input:** `server_status = [1, 1, 0, 0]`  
  **Expected Cost:** `0`

### Complexity
* **Time Complexity:** $\mathcal{O}(N)$
* **Space Complexity:** $\mathcal{O}(1)$ auxiliary space

---

## Directory Structure

```text
DSA-Variants/src/pattern1_two_pointers/lc0283_move_zeroes/
├── README.md
├── Variant1_DefragmentAndDeduplicate.java
├── Variant2_DualBoundaryPartitioning.java
└── Variant3_MinSwapCost.java