
object ScalaMain {

  def main(args: Array[String]): Unit = {

    //Players --> GK, DEF, MID, FWD
    //Boca
    val eAndrada = new Player("Esteban Andrada","GK", Map("Goalkeeping" -> 80))
    val lJara = new Player("Leonardo Jara", "DEF", Map("Defense" -> 75, "Attack" -> 60))
    val pGoltz = new Player("Paolo Goltz", "DEF", Map("Defense" -> 83, "Attack" -> 30))
    val lMagallan = new Player("Lisandro Magallan", "DEF", Map("Defense" -> 85, "Attack" -> 35))
    val fFabra = new Player("Frank Fabra", 1, (70,75))
    val fGago = new Player("Fernando Gago", 2, (70,75))
    val wBarrios = new Player("Wilmar Barrios", 2, (85,65))
    val eCardona = new Player("Edwin Cardona", 2, (60,80))
    val mZarate = new Player("Mauro Zarate", 3, (20, 80))
    val cPavon = new Player("Cristian Pavon", 3, (40, 83))
    val dBenedetto = new Player("Dario Benedetto", "FWD", Map("Defense" ->20, "Attack" -> 95))

    //River
    val fArmani = new Player("Franco Armani","GK", Map("Goalkeeping" -> 85))
    val jMoreira = new Player("Jorge Moreira", "DEF", Map("Defense" -> 72, "Attack" -> 60))
    val jMaidana = new Player("Jonathan Maidana", 1, (90, 60))
    val jPinola = new Player("Javier Pinola", 1, (80,30))
    val mCasco = new Player("Milton Casco", 1, (65, 65))
    val nFernandez = new Player("Ignacio Fernandez", 2, (73,70))
    val lPonzio = new Player("Leonardo Ponzio", 2, (80, 60))
    val ePalacios = new Player("Exequiel Palacios", 2, (70, 75))
    val pMartinez = new Player("Pity Martinez", 2, (55, 80))
    val nScocco = new Player("Ignacio Scocco", 3, (30,85))
    val lPratto = new Player("Lucas Pratto", 3, (20, 90))

    //Independiente

    //Player List
    val bocaJuniorsPlayers = List(eAndrada, lJara , pGoltz, lMagallan, fFabra, fGago, wBarrios, eCardona, mZarate, cPavon, dBenedetto )
    val riverPlatePlayers = List(fArmani, jMoreira, jMaidana, jPinola, mCasco, nFernandez, lPonzio, ePalacios, pMartinez, nScocco, lPratto)

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

    val superClasico = new Match((bocaJuniors, riverPlate), elizondo)
//    superClasico.toString

  }

}
