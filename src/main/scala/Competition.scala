class Competition (val name: String, val teamList: List[Team], val refereeList: List[Referee]) {

  teamList.sortWith(_.points > _.points)

  override def toString: String = {
    var result = ""
    teamList.foreach(team => result += team.toString + "\n\n")
    s"                    |  Competition: $name |\n\n$result\n" + printTable
  }

  def printTable: String = {
    var result = "\n"
    val line = "=================================================================\n"
    result += s"\n$line|| Pos || Team Name || Pts || GF || GA || GD || YEL || RED || \n$line"
    teamList.foreach(team => result += s"|| ${teamList.indexOf(team)} || ${team.name} || ${team.points} || ${team.goalsFor} || ${team.goalsAgainst} || ${team.goalDifference} || ${team.yellowCards} || ${team.redCards} ||\n$line")
    result
  }


}
