package com.pet.depo23.restService;


import com.pet.depo23.repository.BondRepository;
import com.pet.depo23.entity.Bond;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger( LoadDatabase.class );

    @Bean
    CommandLineRunner initDatabase( BondRepository repository ) {
        return args ->  {
            Calendar offer_c = new GregorianCalendar(2023, Calendar.JUNE, 21);
            Calendar mat_c = new GregorianCalendar(2038, Calendar.MAY, 19);

            log.info( "Preloading " + repository.save( new Bond(
                    "SU26243RMFS4", "ОФЗ 26243", "RU000A106E90",
                    offer_c.getTime(), mat_c.getTime(),
                    1000.0, "RUR", 2, 48.87,
                    "GOFZ" )));

            offer_c.set(2021, Calendar.JUNE, 16);
            mat_c.set(2041,Calendar.MAY, 15);
            log.info( "Preloading " + repository.save( new Bond(
                    "SU26238RMFS4", "ОФЗ 26238", "RU000A1038V6",
                    offer_c.getTime(), mat_c.getTime(),
                    1000.0, "RUR", 2, 35.40,
                    "GOFZ" )));
        };
    }
}
