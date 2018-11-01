package com.github.fbaierl.tarjan

import scala.collection.mutable

/**
  * Tarjan's strongly connected components algorithm is an algorithm in graph theory for finding the strongly connected
  * components of a directed graph in linear time.
  */
object TarjanRecursive {

  /**
    * The algorithm takes a directed graph as input, and produces a partition of the graph's vertices into the graph's
    * strongly connected components.
    * @param g the graph
    * @return the strongly connected components of g
    */
  def tarjan[T](g: Map[T, List[T]]): mutable.Buffer[mutable.Buffer[T]] = {
    /*
     * explanation: generic tarjan maps everything on Int's and calls tarjan on Ints
     */
    // the index in the list is the new identifier for the node
    val nodes = g.keySet.toList
    val input = mutable.Map.empty[Int, List[Int]]
    nodes.foreach { node =>
      input.put(nodes.indexOf(node), g(node).map(nodes.indexOf(_)))
    }
    tarjanInt(collection.immutable.Map(input.toList:_*)).map(_.map(nodes(_)))
  }

  private def tarjanInt(g: Map[Int, List[Int]]): mutable.Buffer[mutable.Buffer[Int]] = {
    val mainStack = mutable.Buffer.empty[Int]
    val stackSet = mutable.Set.empty[Int]
    val index = mutable.Map.empty[Int, Int] // index of v
    val lowLink = mutable.Map.empty[Int, Int] // low link of v
    val result = mutable.Buffer.empty[mutable.Buffer[Int]]
    def visit(v: Int): Unit = {
      index(v) = index.size
      lowLink(v) = index(v)
      mainStack += v
      stackSet += v
      for (w <- g(v)) {
        if (!index.contains(w)) {
          visit(w)
          lowLink(v) = math.min(lowLink(w), lowLink(v))
        } else if (stackSet(w)) {
          lowLink(v) = math.min(lowLink(v), index(w))
        }
      }
      if (lowLink(v) == index(v)) {
        val scc = mutable.Buffer.empty[Int]
        var w = -1
        while(v != w) {
          w = mainStack.remove(mainStack.size - 1)
          scc += w
          stackSet -= w
        }
        result += scc
      }
    }
    for (v <- g.keys) {
      if (!index.contains(v)){
        visit(v)
      }
    }
    result
  }

}
