package com.interview.alpha.exchange.app.impl.localdate;

import com.interview.alpha.exchange.app.api.localdate.LocalDateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LocalDateServiceImpl implements LocalDateService {
    @Override
    public LocalDate getYesterdayDate() {
        return LocalDate.now().minusDays(1);
    }
}
