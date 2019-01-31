package com.jimmy.cheong.monads


/*
  Notes from Page 556 of Functional Programming Simplified



 */

object Main extends App {

  case class GolfState(distance: Int)

  def swing(distance: Int): State[GolfState, Int] = State { (s: GolfState) =>
    val newAmount = s.distance + distance
    (GolfState(newAmount), newAmount)
  }

  val stateWithNewDistance: State[GolfState, Int] = for {
    _             <-  swing(20)
    _             <-  swing(15)
    totalDistance <-  swing(0)
  } yield totalDistance

  val beginningState = GolfState(0)

  val results: (GolfState, Int) = stateWithNewDistance.run(beginningState)

  println(s"GolfState:        ${results._1}")
  println(s"Total Distance:   ${results._2}")

}
