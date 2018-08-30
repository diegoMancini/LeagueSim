
object ScalaMain {

  def main(args: Array[String]): Unit = {

    //Players --> GK, DEF, MID, FWD
    //Boca
    val eAndrada = new Player("Esteban Andrada","GK", Map("Goalkeeping" -> 80, "Value" -> 90))
    val lJara = new Player("Leonardo Jara", "DEF", Map("Defense" -> 75, "Attack" -> 60, "Value" -> 85))
    val pGoltz = new Player("Paolo Goltz", "DEF", Map("Defense" -> 83, "Attack" -> 30, "Value" -> 85))
    val lMagallan = new Player("Lisandro Magallan", "DEF", Map("Defense" -> 85, "Attack" -> 35, "Value" -> 85))
    val fFabra = new Player("Frank Fabra", 1, (70,75,90))
    val fGago = new Player()
    val wBarrios = new Player()
    val eCardona = new Player()
    val mZarate = new Player()
    val cPavon = new Player()
    val dBenedetto = new Player("Dario Benedetto", "FWD", Map("Defense" ->20, "Attack" -> 90))
    //River

    //Independiente
    //Player List
    val bocaJuniorsPlayers = List(eAndrada, lJara , dBenedetto )
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
