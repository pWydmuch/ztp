package zad2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {
    private static final String BASIC_PATH = "src/main/resources/";
    private FileWriter fw = null;
    private PrintWriter pw;
    private List<String> fieldsTypes;
    private List<String> fieldsNames;
    private String className;

    public CodeGenerator() {
        fieldsNames = new ArrayList<>();
        fieldsTypes = new ArrayList<>();
    }

    public void generateCode(String classDescription, String gettersSetters, String singleton) {
        generateClassSignature(classDescription);
        pw.println();
        generateFields(classDescription);
        if(singleton.equalsIgnoreCase("T")){
            generateSingleton();
        }
        pw.println();
        if (gettersSetters.equalsIgnoreCase("T")){
            generateGettersSetters();
        }
        pw.println("\n}");
    }
    private void generateClassSignature(String classDescription){
        className = classDescription;
        int iend = classDescription.indexOf("{");
        if (iend ==-1){
            throw new RuntimeException("Po nazwie klasy musi pojawic sie \'{\'");
        }
        className = classDescription.substring(0, iend); //this will give abc
        initiatePrintWriter();
        pw.println("public class " + className + " {");
    }

    private void initiatePrintWriter() {
        File file = new File(BASIC_PATH + className + ".java");

        try {
            fw = new FileWriter(file, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw = new PrintWriter(fw, true);
    }


    private void generateSingleton(){
        pw.println("\tprivate final static " +className+" ourInstance = "+"new "+className+"()"+";");
        pw.println();
        pw.println("\tpublic static " +className+" getInstance() {");
        pw.println("\t\treturn ourInstance;");
        pw.println("\t}");
        pw.println();
        pw.println("\tprivate " +className+"() {");
        pw.println("\t}");
    }

    private void generateGettersSetters() {
        for (int i =0; i<fieldsNames.size();i++){
            pw.println("\tpublic "+ fieldsTypes.get(i)+" get"+capitalize(fieldsNames.get(i))+"() {");
            pw.println("\t\treturn "+ fieldsNames.get(i)+ ";");
            pw.println("\t}");

            pw.println("\tpublic void set"+capitalize(fieldsNames.get(i))+"(" + fieldsTypes.get(i) +" "+ fieldsNames.get(i)+") {");
            pw.println("\t\tthis."+fieldsNames.get(i) + " = " + fieldsNames.get(i) + ";");
            pw.println("\t}");
        }
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    private void generateFields(String classDescription) {
        int beginingCharIndex = classDescription.indexOf("{") + 1;
        int endingCharIndex = classDescription.indexOf("}");
        if (beginingCharIndex ==-1 || endingCharIndex ==-1){
            throw new RuntimeException("Definicje pól muszą być objęte klamrami {}");
        }
        String fieldsDeclaration = classDescription.substring(beginingCharIndex,endingCharIndex);
        String[] eachFieldDeclarations = fieldsDeclaration.split(",");
        for (String eachFieldDeclaration : eachFieldDeclarations) {
            System.out.println(eachFieldDeclaration);
            String[] fieldSignature = eachFieldDeclaration.split(":");
            int iend = fieldSignature[1].indexOf("=");
            fieldsTypes.add(fieldSignature[0]);
            if(iend != -1){
                String[] fieldAssigment = fieldSignature[1].split("=");
                pw.println("\tprivate "+ fieldSignature[0]+" " + fieldAssigment[0] +" = " + fieldAssigment[1] +";");
                fieldsNames.add(fieldAssigment[0]);
            }
            else{
                pw.println("\tprivate "+ fieldSignature[0]+" " + fieldSignature[1] +";");
                fieldsNames.add(fieldSignature[1]);
            }
        }
    }



}
