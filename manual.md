# Benutzerhandbuch – Zahlen-Geheimcode

## 1. Beschreibung
Zahlen-Geheimcode ist ein Java-Konsolenspiel, bei dem der Spieler
einen zufällig generierten vierstelligen Geheimcode erraten muss.

## 2. Spiel starten
1. Öffne das Projekt JavaProjekt in IntelliJ IDEA.
2. Öffne die Datei Main.java im Ordner src.
3. Klicke auf den grünen Play-Button neben der main-Methode.
4. Das Spiel startet in der Konsole.

## 3. Spielregeln
- Der Computer erstellt einen zufälligen vierstelligen Geheimcode.
- Der Code besteht aus den Ziffern 1 bis 9.
- Jede Ziffer darf nur einmal vorkommen.
- Der Spieler hat insgesamt 10 Versuche.
- Ziel ist es, den vollständigen Geheimcode zu erraten.

## 4. Spielablauf
1. Nach dem Start erscheint eine Begrüßung mit den Spielregeln.
2. Gib nach der Eingabeaufforderung vier verschiedene Ziffern von 1 bis 9
   ein und bestätige mit Enter, zum Beispiel `1234`.
3. Das Programm überprüft die Eingabe und gibt Hinweise zu den Ziffern aus.
4. Jeder gültige Tipp verbraucht einen Versuch. Es gibt höchstens zehn
   gültige Versuche pro Runde.
5. Das Spiel endet, wenn der Code erraten wurde oder alle zehn Versuche
   aufgebraucht sind.

## 5. Hinweise und Farben
- Lila: Die Ziffer ist richtig und befindet sich an der richtigen Position.
- Orange: Die Ziffer kommt im Geheimcode vor, steht aber an der falschen Position.
- Nach jedem gültigen Tipp wird angezeigt, wie viele Versuche noch übrig sind.

## 6. Ungültige Eingaben
Folgende Eingaben sind nicht erlaubt:
- Buchstaben oder Sonderzeichen
- Weniger oder mehr als vier Ziffern
- Die Ziffer 0
- Doppelte Ziffern

Bei einer ungültigen Eingabe erscheint eine Fehlermeldung.
Der Spieler verliert dadurch keinen Versuch.

## 7. Spielende
- Wenn der Geheimcode richtig erraten wurde, erscheint eine Glückwunschnachricht.
- Wenn alle 10 Versuche aufgebraucht wurden, wird der Geheimcode angezeigt.
- Anschließend fragt das Programm, ob du noch einmal spielen möchtest.
  Antworte mit `j` oder `ja`, um eine neue Runde zu starten.

## 8. Programm beenden
Antworte nach einer Runde mit `n` oder `nein`, um das Programm zu beenden.
Andere Antworten werden zurückgewiesen, bis eine der vier gültigen Antworten
`j`, `ja`, `n` oder `nein` eingegeben wurde. Auch mit Strg+D (Linux/macOS)
bzw. Strg+Z und Enter (Windows) kann die Konsoleneingabe beendet werden.

## 9. Debugging in IntelliJ IDEA
1. Öffne `src/Main.java` und setze links neben der Zeile `int attempts = 0;`
   in `playGame` einen Breakpoint (roter Punkt im Rand).
2. Starte das Programm mit **Debug** statt **Run**.
3. Der Debugger hält nach dem Erzeugen des Geheimcodes am Breakpoint an.
   Im Fenster **Variables** kannst du zum Beispiel `secretCode` und `attempts`
   untersuchen.
4. Mit **F8** gehst du zur nächsten Zeile; mit **F9** läuft das Programm bis
   zum nächsten Breakpoint weiter.
5. Mache während der Debugger angehalten ist einen Screenshot, auf dem der
   Breakpoint, der angehaltene Quellcode und das Debugger-Fenster sichtbar sind.
   Unter Windows öffnet **Win+Umschalt+S** das Ausschneidewerkzeug.

Zum normalen Spielen kannst du das Programm jederzeit mit **Run** starten;
der Breakpoint ist nur für den Debug-Lauf erforderlich.