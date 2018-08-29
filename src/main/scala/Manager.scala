class Manager (val name: String, val attributes: Map[String,Int]) extends Person{

  def this(name:String) = this(name, Map.empty)

}
