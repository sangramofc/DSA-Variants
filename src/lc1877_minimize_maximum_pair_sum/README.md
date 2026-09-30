# LC 1877: Minimize Maximum Pair Sum in Array

## Variant 1: Server Cluster Load Balancing

### Problem Context
You are given an array `weights` of even length $n$, representing microservice workloads, and a `max_capacity` hardware ceiling. Pair all $n$ tasks into $n/2$ clusters of exactly 2 tasks each such that:

1. The maximum load across all clusters ($L = \text{weight}_1 + \text{weight}_2$) is minimized.
2. No cluster's combined workload exceeds `max_capacity`.

Return the minimum possible maximum cluster load, or `-1` if no valid pairing exists within `max_capacity`.

---

## Variant 2: Dual-Core Processor Task Allocation

### Problem Context
You are given an array `tasks` of even length $n$, where `tasks[i]` represents process execution time (in ms), and a limit `max_skew`. Assign all $n$ processes into $n/2$ dual-core threads (2 processes per thread) such that:

1. The maximum total execution time ($T = \text{task}_1 + \text{task}_2$) across all threads is minimized.
2. No thread's skew ($S = \vert{}\text{task}_1 - \text{task}_2\vert{}$) exceeds `max_skew`.

Return the minimum possible maximum total execution time, or `-1` if any thread violates `max_skew`.