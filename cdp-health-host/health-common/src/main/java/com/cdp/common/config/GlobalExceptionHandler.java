package com.cdp.common.config;

import com.cdp.common.exception.BusinessException;
import com.zhonghui.common.core.result.FwResult;
import com.zhonghui.license.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public FwResult<Object> businessException(BusinessException e) {
        log.error("BusinessException 异常",e);
        return FwResult.failedMsg("系统内部错误,请稍后重试");
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = BadRequestException.class)
    public FwResult<Object> badRequestException(BadRequestException e) {
        // 打印堆栈信息
        log.error("BadRequestException 异常",e);
        return FwResult.failedMsg(e.getMessage());
    }
    /**
     * 全局异常捕捉处理
     *
     * @param ex .
     * @return .
     */
    @ExceptionHandler(value = Exception.class)
    public FwResult<Object> errorHandler(Exception ex, HttpServletRequest request)
    {
        if (null != request) {
            StringBuilder strBuild = new StringBuilder();
            strBuild.append("global catch reqUrl:");
            strBuild.append(request.getRequestURI());
            if (HttpMethod.GET.matches(request.getMethod())) {
                strBuild.append(" queryString:");
                strBuild.append(request.getQueryString());
            }
            log.error(strBuild.toString(), ex);
            return FwResult.failedMsg("系统内部错误,请稍后重试");
        }
        else
        {
            log.error("global catch", ex);
            return FwResult.failedMsg("系统内部错误,请稍后重试");
        }
    }

}
