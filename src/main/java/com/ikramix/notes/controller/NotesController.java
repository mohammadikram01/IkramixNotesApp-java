package com.ikramix.notes.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.ikramix.notes.model.Note;
import com.ikramix.notes.service.NotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NotesController {

    private final NotesService service;
    private final String PASS = "1234"; // keep same default; change in production

    public NotesController(NotesService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String pass) {
        if (PASS.equals(pass)) {
            return "redirect:/notes";
        }
        return "login";
    }

    @GetMapping("/notes")
    public String notes(Model model) {
        model.addAttribute("notes", service.loadNotes());
        model.addAttribute("cats", List.of("Work","Study","Personal","Other"));
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam String category, @RequestParam String text) {
        if (!StringUtils.hasText(text)) return "redirect:/notes";
        List<Note> list = service.loadNotes();
        list.add(new Note(category, text));
        service.saveNotes(list);
        return "redirect:/notes";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int index, @RequestParam String text, @RequestParam String category) {
        List<Note> list = service.loadNotes();
        if (index >= 0 && index < list.size()) {
            list.set(index, new Note(category, text));
            service.saveNotes(list);
        }
        return "redirect:/notes";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int index) {
        List<Note> list = service.loadNotes();
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            service.saveNotes(list);
        }
        return "redirect:/notes";
    }

    @PostMapping("/clear")
    public String clear() {
        service.saveNotes(new ArrayList<>());
        return "redirect:/notes";
    }

    @GetMapping("/pdf")
    public String exportPdf() {
        try {
            Document d = new Document();
            PdfWriter.getInstance(d, new FileOutputStream("all_notes.pdf"));
            d.open();
            d.add(new Paragraph("Ikramix Notes\n\n"));
            for (Note n : service.loadNotes()) {
                d.add(new Paragraph("[" + n.getCategory() + "] " + n.getText()));
            }
            d.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/notes";
    }
}
