

# Worttrainer

## Projektübersicht

Der Worttrainer ist eine Anwendung für Volksschulkinder, die das richtige Schreiben von Wörtern anhand von Bildern üben können. Zu einem angezeigten Bild (über eine URL eingebunden) wird das entsprechende Wort geraten. Die Eingabe wird dann mit der korrekten Schreibweise verglichen und eine Erfolgsmeldung wird angezeigt.

## Funktionen

- Speichern von Wort-Bild-Paaren (über URLs verknüpfte Bilder)
- Zufällige Auswahl eines Wort-Bild-Paars zum Üben
- Benutzer gibt das entsprechende Wort ein, das mit der richtigen Schreibweise verglichen wird
- Statistiken über die Anzahl der Versuche und richtig/falsch beantwortete Wörter
- Grafische Oberfläche mit `JOptionPane` zur Anzeige von Bildern, Statistik und Eingabeaufforderung
- Persistierung der Worttrainer-Session (Wort-Bild-Paare, aktuelle Statistik) in einer JSON-Datei

## Entwicklungsprozess

Die Entwicklung wurde vollständig in einem **Git-Repository** dokumentiert und mit **Gradle** als Build-System durchgeführt. Der Entwicklungsprozess folgte einem Feature-basierten Ansatz:

1. **Entwurf**: Zu jedem Feature wurde zuerst das UML-Diagramm angepasst.
2. **Implementierung**: Jedes Feature wurde nacheinander implementiert.
3. **Tests**: Automatisierte Tests wurden mit **JUnit** geschrieben, um die Funktionalität der Anwendung sicherzustellen.
4. **Dokumentation**: Der Code wurde ausführlich mit **Javadoc** kommentiert.

## Technologien

- **Java**: Die gesamte Anwendung wurde in Java entwickelt.
- **Gradle**: Als Build-System und für die Abhängigkeiten.
- **JUnit**: Für Unit-Tests zur Überprüfung der Code-Funktionalität.
- **Gson**: Für die JSON-Persistierung und -Deserialisierung von Wort-Bild-Paaren.
- **JOptionPane**: Für die grafische Oberfläche (Dialoge für Eingabe und Anzeige von Bildern/Statistiken).

## Projektaufbau

- `src/main/java`: Enthält den Java-Code der Anwendung
- `src/test/java`: Enthält Unit-Tests für den Worttrainer
- `build.gradle`: Gradle-Build-Datei mit allen Abhängigkeiten
- `README.md`: Diese Dokumentation

## Setup und Ausführung

1. **Projekt klonen**: Klone das Repository auf dein lokales System.
   
   ```bash
   git clone https://github.com/TGM-HIT/sew9-2425-worttrainer-<github-username>
   ```

2. **Gradle-Build ausführen**: Verwende Gradle, um das Projekt zu bauen und Tests auszuführen.
   
   ```bash
   ./gradlew build
   ```

3. **Programm starten**: Führe die Anwendung aus, indem du die `Main`-Klasse startest. Das Programm lädt entweder die persistierten Daten oder startet eine neue Sitzung mit einigen vorgegebenen Wort-Bild-Paaren.

4. **Testen**: Um die Unit-Tests auszuführen, verwende:

   ```bash
   ./gradlew test
   ```



