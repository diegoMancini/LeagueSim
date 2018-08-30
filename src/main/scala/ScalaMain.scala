object ScalaMain {

  def main(args: Array[String]): Unit = {

    //Players --> GK, DEF, MID, FWD
    val bocaJuniorsPlayers = List(new Player("Esteban Andrada","GK", Map("Goalkeeping" -> 80)), new Player("Leonardo Jara", "DEF", Map("Defense" -> 75, "Attack" -> 60)), new Player("Dario Benedetto", "FWD", Map("Defense" ->20, "Attack" -> 90)))
    bocaJuniorsPlayers(1).goals += 13
    bocaJuniorsPlayers(2).goals = 15
    val riverPlatePlayers = List(new Player("Franco Armani","GK", Map("Goalkeeping" -> 85)), new Player("Jorge Moreira", "DEF", Map("Defense" -> 72, "Attack" -> 63)))

    //Managers
    val bocaJuniorsManager = new Manager("Guillermo Barros Schelotto")
    val riverPlateManager = new Manager("Marcelo Gallardo")

    //Stadium
    val bocaJuniorsStadium = new Stadium("La Bombonera")
    val riverPlateStadium = new Stadium("El Monumental")

    //Tactics
    val bocaJuniorsTactics = new Tactics(Map("DEF" -> 4, "MID" -> 3, "FWD" -> 3))
    val riverPlateTactics = new Tactics(Map("DEF" -> 4, "MID" -> 4, "FWD" -> 2))

    //Teams
    val bocaJuniors = new Team("Boca Juniors", bocaJuniorsPlayers, bocaJuniorsManager, bocaJuniorsStadium, bocaJuniorsTactics)
    val riverPlate = new Team("River Plate", riverPlatePlayers, riverPlateManager, riverPlateStadium, riverPlateTactics)
    //Team List
    val teamList = List(bocaJuniors, riverPlate).sortBy(team => team.name)

    //Referees
    val elizondo = new Referee("Horacio Elizondo",Map("Overall" -> 100))
    //Referee List
    val refereeList = List(elizondo)

    //League
    val primeraDivisionArgentina = new Competition("Primera Division Argentina", teamList, refereeList)

    println("\n\n" +  primeraDivisionArgentina.toString + "\n\n")
    println("Goalscorer: " + bocaJuniors.printGoalscorer)

  }

}
