class Player (val name: String, val position: String, val attributes: Map[String, Int]) extends Person{

  val overall: Int = attributes.foldLeft(0)(_ + _._2)/5

}
