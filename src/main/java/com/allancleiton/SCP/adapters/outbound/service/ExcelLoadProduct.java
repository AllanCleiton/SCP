package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.entities.JpaProductEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaProductRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelLoadProduct {


    private final JpaProductRepository jpaProductRepository;

    public ExcelLoadProduct(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    // Formato da data
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void LoadProducts() throws IOException{
        List<JpaPalletEntity> listProducts = new ArrayList<>();
        final String defaultPath = "src/main/resources/temp/products.xlsx";

        int line=1;
        try (FileInputStream file = new FileInputStream( defaultPath);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();



            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                try {

                    String[] fields = {
                            String.valueOf((long) row.getCell(2).getNumericCellValue()).replace(".0", ""),
                            String.valueOf(row.getCell(3).getNumericCellValue()).replace(".0", ""),
                            String.valueOf(row.getCell(4).getNumericCellValue()).replace(".0", ""),
                            String.valueOf(row.getCell(13).getNumericCellValue()).replace(".0", ""),
                            String.valueOf(row.getCell(14).getNumericCellValue()).replace(".0", ""),
                            String.valueOf(row.getCell(1).getNumericCellValue()).replace(".0", ""),
                            row.getCell(7).getStringCellValue(),
                            row.getCell(15).getStringCellValue(),
                            String.valueOf(row.getCell(6).getNumericCellValue()).replace(".0", "")

                    };

                   // int validate = (int) ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(fields[5], formatter)) * (-1);

                    if(Long.parseLong(fields[5]) == 0){
                        jpaProductRepository.save(new JpaProductEntity(
                                Long.valueOf(fields[0]),
                                Long.valueOf(fields[1]),
                                Long.valueOf(fields[2]),
                                Double.valueOf(fields[3]),
                                Short.valueOf(fields[4]),
                                LocalDate.parse(fields[6], formatter),
                                LocalDate.parse(fields[7], formatter),
                                Integer.parseInt(fields[8])
                        ));
                    }else {
                        jpaProductRepository.save(new JpaProductEntity(
                                Long.valueOf(fields[0]),
                                Long.valueOf(fields[1]),
                                Long.valueOf(fields[2]),
                                Double.valueOf(fields[3]),
                                Short.valueOf(fields[4]),
                                new JpaPalletEntity(Long.parseLong(fields[5])),
                                LocalDate.parse(fields[6], formatter),
                                LocalDate.parse(fields[7], formatter),
                                Integer.parseInt(fields[8])
                        ));
                    }

                }catch (IllegalStateException t ) {
                    //t.printStackTrace();
                    System.out.println(" Não foi possivel pegar um valor numérico de uma célula de string!");
                }


                line++;
            }
        } catch (IOException e) {
            System.out.println(" Ouve um erro ao tentar localizar o arquivo pallets.xls!\n "+ e.getMessage());

        }
    }

}
