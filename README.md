# Scala JVM & Scala.js implementation of Tarjan's strongly connected components algorithm

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
List(List("d", "e", "c"),
     List("a"), 
     List("b"))
```

#Installation

Add a dependency in your build.sbt:


- JVM Scala:

```scala
libraryDependencies += "com.github.fbaierl" %% "scala-tarjan_2.12" % "0.1.1"
```

- Scala.js:

```scala
libraryDependencies += "com.github.fbaierl" %%% "scala-tarjan_2.12" % "0.1.1"
```


# See also:
Python version of this algorithm: [py-tarjan](https://github.com/bwesterb/py-tarjan)


# License:

Copyright 2018 Florian Baierl

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
