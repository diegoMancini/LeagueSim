class Match (val teams: (Team, Team), val referee: Referee) {

  var homeGoals = 0
  var homeYellow = 0
  var homeRed = 0
  var awayGoals = 0
  var awayYellow = 0
  var awayRed = 0

  val info = {

  }


  def calculate() :(Int, Int, Int, Int, Int, Int) = {
    val homeTeam = teams._1
    val awayTeam = teams._2
    val ratio = if (betterTeam._2 == 1) 0.75 else 0.25

    val homeGK = homeTeam.players.head.overall
    val homeDefense = (homeTeam.tactics.formation("DEF"), homeTeam.defenseOverall)
    val homeMidfield = (homeTeam.tactics.formation("MID"), homeTeam.midfieldOverall)
    val homeForward = (homeTeam.tactics.formation("FWD"), homeTeam.forwardOverall)

    val awayGK = awayTeam.players.head.overall
    val awayDefense = (awayTeam.tactics.formation("DEF"), awayTeam.defenseOverall)
    val awayMidfield = (awayTeam.tactics.formation("MID"), awayTeam.midfieldOverall)
    val awayForward = (awayTeam.tactics.formation("FWD"), awayTeam.forwardOverall)

    (1,3,0,0,5,1)
  }

  val betterTeam: (Team,Int)= if (teams._1.getReputation > teams._2.getReputation) (teams._1,1) else (teams._2,2)
}
