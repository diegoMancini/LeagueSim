class Tactics(val formation: Map[String , Int]) {

  override def toString: String = {
    s"${formation("DEF")}-${formation("MID")}-${formation("FWD")}"
  }
}
