package com.zkteco.productapp.config;

import com.zkteco.productapp.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class InternalizationFilter extends AcceptHeaderLocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        try {
            List<Locale> locales = Arrays.asList(new Locale("en"), new Locale("idn"));
            if (request.getHeader(Constants.ACCEPT_LANGUAGE_KEY) == null
                    || request.getHeader(Constants.ACCEPT_LANGUAGE_KEY).isEmpty()) {
                return Locale.getDefault();
            }
            List<Locale.LanguageRange> languageRanges = Locale.LanguageRange
                    .parse(Constants.ACCEPT_LANGUAGE_KEY);
            return Locale.lookup(languageRanges, locales);
        } catch (Exception e) {
            e.printStackTrace();
            return Locale.getDefault();
        }
    }
}
