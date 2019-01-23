package com.lee.aspirateurdonnees.asp;

import com.lee.aspirateurdonnees.model.Cours;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoursDataAspirateur {

    private static final Logger LOG = LoggerFactory.getLogger(CoursDataAspirateur.class);
    private static final String FILECSV = "src/main/resources/cours.csv";

    public static void h2ToCvs(PrintWriter writerHttpServletResponse, List<Cours> coursList) throws IOException{
        try{
        /* reponse sur la page : http://localhost:8080/cours */
            ColumnPositionMappingStrategy cpms = new ColumnPositionMappingStrategy();
            cpms.setType(Cours.class);
            cpms.generateHeader();
            String[] col = new String[]{"id", "typeEvenement", "nomEvenement", "typeParticipation", "dateDebut","dateFin", "duree", "presence"};
            cpms.setColumnMapping(col);

            StatefulBeanToCsvBuilder<Cours> builderHttpServletResponse= new StatefulBeanToCsvBuilder(writerHttpServletResponse);
            StatefulBeanToCsv sbtcHttpServletResponse = builderHttpServletResponse
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(cpms)
                    .withSeparator(';')
                    .build();
            sbtcHttpServletResponse.write(coursList);
            writerHttpServletResponse.close();

        /* telechargement du fichier cours.csv quand on va sur la page : http://localhost:8080/cours */
            FileWriter writerFileCsv = new FileWriter(FILECSV);

            StatefulBeanToCsvBuilder<Cours> builderFileCsv= new StatefulBeanToCsvBuilder(writerFileCsv);
            StatefulBeanToCsv sbtcFileCsv = builderFileCsv
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(cpms)
                    .withSeparator(';')
                    /*.withLineEnd("/")*/
                    .build();
            sbtcFileCsv.write(coursList);
            writerFileCsv.close();

        } catch (CsvException exception) {
            LOG.error("Erreur !", exception);
        }
    }
}