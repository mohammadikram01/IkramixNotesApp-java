import javax.swing.*;
import java.awt.*;
import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class IkramixNotes extends JFrame {

    DefaultListModel<String> m=new DefaultListModel<>();
    JList<String> list=new JList<>(m);
    JComboBox<String> cat=new JComboBox<>(new String[]{"Work","Study","Personal","Other"});
    int fs=14; String PASS="1234", FILE="notes.txt";

    IkramixNotes(){
        if(!PASS.equals(JOptionPane.showInputDialog("Pass:")))System.exit(0);

        setTitle("Ikramix Notes"); setSize(480,520);
        add(new JScrollPane(list),BorderLayout.CENTER);

        JPanel top=new JPanel(new BorderLayout());
        JPanel c=new JPanel(); c.add(new JLabel("Cat:")); c.add(cat);
        JPanel f=new JPanel(); JButton sm=new JButton("A-"),bg=new JButton("A+");
        f.add(sm); f.add(bg);
        top.add(c,BorderLayout.WEST); top.add(f,BorderLayout.EAST);
        add(top,BorderLayout.NORTH);

        JPanel p=new JPanel(new GridLayout(1,6));
        JButton add=new JButton("Add"),edit=new JButton("Edit"),
        del=new JButton("Del"),clr=new JButton("Clr"),
        pdf=new JButton("PDF"),out=new JButton("Out");
        JButton[] bs={add,edit,del,clr,pdf,out};
        for(JButton b:bs){b.setFocusable(false); p.add(b);}
        add(p,BorderLayout.SOUTH);

        load(); font();

        add.addActionListener(e->{
            String t=JOptionPane.showInputDialog("Note:");
            if(t!=null&&!t.isEmpty()){m.addElement("["+cat.getSelectedItem()+"] "+t);save();}
        });

        edit.addActionListener(e->{
            int i=list.getSelectedIndex();
            if(i>=0){
                String t=JOptionPane.showInputDialog("Edit:",m.get(i));
                if(t!=null&&!t.isEmpty())m.set(i,t); save();
            }
        });

        del.addActionListener(e->{int i=list.getSelectedIndex();if(i>=0)m.remove(i);save();});
        clr.addActionListener(e->{if(JOptionPane.showConfirmDialog(this,"Clear?")==0){m.clear();save();}});
        sm.addActionListener(e->{if(fs>10){fs-=2;font();}});
        bg.addActionListener(e->{if(fs<30){fs+=2;font();}});
        out.addActionListener(e->{dispose();new IkramixNotes();});
        pdf.addActionListener(e->exportPDF());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); setVisible(true);
    }

    void exportPDF(){
        try{
            Document d=new Document();
            PdfWriter.getInstance(d,new FileOutputStream("all_notes.pdf"));
            d.open(); d.add(new Paragraph("Ikramix Notes\n"));
            for(int i=0;i<m.size();i++)d.add(new Paragraph(m.get(i)));
            d.close(); JOptionPane.showMessageDialog(this,"Exported!");
        }catch(Exception ex){}
    }

    void font(){
        list.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, fs));
    }

    void save(){try(FileWriter f=new FileWriter(FILE)){for(int i=0;i<m.size();i++)f.write(m.get(i)+"\n");}catch(Exception e){}}
    void load(){try(BufferedReader r=new BufferedReader(new FileReader(FILE))){String l;while((l=r.readLine())!=null)m.addElement(l);}catch(Exception e){}}

    public static void main(String[] a){new IkramixNotes();}
}
