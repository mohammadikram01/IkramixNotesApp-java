package com.ikramix.notes.service;

import com.ikramix.notes.model.Note;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotesService {

    private final Path FILE = Paths.get("notes.txt");

    public synchronized List<Note> loadNotes() {
        if (!Files.exists(FILE)) return new ArrayList<>();
        try {
            return Files.readAllLines(FILE).stream()
                    .filter(l -> !l.isBlank())
                    .map(l -> {
                        if(l.startsWith("[")) {
                            int end = l.indexOf(']');
                            if (end > 0 && l.length() > end+2) {
                                String cat = l.substring(1, end);
                                String text = l.substring(end + 2);
                                return new Note(cat, text);
                            }
                        }
                        return new Note("Other", l);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public synchronized void saveNotes(List<Note> notes) {
        try (BufferedWriter bw = Files.newBufferedWriter(FILE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Note n : notes) {
                bw.write("[" + n.getCategory() + "] " + n.getText());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
