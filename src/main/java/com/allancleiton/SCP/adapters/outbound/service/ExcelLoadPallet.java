package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaPalletRepository;
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
import java.util.Iterator;


@Component
public class ExcelLoadPallet {


    private final JpaPalletRepository jpaPalletRepository;

    public ExcelLoadPallet(JpaPalletRepository jpaPalletRepository) {
        this.jpaPalletRepository = jpaPalletRepository;
    }

    // Formato da data
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void LoadPallets(){
        final String defaultPath = "src/main/resources/temp/pallets.xlsx";

        int line=1;
        try (FileInputStream file = new FileInputStream( defaultPath);
             Workbook workbook = new XSSFWorkbook(file)) {
             Sheet sheet = workbook.getSheetAt(0);
             Iterator<Row> rowIterator = sheet.iterator();



            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                try {
                    if( row.getCell(1) != null) {
                        if(row.getCell(1).getNumericCellValue() != 0) {
                            try {
                                String[] fields = {
                                        String.valueOf(row.getCell(1).getNumericCellValue()).replace(".0", ""),
                                        String.valueOf(row.getCell(3).getNumericCellValue()).replace(".0", ""),
                                        row.getCell(8).getStringCellValue().substring(0,5),
                                        row.getCell(8).getStringCellValue().substring(5,8),
                                        row.getCell(8).getStringCellValue().substring(9),
                                        row.getCell(0).getStringCellValue(),
                                        String.valueOf(row.getCell(6).getNumericCellValue()).replace(".0", "")

                                };

                                int days = (int) ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(fields[5], formatter)) * (-1);

                                jpaPalletRepository.save(new JpaPalletEntity(
                                        Long.valueOf(fields[0]),
                                        Long.valueOf(fields[1]),
                                        Long.valueOf(fields[1]),
                                        fields[2],
                                        fields[3],
                                        fields[4],
                                        days,
                                        Integer.valueOf(fields[6])
                                ));

                            }catch(NullPointerException e) {
                                System.out.println(" Erro: Ouve uma divergencia na tabela de produtos na linha: "+line);
                                try {
                                    Thread.sleep(3000); // Pausa de 3 segundos (3000 milissegundos)
                                } catch (InterruptedException e2) {
                                    System.out.println(e2.getMessage());
                                }
                            }
                        }
                    }
                }catch (IllegalStateException t) {
                    System.out.println(" Não foi possivel pegar um valor numérico de uma célula de string!");
                }


                line++;
            }
        } catch (IOException e) {
            System.out.println(" Ouve um erro ao tentar localizar o arquivo pallets.xls!\n "+ e.getMessage());

        }
    }
    /*
    default List<Product> LoadProductsOfDb(String path) {
        final String pathFileDb;
        DB db;
        List<Product> list;

        if(Application.executionCount == -1) {
            pathFileDb = "/config/cacheproducts/cache.db";
            db = DBMaker.fileDB(path + pathFileDb).make();
            @SuppressWarnings("unchecked")
            Set<Product> cache = (Set<Product>) db.hashSet("cache", Serializer.JAVA).createOrOpen();
            list = new ArrayList<>(cache);
            db.close();

            return list;
        }

        File top = Application.history.peek();
        db = DBMaker.fileDB(top).make();

        @SuppressWarnings("unchecked")
        Set<Product> cache = (Set<Product>) db.hashSet("cache", Serializer.JAVA).createOrOpen();
        list = new ArrayList<>(cache);
        db.close();

        return list;
    }

    default void shutDownDb(String path) {
        final String pathFileDb = "/config/cacheproducts/cache.db";
        DB db = DBMaker.fileDB(path + pathFileDb).make();
        @SuppressWarnings("unchecked")
        Set<Product> cache = (Set<Product>) db.hashSet("cache", Serializer.JAVA).createOrOpen();
        cache.clear();
        db.commit();
        db.close();

        while(!Application.history.isEmpty()) {
            if(!Application.history.peek().getName().equals("cache.db"))
                Application.history.pop().delete();
            else
                Application.history.pop();
        }



    }

    default void saveChanges(List<Product> allProducts, String path) {
        String pathFileDb = path + "/config/cacheproducts/cache" + Application.executionCount + ".db";
        File dbFile = new File(pathFileDb);

        try (DB db = DBMaker.fileDB(dbFile).make()) {
            @SuppressWarnings("unchecked")
            Set<Product> cache = (Set<Product>) db.hashSet("cache", Serializer.JAVA).createOrOpen();

            cache.clear();
            cache.addAll(allProducts);

            db.commit();
        }

        Application.history.push(dbFile);
    }

    default List<Product> saveRestore() {
        File top, aux;

        // se o topo não for cache.db, remove o último e deleta depois
        if (!"cache.db".equals(Application.history.peek().getName())) {
            aux = Application.history.pop();
            top = Application.history.peek();
        } else {
            top = Application.history.peek();
            aux = null;
        }

        try (DB dbConn = DBMaker.fileDB(top).make()) {
            @SuppressWarnings("unchecked")
            Set<Product> cache = (Set<Product>) dbConn
                    .hashSet("cache", Serializer.JAVA)
                    .createOrOpen();

            List<Product> list = new ArrayList<>(cache);

            if (aux != null && aux.exists()) {
                aux.delete();
            }

            return list;
        }
    }

*/
}
