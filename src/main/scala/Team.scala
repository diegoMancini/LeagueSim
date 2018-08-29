import scala.annotation.tailrec

class Team (val name: String, val players: List[Player], val manager : Manager, val stadium: Stadium, val tactics: Tactics) {

  val reputation: Int = getReputation
  var points: Int = 0
  var goalsFor: Int = 0
  var goalsAgainst: Int = 0
  var goalDifference: Int = goalsFor - goalsAgainst


  implicit def getReputation: Int = {
  @tailrec
    def getReputation(list: List[Player], accum: Int): Int = {
      list match {
        case x :: tail => getReputation(tail, accum + x.overall)
        case Nil => accum
      }
    }
    getReputation(players, 0)
  }

}

