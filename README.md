# IkramixNotesApp

A Spring Boot web conversion of your original Swing Ikramix Notes app.
Features:
- Login (default password: 1234)
- Add / Edit / Delete / Clear notes
- Categories: Work / Study / Personal / Other
- Export notes to PDF (`all_notes.pdf`)
- Uses Bootstrap for a modern responsive UI
- Notes are stored in `notes.txt` at the application working directory

## Run locally

1. Build:
   mvn clean package

2. Run:
   java -jar target/IkramixNotesApp-0.0.1-SNAPSHOT.jar

3. Open:
   http://localhost:8080

## Deploy on EC2
- Install Java 17
- Upload jar and run `java -jar ...`
- Optionally setup systemd service and reverse-proxy with Nginx

