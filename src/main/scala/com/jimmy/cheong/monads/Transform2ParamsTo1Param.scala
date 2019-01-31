package com.jimmy.cheong.monads

/*
  Practice from Chapter 54 of Functional Programming Simplified
 */

object Transform2ParamsTo1ParamObject extends App {

  case class Transform2ParamsTo1Param[A, B](fun: (A, A) => B)

  // Example with a function that takes 2 strings and returns an Int
  val x = Transform2ParamsTo1Param{ (a: String, b: String) =>
    a.length + b.length
  }

  // Prints 6
  println(x.fun("foo", "bar"))

  // Example with a function that takes 2 Ints and returns an Int
  val sum_ = Transform2ParamsTo1Param { (a: Int, b: Int) =>
    a + b
  }

  // Prints 12
  println(sum_.fun(6, 6))
}