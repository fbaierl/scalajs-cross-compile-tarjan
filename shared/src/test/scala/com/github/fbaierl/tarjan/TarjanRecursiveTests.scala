package com.github.fbaierl.tarjan

import org.scalatest.FlatSpec

import com.github.fbaierl.tarjan.TarjanRecursive._

class TarjanRecursiveTests extends FlatSpec {

  "Tarjan" should "partition a graph with two nodes (strings) correctly" in {
    val input = Map("a" -> List("b"),
                    "b" -> List("a"))
    val r = tarjan(input)
    assert(r.size == 1)
    assert(r.head.contains("a") && r.head.contains("b"))
  }

  it should "work with Ints" in {
    val inputComplexCircle = Map(1 -> List(2), 2 -> List(3), 3 -> List(1))
    val r = tarjan(inputComplexCircle)
    assert(r.size == 1)
    assert(r.head.contains(1))
    assert(r.head.contains(2))
    assert(r.head.contains(3))
  }

  it should "work with Classes" in {
    case class Node(id: String)
    val a = Node("i am a")
    val b = Node("i am b")
    val c = Node("i am c")
    val d = Node("i am d")
    val e = Node("i am e")
    val input = Map(
      a -> List(c),
      b -> List(a),
      c -> List(e, d),
      d -> List(c),
      e -> List(c, d))
    val result = tarjan(input)

    // should be 3 buffers
    assert(result.size == 3)

    // the buffer that has "a" in it should have size 1
    val resultWithA = result.filter(_.contains(a))
    assert(resultWithA.size == 1) // "a" is only in one buffer
    val bufferWithA = resultWithA.head
    assert(bufferWithA.size == 1) // only "a" is in that buffer

    val resultWithB = result.filter(_.contains(b))
    assert(resultWithB.size == 1) // "b" is only in one buffer
    val bufferWithB = resultWithB.head
    assert(bufferWithB.size == 1) // only "b" is in that buffer

    // sanity-check: the other buffer has everything else
    val rest = result.filter(!_.contains(a)).filter(!_.contains(b))
    assert(rest.head.contains(c))
    assert(rest.head.contains(d))
    assert(rest.head.contains(e))
    assert(rest.head.size == 3)
  }
}
