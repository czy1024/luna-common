package com.luna.common.utils;

import com.luna.common.dto.ResultDTO;

/**
 * @author Luna
 */
public class ResultDTOUtils {
    public static <T> T checkResultAndGetData(ResultDTO<T> resultDTO) {
        if (resultDTO.isSuccess() == false) {
            throw new RuntimeException("code=" + resultDTO.getCode() + ", message=" + resultDTO.getMessage());
        }
        return resultDTO.getData();
    }
}
