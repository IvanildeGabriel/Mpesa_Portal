package mz.vm.mpesa.views.Utils;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Util {

    public static Converter<LocalDate, Date> convertLocalDateToDate() {

        return new Converter<LocalDate, Date>() {
            @Override
            public Result<Date> convertToModel(LocalDate localDate, ValueContext valueContext) {
                try {
                    return Result.ok(convertToDateViaInstant(localDate));
                } catch (RuntimeException e) {
                    return Result.error("Introduza uma data válida");
                } catch (ParseException e) {
                    return Result.error("Erro na formatação da data");
                }

            }

            @Override
            public LocalDate convertToPresentation(Date date, ValueContext valueContext) {

                if (date != null) {
                    return Instant.ofEpochMilli(date.getTime())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                } else
                    return null;
            }
        };
    }

    public static Date convertToDateViaInstant(LocalDate dateToConvert) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(formatDate(dateToConvert));
    }

    public static String formatDate(LocalDate date) {
        if (date != null) {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            return date.format(formatters);
        } else return null;
    }
}
