import scala.annotation.tailrec

class Team (val name: String, val players: List[Player], val manager : Manager, val stadium: Stadium, val tactics: Tactics) {

  val reputation: Int = getReputation
  var points: Int = 0
  var goalsFor: Int = goals()
  var goalsAgainst: Int = players(0).goals
  var goalDifference: Int = goalsFor - goalsAgainst
  var yellowCards: Int = yellow()
  var redCards: Int = red()

  val goalscorer : Player = {
    val aux = players.sortWith(_.goals > _.goals)
    aux.head
  }

  private def goals(): Int = {
    @tailrec
      def goals(list: List[Player], accum: Int) : Int = {
        list match {
          case x :: tail => goals(tail, accum + x.goals)
          case Nil => accum
        }
    }
    goals(players, 0)
  }

  private def yellow(): Int = {
    @tailrec
    def yellow(list: List[Player], accum: Int) : Int = {
      list match {
        case x :: tail => yellow(tail, accum + x.yellowCards)
        case Nil => accum
      }
    }
    yellow(players, 0)
  }

  private def red(): Int = {
    @tailrec
    def red(list: List[Player], accum: Int) : Int = {
      list match {
        case x :: tail => red(tail, accum + x.redCards)
        case Nil => accum
      }
    }
    red(players, 0)
  }

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

  override def toString: String = {
    var result = ""
    players.foreach(player => result += player.toString + "\n")
    s"-  Team: $name  |||  Manager: ${manager.name}  |||  Stadium: ${stadium.name}  |||  Tactics: ${tactics.toString}  |||\n$result"
  }

}

