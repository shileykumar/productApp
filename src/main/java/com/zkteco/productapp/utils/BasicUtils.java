package com.zkteco.productapp.utils;

import com.zkteco.productapp.config.InternalizationConfig;
import com.zkteco.productapp.model.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BasicUtils {

    @Autowired
    private InternalizationConfig internalizationConfig;

    public BasicUtils() {
        super();
    }

    public static boolean isNullOrEmpty(Object value) {
        return (Objects.isNull(value)) || value.toString().isBlank() ? Boolean.TRUE : Boolean.FALSE;
    }

    public Result prepareResponseObject(String code, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(internalizationConfig.locale(code));
        if (isNullOrEmpty(data)) {
            result.setData(null);
        } else {
            result.setData(data);
        }
        return result;
    }
}
