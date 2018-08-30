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

  def this(name: String, pos: Int, data: (Int, Int, Int)) = {
    this(name, {if (pos == 0) "GK" else if (pos ==1) "DEF" else if (pos == 2) "MID" else "FWD"}, attributes = Map("Defense" -> data._1, "Attack" -> data._2 , "Value" -> data._3))
  }

  def this(name: String, position: String, data: (Int, Int)) = {
    this(name, position, attributes = Map("Goalkeeping" -> data._1, "Value" -> data._2))
  }

}
