package ToDo_List;

public class Messages {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_REDTEXT = "\u001B[31m";
	public static final String ANSI_GREENTEXT = "\u001B[32m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	
	public static void Hauptmenü() {
		System.out.println("*   *  *****  *      *      *****");
		System.out.println("*   *  *   *  *      *      *   *");
		System.out.println("*****  *****  *      *      *   *");
		System.out.println("*   *  *   *  *      *      *   *");
		System.out.println("*   *  *   *  *****  *****  *****");
		System.out.println("===================================");
		
		System.out.println("Willkommen zurück.");
		System.out.print("Momentan hast du noch ");
		//X und Y über getCount Funktion in Task Klasse
		System.out.print(ANSI_RED_BACKGROUND + "{X} Tasks" + ANSI_RESET);
		System.out.println(" von insgesamt {Y} Tasks offen.");
		System.out.println("");
		System.out.println("Du hast folgende Optionen:");
		System.out.println("1. Tasks anzeigen, die noch zu erledigen sind");
		System.out.println("2. Tasks anzeigen, die schon erledigt wurden");
		System.out.println("3. Eine offene Task auf erledigt setzen");
		System.out.println("4. Eine erledigte Task löschen");
		System.out.println("Ihre Auswahl (1-4): ");
		
		
		
	}
	public static void displayTasks() {
		System.out.println("*****       ****       ");
		System.out.println("  *         *   *      ");
		System.out.println("  *   ****  *   * ****  *");
		System.out.println("  *   *  *  *   * *  *   ");
		System.out.println("  *   ****  ****  ****  *");
		System.out.println("==========================");
	}
	

	
}
