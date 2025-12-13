package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.entities.JpaProductEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaProductRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.DataIntegrityViolationException;
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
        String pallet = null;
        try (FileInputStream file = new FileInputStream( defaultPath);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();



            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                try {
                    if(!row.getCell(2).getStringCellValue().equals("Etiq Prod")) {
                        String[] fields = {
                                row.getCell(2).getStringCellValue().replace(".", ""),
                                row.getCell(3).getStringCellValue().replace(".", ""),
                                row.getCell(4).getStringCellValue(),
                                row.getCell(13).getStringCellValue().replace(",", "."),
                                row.getCell(14).getStringCellValue(),
                                row.getCell(7).getStringCellValue(),
                                row.getCell(15).getStringCellValue(),
                                row.getCell(6).getStringCellValue().replace(",00", ""),
                                row.getCell(1).getStringCellValue().replace(".", ""),

                        };


                        if (row.getCell(1).getStringCellValue().replace(".", "").isEmpty() || row.getCell(0).getStringCellValue().equals("SEM ENDEREÇO")) {
                            pallet = fields[8];
                            jpaProductRepository.save(new JpaProductEntity(
                                    Long.valueOf(fields[0]),
                                    Integer.valueOf(fields[1]),
                                    Integer.valueOf(fields[2]),
                                    Double.valueOf(fields[3]),
                                    Short.valueOf(fields[4]),
                                    LocalDate.parse(fields[5], formatter),
                                    LocalDate.parse(fields[6], formatter),
                                    Integer.parseInt(fields[7])
                            ));
                        } else {
                            pallet = fields[8];
                            jpaProductRepository.save(new JpaProductEntity(
                                    Long.valueOf(fields[0]),
                                    Integer.valueOf(fields[1]),
                                    Integer.valueOf(fields[2]),
                                    Double.valueOf(fields[3]),
                                    Short.valueOf(fields[4]),
                                    new JpaPalletEntity(Integer.parseInt(fields[8])),
                                    LocalDate.parse(fields[5], formatter),
                                    LocalDate.parse(fields[6], formatter),
                                    Integer.parseInt(fields[7])
                            ));
                        }
                    }


                }catch (IllegalStateException | NumberFormatException e) {
                    e.printStackTrace();
                }catch (DataIntegrityViolationException ex) {
                    System.out.println("Erro de FK: pallet não existe:  " + pallet);

                }


                line++;
            }
        } catch (IOException e) {
            System.out.println(" Ouve um erro ao tentar localizar o arquivo pallets.xls!\n "+ e.getMessage());

        }
    }

}
