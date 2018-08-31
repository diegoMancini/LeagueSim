import scala.annotation.tailrec

class Team (val name: String, val players: List[Player], val manager : Manager, val stadium: Stadium, val tactics: Tactics) {

  val reputation: Int = getReputation
  var points: Int = 0
  var goalsFor: Int = goals()
  var goalsAgainst: Int = players.head.goals
  var goalDifference: Int = goalsFor - goalsAgainst
  var yellowCards: Int = yellow()
  var redCards: Int = red()

  val listByPosition: Map[String, List[Player]] = generateListByPosition
  val gkOverall = players.head.overall
  val defenseOverall = {}
  val midfieldOverall = {}
  val forwardOverall = {}


  val goalscorer : Player = {val aux = players.sortWith(_.goals > _.goals); aux.head}
  val printGoalscorer = s"${goalscorer.name}: ${goalscorer.goals} goals"

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

  def getReputation: Int = {
  @tailrec
    def getReputation(list: List[Player], accum: Int): Int = {
      list match {
        case x :: tail => getReputation(tail, accum + x.overall)
        case Nil => accum
      }
    }
    getReputation(players, 0)
  }

  implicit def generateListByPosition : Map[String, List[Player]] = {
    val defense = tactics.formation("DEF")
    val midfield = tactics.formation("MID")
    val forward = tactics.formation("FWD")
    val goalkeeper = List(players.head)
    val defenders: List[Player] = players.filter(player => if (player.position == "DEF") true else false)
    val midfielders: List[Player] = players.filter(player => if (player.position == "MID") true else false)
    val forwards: List[Player] = players.filter(player => if (player.position == "FWD") true else false)

    Map(("Goalkeeper", goalkeeper),("Defense", defenders), ("Midfield", midfielders) , ("Forwards", forwards))
  }

  override def toString: String = {
    var result = ""
    players.foreach(player => result += player.toString + "\n")
    s"-  Team: $name  |||  Manager: ${manager.name}  |||  Stadium: ${stadium.name}  |||  Tactics: ${tactics.toString}  |||\n$result"
  }

}

