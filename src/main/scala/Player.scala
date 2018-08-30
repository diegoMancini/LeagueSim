class Player (val name: String, val position: String, val attributes: Map[String, Int]) extends Person{

  var goals = 0
  var yellowCards = 0
  var redCards = 0
  val overall: Int = attributes.foldLeft(0)(_ + _._2)/5

  override def toString: String = {
    var result = ""
    for ((k,v) <- attributes) result += s"$k: $v | "
    s"|||  Player: $name  |||  Position: $position  |||  Attributes: => $result<="
  }

}
