package com.allancleiton.SCP;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaPalletRepository;
import com.allancleiton.SCP.adapters.outbound.service.ExcelLoadPallet;
import com.allancleiton.SCP.adapters.outbound.service.ExcelLoadProduct;
import com.allancleiton.SCP.application.service.ConditionInterpreter;
import com.allancleiton.SCP.domain.entities.Pallet;
import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootTest
class ScpApplicationTests {
    @Test
	void contextLoads() {
        ConfigurableApplicationContext springContext = new SpringApplicationBuilder(ScpApplication.class).run();

        ExcelLoadPallet excelLoadPallet = springContext.getBean(ExcelLoadPallet.class);

        excelLoadPallet.LoadPallets();

        JpaPalletRepository repository = springContext.getBean(JpaPalletRepository.class);;

        ConditionInterpreter<Pallet> interpreter = new ConditionInterpreter<>(">=301 && <= 322");

        List<JpaPalletEntity> lit = repository.findAllByCode(1055);


        interpreter.submit(lit.stream().map(p -> new Pallet(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getChamber(),
                p.getRoad(),
                p.getPosition(),
                p.getDays(),
                p.getBoxes()
        )).toList()).forEach(IO::println);

    }

}
