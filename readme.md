# Geheimcode-Spiel

## Projektbeschreibung

Dieses Java-Konsolenspiel erstellt einen zufälligen vierstelligen Geheimcode. Der Code enthält nur Ziffern von 1 bis 9 und keine Ziffer kommt mehrmals vor. Der Spieler versucht, den Code innerhalb von zehn gültigen Versuchen zu erraten.

Nach jedem gültigen Tipp zeigt das Spiel für jede Stelle einzeln an, ob die Ziffer passt, zwar im Geheimcode vorkommt, aber an der falschen Stelle steht, oder nicht im Code vorkommt. Eine passende Ziffer wird lila angezeigt, eine vorkommende Ziffer an der falschen Stelle orange. Zusätzlich zeigt das Spiel die jeweiligen Trefferzahlen und die verbleibenden Versuche an. Wenn der Code erraten wurde, erscheint der vollständige Code lila. Ungültige Eingaben werden erklärt und kosten keinen Versuch. Nach einer Runde kann der Spieler eine neue Runde starten oder das Programm beenden.

Die Farben werden über ANSI-Farbcodes ausgegeben. Für die farbige Darstellung muss das verwendete Terminal ANSI-Farben unterstützen; die Textmeldungen nennen die Positionen und Treffer auch unabhängig von der Farbe.

## Autor

Berna Ibili

## Starten

Das Projekt benötigt ein installiertes Java Development Kit. Die Datei `src/Main.java` kann in einer Java-IDE gestartet werden. Alternativ lassen sich die folgenden Befehle im Projektverzeichnis ausführen:

```text
javac src\Main.java
java -cp src Main
```
