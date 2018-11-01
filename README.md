# Scala implementation of Tarjan's strongly connected components algorithm

Tarjan's strongly connected components algorithm is an algorithm in graph theory for finding the strongly connected components of a directed graph in linear time.

- **Input**: a directed graph
- **Output**: partition of the graph's vertices into the graph's strongly connected components

# Example

<img src="https://raw.githubusercontent.com/fbaierl/scala-tarjan/master/example_diagram.png" width="220">

```scala
import com.github.fbaierl.tarjan.TarjanRecursive._

tarjan(Map(
   "a" -> List("c"),
   "b" -> List("a"),
   "c" -> List("e"),
   "d" -> List("c"),
   "e" -> List("c", "d")))
```
Result:
```scala
ArrayBuffer(
    ArrayBuffer("d", "e", "c"),
    ArrayBuffer("a"), 
    ArrayBuffer("b"))
```

# See also:
Python version of this algorithm: [py-tarjan](https://github.com/bwesterb/py-tarjan)

