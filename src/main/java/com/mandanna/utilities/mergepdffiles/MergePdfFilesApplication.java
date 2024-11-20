package com.mandanna.utilities.mergepdffiles;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MergePdfFilesApplication {

    public void mergePDFFiles(List<File> files,
                              String mergedFileName) {
        try {
            PDFMergerUtility pdfmerger = new PDFMergerUtility();
            for (File file : files) {
                PDDocument document = Loader.loadPDF(file);
                pdfmerger.setDestinationFileName(mergedFileName);
                pdfmerger.addSource(file);
                pdfmerger.mergeDocuments(null);
                document.close();
            }
        } catch (IOException e) {
            System.out.println("Error to merge files. Error: " + e.getMessage());
        }
    }

    public static void main(String args[]) throws Exception {
        String myDirectoryPath = "C:\\Users\\manda\\IdeaProjects\\merge-pdf-files\\src\\main\\resources";
        File dir = new File(myDirectoryPath);
        File[] directoryListing = dir.listFiles();
        MergePdfFilesApplication app = new MergePdfFilesApplication();
        app.mergePDFFiles(List.of(directoryListing),"combined-18-dec-2018-25-apr-2020-270-10-st");
    }
}
