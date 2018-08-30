class Competition (val name: String, val teamList: List[Team], val refereeList: List[Referee]) {

  teamList.sortWith(_.points > _.points)

  override def toString: String = {
    var result = ""
    val line = "=============================================================================\n"
    teamList.foreach(team => result += team.toString + "\n\n")
    s"                    |  Competition: $name |\n\n$result\n" + printTable
  }

  def printTable: String = {
    teamList.sortWith(_.points>_.points)
    var result = "\n"
    var index = 0
    result += "|| Pos || Team Name || Pts || GF || GA || GD || YEL || RED || \n"
    teamList.foreach(team => result += s"|| ${teamList.indexOf(team)} || ${team.name} || ${team.points} || ${team.goalsFor} || ${team.goalsAgainst} || ${team.goalDifference} || ${team.yellowCards} || ${team.redCards} ||\n")
    result
  }


}
