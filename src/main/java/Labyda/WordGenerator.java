package Labyda;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordGenerator {

    //Create Word
    public void createWord() throws IOException {

        //Пустой документ
        XWPFDocument document = new XWPFDocument();
        //Записать документ в файловую систему
        FileOutputStream out = new FileOutputStream(
                new File("Отчёт.docx"));

        //создаь образец
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Запчасти в городе.");
        run.addBreak();
        run.setText("================================================================");
        run.addBreak();
        run.setText("|Название_фирмы           |Название_детали          |Количество_деталей       |");
        run.addBreak();
        run.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        run.addBreak();
        document.write(out);

        //закрыть документ
        out.close();

    }
}
