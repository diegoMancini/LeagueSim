class Player (val name: String, val position: String, val attributes: Map[String, Int]) extends Person{

  var goals = 0
  var yellowCards = 0
  var redCards = 0
  val overall: Int = { if(this.position == "MID" ) attributes.foldLeft(0)(_ + _._2) / 2 else if(this.position == "GK") attributes("Goalkeeping") else if(this.position == "FWD") attributes.foldLeft(0)(_ + _._2) / 2 + 20 else attributes.foldLeft(0)(_ + _._2) / 2 + 10}

  override def toString: String = {
    var result = ""
    for ((k,v) <- attributes) result += s"$k: $v | "
    s"|||  Player: $name  |||  Position: $position  |||  Overall: $overall  |||  Attributes: => $result<=  |||"
  }

  def this(name: String, pos: Int, data: (Int, Int)) = {
    this(name, {if (pos ==1) "DEF" else if (pos == 2) "MID" else "FWD"}, attributes = Map("Defense" -> data._1, "Attack" -> data._2))
  }

  def this(name: String, data: Int) = {
    this(name, "GK", attributes = Map("Goalkeeping" -> data))
  }

}
